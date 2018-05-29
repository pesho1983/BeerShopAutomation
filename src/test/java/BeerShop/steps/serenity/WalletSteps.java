package BeerShop.steps.serenity;

import BeerShop.pages.WalletPage;
import cucumber.api.Transpose;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class WalletSteps {

    WalletPage walletPage;

    @Step
    public void addMoney(@Transpose Map<String, Float> data) {
        walletPage.getMoneyField().type(data.get("deposit").toString());
    }

    @Step
    public void addSymbols(@Transpose Map<String, String> data) {
        walletPage.getMoneyField().type(data.get("deposit"));
    }

    @Step
    public void pressDepositButton() {
        walletPage.getDepositButton().click();
    }

    @Step
    public String getCurrentBalance(){
        return walletPage.getCurrentBalance().getText().replace("Current balance: BGN ", "");
    }

    @Step
    public void assertCurrentBalance(@Transpose Map<String, String> data) {
        String successMessage = data.get("funds");
        Assert.assertEquals(successMessage, walletPage.getCurrentBalance().getText());
    }

    @Step
    public void assertBalanceChange(String currentBalance, float depositBalance){
        float balanceChange = Float.parseFloat(currentBalance) + depositBalance;
        Assert.assertEquals(Float.parseFloat(getCurrentBalance()), balanceChange, 0.001);
    }
}
