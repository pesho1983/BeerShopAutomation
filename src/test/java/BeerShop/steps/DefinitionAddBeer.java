package BeerShop.steps;

import BeerShop.pages.AdminPage;
import BeerShop.pages.AdminProfilePage;
import BeerShop.steps.serenity.LoginAdminSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Map;

public class DefinitionAddBeer {
    @Steps
    LoginAdminSteps loginAdminSteps;

    @Steps
    AdminPage adminPage;

    @Steps
    AdminProfilePage adminProfilePage;

    @Given("^you are logged in as administrator with valid data:$")
    public void youAreLoggedInAsAdministratorWithUsernameAndPassword(Map<String,String> data)  {
       loginAdminSteps.goToLoginPage();
       loginAdminSteps.loginAsAdmin(data);

    }

    @When("^admin  clicks on add beers$")
    public void adminClicksOnAddBeers() {
         loginAdminSteps.clickButtonAddBeer();
    }

    
    @And("^beer all beer credentials are filled:$")
    public void beerAllBeerCredientialsNameDescriptionPriceAndQuantityAreFilled(Map<String,String> data){
        loginAdminSteps.addNewBeer(data);

    }


    @Then("^beer is successfully added to the  list$")
    public void beerIsSuccessfullyAddedToTheList()  {
        Assert.assertEquals("Uploaded successfully.",adminProfilePage.getSuccessfullMessage().getText());
    }


}
