package BeerShop.pages;

import BeerShop.Utils.Utils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "profile.php")
public class ProfilePage extends PageObject {

    @FindBy(xpath = "//a[@href='changeProfile.php']")
    private WebElementFacade changeInfoButton;

    @FindBy(xpath = "//div/p[contains(text(), \"First name:\")]")
    private WebElementFacade firstName;

    public String getFirstName() {
        return Utils.replaceWordWithWhitespace(this.firstName.getText(), "First name: ");
    }

    public ProfilePage clickOnChangeInfoButton() {
        Utils.javascriptWindowScroll(500);
        this.changeInfoButton.click();
        return this;
    }
}
