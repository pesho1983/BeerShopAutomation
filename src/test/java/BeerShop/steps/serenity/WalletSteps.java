package BeerShop.steps.serenity;

import BeerShop.pages.WalletPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class WalletSteps {

    WalletPage walletPage;

    @Step
    public void addMoney(Map<String, String> data) {
        walletPage.getMoneyField().type(data.get("deposit"));
    }

    @Step
    public void pressDepositButton() {
        walletPage.getDepositButton().click();
    }

    @Step
    public void assertCurrentBalance() {
       walletPage.getCurrentBalance().getText();
    }
}
