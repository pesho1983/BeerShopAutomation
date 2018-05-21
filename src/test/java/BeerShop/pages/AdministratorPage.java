package BeerShop.pages;

import BeerShop.Utils.Utils;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;


public class AdministratorPage extends PageObject {


    @FindBy(xpath = "//a[contains(. ,'ADD BEER')]")
    private WebElementFacade addBeerBtn;

    @FindBy(xpath = "//a[contains(. ,'EDIT BEER')]")
    private WebElementFacade editBeerBtn;

    @FindBy(xpath = "//a[contains(.,'USER ORDERS')]")
    private WebElementFacade userOrdersBtn;

    @FindBy(name = "name")
    private WebElementFacade newProductName;

    @FindBy(name = "description")
    private WebElementFacade newProductDescription;

    @FindBy(name = "price")
    private WebElementFacade newProductPrice;

    @FindBy(name = "quantity")
    private WebElementFacade newProductQuantity;

    @FindBy(name = "picture")
    private WebElementFacade newProductPicture;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElementFacade newProductSavebtn;

    @FindBy(xpath = "//a[contains(., 'Back to ')]")
    private WebElementFacade backToCatalogBtn;

    @FindBy(name = "picture")
    private WebElementFacade beerPicture;


    @FindBy(id = "profile")
    private WebElementFacade profileUsername;


    @FindBy(xpath = "//div[contains(text(), \"Uploaded successfully.\")]")
    private WebElementFacade SuccessBeerMsg;

    public void getNthEditBeerBtn(int n) {
        WebElement editBtn = this.getDriver().findElement(By.xpath("(//a[contains(.,'Edit')])[" + n + "]"));

    }

    public WebElementFacade getProfileUsername() {
        return profileUsername;
    }

    public void getNthDeleteBeerBtn(int n) {
        WebElement editBtn = this.getDriver().findElement(By.xpath("(//a[contains(.,'Delete')])[" + n + "]"));
    }

    public WebElementFacade getAddBeerBtn() {
        return addBeerBtn;
    }

    public WebElementFacade getEditBeerBtn() {
        return editBeerBtn;
    }

    public WebElementFacade getUserOrdersBtn() {
        return userOrdersBtn;
    }

    public WebElementFacade getNewProductName() {
        return newProductName;
    }

    public WebElementFacade getNewProductDescription() {
        return newProductDescription;
    }

    public WebElementFacade getNewProductPrice() {
        return newProductPrice;
    }

    public WebElementFacade getNewProductQuantity() {
        return newProductQuantity;
    }

    public WebElementFacade getNewProductPicture() {
        return newProductPicture;
    }

    public WebElementFacade getSuccessBeerMsg() {
        return SuccessBeerMsg;
    }

    public WebElementFacade getNewProductSavebtn() {
        return newProductSavebtn;
    }

    public WebElementFacade getBackToCatalogBtn() {
        return backToCatalogBtn;
    }

    public void uploadImg(String imgLocation) {
        beerPicture.sendKeys(imgLocation);

    }
}
