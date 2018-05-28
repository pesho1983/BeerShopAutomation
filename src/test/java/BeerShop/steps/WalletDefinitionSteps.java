package BeerShop.steps;

import BeerShop.pages.WalletPage;
import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import BeerShop.steps.serenity.WalletSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Map;

public class WalletDefinitionSteps {

    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    WalletSteps walletSteps;
    @Steps
    WalletPage walletPage;


    @Given("^the user is logged in with valid credentials:$")
    public void theUserIsLoggedInWithValidCredentials(Map<String, String> data){
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        //loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();
    }

    @And("^the user is on wallet page with zero funds:$")
    public void theUserIsOnWalletPage(Map<String, String> data){
        loginSteps.clickOnWalletLink();
        walletSteps.addMoney(data);
        walletSteps.pressDepositButton();
    }

    @When("^adding additional funds to the personal account:$")
    public void addingAdditionalFundsToThePersonalAccount(Map<String, String> data) {
        walletSteps.addMoney(data);
        walletSteps.pressDepositButton();
    }

    @Then("^the funds are added to users personal account$")
    public void theFundsAreAddedToUsersPersonalAccount()  {
        Assert.assertEquals("Current balance: BGN 100.00",walletPage.getCurrentBalance().getText());
    }

    @Then("^current balance will increased with additional funds$")
    public void currentBalanceWillIncreasedWithAdditionalFunds() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

//    @Then("^current balance will be (\\d+)\.(\\d+)$")
//    public void currentBalanceWillBe(int arg0, int arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @When("^adding special characters in Deposit field:$")
    public void addingSpecialCharactersInDepositField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^current balance will be the same as before$")
    public void currentBalanceWillBeTheSameAsBefore() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the user has enough money in wallet$")
    public void theUserHasEnoughMoneyInWallet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the user is on order prevew page$")
    public void theUserIsOnOrderPrevewPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^click on button place order:$")
    public void clickOnButtonPlaceOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^order has been placed$")
    public void orderHasBeenPlaced() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^current amount in wallet is less with total order price$")
    public void currentAmountInWalletIsLessWithTotalOrderPrice() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^there is not enough money in wallet$")
    public void thereIsNotEnoughMoneyInWallet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^order hasn't been placed$")
    public void orderHasnTBeenPlaced() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^there is warning message$")
    public void thereIsWarningMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
