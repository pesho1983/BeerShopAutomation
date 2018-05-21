package BeerShop.steps.serenity;

import BeerShop.Utils.ShippingDetails;
import BeerShop.Utils.Utils;
import BeerShop.pages.BasketPage;
import BeerShop.pages.CatalogPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BasketSteps {

    BasketPage basketPage;
    CatalogPage catalogPage;

    @Step
    public void openBasketPage(){
        basketPage.open();
    }

    @Step
    public String getTitle(){
        return basketPage.getDriver().getTitle();
    }

    @Step
    public String getEmptyBasketMessage(){
        return basketPage.getQuantityEmpty().getText();
    }

    @Step
    public void clickOnAddToCart(int product){
        if(product > 8){
            Utils.javascriptWindowScroll(500);
        }
        catalogPage.clickOnAddToCart(product);
    }

    @Step
    public String getCatalogProductName(int product){
        if(product > 8){
            Utils.javascriptWindowScroll(500);
        }
        return catalogPage.getProductName(product);
    }

    @Step
    public String getFirstProductName(){
        return basketPage.getProductName().getText();
    }

    @Step
    public void clickContinueShopping(){
        basketPage.getBackToCatalogBtn().click();
    }

    @Step
    public void clickOnWalletButton(){
        basketPage.getWalletBtn().click();
    }

    @Step
    public void removeProduct(){
        basketPage.getRemoveProduct().click();
        Utils.acceptAlert();

    }

    @Step
    public void clickOnCheckout(){
        basketPage.getCheckout().click();
    }

    @Step
    public void manipulateQuantity(String quantity){
        basketPage.getQuantity().click();
        basketPage.getQuantity().sendKeys(Keys.BACK_SPACE);
        basketPage.getQuantity().sendKeys("" + quantity);
        basketPage.getQuantity().sendKeys(Keys.ENTER);
        if(Integer.parseInt(quantity) < 0 ){
            Utils.acceptAlert();
        }
        basketPage.open();
    }

    @Step
    public String getQuantity() {
        return basketPage.getQuantity().getValue();
    }

    @Step
    public String getPrice() {
        return removeSuffixFromPrice(basketPage.getPrice());
    }

    @Step
    public String getSubtotal(){
       return removeSuffixFromPrice(basketPage.getSubtotal());
    }

    @Step
    public int getProductCount(){
        return basketPage.findAll(By.xpath("//tbody/tr")).size();
    }

    @Step
    public float getCartTotal(){
        String wholeWord = basketPage.getCartTotal().getText();
        return Float.parseFloat(basketPage.getCartTotal().getText().substring(6, wholeWord.length() - 3));
    }

    @Step
    public float calculateCartTotal(){
        float cartTotal = 0;
        Object[] total = basketPage.findAll(By.xpath("//tbody/tr")).toArray();
        int targetElement = 1;
        for (Object element: total
             ) {
            String xpath = Utils.productIndividualXpath((WebElementFacade)element, "]") + "[" + targetElement + "]/td[4]";
            String productSubtotal = basketPage.find(By.xpath(xpath)).getText();
            cartTotal += Float.parseFloat(productSubtotal.substring(0, productSubtotal.length() - 3));
            targetElement++;
        }
        return cartTotal;
    }

    @Step
    public void clickOnPlaceOrder(){
        basketPage.getPlaceOrderBtn().click();
    }

    @Step
    public String getShippingDetails(ShippingDetails parameter){
        String element;
        switch (parameter) {
            case TITLE:
                return basketPage.getShippingDetails().findElement(By.xpath("h4")).getText();
            case FIRST_NAME:
                element =  basketPage.getShippingDetails().findElement(By.xpath("p[1]")).getText();
                return Utils.replaceWordWithWhitespace(element, "First Name: ");
            case LAST_NAME:
                element =  basketPage.getShippingDetails().findElement(By.xpath("p[2]")).getText();
                return Utils.replaceWordWithWhitespace(element, "Last Name: ");
            case PHONE:
                element = basketPage.getShippingDetails().findElement(By.xpath("p[3]")).getText();
                return Utils.replaceWordWithWhitespace(element, "Phone: ");
            case ADDRESS:
                element =  basketPage.getShippingDetails().findElement(By.xpath("p[4]")).getText();
                return Utils.replaceWordWithWhitespace(element, "Address: ");
            default: break;
        }
        return null;
    }

    @Step
    public String getOrderSuccessMessage(){
        return Utils.replaceWordWithRegex(basketPage.getSuccesMsgText(), " Order ID is #(\\d+)");
    }

    @Step
    public String getErrorMessage(){
        return basketPage.getErrorOrderMsgBox();
    }

    private String removeSuffixFromPrice(WebElementFacade target){
        String result = target.getText();
        return result.substring(0, result.length() - 3);
    }



}
