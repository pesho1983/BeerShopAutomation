package BeerShop.steps.serenity;

import BeerShop.entities.User;
import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

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
        return loginPage.errorMsgForWrongUserOrPass();
    }

    @Step
    public void enterUsernameAndPassword(List<User> user) {
        loginPage.enterUsernameAndPassword(user);
//        loginPage.enterUsername(user);
//        loginPage.enterPassword(user);
    }

    @Step
    public void pressSubmitButton() {
        loginPage.pressSubmitButton();
    }

    @Step
    public void assertUserIsOnCatalogPage(String defaultUrl) {
        Assert.assertEquals(defaultUrl, loginPage.getCurrentURL());
    }

    @Step
    public void clickOnProfileNavLink() {
        loginPage.clickOnProfileNavLink();
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
    public void asserOnErrorMsg(String message) {
        Assert.assertEquals(message, getErrorTextMsg());
    }

    @Step
    public void assertUserIsOnLogin(String message) {
        Assert.assertEquals(message, getTitle());
    }

    @Step
    public void clickOnWalletLink() {
        loginPage.clickOnWalletLink();
    }

    @Step
    public void assertValidationMessage(String validation, String defaulMessage) {
        loginPage.assertValidationMessage(validation, defaulMessage);
    }

    @Step
    public void checkRememberMeCheckbox() {
        loginPage.checkRememberMeCheckbox();
    }

    @Step
    public void assertLoggedInWithSameUser(String username) {
        Assert.assertEquals(username, loginPage.getProfileUsermame());

    }
}
