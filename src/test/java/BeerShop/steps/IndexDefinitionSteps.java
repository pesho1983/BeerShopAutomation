package BeerShop.steps;

import BeerShop.entities.User;
import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import BeerShop.steps.serenity.WalletSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class IndexDefinitionSteps {
    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    WalletSteps walletSteps;


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
    public void theUserIsOnWalletPage( float data){
        loginSteps.clickOnWalletLink();
        walletSteps.addMoney(data);
        walletSteps.pressDepositButton();
    }
//    Map<String, Float>

    @Then("^go back to Index page current bought beer have to be shown$")
    public void currentBoughtBeerHaveToBeShown() {
        indexSteps.openURL();
        indexSteps.assertLastThreeSoldBeersAreOnIndexPage();
    }

}
