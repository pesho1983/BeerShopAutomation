package BeerShop.steps;

import BeerShop.pages.PasswordChangePage;
import BeerShop.steps.serenity.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

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
    @Steps
    PasswordChangePage passwordChangePage;

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

    @When("^I enter valid oldPassword, newPassword and confirmPassword:$")
    public void iEnterValidOldPasswordNewPasswordAndConfirmPassword(Map<String, String> data){
        passwordChangeSteps.enterOldPassNewPassAndConfirmPass(data);
    }

    @And("^click on Save button$")
    public void clickOnSaveButton()  {
        passwordChangeSteps.clickOnSaveButton();
    }

    @Then("^password is successfully changed$")
    public void passwordIsSuccessfullyChanged()  {
        Assert.assertEquals("Your profile has been updated.", passwordChangePage.getSuccessMessage());
    }



}
