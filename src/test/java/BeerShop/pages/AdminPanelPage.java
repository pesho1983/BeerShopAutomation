package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/adminProfile.php")
public class AdminPanelPage extends PageObject {
    @FindBy(className = "img-fluid")
    private WebElementFacade addBeer;

    public WebElementFacade getAddBeer() {
        return addBeer;
    }

}
