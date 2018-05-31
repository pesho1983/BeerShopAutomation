package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "index.php")
public class IndexPage extends PageObject {

    @FindBy(id = "login")
    private WebElementFacade loginNavLink;

    @FindBy(css = ".last_sold>div>p:nth-child(2)")
    private WebElementFacade lastSoldBeer;

    public WebElementFacade getLastSoldBeer() {
        return lastSoldBeer;
    }

    public WebElementFacade getLoginNavLink() {
        return loginNavLink;
    }


}
