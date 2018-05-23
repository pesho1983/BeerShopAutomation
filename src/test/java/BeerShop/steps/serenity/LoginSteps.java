package BeerShop.steps.serenity;

import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

import static BeerShop.Utils.Utils.WEBSITE_URL;


@DefaultUrl(WEBSITE_URL + "login.php")
public class LoginSteps {



    LoginPage loginPage;


    @Step
    public void navigateToLoginPage() {
        loginPage.open();
    }

    @Step
    public String getErrorTextMsg() {
        return loginPage.getWrongUserOrPassBox().getText();
    }

    @Step
    public void enterUsernameAndPassword(Map<String, String> data) {
        loginPage.getUsername().type(data.get("username"));
        loginPage.getPassword().type(data.get("password"));
    }


    public void enterUsernameAndPassword(String username, String password) {
        loginPage.getUsername().type(username);
        loginPage.getPassword().type(password);
    }

    @Step
    public void pressSubmitButton() {

        loginPage.getSubmitButton().click();
    }

    @Step
    public void assertUserIsOnCatalogPage() {
        Assert.assertEquals("http://192.168.10.158/BeerShop/catalog.php#", loginPage.getDriver().getCurrentUrl());
    }


    @Step
    public void clickOnProfileNavLink() {
        loginPage.getProfileNavLink().click();
    }

    @Step
    public void openSite() {
        loginPage.open();
    }


    @Step
    public String getTitle() {
        return loginPage.getTitle();
    }

    @Step
    public void asserOnErrorMsg() {
        Assert.assertEquals("Wrong username or password!", getErrorTextMsg());
    }


    @Step
    public void assertUserIsOnLogin() {
        Assert.assertEquals("Login", getTitle());
    }

    public void clickOnWalletLink() {
    }
}
