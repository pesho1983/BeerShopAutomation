package BeerShop.pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;




@DefaultUrl("http://192.168.10.158/BeerShop/login.php")
public class LoginPage extends PageObject {

    @FindBy(id="inputEmail")
    private WebElementFacade username;

    @FindBy(id="password")
    private WebElementFacade password;

    @FindBy(name="login")
    private WebElementFacade signIn;

    @FindBy(className = "extraPlace")
    private WebElementFacade note;

    @FindBy(css=".btn.btn-md.btn-success.btn-block")
    private WebElementFacade submitButton;

    @FindBy(id = "profile")
    private WebElementFacade profileNavLink;

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

    public WebElementFacade getWalletLink() {
        return walletLink;
    }

    public WebElementFacade getProfileUsermame() {
        return profileUsermame;
    }

}
