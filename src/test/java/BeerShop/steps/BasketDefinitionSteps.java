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

    @Given("^a user is logged in:$")
    public void aUserIsLoggedIn() {
    }

    @When("^a user navigates to basket page$")
    public void aUserNavigatesToBasketPage() {
    }

    @Then("^Informational message \"([^\"]*)\" should appear$")
    public void informationalMessageShouldAppear(String arg0) {
    }

    @When("^user adds product to shopping cart$")
    public void userAddsProductToShoppingCart() {
    }

    @Then("^user should be redirected to \"([^\"]*)\"$")
    public void userShouldBeRedirectedTo(String arg0) {
    }

    @And("^the product is present$")
    public void theProductIsPresent() {
    }

    @When("^a user adds multiple products to shopping cart$")
    public void aUserAddsMultipleProductsToShoppingCart() {
    }

    @Then("^a user should be redirected to \"([^\"]*)\"$")
    public void aUserShouldBeRedirectedTo(String arg0) {
    }

    @And("^the products are present$")
    public void theProductsArePresent() {
    }

    @And("^user is on the \"([^\"]*)\" page$")
    public void userIsOnThePage(String arg0) {
    }

    @When("^pressing \"([^\"]*)\" button is clicked$")
    public void pressingButtonIsClicked(String arg0) {
    }

    @Then("^a user is redirected to \"([^\"]*)\"$")
    public void aUserIsRedirectedTo(String arg0) {
    }

    @When("^pressing the wallet icon$")
    public void pressingTheWalletIcon() {
    }

    @Then("^a user is redirected to wallet page$")
    public void aUserIsRedirectedToWalletPage() {
    }

    @And("^product is added to the basket$")
    public void productIsAddedToTheBasket() {
    }

    @When("^pressing on the trash button icon$")
    public void pressingOnTheTrashButtonIcon() {
    }

    @Then("^the product is removed from the \"([^\"]*)\"$")
    public void theProductIsRemovedFromThe(String arg0) {
    }

    @When("^pressing the \"([^\"]*)\" button$")
    public void pressingTheButton(String arg0) {
    }

    @When("^a user increases the quantity$")
    public void aUserIncreasesTheQuantity() {
    }

    @Then("^the product quantity should be changed$")
    public void theProductQuantityShouldBeChanged() {
    }

    @When("^a user sets quantity to negative number$")
    public void aUserSetsQuantityToNegativeNumber() {
    }

    @Then("^an alert message appears$")
    public void anAlertMessageAppears() {
    }

    @And("^product quantity remains unchanged$")
    public void productQuantityRemainsUnchanged() {
    }

    @When("^a user sets quantity to zero$")
    public void aUserSetsQuantityToZero() {
    }

    @Then("^the product is removed from cart$")
    public void theProductIsRemovedFromCart() {
    }

    @Then("^the product subtotal should be calculated$")
    public void theProductSubtotalShouldBeCalculated() {
    }

    @When("^adding multiple product to the basket$")
    public void addingMultipleProductToTheBasket() {
    }

    @Then("^basket total price is summed$")
    public void basketTotalPriceIsSummed() {
    }

    @Then("^the shipping details are displayed$")
    public void theShippingDetailsAreDisplayed() {
    }

    @And("^the information corresponds to the logged user$")
    public void theInformationCorrespondsToTheLoggedUser() {
    }

    @And("^on the \"([^\"]*)\" page$")
    public void onThePage(String arg0) {
    }

    @Then("^a user is redirected to an order success page$")
    public void aUserIsRedirectedToAnOrderSuccessPage() {
    }

    @And("^the success order message appears$")
    public void theSuccessOrderMessageAppears() {
    }

    @Then("^an error message about insufficient funds appears$")
    public void anErrorMessageAboutInsufficientFundsAppears() {
    }

    @Then("^an error message about insufficient amount appears$")
    public void anErrorMessageAboutInsufficientAmountAppears() {
    }
}
