package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/changeProfile.php")
public class ChangeProfilePage extends PageObject {

    @FindBy(xpath = "//a[@href=\"passwordChange.php\"]")
    private WebElementFacade changePasswordButton;

    public WebElementFacade getChangePasswordButton() {
        return changePasswordButton;
    }
}
