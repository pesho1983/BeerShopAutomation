package BeerShop.steps;

import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class LoginDefinitionSteps {


    @Steps
    LoginSteps loginSteps;
    @Steps
    IndexSteps indexSteps;


    @Given("^I am on Login page$")
    public void iAmOnLoginPage() {

        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
    }

    @When("^I enter (.*) and (.*)$")
    public void iEnterUsernameAndPassword(String username, String password){
        loginSteps.enterUsernameAndPassword(username, password);
    }

    @And("^click on Sign In button$")
    public void clickOnSignInButton() {
        loginSteps.pressSubmitButton();
    }

    @Then("^I should be logged in and redirected to \"([^\"]*)\"$")
    public void iShouldBeLoggedInAndRedirectedToCatalogPage(String defaultUrl) {
        loginSteps.assertUserIsOnCatalogPage(defaultUrl);
    }

    @Then("^I should see (.*) (.*) on Login page$")
    public void iShouldSeeValidationMessageOnLoginPage(String validation, String defaultMessage) {
        loginSteps.assertValidationMessage(validation, defaultMessage);
    }

    @And("^I open new browser session$")
    public void iOpenNewBrowserSession() {
        indexSteps.openURL();
    }

    @Then("^I should be logged in site with same (.*)$")
    public void iShouldBeLoggedInSiteWithSameCredentials(String username)  {
        loginSteps.assertLoggedInWithSameUser(username);
    }

    @And("^click on Remember me checkbox an press Sign In button$")
    public void clickOnRememberMeCheckboxAnPressSignInButton() {
        loginSteps.checkRememberMeCheckbox();
        loginSteps.pressSubmitButton();
    }

}
