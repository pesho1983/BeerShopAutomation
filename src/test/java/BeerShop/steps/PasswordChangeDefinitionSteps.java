package BeerShop.steps;

import BeerShop.pages.IndexPage;
import BeerShop.pages.PasswordChangePage;
import BeerShop.steps.serenity.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    public void iAmOnProfilePage(Map<String, String> data) {

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

    @When("^I enter correct oldPassword, newPassword and confirmPassword:$")
    public void iEnterValidOldPasswordNewPasswordAndConfirmPassword(Map<String, String> data){
        passwordChangeSteps.enterOldPassNewPassAndConfirmPass(data);
    }

    @And("^click on Save button$")
    public void clickOnSaveButton()  {
        passwordChangeSteps.clickOnSaveButton();
    }

    @Then("^I should see message \"([^\"]*)\"$")
    public void passwordIsSuccessfullyChanged(String message)  {
        passwordChangeSteps.assertSuccessMessageText(message);
}


    @When("^I enter wrong oldPassword:$")
    public void iEnterWrongOldPassword(Map<String, String> data) {
        passwordChangeSteps.enterOldPassNewPassAndConfirmPass(data);
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void iShouldSeeAnWrongPasswordMessage(String message) {
        passwordChangeSteps.assertWrongPasswordMessage(message);
    }
}
