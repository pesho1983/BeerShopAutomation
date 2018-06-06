package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class WalletPage extends PageObject {

    @FindBy(name = "money")
    private WebElementFacade moneyField;

    @FindBy(name="deposit")
    private WebElementFacade depositButton;

    @FindBy (id="money")
    private WebElementFacade currentBalance;

    public WebElementFacade getMoneyField() {
        return moneyField;
    }

    public WebElementFacade getCurrentBalanceElement() {
        return currentBalance;
    }
    public WalletPage pressDepositButton() {
        this.depositButton.click();
        return this;
    }

}
