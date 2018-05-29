package BeerShop.steps;

import BeerShop.steps.serenity.IndexSteps;
import BeerShop.steps.serenity.LoginSteps;
import BeerShop.steps.serenity.WalletSteps;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.Map;



public class WalletDefinitionSteps {
    private String currentMoney;
    private float depositMoney;

    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    WalletSteps walletSteps;


    @Given("^a user is logged in with valid credentials:$")
    public void aUserIsLoggedInWithValidCredentials(Map<String,String> data){
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();
    }

    @And("^the user is on wallet page with zero funds:$")
    public void theUserIsOnWalletPageWithZeroFunds( Map<String,Float> data) {
        loginSteps.clickOnWalletLink();
        walletSteps.addMoney(data);
        walletSteps.pressDepositButton();
    }

    @When("^add additional funds to the personal account:$")
    public void addAdditionalFundsToThePersonalAccount( Map<String,Float> data) {
        walletSteps.addMoney(data);
        walletSteps.pressDepositButton();
    }

    @Then("^the funds are added to users personal account:$")
    public void theFundsAreAddedToUsersPersonalAccount( Map<String,String> data)  {
        walletSteps.assertCurrentBalance(data);
    }


    @Given("^the user is on wallet page$")
    public void theUserIsOnWalletPage()  {
        loginSteps.clickOnWalletLink();
        walletSteps.pressDepositButton();

    }

    @Then("^current balance increase or decrease with the additional funds:$")
    public void currentBalanceIncreaseOrDecreaseWithTheAdditionalFunds()  {
        walletSteps.assertBalanceChange(currentMoney, depositMoney);
    }

    @When("^add additional funds to the personal account and calculate:$")
    public void addAdditionalFundsToThePersonalAccountAndCalculate(@Transpose Map<String,Float> data) {
        currentMoney = walletSteps.getCurrentBalance();
        depositMoney = data.get("deposit");
        walletSteps.addMoney(data);
        walletSteps.pressDepositButton();
    }

    @Then("^current balance is:$")
    public void currentBalanceIs( Map<String, String> data)  {
        walletSteps.assertCurrentBalance(data);
    }

    @When("^add special characters in deposit field:$")
    public void addSpecialCharactersInDepositField(@Transpose Map<String,String> data) {
       walletSteps.addSymbols(data);
       walletSteps.pressDepositButton();
    }

    @Then("^current balance is the same as before:$")
    public void currentBalanceIsTheSameAsBefore(Map<String, String> data) {
        walletSteps.assertCurrentBalance(data);
    }


//    @Then("^current balance will increased with additional funds$")
//    public void currentBalanceWillIncreasedWithAdditionalFunds() throws Throwable {
//
//    }

//    @Then("^current balance will be (\\d+)\.(\\d+)$")
//    public void currentBalanceWillBe(int arg0, int arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

//    @When("^adding special characters in Deposit field:$")
//    public void addingSpecialCharactersInDepositField() throws Throwable {
//
//    }
//
//    @Then("^current balance will be the same as before$")
//    public void currentBalanceWillBeTheSameAsBefore() throws Throwable {
//
//    }
//
//    @And("^the user has enough money in wallet$")
//    public void theUserHasEnoughMoneyInWallet() throws Throwable {
//
//    }
//
//    @And("^the user is on order prevew page$")
//    public void theUserIsOnOrderPrevewPage() throws Throwable {
//
//    }
//
//    @When("^click on button place order:$")
//    public void clickOnButtonPlaceOrder() throws Throwable {
//
//    }
//
//    @Then("^order has been placed$")
//    public void orderHasBeenPlaced() throws Throwable {
//
//    }
//
//    @And("^current amount in wallet is less with total order price$")
//    public void currentAmountInWalletIsLessWithTotalOrderPrice() throws Throwable {
//
//    }
//
//    @And("^there is not enough money in wallet$")
//    public void thereIsNotEnoughMoneyInWallet() throws Throwable {
//
//    }
//
//    @Then("^order hasn't been placed$")
//    public void orderHasnTBeenPlaced() throws Throwable {
//
//    }
//
//    @And("^there is warning message$")
//    public void thereIsWarningMessage() throws Throwable {
//
//    }
}
