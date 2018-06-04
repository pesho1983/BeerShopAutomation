package BeerShop.pages;

import BeerShop.Utils.Utils;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "viewCart.php")
public class BasketPage extends PageObject {
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElementFacade firstProductPrice;

    @FindBy(xpath = "//tr/td[text()]")
    private WebElementFacade productName;

    @FindBy(xpath = "//tfoot/tr/td/a")
    private WebElementFacade backToCatalogBtn;

    @FindBy(xpath = "//input[@class=\"form-control text-center\"]")
    private WebElementFacade quantity;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private WebElementFacade price;

    @FindBy(xpath = "//tbody/tr/td[4]")
    private WebElementFacade subtotal;

    @FindBy(xpath = "//tfoot/tr/td[3]")
    private WebElementFacade cartTotal;

    @FindBy(xpath = "//p")
    private WebElementFacade quantityEmpty;

    @FindBy(xpath = "//a[@href=\"checkout.php\"]")
    private WebElementFacade checkout;

    @FindBy(id = "wallet")
    private WebElementFacade walletBtn;

    @FindBy(xpath = "//tbody/tr/td[last()]/a")
    private WebElementFacade removeProduct;

    @FindBy(xpath = "//div[@class=\"alert alert-danger\"]")
    private WebElementFacade errorMessageBox;

    @FindBy(xpath = "//p[contains(text(), 'Your order')]")
    private WebElementFacade successOrderMsgBox;

    @FindBy(xpath = "//a [@class =\"btn btn-success orderBtn\"]")
    private WebElementFacade placeOrderBtn;

    @FindBy(xpath = "//div[@class=\"shipAddr\"]")
    private WebElementFacade shippingDetails;

    public BasketPage clickPlaceOrderButton() {
        this.placeOrderBtn.click();
        return this;
    }

    public WebElementFacade getFirstProductPrice() {
        return firstProductPrice;
    }

    public BasketPage clickWalletButton() {
        this.walletBtn.click();
        return this;
    }

    public BasketPage clickRemoveProduct() {
        this.removeProduct.click();
        Utils.acceptAlert();
        return this;
    }

    public BasketPage clickCheckoutButton() {
        this.checkout.click();
        return this;
    }

    public WebElementFacade getQuantityEmpty() {
        return quantityEmpty;
    }

    public WebElementFacade getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return Utils.removeSuffixFromPrice(this.price);
    }

    public WebElementFacade getSubtotal() {
        return subtotal;
    }

    public float getCartTotal() {
        String wholeWord = this.cartTotal.getText();
        return Float.parseFloat(wholeWord.substring(6, wholeWord.length() - 3));
    }

    public BasketPage clickBackToCatalogButton() {
        this.backToCatalogBtn.click();
        return this;
    }

    public WebElementFacade getProductName() {
        return productName;
    }

    public WebElementFacade getShippingDetails() {
        return shippingDetails;
    }

    public String getSuccesMsgText() {
        return Utils.replaceWordWithRegex(this.successOrderMsgBox.getText(), " Order ID is #(\\d+)");
    }

    public String getErrorOrderMsgBox() {
        return errorMessageBox.getText();
    }

}
