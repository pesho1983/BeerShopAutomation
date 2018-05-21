package BeerShop.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://192.168.10.158/BeerShop/login.php")
public class LoginPage extends PageObject {

    @FindBy(id="inputEmail")
    private WebElementFacade username;

    @FindBy(id="password")
    private WebElementFacade password;

    @FindBy(name="login")
    private WebElementFacade submitButton;

    @FindBy(id = "profile")
    private WebElementFacade profileNavLink;

    @FindBy(id="wallet")
    private WebElementFacade walletLink;

    public WebElementFacade getUsername() {
        return username;
    }

    public WebElementFacade getPassword() {
        return password;
    }

    public WebElementFacade getSubmitButton() {
        return submitButton;
    }

    public WebElementFacade getProfileNavLink() {
        return profileNavLink;
    }

    public WebElementFacade getWalletLink() {
        return walletLink;
    }

}
