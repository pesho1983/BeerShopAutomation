package BeerShop.steps;

import BeerShop.entities.User;
import BeerShop.steps.serenity.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.List;

public class PasswordChangeDefinitionSteps {

    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    PasswordChangeSteps passwordChangeSteps;
    @Steps
    BasketSteps basketSteps;


    @Given("^I am on Profile page logged in with:$")
    public void iAmOnProfilePage(@Transpose Map<String, String> data) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();
        loginSteps.clickOnProfileNavLink();
    }

    @And("^click on \"([^\"]*)\" and \"([^\"]*)\" buttons$")
    public void clickOnChangeInfoButton(String changeInfoButton, String changePasswordButton) {
        basketSteps.clickButton(changeInfoButton);
        basketSteps.clickButton(changePasswordButton);
    }

    @And("^click on Save button$")
    public void clickOnSaveButton() {
        passwordChangeSteps.clickOnSaveButton();
    }


    @Then("^I should see message \"([^\"]*)\"$")
    public void passwordIsSuccessfullyChanged(String message) {
        passwordChangeSteps.assertSuccessMessageText(message);
    }

    @When("^user enter:$")
    public void userEnterWrongOldPassword(List<User> user) {
        passwordChangeSteps.enterOldPassNewPassAndConfirmPass(user);
    }

    @When("^a user press Back to your profile button$")
    public void userPressBackToYourProfileButton() {
        passwordChangeSteps.clickOnBackToProfileButton();
    }

    @Then("^a user should be redirected to \"([^\"]*)\"$")
    public void userShouldBeRedirectedToProfilePage(String defaultUrl) {
        passwordChangeSteps.assertProfilePageURL(defaultUrl);
    }

    @Then("^(.*) message should be displayed for (.*) field$")
    public void validationMessageShoudBeDisplayedForDefinedField(String defaultMessage, String validation) {
        passwordChangeSteps.assertPasswordFieldValidationMessage(defaultMessage, validation);
    }
}
