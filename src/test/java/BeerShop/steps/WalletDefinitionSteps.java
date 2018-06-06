package BeerShop.steps;

import BeerShop.pages.BasketPage;
import BeerShop.steps.serenity.*;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.Map;


public class WalletDefinitionSteps {
    public float totalPriceFromBasket;
    private String currentMoney;
    private float depositMoney;

    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    WalletSteps walletSteps;
    @Steps
    CatalogSteps catalogSteps;
    @Steps
    BasketSteps basketSteps;
    @Steps
    BasketDefinitionSteps basketDefinitionSteps;

    BasketPage basketPage;


    @Given("^a user is logged in with valid credentials:$")
    public void aUserIsLoggedInWithValidCredentials(Map<String, String> data) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();
    }

//    @And("^the user is on wallet page with zero funds:$")
//    public void theUserIsOnWalletPageWithZeroFunds(Float data) {
//        loginSteps.clickOnWalletLink();
//        walletSteps.addMoney(data);
//        walletSteps.pressDepositButton();
//    }

    @Then("^the funds are added to user's personal account:$")
    public void theFundsAreAddedToUsersPersonalAccount(String data) {
        walletSteps.assertCurrentBalance(data);
    }

    @Given("^the user is on wallet page$")
    public void theUserIsOnWalletPage() {
        loginSteps.clickOnWalletLink();
        walletSteps.pressDepositButton();
    }

    @Then("^current balance increase or decrease with the additional funds:$")
    public void currentBalanceIncreaseOrDecreaseWithTheAdditionalFunds() {
        walletSteps.assertBalanceChange(currentMoney, depositMoney);
    }

    @Then("^current balance should be \"([^\"]*)\":$")
    public void currentBalanceShouldBe(String data) {
        walletSteps.assertCurrentBalance(data);
    }

    @When("^the user adds special characters in deposit field:$")
    public void theUserAddsSpecialCharactersInDepositField(@Transpose Map<String, String> data) {
        walletSteps.addSymbols(data);
        walletSteps.pressDepositButton();
    }

    @When("the user is on the wallet page and check his current balance$")
    public String theUserIsOnTheWalletPageAndCheckHisCurrentBalance() {
        loginSteps.clickOnWalletLink();
        return currentMoney = walletSteps.getCurrentBalance();
    }

    @When("^the user adds \"([^\"]*)\" funds to the personal account$")
    public void theUserAddsFundsToThePersonalAccount(Float data) {
        walletSteps.addMoney(data);
        walletSteps.getCurrentBalance();
        walletSteps.pressDepositButton();
    }

    @When("^the user is on order preview page:$")
    public void theUserIsOnOrderPrevewPage(Map<String, Integer> product) {
        catalogSteps.redirectToCatalog();
        basketSteps.clickOnAddToCart(product.get("product"));
        totalPriceFromBasket = basketPage.getCartTotal();
    }

    @Then("^current amount in wallet is less with total order price$")
    public void currentAmountInWalletIsLessWithTotalOrderPrice() {
        catalogSteps.redirectToCatalog();
        loginSteps.clickOnWalletLink();
        float cartPrice = basketDefinitionSteps.cartTotalPrice;
        float moneyBeforeBuy = Float.parseFloat(currentMoney);
        float moneyInWallet = Float.valueOf(walletSteps.getCurrentBalance());
        walletSteps.assertPurchaseBalanceChange(moneyInWallet, moneyBeforeBuy, totalPriceFromBasket);
    }

    @Then("^\"([^\"]*)\" funds are added to the account$")
    public void fundsAreAddedToTheAccount(float value) {
        walletSteps.assertBalanceIsChanged(value, currentMoney);
    }

    @When("^the user has enough money to buy beer$")
    public void theUserHasEnoughMoneyToBuyBeer() {
        loginSteps.clickOnWalletLink();
        walletSteps.checkIfTheBalanceIsEnough();
        currentMoney = walletSteps.getCurrentBalance();
    }

    @When("^user press \"([^\"]*)\" and \"([^\"]*)\" buttons to confirm order$")
    public void userPressAndButtonsToConfirmOrder(String checkout, String placeOrder)  {
        basketSteps.clickButton(checkout);
        basketSteps.clickButton(placeOrder);
    }
}