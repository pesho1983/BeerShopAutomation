package BeerShop.steps;

import BeerShop.entities.User;
import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class LoginDefinitionSteps {

    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;


    @Given("^I am on Login page$")
    public void iAmOnLoginPage() {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
    }

    @When("^I enter valid (.*) and (.*)$")
    public void iEnterValidUsernameAndPassword(String username, String password){
        loginSteps.enterUsernameAndPassword(username, password);
    }

    @And("^Click on Sign In button$")
    public void clickOnSignInButton()  {
        loginSteps.pressSubmitButton();
    }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn()  {
        loginSteps.assertUserIsOnCatalogPage();
    }


    @Given("^a user is logged in as (.*)$")
    public void aUserIsLoggedInAsUsernameAndPassword(List<List<User>> tupak) {
        //loginSteps.enterUsernameAndPassword(tupak);

    }
}
