package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/orders.php")
public class OrdersPage extends PageObject {

    @FindBy(xpath = "//a[@href='oldOrders.php']")
    private WebElementFacade completedOrdersBtn;

    @FindBy(css = "table tr strong")
    private WebElementFacade getCartTotalPriceElement;

    public WebElementFacade getOrdersLink() {

        return completedOrdersBtn.waitUntilClickable();
    }

    public float getCartTotalPrice() {
        float cartTotalPrice = Float.parseFloat(getCartTotalPriceElement
                .getText()
                .trim()
                .replaceAll("[^\\d+.]", ""));

        return cartTotalPrice;
    }
}
