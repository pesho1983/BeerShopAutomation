package BeerShop.pages;

import BeerShop.Utils.Utils;
import jnr.ffi.Struct;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import sun.security.util.PendingException;

import java.util.List;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "/catalog.php")
public class CatalogPage extends PageObject {

    @FindBy(xpath = "//div [@class=\"product justify-content-md-center\"]")
    private WebElementFacade productBox;

    @FindBy(xpath = ".//div [@class=\"product justify-content-md-center\"]/h2[text()]")
    private WebElementFacade productName;

    @FindBy(css = "[name=\"order\"]")
    private WebElementFacade selectOrderBy;

    @FindBy(css = ".btn-danger")
    private WebElementFacade sortButton;

    @FindBy(css = ".product h2")
    private List<WebElementFacade> listOfProductsNames;

    @FindBy(css = ".product a")
    private List<WebElementFacade> listOfAddToCartButtons;

    @FindBy(css = ".quickview")
    private List<WebElementFacade> listOfDescriptionButtons;

    @FindBy(css = ".price")
    private List<WebElementFacade> listOfProductsPrices;

    @FindBy(css = ".headline")
    private WebElementFacade productNameInDescriptionContainer;

    @FindBy(css = ".active .price")
    private WebElementFacade productPriceInDescriptionContainer;

    @FindBy(css = ".active .description")
    private WebElementFacade productDescriptionInDescriptionContainer;

    @FindBy(css = ".close")
    private WebElementFacade closeButtonInDescriptionContainer;

    @FindBy(css = ".pagination a")
    private List<WebElementFacade> listOfPages;

    public String getProductNameFromDescriptionContainer() {
        return this.productNameInDescriptionContainer.getText();
    }

    public String getProductDescriptionFromDescriptionContainer() {
        return this.productDescriptionInDescriptionContainer.getText();
    }

    public float getProductPriceFromDescriptionContainer() {
        float productPrice = Float.parseFloat(Utils.removeSuffixFromPrice(productPriceInDescriptionContainer));
        return productPrice;
    }

    public Float getProductPrice(int product) {
        float productPrice = Float.parseFloat(Utils.removeSuffixFromPrice(listOfProductsPrices.get(product - 1)));
        return productPrice;
    }

    public WebElementFacade getProductBox() {
        return productBox;
    }

    public WebElementFacade getProduct() {
        return productName;
    }

    public void clickOnAddToCart(int product) {
        listOfAddToCartButtons.get(product - 1).click();
    }

    public String getProductName(int product) {
        return listOfProductsNames.get(product - 1).getText();
    }

    public void clickProductDescription(int product) {
        listOfDescriptionButtons.get(product - 1).click();
    }

    public void clickOnSortButton() {
        sortButton.click();
    }

    public void clickOnSelectOrderBy() {
        this.selectOrderBy.click();
    }

    public void clickOnPage(int page) {
        this.listOfPages.get(page - 1).click();
    }

    public void sortProductsBy(String option) {
        WebElementFacade optionCss = find(By.cssSelector("[value='" + option + "']"));
        optionCss.click();
    }

    public String getFirstProductName() {
        String nameOfFirstBeer = listOfProductsNames.get(0).getText();
        return nameOfFirstBeer;
    }

    public String getLastProductName() {
        int lastProduct = listOfProductsNames.size() - 1;
        if (lastProduct > 8) {
            Utils.javascriptWindowScroll(500);
        }
        String nameOfLastBeer = listOfProductsNames.get(lastProduct).getText();
        return nameOfLastBeer;
    }

    public Float getFirstProductPrice() {
        String price = listOfProductsPrices.get(0).getText();
        price = price.substring(0, price.length() - 3);
        System.out.println(price);
        return Float.parseFloat(price);
    }

    public Float getLastProductPrice() {
        int lastProduct = listOfProductsPrices.size() - 2;
        if (lastProduct > 8) {
            Utils.javascriptWindowScroll(500);
        }
        String price = listOfProductsPrices.get(lastProduct).getText();
        price = price.substring(0, price.length() - 3);
        System.out.println(price);
        return Float.parseFloat(price);
    }

    public boolean compareProduct(String option) {
        switch (option) {
            case "name":
                if (getFirstProductName().compareTo(getLastProductName()) < 0) {
                    return true;
                }
                break;
            case "nameDesc":
                if (getFirstProductName().compareTo(getLastProductName()) > 0) {
                    return true;
                }
                break;
            case "price":
                if (getFirstProductPrice() < getLastProductPrice()) {
                    return true;
                }
                break;
            case "priceDesc":
                if (getFirstProductPrice() > getLastProductPrice()) {
                    return true;
                }
                break;
            default:
                throw new PendingException("The method for " + option + " is not implemented yet.");
        }
        return false;
    }

//    public void clickOnAddToCart(int product) {
//
//        String result = Utils.productIndividualXpath(this.getProductBox(), "]]");
//        String targetProduct = result + "][" + product + "]" + "/a";
//        this.getDriver().findElement(By.xpath(targetProduct)).click();
//    }

//    public String getProductName(int product) {
//        String result = Utils.productIndividualXpath(this.getProduct(), "]/h2[text()]");
//
//        String targetProductName = result + "[" + product + "]" + "/h2";
//        return this.getDriver().findElement(By.xpath(targetProductName)).getText();
//    }
}

