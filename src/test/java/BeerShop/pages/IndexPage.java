package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "index.php")
public class IndexPage extends PageObject {

    @FindBy(id = "login")
    private WebElementFacade login;

    @FindBy(id = "catalog")
    private WebElementFacade catalog;

    @FindBy(css = ".last_sold div p:nth-child(2)")
    private List<WebElementFacade> listOfLastSoldBeers;

    @FindBy(id = "myHeader")
    private HeaderMenu headerMenu;

    public boolean getLastThreeSoldBeers(List<String> listOfSoldBeers, int numberOfPurchasedBeers) {
        for (int i = 0; i < numberOfPurchasedBeers; i++) {
            if (!listOfLastSoldBeers.get(i).getText().equals(listOfSoldBeers.get(i))) {
                return false;
            }
        }

        return true;
    }

    public void clickOnLoginNavLink() {

        //this.headerMenu.clickLoginButton();
        this.login.click();
    }

    public void clickOnCatalogNavLink(){
        this.catalog.click();
    }
}
