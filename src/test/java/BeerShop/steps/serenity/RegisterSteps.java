package BeerShop.steps.serenity;

import BeerShop.entities.User;
import BeerShop.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import java.util.List;

public class RegisterSteps {

    RegisterPage registerPage;

    @Step
    public void openRegisterPage() {
        registerPage.open();
    }

    @Step
    public void fillRegistrationForm(List<User> user) {
        registerPage.fillRegistrationForm(user);
        registerPage.clickOnAgreement();
        registerPage.clickOnGDPR();
    }

    @Step
    public void fillRegistrationFormWithoutCheckbox(List<User> user) {
        registerPage.fillRegistrationForm(user);
    }

    @Step
    public void clickOnRegisterButton() {
        registerPage.clickOnRegisterButton();
    }

    @Step
    public void assertExactURL(String expectedURL) {
        Assert.assertEquals(expectedURL, registerPage.getCurrentURL());
    }

    @Step
    public void verifyCorrectErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, registerPage.getErrorMessageLabel());
    }

    @Step
    public void verifyCorrectBackendErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, registerPage.getErrorMessageLabelStrong());
    }
}
