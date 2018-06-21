package BeerShop.pages;


import BeerShop.entities.User;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import java.util.List;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL+"login.php")

public class LoginPage extends PageObject {

    @FindBy(id = "inputEmail")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(name="login")
    private WebElementFacade signIn;

    @FindBy(className = "extraPlace")
    private WebElementFacade note;

    @FindBy(css=".btn.btn-md.btn-success.btn-block")
    private WebElementFacade submitButton;

    @FindBy(id = "profile")
    private WebElementFacade profileNavLink;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElementFacade wrongUserOrPassBox;

    @FindBy(xpath = "//strong")
    private WebElementFacade wrongUsernameOrPasswordMessage;

    @FindBy(id="inputEmail-error")
    private WebElementFacade usernameValidationMessage;

    @FindBy(id="password-error")
    private WebElementFacade passwordValidationMessage;

    @FindBy(name="remember")
    private WebElementFacade rememberMeCheckbox;

    @FindBy(id="wallet")
    private WebElementFacade walletLink;

    @FindBy(css = "a#profile")
    private WebElementFacade profileUsermame;


    public WebElementFacade getUsername() {
        return username;
    }

    public WebElementFacade getPassword() {
        return password;
    }

    public void enterUsernameAndPassword(List<User> user) {
        this.getUsername().type(user.get(0).getUsername());
        this.getPassword().type(user.get(0).getPassword());
    }

    public WebElementFacade getNote() {
        return note;
    }


    public WebElementFacade getSubmitButton() {
        return submitButton;}

    public WebElementFacade getSignIn() {
        return signIn;}

    public WebElementFacade getProfileNavLink() {
        return profileNavLink;
    }

    public WebElementFacade getWrongUserOrPassBox() {
        return wrongUserOrPassBox;
    }

    public WebElementFacade getWrongUsernameOrPasswordMessage() {
        return wrongUsernameOrPasswordMessage;
    }

    public WebElementFacade getUsernameValidationMessage() {
        return usernameValidationMessage;
    }

    public WebElementFacade getPasswordValidationMessage() {
        return passwordValidationMessage;
    }

    public WebElementFacade getRememberMeCheckBox() {
        return rememberMeCheckbox;
    }

    public LoginPage clickOnWalletLink() {
        this.walletLink.click();
        return this;
    }

    public WebElementFacade getProfileUsermame() {
        return profileUsermame;
    }

}
