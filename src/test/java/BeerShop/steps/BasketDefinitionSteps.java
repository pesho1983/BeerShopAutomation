package BeerShop.steps;

import BeerShop.Utils.ShippingDetails;
import BeerShop.steps.serenity.BasketSteps;
import BeerShop.steps.serenity.LoginSteps;
import BeerShop.steps.serenity.ProfileSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import sun.java2d.cmm.Profile;

import java.util.Map;
import java.util.Random;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class BasketDefinitionSteps {
    private static String name;
    private static String userFirstName;
    private static String result;

    @Steps
    BasketSteps basketSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    ProfileSteps profileSteps;

    @Given("^a user is logged in:$")
    public void aUserIsLoggedIn(Map<String, String> data) {
        loginSteps.openSite();
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();

    }

    @When("^the user navigates to basket page$")
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
        Assert.assertEquals(title, getDriver().getTitle());
    }

    @And("^the product is present$")
    public void theProductIsPresent() {
        Assert.assertEquals(name, basketSteps.getFirstProductName());
    }

    @When("^(?:user|the user) adds multiple products to shopping cart$")
    public void aUserAddsMultipleProductsToShoppingCart() {
        basketSteps.clickOnAddToCart(1);
        basketSteps.clickContinueShopping();
        basketSteps.clickOnAddToCart(2);
    }

    @Then("^the products are present$")
    public void theProductsArePresent() {
        Assert.assertEquals(2, basketSteps.getProductCount());
    }

   @When("^user is on the \"([^\"]*)\" page$")
   public void userIsOnTheBasketPage(String targetPage) {
       switch(targetPage){
           case "Basket": basketSteps.openBasketPage();
       }
   }

    @And("^user clicks the \"([^\"]*)\" (?:button|icon)")
    public void userClicksTheButton(String buttonName) {
        buttonName = buttonName.replace("\"", "");
        switch (buttonName) {
            case "Checkout": basketSteps.clickOnCheckout(); break;
            case "Continue Shopping": basketSteps.clickContinueShopping(); break;
            case "Place order" : basketSteps.clickOnPlaceOrder(); break;
            case "Wallet" : basketSteps.clickOnWalletButton(); break;
            case "Thrash" : basketSteps.removeProduct(); break;
            default: break;
        }
    }

    @And("^(?:user|the user) had added product in his basket")
    public void productIsAddedToTheBasket() {
        Random random = new Random();
        basketSteps.clickOnAddToCart(random.nextInt(12) + 1);
    }

    @Then("^the product is removed from the \"Basket\"$")
    public void theProductIsRemovedFromTheBasket() {
        Assert.assertEquals("Your cart is empty.....", basketSteps.getEmptyBasketMessage());
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
        float subtotal = Float.parseFloat(result) * Float.parseFloat(basketSteps.getPrice());
        float actualSubtotal = Float.parseFloat(basketSteps.getSubtotal());
        Assert.assertEquals(subtotal, actualSubtotal, 0.1);

    }

    @Then("^basket total price is summed$")
    public void basketTotalPriceIsSummed() {
        Assert.assertEquals(basketSteps.getCartTotal(), basketSteps.calculateCartTotal(), 0.1);
    }

    @Then("^the \"([^\"]*)\" are displayed$")
    public void theShippingDetailsAreDisplayed(String shippingDetails) {
        Assert.assertEquals(shippingDetails, basketSteps.getShippingDetails(ShippingDetails.TITLE));
    }

    @Then("^the information corresponds to the logged user$")
    public void theInformationCorrespondsToTheLoggedUser() {
        //Assert is temporary hardcoded, because profile steps are not yet implemented, will be changed after.
        userFirstName = basketSteps.getShippingDetails(ShippingDetails.FIRST_NAME);
        Assert.assertEquals(profileSteps.getUserFirstName(), userFirstName);
    }

    @Then("^the \"([^\"]*)\" message appears$")
    public void theSuccessOrderMessageAppears(String orderSuccess) {
        Assert.assertEquals(orderSuccess, basketSteps.getOrderSuccessMessage());
    }

    @Then("^an error (?:message containing|message) \"([^\"]*)\" appears$")
    public void anErrorMessageAboutInsufficientFundsAppears(String message) {
        Assert.assertEquals(true, basketSteps.getErrorMessage().contains(message));
    }
}
