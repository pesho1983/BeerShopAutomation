package BeerShop.steps;

import BeerShop.Utils.ShippingDetails;
import BeerShop.Utils.constants.BasketConstants;
import BeerShop.entities.User;
import BeerShop.pages.BasketPage;
import BeerShop.pages.OrdersPage;
import BeerShop.steps.serenity.BasketSteps;
import BeerShop.steps.serenity.LoginSteps;
import BeerShop.steps.serenity.ProfileSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;
import java.util.Random;


public class BasketDefinitionSteps {
    private static String name;
    private static String userFirstName;
    private static String result;
    private int productCount;
    private Random random = new Random();
    public float cartTotal;
    public float cartTotalPrice;
    public OrdersPage ordersPage;

    @Steps
    BasketSteps basketSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    ProfileSteps profileSteps;

    BasketPage basketPage;

    @Given("^a user is logged in:$")
    public void aUserIsLoggedIn(List<User> user) {
        loginSteps.openSite();
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();

    }

    @When("^the user navigates to basket page$")
    public void aUserNavigatesToBasketPage() {
        basketSteps.openBasketPage();
    }

    @Then("^informational message \"([^\"]*)\" should appear$")
    public void informationalMessageShouldAppear(String message) {
        basketSteps.assertMessageEquals(message);
    }

    @When("^user adds product (\\d+) to shopping cart$")
    public void userAddsProductToShoppingCart(int product) {
        name = basketSteps.getCatalogProductName(product);
        basketSteps.clickOnAddToCart(product);
    }

    @Then("^user should be redirected to \"([^\"]*)\"$")
    public void userShouldBeRedirectedTo(String title) {
        basketSteps.assertTitle(title);
    }

    @And("^the product is present$")
    public void theProductIsPresent() {
        basketSteps.assertMessageEquals(name);
    }

    @When("^(?:user|the user) adds (\\d+) products to shopping cart$")
    public void aUserAddsMultipleProductsToShoppingCart(int productCount) {
        this.productCount = productCount;
        basketSteps.addMultipleProducts(productCount, random);
    }

    @Then("^the products are present$")
    public void theProductsArePresent() {
        basketSteps.assertBeerQuantity(String.valueOf(this.productCount));
    }

    @When("^user is on the \"([^\"]*)\" page$")
    public void userIsOnTheBasketPage(String targetPage) {
        switch (targetPage) {
            case "Basket":
                basketSteps.openBasketPage();
        }
    }

    @And("^user clicks the \"([^\"]*)\" (?:button|icon)")
    public void userClicksTheButton(String buttonName) {
        cartTotal = basketSteps.calculateCartTotal();
        cartTotalPrice = ordersPage.getCartTotalPrice();
        basketSteps.clickButton(buttonName);
    }

    @And("^(?:user|the user) had added product in his basket")
    public void productIsAddedToTheBasket() {
        basketSteps.clickOnAddToCart(random.nextInt(12) + 1);
    }

    @Then("^the product is removed from the \"Basket\"$")
    public void theProductIsRemovedFromTheBasket() {
        basketSteps.assertMessageEquals(BasketConstants.EMPTY_CART_MESSAGE);
    }

    @When("^the user changes the quantity:$")
    public void aUserIncreasesTheQuantity(Map<String, String> data) {
        result = data.get("quantity");
        basketSteps.manipulateQuantity(data.get("quantity"));
    }

    @Then("^the product quantity should be changed$")
    public void theProductQuantityShouldBeChanged() {
        basketSteps.assertBeerQuantity(result);
    }

    @Then("^product quantity remains unchanged$")
    public void productQuantityRemainsUnchanged() {
        basketSteps.assertMessageEquals("1");
    }

    @Then("^the product is removed from cart$")
    public void theProductIsRemovedFromCart() {
        basketSteps.assertMessageEquals(BasketConstants.EMPTY_CART_MESSAGE);
    }

    @Then("^the product subtotal should be calculated$")
    public void theProductSubtotalShouldBeCalculated() {
        basketSteps.assertBeerPrice(result);

    }

    @Then("^basket total price is summed$")
    public void basketTotalPriceIsSummed() {
        basketSteps.assertBeerTotalPrice();
    }

    @Then("^the \"([^\"]*)\" are displayed$")
    public void theShippingDetailsAreDisplayed(String shippingDetails) {
        basketSteps.assertShippingDetails(shippingDetails);
    }

    @Then("^the information corresponds to the logged user$")
    public void theInformationCorrespondsToTheLoggedUser() {
        userFirstName = basketSteps.getShippingDetails(ShippingDetails.FIRST_NAME);
        basketSteps.assertUserFirstname(userFirstName);
    }

    @Then("^the \"([^\"]*)\" message appears$")
    public void theSuccessOrderMessageAppears(String orderSuccess) {
        basketSteps.assertMessageEquals(orderSuccess);
    }

    @Then("^an error (?:message containing|message) \"([^\"]*)\" appears$")
    public void anErrorMessageAboutInsufficientFundsAppears(String message) {
        basketSteps.assertMessageEquals(message);
    }

}
