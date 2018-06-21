package BeerShop.steps;

import BeerShop.steps.serenity.CatalogSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CatalogDefinitionSteps {
    private String option;
    @Steps
    CatalogSteps catalogSteps;


    @Given("^a user is on Catalog page$")
    public void aUserIsOnCatalogPage(){
        catalogSteps.openCatalogPage();
    }

    @When("^select order by (.*)$")
    public void selectOrderByName(String option){
        this.option = option;
        catalogSteps.sortProducts(option);
    }

    @When("^press Sort button$")
    public void pressSortButton() {
        catalogSteps.clickOnSortButton();
    }

    @Then("^beers should be sorted$")
    public void beersShouldBeSorted(){
        catalogSteps.assertOrderByOption(option);
    }
}
