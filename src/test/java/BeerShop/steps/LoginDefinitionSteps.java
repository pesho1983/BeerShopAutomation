package BeerShop.steps;

import BeerShop.steps.serenity.IndexPageSteps;
import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class LoginDefinitionSteps {

    @Steps
    IndexPageSteps indexPageSteps;
    @Steps
    LoginSteps loginSteps;


    @Given("^I am on Login page$")
    public void iAmOnLoginPage() {
        indexPageSteps.goToHomePage();
        indexPageSteps.clickOnLogin();
    }

    @When("^I enter valid (.*) and (.*)$")
    public void iEnterValidUsernameAndPassword(String username, String password){
        loginSteps.enterUsernameAndPassword(username, password);
    }

    @And("^Click on Sign In button$")
    public void clickOnSignInButton() throws Throwable {
        loginSteps.pressSubmitButton();
    }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() throws Throwable {
        loginSteps.assertUserIsOnCatalogPage();
    }


}
