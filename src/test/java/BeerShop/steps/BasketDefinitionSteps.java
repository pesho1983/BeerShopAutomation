package BeerShop.steps;

import BeerShop.steps.serenity.BasketSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BasketDefinitionSteps {
    @Steps
    BasketSteps basketSteps;


    @Given("^The user is logged in:$")
    public void theUserIsLoggedIn() {

    }

    @When("^The user navigates to basket page$")
    public void theUserNavigatesToBasketPage() {

    }

    @Then("^Informational message \"([^\"]*)\" should appear$")
    public void informationalMessageShouldAppear(String arg0) {

    }

    @When("^The user adds product to shopping cart$")
    public void theUserAddsProductToShoppingCart() {


    }

    @Then("^The user should be redirected to \"([^\"]*)\"$")
    public void theUserShouldBeRedirectedTo(String arg0) {


    }

    @And("^The product is present$")
    public void theProductIsPresent() {


    }

    @Given("^Given The user is logged in:$")
    public void givenTheUserIsLoggedIn() {


    }

    @When("^The user adds multiple products to shopping cart$")
    public void theUserAddsMultipleProductsToShoppingCart() {


    }

    @And("^The products are present$")
    public void theProductsArePresent() {


    }

    @When("^Pressing \"([^\"]*)\" button is clicked$")
    public void pressingButtonIsClicked(String arg0) {


    }

    @Then("^The user is redirected to \"([^\"]*)\"$")
    public void theUserIsRedirectedTo(String arg0) {


    }

    @When("^Pressing the wallet icon$")
    public void pressingTheWalletIcon() {


    }

    @Then("^The user is redirected to wallet page$")
    public void theUserIsRedirectedToWalletPage() {


    }

    @And("^Product is added to the basket$")
    public void productIsAddedToTheBasket() {


    }

    @When("^Pressing on the trash button icon$")
    public void pressingOnTheTrashButtonIcon() {


    }

    @Then("^The product is removed from the \"([^\"]*)\"$")
    public void theProductIsRemovedFromThe(String arg0) {


    }

    @When("^Pressing the \"([^\"]*)\" button$")
    public void pressingTheButton(String arg0) {


    }

    @When("^The user increases the quantity$")
    public void theUserIncreasesTheQuantity() {


    }

    @Then("^The product quantity should be changed$")
    public void theProductQuantityShouldBeChanged() {


    }

    @When("^The user sets quantity to negative number$")
    public void theUserSetsQuantityToNegativeNumber() {


    }

    @Then("^An alert message appears$")
    public void anAlertMessageAppears() {


    }

    @And("^Product quantity remains unchanged$")
    public void productQuantityRemainsUnchanged() {


    }

    @When("^The user sets quantity to zero$")
    public void theUserSetsQuantityToZero() {


    }

    @Then("^The product is removed from cart$")
    public void theProductIsRemovedFromCart() {


    }

    @Then("^The product subtotal should be calculated$")
    public void theProductSubtotalShouldBeCalculated() {


    }

    @When("^Adding multiple product to the basket$")
    public void addingMultipleProductToTheBasket() {


    }

    @Then("^Basket total price is summed$")
    public void basketTotalPriceIsSummed() {


    }

    @Then("^The shipping details are displayed$")
    public void theShippingDetailsAreDisplayed() {


    }

    @And("^The information corresponds to the logged user$")
    public void theInformationCorrespondsToTheLoggedUser() {


    }

    @And("^On the \"([^\"]*)\" page$")
    public void onThePage(String arg0) {


    }

    @Then("^The user is redirected to an order success page$")
    public void theUserIsRedirectedToAnOrderSuccessPage() {


    }

    @And("^The success order message appears$")
    public void theSuccessOrderMessageAppears() {


    }

    @Then("^An error message about insufficient funds appears$")
    public void anErrorMessageAboutInsufficientFundsAppears() {


    }

    @Then("^An error message about insufficient amount appears$")
    public void anErrorMessageAboutInsufficientAmountAppears() {


    }

    @And("^User is on the \"([^\"]*)\" page$")
    public void userIsOnThePage(String arg0) {

    }
}
