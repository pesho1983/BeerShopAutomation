package BeerShop.steps.serenity;


import BeerShop.entities.User;
import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;
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

    @Step
    public void enterUsernameAndPassword(List<User> user) {
        loginPage.getUsername().type(user.get(0).getUsername());
        loginPage.getPassword().type(user.get(0).getPassword());
    }

    @Step
    public void enterUsernameAndPassword(String username, String password) {
        loginPage.getUsername().type(username);
        loginPage.getPassword().type(password);
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
    public void asserOnErrorMsg() {
        Assert.assertEquals("Wrong username or password!", getErrorTextMsg());
    }


    @Step
    public void assertUserIsOnLogin() {
        Assert.assertEquals("Login", getTitle());
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
