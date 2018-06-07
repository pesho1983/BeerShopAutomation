package BeerShop.steps.serenity;

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
        Assert.assertEquals(succsessMessage,passwordChangePage.getSuccessMessage());
    }

    @Step
    public void assertProfilePageURL(String defaultUrl){
        String currentUrl = profilePage.getDriver().getCurrentUrl();
        Assert.assertEquals(defaultUrl,currentUrl);
    }

    @Step
    public void assertPasswordFieldValidationMessage(String defaultValidation, String fieldValidation){
        passwordChangePage.assertPasswordFieldValidationMessage(defaultValidation, fieldValidation);
    }
}
