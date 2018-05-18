package BeerShop.steps.serenity;

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
    public void enterOldPassNewPassAndConfirmPass(Map<String, String> data){
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
    public void assertWrongPasswordMessage(String wrongMessage){
        Assert.assertEquals(wrongMessage, passwordChangePage.getWrongPassword().getText());
    }

    @Step
    public void assertProfilePageURL(String defaultUrl){
        String currentUrl = profilePage.getDriver().getCurrentUrl();
        Assert.assertEquals(defaultUrl,currentUrl);
    }

    @Step
    public void assertPasswordFieldValidationMessage(String defaultValidation,  int fieldNum){
        WebElementFacade oldPassValidation = passwordChangePage.getOldPasswordValidationMessage();
        WebElementFacade newPassValidation = passwordChangePage.getNewPasswordValidationMessage();
        WebElementFacade confirmPassValidation = passwordChangePage.getConfirmPasswordValidationMessage();
        if (fieldNum == 0) {

            Assert.assertEquals(defaultValidation,oldPassValidation.getText());
        }
        else if (fieldNum == 1){

            Assert.assertEquals(defaultValidation,newPassValidation.getText());
        }
        else if (fieldNum == 2){

            Assert.assertEquals(defaultValidation,confirmPassValidation.getText());
        }
        else if (fieldNum == 3){

            Assert.assertEquals(defaultValidation,oldPassValidation.getText());
            Assert.assertEquals(defaultValidation,newPassValidation.getText());
            Assert.assertEquals(defaultValidation,confirmPassValidation.getText());
        }
    }
}
