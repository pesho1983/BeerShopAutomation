package BeerShop.steps;

import BeerShop.steps.serenity.BasketSteps;
import BeerShop.steps.serenity.LoginSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Map;

public class BasketDefinitionSteps {
    private static String name;
    private static String result;
    private static int subtotal;

    @Steps
    BasketSteps basketSteps;

    @Steps
    LoginSteps loginSteps;

    @Given("^a user is logged in:$")
    public void aUserIsLoggedIn(Map<String, String> data) {
        loginSteps.openSite();
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();

    }

    @When("^a user navigates to basket page$")
    public void aUserNavigatesToBasketPage() {
        basketSteps.openBasketPage();
    }

    @Then("^informational message \"([^\"]*)\" should appear$")
    public void informationalMessageShouldAppear(String message) {
        Assert.assertEquals(message, basketSteps.getEmptyBasketMessage());
    }

    @When("^user adds product (\\d+) to shopping cart$")
    public void userAddsProductToShoppingCart(int product) {
        name = basketSteps.getCatalogProductName(product);
        basketSteps.clickOnAddToCart(product);
    }

    @Then("^user should be redirected to \"([^\"]*)\"$")
    public void userShouldBeRedirectedTo(String title) {
        Assert.assertEquals(title, basketSteps.getTitle());
    }

    @And("^the product is present$")
    public void theProductIsPresent() {
        Assert.assertEquals(name, basketSteps.getFirstProductName());
    }

    @When("^a user adds multiple products to shopping cart$")
    public void aUserAddsMultipleProductsToShoppingCart() {
        basketSteps.clickOnAddToCart(1);
        basketSteps.clickContinueShopping();
        basketSteps.clickOnAddToCart(2);
    }

    @Then("^the products are present$")
    public void theProductsArePresent() {
        Assert.assertEquals(2, basketSteps.getProductCount());
    }

    @And("^user is on the \"Basket\" page$")
    public void userIsOnThePage() {
        basketSteps.openBasketPage();
    }

    @When("^pressing \"Continue Shopping\" button is clicked$")
    public void pressingButtonIsClicked() {
        basketSteps.clickContinueShopping();

    }

    @Then("^the user is redirected to \"([^\"]*)\"$")
    public void theUserIsRedirectedTo(String title) {
        Assert.assertEquals(title, basketSteps.getTitle());
    }

    @When("^pressing the wallet icon$")
    public void pressingTheWalletIcon() {
        basketSteps.clickOnWalletButton();
    }

//    @Then("^user should be redirected to \"([^\"]*)\"$")
//    public void theUserIsRedirectedToWalletPage(String wallet) {
//        Assert.assertEquals(wallet, basketSteps.getTitle());
//
//    }

    @And("^product is added to the basket$")
    public void productIsAddedToTheBasket() {
        basketSteps.clickOnAddToCart(1);
    }

    @When("^pressing on the trash button icon$")
    public void pressingOnTheTrashButtonIcon() {
        basketSteps.removeProduct();
    }

    @Then("^the product is removed from the \"Basket\"$")
    public void theProductIsRemovedFromTheBasket() {
        Assert.assertEquals("Your cart is empty.....", basketSteps.getEmptyBasketMessage());
    }

    @When("^pressing the \"Checkout\" button$")
    public void pressingTheCheckoutButton() {
        basketSteps.clickOnCheckout();
    }

    @When("^the user changes the quantity:$")
    public void aUserIncreasesTheQuantity(Map<String, String> data) {
        result = data.get("quantity");
        basketSteps.manipulateQuantity(data.get("quantity"));
    }

    @Then("^the product quantity should be changed$")
    public void theProductQuantityShouldBeChanged() {
        Assert.assertEquals(result, basketSteps.getQuantity());
    }

    @Then("^product quantity remains unchanged$")
    public void productQuantityRemainsUnchanged() {
        Assert.assertEquals("1", basketSteps.getQuantity());
    }

    @Then("^the product is removed from cart$")
    public void theProductIsRemovedFromCart() {
        Assert.assertEquals("Your cart is empty.....", basketSteps.getEmptyBasketMessage());
    }

    @Then("^the product subtotal should be calculated$")
    public void theProductSubtotalShouldBeCalculated() {
        subtotal = Integer.parseInt(result) * Integer.parseInt(basketSteps.getPrice());
        int actualSubtotal = Integer.parseInt(basketSteps.getSubtotal());
        Assert.assertEquals(subtotal, actualSubtotal);
    }

    @Then("^basket total price is summed$")
    public void basketTotalPriceIsSummed() {
        Assert.assertEquals(basketSteps.getCartTotal(), basketSteps.calculateCartTotal());
    }

    @When("^pressing the \"Place order\" button$")
    public void pressingThePlaceOrderButton()  {
        basketSteps.clickOnPlaceOrder();
    }

    @Then("^the shipping details are displayed$")
    public void theShippingDetailsAreDisplayed() {
    }

    @And("^the information corresponds to the logged user$")
    public void theInformationCorrespondsToTheLoggedUser() {
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
