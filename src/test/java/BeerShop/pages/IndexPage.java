package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/index.php")
public class IndexPage extends PageObject {

    @FindBy(id = "login")
    private WebElementFacade loginNavLink;

    public WebElementFacade getLoginNavLink() {
        return loginNavLink;
    }


}
