package BeerShop.steps.serenity;

import BeerShop.pages.BasketPage;
import net.thucydides.core.annotations.Step;

public class BasketSteps {

    BasketPage basketPage;

    @Step
    public void openBasketPage(){
        basketPage.open();
    }
}
