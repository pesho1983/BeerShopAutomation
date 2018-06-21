package BeerShop.pages;

import BeerShop.entities.User;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "login.php")

public class LoginPage extends PageObject {

    @FindBy(id = "inputEmail")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(name = "login")
    private WebElementFacade signIn;

    @FindBy(className = "extraPlace")
    private WebElementFacade note;

    @FindBy(css = ".btn.btn-md.btn-success.btn-block")
    private WebElementFacade submitButton;

    @FindBy(id = "profile")
    private WebElementFacade profileNavLink;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElementFacade wrongUserOrPassBox;

    @FindBy(xpath = "//strong")
    private WebElementFacade wrongUsernameOrPasswordMessage;

    @FindBy(id = "inputEmail-error")
    private WebElementFacade usernameValidationMessage;

    @FindBy(id = "password-error")
    private WebElementFacade passwordValidationMessage;

    @FindBy(name = "remember")
    private WebElementFacade rememberMeCheckbox;

    @FindBy(id = "wallet")
    private WebElementFacade walletLink;

    @FindBy(css = "a#profile")
    private WebElementFacade profileUsermame;

    public void enterUsernameAndPassword(List<User> user) {
        this.username.type(user.get(0).getUsername());
        this.password.type(user.get(0).getPassword());
    }

    public WebElementFacade getNote() {
        return note;
    }

    public LoginPage pressSubmitButton() {
        this.submitButton.click();
        return this;
    }

    public LoginPage clickSignInButton() {
        this.signIn.click();
        return this;
    }

    public String profileNavUsername() {
        return this.profileNavLink.getText();
    }

    public LoginPage clickOnProfileNavLink() {
        this.profileNavLink.click();
        return this;
    }

    public String errorMsgForWrongUserOrPass() {
        return this.wrongUserOrPassBox.getText();
    }

    public String getWrongUsernameOrPasswordMessage() {
        return this.wrongUsernameOrPasswordMessage.getText();
    }

    public String getUsernameValidationMessage() {
        return this.usernameValidationMessage.getText();
    }

    public String getPasswordValidationMessage() {
        return this.passwordValidationMessage.getText();
    }

    public LoginPage checkRememberMeCheckbox() {
        this.rememberMeCheckbox.click();
        return this;
    }

    public LoginPage clickOnWalletLink() {
        this.walletLink.click();
        return this;
    }

    public String getCurrentURL() {
        return this.getDriver().getCurrentUrl();
    }

    public String getProfileUsermame() {
        return this.profileUsermame.getText();
    }

}
