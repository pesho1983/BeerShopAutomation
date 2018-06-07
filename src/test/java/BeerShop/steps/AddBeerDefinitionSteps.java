package BeerShop.steps;

import BeerShop.entities.User;
import BeerShop.pages.AdminPanelPage;
import BeerShop.pages.AddBeerPage;
import BeerShop.steps.serenity.AddBeerSteps;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddBeerDefinitionSteps {
    @Steps
    AddBeerSteps addBeerSteps;


    @Given("^you are logged in as administrator with valid data:$")
    public void youAreLoggedInAsAdministratorWithUsernameAndPassword(@Transpose List<User> user)  {
       addBeerSteps.goToLoginPage();
       addBeerSteps.loginAsAdmin(user);
    }

    @When("^admin clicks on add beers$")
    public void adminClicksOnAddBeers() {
         addBeerSteps.clickButtonAddBeer();
    }

    
    @When("^beer all beer credentials are filled:$")
    public void beerAllBeerCredientialsNameDescriptionPriceAndQuantityAreFilled(Map<String,String> data){
        addBeerSteps.addNewBeer(data);
    }

    @Then("^successful \"([^\"]*)\" message appears.$")
    public void successfullMessageAppears(String message) {
       addBeerSteps.assertSuccessfulMessage(message);
    }

    @When("^user add data:$")
    public void userAddData(@Transpose Map<String,String> data){
        addBeerSteps.fillCredentials(data);
    }

    @Then("(.*) appears:$")
    public void assertMessageAppears(String message){
         addBeerSteps.assertDangerMessage(message);

    }

    @Then("(.*) about the same name is displayed:$")
    public void messageAboutTheSameNameIsDisplayed(String message){
        addBeerSteps.assertMessageSameName(message);
    }
}
