package BeerShop.pages;

<<<<<<< HEAD
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

=======
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

>>>>>>> e49df27184fe5f182fb04723af8b18a1696e6b03
@DefaultUrl("http://192.168.10.158/BeerShop/login.php")
public class LoginPage extends PageObject {

    @FindBy(id="inputEmail")
    private WebElementFacade username;

    @FindBy(id="password")
    private WebElementFacade password;

    @FindBy(name="login")
<<<<<<< HEAD
    private WebElementFacade signIn;

    @FindBy(className = "extraPlace")
    private WebElementFacade note;
=======
    private WebElementFacade submitButton;

    @FindBy(id = "profile")
    private WebElementFacade profileNavLink;
>>>>>>> e49df27184fe5f182fb04723af8b18a1696e6b03

    public WebElementFacade getUsername() {
        return username;
    }

    public WebElementFacade getPassword() {
        return password;
    }

<<<<<<< HEAD
    public WebElementFacade getNote() {
        return note;
    }
    public WebElementFacade getSignIn() {
        return signIn;

=======
    public WebElementFacade getSubmitButton() {
        return submitButton;
    }

    public WebElementFacade getProfileNavLink() {
        return profileNavLink;
>>>>>>> e49df27184fe5f182fb04723af8b18a1696e6b03
    }
}
