package BeerShop.steps;


import BeerShop.steps.serenity.AdministratorSteps;
import BeerShop.steps.serenity.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Map;

public class AdministratorDefinitionSteps {

    @Steps
    AdministratorSteps adminSteps;

    @Steps
    LoginSteps loginSteps;


    @Given("^I am on the log in page$")
    public void iAmOnTheLogInPage() {
        loginSteps.navigateToLoginPage();
    }

    @When("^Filling the form with admin access credentials:$")
    public void fillingTheFormWithAdminAccessCredentials(Map<String, String> data) {
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();

    }

    @Then("^You are logged in as admin$")
    public void youAreLoggedInAsAdmin() {
        Assert.assertEquals("admin", adminSteps.getLoggedUserText());
    }

    @And("^Redirected to \"([^\"]*)\"$")
    public void redirectedTo(String arg0) {
        Assert.assertEquals("Admin Panel", adminSteps.getTitle());
    }

    @Then("^Error message appears$")
    public void errorMessageAppears() {
        Assert.assertEquals("Wrong username or password!", loginSteps.getErrorTextMsg());
    }

    @And("^The user is on the \"([^\"]*)\"$")
    public void theUserIsOnThe(String arg0) {
        Assert.assertEquals("Login", loginSteps.getTitle());
    }

    @Given("^You are logged in as administrator:$")
    public void youAreLoggedInAsAdministrator(Map<String, String> data) {
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();
    }

    @When("^You are on the \"([^\"]*)\" page$")
    public void youAreOnThePage(String arg0) {
        adminSteps.navigateToAddBeerPage();
    }

    @And("^Filling the beer description:$")
    public void fillingTheBeerDescription(Map<String, String> data) {
        adminSteps.fillingBeerDescriptionForm(data);
        adminSteps.clickSaveBeerBtn();
    }

    @Then("^Product is loaded to the catalog$")
    public void productIsLoadedToTheCatalog() {

    }

    @Then("^Pop up error message appears$")
    public void popUpErrorMessageAppears() {

    }

    @And("^process is stopped$")
    public void processIsStopped() {

    }

    @And("^Pressing the \"([^\"]*)\" button$")
    public void pressingTheButton(String arg0) {

    }

    @Then("^You are redirected to the beer catalog$")
    public void youAreRedirectedToTheBeerCatalog() {

    }


}