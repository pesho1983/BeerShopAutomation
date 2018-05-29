package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/adminProfile.php#")
public class AdminProfilePage extends PageObject {

    @FindBy(xpath = "//a[@href='orders.php']")
    private WebElementFacade  ordersLink;

    public WebElementFacade getOrdersLink() {
        return ordersLink.waitUntilClickable();
    }
}
