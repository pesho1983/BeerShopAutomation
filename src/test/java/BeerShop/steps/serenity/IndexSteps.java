package BeerShop.steps.serenity;

import BeerShop.entities.User;
import BeerShop.pages.IndexPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static BeerShop.Utils.constants.BasketConstants.*;


public class IndexSteps {
    IndexPage indexPage;
    @Steps
    BasketSteps basketSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    WalletSteps walletSteps;
    private Random random = new Random();
    private int numberOfPurchasedBeers;

    @Step
    public void openURL() {
        indexPage.open();
    }

    @Step
    public void clickOnLoginNavLink() {
        indexPage.clickOnLoginNavLink();
    }

    @Step
    public void addProductToBasket(int numberOfPurchasedBeers){
        this.numberOfPurchasedBeers = numberOfPurchasedBeers;
        for (int i = 0; i < numberOfPurchasedBeers; i++){
            basketSteps.clickOnAddToCart(random.nextInt(12) + 1);
            basketSteps.getProductName();
            if (numberOfPurchasedBeers != 1 & i < numberOfPurchasedBeers){
                basketSteps.clickButton(CONTINUE_SHOPPING_BUTTON);
            }
        }
    }

    @Step
    public void loginInSite(List<User> user){
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();
    }

//    @Step
//    public void theUserAddMoney(Map<String, String> data){
//        loginSteps.clickOnWalletLink();
//        walletSteps.addMoney(data);
//        walletSteps.pressDepositButton();
//    }

    @Step
    public void assertLastThreeSoldBeersAreOnIndexPage() {
        basketSteps.assertIfLastSoldBeerIsOnIndexPage(numberOfPurchasedBeers);
    }
}
