package BeerShop.steps.serenity;

import BeerShop.pages.LoginPage;
import BeerShop.pages.PasswordChangePage;
import BeerShop.pages.ProfilePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class PasswordChangeSteps {

    PasswordChangePage passwordChangePage;
    ProfilePage profilePage;

    @Step
    public void enterOldPassNewPassAndConfirmPass(Map<String, String> data) {
        passwordChangePage.getOldPassword().type(data.get("oldPassword"));
        passwordChangePage.getNewPassword().type(data.get("newPassword"));
        passwordChangePage.getConfirmPassword().type(data.get("confirmPassword"));
    }

    @Step
    public void clickOnSaveButton() {
        passwordChangePage.getSaveButton().click();

    }

    @Step
    public void clickOnBackToProfileButton() {
        passwordChangePage.getBackToProfileButton().click();
    }

    @Step
    public void assertSuccessMessageText(String succsessMessage) {
        Assert.assertEquals(succsessMessage,passwordChangePage.getSuccessMessage().getText());
    }

    @Step
    public void assertProfilePageURL(String defaultUrl){
        String currentUrl = profilePage.getDriver().getCurrentUrl();
        Assert.assertEquals(defaultUrl,currentUrl);
    }

    @Step
    public void assertPasswordFieldValidationMessage(String fieldValidation,  String defaultValidation){
        WebElementFacade oldPassValidation = passwordChangePage.getOldPasswordValidationMessage();
        WebElementFacade newPassValidation = passwordChangePage.getNewPasswordValidationMessage();
        WebElementFacade confirmPassValidation = passwordChangePage.getConfirmPasswordValidationMessage();
        switch (fieldValidation){
            case "oldPasswordValidation":
                Assert.assertEquals(defaultValidation,oldPassValidation.getText());
                break;
            case "newPasswordValidation":
                Assert.assertEquals(defaultValidation,newPassValidation.getText());
                break;
            case "confirmPasswordValidation":
                Assert.assertEquals(defaultValidation,confirmPassValidation.getText());
                break;
            case "allPasswordValidations":
                Assert.assertEquals(defaultValidation,oldPassValidation.getText());
                Assert.assertEquals(defaultValidation,newPassValidation.getText());
                Assert.assertEquals(defaultValidation,confirmPassValidation.getText());
                break;
            case "successPasswordChange":
                Assert.assertEquals(defaultValidation,passwordChangePage.getSuccessMessage().getText());
                break;
            case "errorPasswordChange":
                Assert.assertEquals(defaultValidation,passwordChangePage.getWrongPasswordMessage().getText());
                break;
            case "requiredPasswordSymbols":
                Assert.assertEquals(defaultValidation,passwordChangePage.getRequiredPasswordSymbolsMessage().getText());
            break;
            case "matchPasswordError":
                Assert.assertEquals(defaultValidation,passwordChangePage.getMatchPasswordMessage().getText());
                break;
        }
    }
}
