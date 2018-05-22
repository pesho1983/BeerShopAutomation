package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://192.168.10.158/BeerShop/profile.php")
public class ProfilePage extends PageObject {

    @FindBy(xpath = "//a[@href='changeProfile.php']")
    private WebElementFacade changeInfoButton;

    public WebElementFacade getChangeInfoButton() {
        return changeInfoButton;
    }
}
