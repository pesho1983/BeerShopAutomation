package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import java.util.List;

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

    private WebElementFacade submitButton;

    @FindBy(id = "profile")
    private WebElementFacade profileNavLink;

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
}
