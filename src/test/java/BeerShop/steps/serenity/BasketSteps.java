package BeerShop.steps.serenity;

import BeerShop.Utils.ShippingDetails;
import BeerShop.Utils.Utils;
import BeerShop.Utils.constants.BasketConstants;
import BeerShop.Utils.constants.UserProfileConstants;
import BeerShop.pages.BasketPage;
import BeerShop.pages.CatalogPage;
import BeerShop.pages.ProfilePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.*;


public class BasketSteps {
    private String productName;
    private List<String> listOfSoldBeers = new ArrayList<>();
    BasketPage basketPage;
    CatalogPage catalogPage;
    ProfilePage profilePage;
    IndexPage indexPage;
    PasswordChangePage passwordChangePage;
    ChangeProfilePage changeProfilePage;

    @Step
    public void openBasketPage() {
        basketPage.open();
    }

    @Step
    public String getTitle() {
        return basketPage.getDriver().getTitle();
    }

    @Step
    public void clickOnAddToCart(int product) {
        if (product > 8) {
            Utils.javascriptWindowScroll(500);
        }
        catalogPage.clickOnAddToCart(product);
    }

    @Step
    public String getCatalogProductName(int product) {
        if (product > 8) {
            Utils.javascriptWindowScroll(500);
        }
        return catalogPage.getProductName(product);
    }

    @Step
    public void clickButton(String buttonName) {
        buttonName = buttonName.replace("\"", "");
        switch (buttonName) {
            case BasketConstants.CHECKOUT_BUTTON:
                basketPage.clickCheckoutButton();
                break;
            case BasketConstants.CONTINUE_SHOPPING_BUTTON:
                basketPage.clickBackToCatalogButton();
                break;
            case BasketConstants.PLACE_ORDER_BUTTON:
                basketPage.clickPlaceOrderButton();
                break;
            case BasketConstants.WALLET_BUTTON:
                basketPage.clickWalletButton();
                break;
            case BasketConstants.REMOVE_BUTTON:
                basketPage.clickRemoveProduct();
                break;
            case PasswordChangeConstants.BACK_TO_YOUR_PROFILE_BUTTON:
                passwordChangePage.clickOnBackToProfileButton();
                break;
            case PasswordChangeConstants.PASSWORD_CHANGE_SAVE_BUTTON:
                passwordChangePage.clickOnSaveButton();
                break;
            case ProfileConstants.CHANGE_INFO_BUTTON:
                profilePage.clickOnChangeInfoButton();
                break;
            case PasswordChangeConstants.CHANGE_PASSWORD_BUTTON:
                changeProfilePage.clickOnChangePasswordButton();
                break;
            default:
                break;
        }
    }

    @Step
    public void manipulateQuantity(String quantity) {
        basketPage.getQuantity().click();
        basketPage.getQuantity().sendKeys(Keys.BACK_SPACE);
        basketPage.getQuantity().sendKeys("" + quantity);
        basketPage.getQuantity().sendKeys(Keys.ENTER);
        if (Integer.parseInt(quantity) < 0) {
            Utils.acceptAlert();
        }
        basketPage.open();
    }

    @Step
    public int getAllProductsQuantity() {
        int totalQuantity = 0;
        for (WebElementFacade element : basketPage.findAll(By.xpath("//input[@class='form-control text-center']"))) {
            totalQuantity += Integer.parseInt(element.getValue());
        }
        return totalQuantity;
    }

    @Step
    public float calculateCartTotal() {
        float cartTotal = 0;
        Object[] total = basketPage.findAll(By.xpath("//tbody/tr")).toArray();
        int targetElement = 1;
        for (Object element : total
                ) {
            String xpath = Utils.productIndividualXpath((WebElementFacade) element, "]") + "[" + targetElement + "]/td[4]";
            String productSubtotal = basketPage.find(By.xpath(xpath)).getText();
            cartTotal += Float.parseFloat(productSubtotal.substring(0, productSubtotal.length() - 3));
            targetElement++;
        }
        return cartTotal;
    }

    @Step
    public String getShippingDetails(ShippingDetails parameter) {
        String element;
        switch (parameter) {
            case TITLE:
                return basketPage.getShippingDetails().findElement(By.xpath("h4")).getText();
            case FIRST_NAME:
                element = basketPage.getShippingDetails().findElement(By.xpath("//p[contains(text(), \"First Name:\")]")).getText();
                return Utils.replaceWordWithWhitespace(element, "First Name: ");
            case LAST_NAME:
                element = basketPage.getShippingDetails().findElement(By.xpath("//p[contains(text(), \"Last Name:\")]")).getText();
                return Utils.replaceWordWithWhitespace(element, "Last Name: ");
            case PHONE:
                element = basketPage.getShippingDetails().findElement(By.xpath("//p[contains(text(), \"Phone:\")]")).getText();
                return Utils.replaceWordWithWhitespace(element, "Phone: ");
            case ADDRESS:
                element = basketPage.getShippingDetails().findElement(By.xpath("//p[contains(text(), \"Address:\")]")).getText();
                return Utils.replaceWordWithWhitespace(element, "Address: ");
            default:
                break;
        }
        return null;
    }

    @Step
    public void assertMessageEquals(String message) {
        switch (message) {
            case BasketConstants.ORDER_SUCCESS_MESSAGE:
                Assert.assertEquals(message, basketPage.getSuccesMsgText());
                break;
            case BasketConstants.INSUFFICIENT_FUNDS_MESSAGE:
                Assert.assertEquals(true, basketPage.getErrorOrderMsgBox().contains(message));
                break;
            case BasketConstants.INSUFFICIENT_BEERS_MESSAGE:
                Assert.assertEquals(true, basketPage.getErrorOrderMsgBox().contains(message));
                break;
            case BasketConstants.EMPTY_CART_MESSAGE:
                Assert.assertEquals(message, basketPage.getQuantityEmpty().getText());
                break;
            case "1":
                Assert.assertEquals("1", basketPage.getQuantity().getValue());
                break;
            default:
                Assert.assertEquals(message, basketPage.getProductName().getText());
        }
    }

    @Step
    public void assertBeerQuantity(String quantity) {
        Assert.assertEquals(Integer.parseInt(quantity), getAllProductsQuantity());
    }

    @Step
    public void assertBeerPrice(String result) {
        float subtotal = Float.parseFloat(result) * Float.parseFloat(basketPage.getPrice());
        float actualSubtotal = Float.parseFloat(Utils.removeSuffixFromPrice(basketPage.getSubtotal()));
        Assert.assertEquals(subtotal, actualSubtotal, 0.01);
    }

    @Step
    public void assertBeerTotalPrice() {
        Assert.assertEquals(basketPage.getCartTotal(), calculateCartTotal(), 0.1);
    }

    @Step
    public void assertTitle(String title) {
        Assert.assertEquals(title, getTitle());
    }

    @Step
    public void assertShippingDetails(String shippingDetails) {
        Assert.assertEquals(shippingDetails, getShippingDetails(ShippingDetails.TITLE));
    }

    @Step
    public void assertUserFirstname(String userFirstName) {
        profilePage.open();
        Assert.assertEquals(profilePage.getFirstName(), userFirstName);
    }

    @Step
    public void addMultipleProducts(int productCount, Random random) {
        for (int i = 0; i < productCount; i++) {
            clickOnAddToCart(random.nextInt(12) + 1);
            clickButton(BasketConstants.CONTINUE_SHOPPING_BUTTON);
        }
        basketPage.open();
    }

    @Step
    public String getProductName() {
        productName = basketPage.getProductName().getText();
        listOfSoldBeers.add(productName);
        return productName;
    }

//    @Step
//    public void assertNameOfLastSoldBeer() {
//        Assert.assertEquals(productName, indexPage.getLastSoldBeer().getText());
//    }

    @Step
    public void assertIfLastSoldBeerIsOnIndexPage(int numberOfPurchasedBeers) {
        Assert.assertTrue(indexPage.getLastThreeSoldBeers(listOfSoldBeers, numberOfPurchasedBeers));
    }
}
