package BeerShop.steps.serenity;

import BeerShop.pages.BasketPage;
import BeerShop.pages.WalletPage;
import BeerShop.steps.BasketDefinitionSteps;
import BeerShop.steps.WalletDefinitionSteps;
import cucumber.api.Transpose;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class WalletSteps {

    WalletPage walletPage;
    BasketPage basketPage;
    WalletDefinitionSteps walletDefinitionSteps;
    LoginSteps loginSteps;
    BasketDefinitionSteps basketDefinitionSteps;

    @Step
    public void addMoney(float data) {
        String money = Float.toString(data);
        walletPage.getMoneyField().type(money);
    }

    @Step
    public void addSymbols(@Transpose Map<String, String> data) {
        walletPage.getMoneyField().type(data.get("deposit"));
    }

    @Step
    public void pressDepositButton() {
        walletPage.pressDepositButton();
    }

    @Step
    public String getCurrentBalance() {
        return walletPage.getCurrentBalanceElement().getText().replace("Current balance: BGN ", "");
    }

    @Step
    public void assertCurrentBalance(String data) {
        Assert.assertEquals(data, walletPage.getCurrentBalanceElement().getText());
    }

    @Step
    public void assertBalanceChange(String currentBalance, float depositBalance) {
        float balanceChange = Float.parseFloat(currentBalance) + depositBalance;
        Assert.assertEquals(Float.parseFloat(getCurrentBalance()), balanceChange, 0.001);
    }

    @Step
    public void assertPurchaseBalanceChange(float currentMoney, float moneyBeforeBuy, float cartPrice) {
        float balanceChange = moneyBeforeBuy - cartPrice;
        Assert.assertEquals(currentMoney, balanceChange, 0.001);
    }

    @Step
    public void assertBalanceIsChanged(float value, String currentMoney) {
        float balanceBeforeTheTransaction = (Float.parseFloat(currentMoney) + value);
        float currentBalance = Float.parseFloat(getCurrentBalance());
        Assert.assertEquals(balanceBeforeTheTransaction, currentBalance, 0.01);
    }

    @Step
    public void checkIfTheBalanceIsEnough() {
        if (Float.parseFloat(getCurrentBalance()) <= 50) {
            addMoney(Float.parseFloat("50"));
            pressDepositButton();
        }
    }
}

