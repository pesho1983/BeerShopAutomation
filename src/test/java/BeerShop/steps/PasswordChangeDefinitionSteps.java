package BeerShop.steps;

import BeerShop.steps.serenity.*;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class PasswordChangeDefinitionSteps {

    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    ProfileSteps profileSteps;
    @Steps
    ChangeProfileSteps changeProfileSteps;
    @Steps
    PasswordChangeSteps passwordChangeSteps;


    @Given("^I am on Profile page logged in with:$")
    public void iAmOnProfilePage(@Transpose Map<String, String> data) {

        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();
        loginSteps.clickOnProfileNavLink();
    }

    @And("^click on change Info button$")
    public void clickOnChangeInfoButton() {
        profileSteps.clickOnChangeInfoButton();
    }

    @And("^click on change Password button$")
    public void clickOnChangePasswordButton() {
        changeProfileSteps.clickOnChangePasswordButton();
    }

    @And("^click on Save button$")
    public void clickOnSaveButton() {
        passwordChangeSteps.clickOnSaveButton();
    }

    @Then("^I should see message \"([^\"]*)\"$")
    public void passwordIsSuccessfullyChanged(String message) {
        passwordChangeSteps.assertSuccessMessageText(message);
    }

    @When("^I enter:$")
    public void iEnterWrongOldPassword(@Transpose Map<String, String> data) {
        passwordChangeSteps.enterOldPassNewPassAndConfirmPass(data);
    }

    @When("^I press Back to your profile button$")
    public void iPressBackToYourProfileButton() {
        passwordChangeSteps.clickOnBackToProfileButton();
    }

    @Then("^I should be redirected to \"([^\"]*)\"$")
    public void iShouldBeRedirectedToProfilePage(String defaultUrl) {
        passwordChangeSteps.assertProfilePageURL(defaultUrl);
    }

    @Then("^I should see (.*) (.*) on PaswordChange page$")
    public void iShouldSeeValidationMessageOnPaswordChangePage(String validation, String defaultMessage) {
        passwordChangeSteps.assertPasswordFieldValidationMessage(validation, defaultMessage);
    }
}
