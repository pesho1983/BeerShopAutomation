package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProfilePage extends PageObject {

    @FindBy(xpath = "//a[contains(text(), \"Change\")]")
    private WebElementFacade changeInfoButton;

    public WebElementFacade getChangeInfoButton() {
        return changeInfoButton;
    }
}
