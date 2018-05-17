package BeerShop.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/viewCart.php")
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

    public WebElementFacade getPlaceOrderBtn() {
        return placeOrderBtn;
    }

    public WebElementFacade getFirstProductPrice() {
        return firstProductPrice;
    }

    public WebElementFacade getWalletBtn() {
        return walletBtn;
    }

    public WebElementFacade getRemoveProduct() {
        return removeProduct;
    }

    public WebElementFacade getCheckout() {
        return checkout;
    }

    public WebElementFacade getQuantityEmpty() {
        return quantityEmpty;
    }

    public WebElementFacade getQuantity() {
        return quantity;
    }

    public WebElementFacade getPrice() {
        return price;
    }

    public WebElementFacade getSubtotal() {
        return subtotal;
    }

    public WebElementFacade getCartTotal() {
        return cartTotal;
    }

    public WebElementFacade getBackToCatalogBtn() {
        return backToCatalogBtn;
    }

    public WebElementFacade getProductName() {
        return productName;
    }

    public WebElementFacade getShippingDetails() {
        return shippingDetails;
    }

    public String getSuccesMsgText() {
        return successOrderMsgBox.getText();
    }

    public String getErrorOrderMsgBox() {
        return errorMessageBox.getText();
    }
}
