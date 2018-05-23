package BeerShop.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.stream.Collectors;

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

    @FindBy(name = "login")
    private WebElementFacade submitButton;

    @FindBy(id = "profile")
    private WebElementFacade profileNavLink;


    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElementFacade wrongUserOrPassBox;

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

    public WebElementFacade getWrongUserOrPassBox() {
        return wrongUserOrPassBox;
    }


    public WebElementFacade getWalletLink() {
        return walletLink;
    }


}
