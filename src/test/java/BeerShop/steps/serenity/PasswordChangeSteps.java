package BeerShop.steps.serenity;

import BeerShop.entities.User;
import BeerShop.pages.PasswordChangePage;
import BeerShop.pages.ProfilePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import java.util.List;

public class PasswordChangeSteps {
    PasswordChangePage passwordChangePage;
    ProfilePage profilePage;

    @Step
    public void enterOldPassNewPassAndConfirmPass(List<User> user) {
        passwordChangePage.getOldPassword().type(user.get(0).getPassword());
        passwordChangePage.getNewPassword().type(user.get(0).getNewPassword());
        passwordChangePage.getConfirmPassword().type(user.get(0).getConfirmPassword());
    }

    @Step
    public void clickOnSaveButton() {
        passwordChangePage.clickOnSaveButton();
    }

    @Step
    public void clickOnBackToProfileButton() {
        passwordChangePage.clickOnBackToProfileButton();

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
    public void assertPasswordFieldValidationMessage(String defaultValidation, String fieldValidation){
        WebElementFacade oldPassValidation = passwordChangePage.getOldPasswordValidationMessage();
        WebElementFacade newPassValidation = passwordChangePage.getNewPasswordValidationMessage();
        WebElementFacade confirmPassValidation = passwordChangePage.getConfirmPasswordValidationMessage();
        switch (fieldValidation){
            case "Empty Current Password":
                Assert.assertEquals(defaultValidation,oldPassValidation.getText());
                break;
            case "Empty New Password":
                Assert.assertEquals(defaultValidation,newPassValidation.getText());
                break;
            case "Empty Confirm Password":
                Assert.assertEquals(defaultValidation,confirmPassValidation.getText());
                break;
            case "All Empty":
                Assert.assertEquals(defaultValidation,oldPassValidation.getText());
                Assert.assertEquals(defaultValidation,newPassValidation.getText());
                Assert.assertEquals(defaultValidation,confirmPassValidation.getText());
                break;
            case "Change Password":
                Assert.assertEquals(defaultValidation,passwordChangePage.getSuccessMessage().getText());
                break;
            case "Current Password":
                Assert.assertEquals(defaultValidation,passwordChangePage.getWrongPasswordMessage().getText());
                break;
            case "New Password":
                Assert.assertEquals(defaultValidation,passwordChangePage.getRequiredPasswordSymbolsMessage().getText());
            break;
            case "Confirm New Password":
                Assert.assertEquals(defaultValidation,passwordChangePage.getMatchPasswordMessage().getText());
                break;
        }
    }
}
