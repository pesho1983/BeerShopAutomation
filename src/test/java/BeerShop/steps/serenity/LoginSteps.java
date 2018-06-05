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
        return loginPage.getWrongUserOrPassBox().getText();
    }

    @Step
    public void enterUsernameAndPassword(List<User> user) {
        loginPage.enterUsernameAndPassword(user);
    }

    @Step
    public void pressSubmitButton() {
        loginPage.getSubmitButton().click();
    }

    @Step
    public void assertUserIsOnCatalogPage(String defaultUrl) {
        Assert.assertEquals(defaultUrl, loginPage.getDriver().getCurrentUrl());
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
    public void asserOnErrorMsg(String message) {
        Assert.assertEquals(message, getErrorTextMsg());
    }

    @Step
    public void assertUserIsOnLogin(String message) {
        Assert.assertEquals(message, getTitle());
    }

    @Step
    public void clickOnWalletLink() {
        loginPage.getWalletLink().click();
    }

    @Step
    public void assertValidationMessage(String validation, String defaulMessage) {
        switch (validation) {
            case "errorLogin":
                Assert.assertEquals(defaulMessage, loginPage.getWrongUsernameOrPasswordMessage().getText());
                break;
            case "usernameValidation":
                Assert.assertEquals(defaulMessage, loginPage.getUsernameValidationMessage().getText());
                break;
            case "passwordValidation":
                Assert.assertEquals(defaulMessage, loginPage.getPasswordValidationMessage().getText());
                break;
            case "userAndPassValidations":
                Assert.assertEquals(defaulMessage, loginPage.getUsernameValidationMessage().getText());
                Assert.assertEquals(defaulMessage, loginPage.getPasswordValidationMessage().getText());
                break;
        }

    }

    @Step
    public void checkRememberMeCheckbox() {
        loginPage.getRememberMeCheckBox().click();
    }

    @Step
    public void assertLoggedInWithSameUser(String username) {
        Assert.assertEquals(username, loginPage.getProfileUsermame().getText());

    }
}
