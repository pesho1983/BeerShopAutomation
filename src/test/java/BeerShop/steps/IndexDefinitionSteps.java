package BeerShop.steps;

import BeerShop.entities.User;
import BeerShop.steps.serenity.IndexSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class IndexDefinitionSteps {
    @Steps
    IndexSteps indexSteps;


    @Given("^user is on Catalog page logged in with$")
    public void iAmOnCatalogPageLoggedInWith(List<User> user) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        indexSteps.loginInSite(user);
    }

    @And("the user adds (\\d+) products in the basket")
    public void productIsAddedToTheBasket(int numberOfPurchasedBeers) {
        indexSteps.addProductToBasket(numberOfPurchasedBeers);
    }

    @And("^user is on wallet page and add funds:$")
    public void theUserIsOnWalletPage(Map<String, String> data){
        indexSteps.theUserAddMoney(data);
    }


    @Then("^go back to Index page current bought beer have to be shown$")
    public void currentBoughtBeerHaveToBeShown() {
        indexSteps.openURL();
        indexSteps.assertLastThreeSoldBeersAreOnIndexPage();
    }

}
