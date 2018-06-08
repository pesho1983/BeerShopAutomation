package BeerShop.steps;

import BeerShop.steps.serenity.BasketSteps;
import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import BeerShop.steps.serenity.WalletSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.Map;
import java.util.Random;

public class IndexDefinitionSteps {
    public static String name;
    private Random random = new Random();

    @Steps
    LoginSteps loginSteps;
    @Steps
    IndexSteps indexSteps;
    @Steps
    BasketSteps basketSteps;
    @Steps
    WalletSteps walletSteps;

    @Given("^user is on Catalog page logged in with$")
    public void iAmOnCatalogPageLoggedInWith(Map<String, String> data) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();
    }

    @And("^(?:user|the user) had added random product in his basket")
    public void productIsAddedToTheBasket() {
        basketSteps.clickOnAddToCart(random.nextInt(12) + 1);
        name = basketSteps.getProductName();

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
        indexSteps.assertLastSoldBeer(name);
    }
}
