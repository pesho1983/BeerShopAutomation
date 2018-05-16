package BeerShop.steps;

import BeerShop.pages.AdminPage;
import BeerShop.pages.IndexPage;
import BeerShop.pages.LoginPage;
import BeerShop.steps.serenity.IndexPageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.http.util.Asserts;
import org.junit.Assert;


public class DefinitionIndexPage {


   @Steps
   IndexPageSteps indexPageSteps;

   @Steps
   LoginPage loginPage;

   @Steps
    AdminPage adminPage;

    @Given("^open index page$")
    public void openIndexPage() {
      indexPageSteps.goToHomePage();
    }
    @When("^click on login page and open$")
    public void clickOnLoginPageAndOpen() {
        indexPageSteps.clickOnLogin();
    }
    @And("^have to login with admin profile$")
    public void haveToLoginWithAdminProfile(){
        indexPageSteps.logInAsAdmin();

    }
    @Then("^you have to see the admin panel$")
    public void youHaveToSeeTheAdminPanel(){
        Assert.assertEquals("Admin Panel",adminPage.getTitle());
    }

    @Given("^you are logged in as administrator:$")
    public void youAreLoggedInAsAdministrator() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^admin clicks on add beers$")
    public void adminClicksOnAddBeers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^beer all beer credientials are filled:$")
    public void beerAllBeerCredientialsAreFilled() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^beer is successfully added to the list$")
    public void beerIsSuccessfullyAddedToTheList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^you are logged in as administrator with <username> and <password>$")
    public void youAreLoggedInAsAdministratorWithUsernameAndPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
