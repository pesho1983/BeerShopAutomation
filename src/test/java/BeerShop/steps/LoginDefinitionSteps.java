package BeerShop.steps;

import BeerShop.pages.IndexPage;
import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

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

    @When("^I enter valid username and password:$")
    public void iEnterValidUsernameAndPassword(Map<String, String> data){
        loginSteps.enterUsernameAndPassword(data);
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
