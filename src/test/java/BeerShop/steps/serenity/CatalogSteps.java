package BeerShop.steps.serenity;

import BeerShop.pages.CatalogPage;
import net.thucydides.core.annotations.Step;

public class CatalogSteps {
    CatalogPage catalogPage;


    @Step
    public void clickOnAddToCart(int product){
        catalogPage.clickOnAddToCart(product);
    }
}
