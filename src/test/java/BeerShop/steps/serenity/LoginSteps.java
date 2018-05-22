package BeerShop.steps.serenity;

import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Map;
@DefaultUrl("http://192.168.10.158/BeerShop/login.php")
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


    public void clickOnWalletLink() {
    }
}
