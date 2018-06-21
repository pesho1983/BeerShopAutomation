package BeerShop.steps.serenity;

import BeerShop.Utils.constants.PasswordChangeConstants;
import BeerShop.entities.User;
import BeerShop.pages.PasswordChangePage;
import BeerShop.pages.ProfilePage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

public class PasswordChangeSteps {
    PasswordChangePage passwordChangePage;
    ProfilePage profilePage;

    @Step
    public void enterOldPassNewPassAndConfirmPass(List<User> user) {
        passwordChangePage.enterPassword(user);
        passwordChangePage.enterNewPassword(user);
        passwordChangePage.enterConfirmPassword(user);
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
        Assert.assertEquals(succsessMessage, passwordChangePage.getSuccessMessage());
    }

    @Step
    public void assertProfilePageURL(String defaultUrl) {
        String currentUrl = profilePage.getDriver().getCurrentUrl();
        Assert.assertEquals(defaultUrl, currentUrl);
    }

    @Step
    public void assertPasswordFieldValidationMessage(String defaultValidation, String fieldValidation) {
        switch (fieldValidation) {
            case PasswordChangeConstants.EMPTY_CURRENT_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getOldPasswordValidationMessage());
                break;
            case PasswordChangeConstants.EMPTY_NEW_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getNewPasswordValidationMessage());
                break;
            case PasswordChangeConstants.EMPTY_CONFIRM_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getConfirmPasswordValidationMessage());
                break;
            case PasswordChangeConstants.ALL_EMPTY_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getOldPasswordValidationMessage());
                Assert.assertEquals(defaultValidation, passwordChangePage.getNewPasswordValidationMessage());
                Assert.assertEquals(defaultValidation, passwordChangePage.getConfirmPasswordValidationMessage());
                break;
            case PasswordChangeConstants.CHANGE_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getSuccessMessage());
                break;
            case PasswordChangeConstants.CURRENT_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getWrongPasswordMessage());
                break;
            case PasswordChangeConstants.NEW_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getRequiredPasswordSymbolsMessage());
                break;
            case PasswordChangeConstants.CONFIRM_NEW_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, passwordChangePage.getMatchPasswordMessage());
                break;
        }
    }
}

