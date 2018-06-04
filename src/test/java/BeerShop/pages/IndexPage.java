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

    @FindBy(css = ".last_sold>div:nth-last-child(3)>p:nth-child(2)")
    private WebElementFacade lastSoldBeer;

    @FindBy (css = ".last_sold div p:nth-child(2)")
    private List<WebElementFacade> listOfLastSoldBeers;

    public boolean getLastThreeSoldBeers(List<String> listOfSoldBeers) {
        for (int i = 0; i < 3; i++){
            if (!listOfLastSoldBeers.get(i).getText().equals(listOfSoldBeers.get(i))){
                return false;
            }
        }

        return true;
    }


    public WebElementFacade getLastSoldBeer() {
        return lastSoldBeer;
    }

      public WebElementFacade getLogin() {
        return login;
    }


}
