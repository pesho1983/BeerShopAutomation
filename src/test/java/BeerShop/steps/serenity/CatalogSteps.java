package BeerShop.steps.serenity;

import BeerShop.pages.CatalogPage;
import net.thucydides.core.annotations.Step;

public class CatalogSteps {
    CatalogPage catalogPage;


    @Step
    public void redirectToCatalog(){
        catalogPage.open();
    }
    @Step
    public void clickOnAddToCart(int product) {
        catalogPage.clickOnAddToCart(product);
    }

    @Step
    public String getProductName(int product) {
       return catalogPage.getProductName(product);
    }

    @Step
    public String getTitle(){
        return catalogPage.getTitle();
    }
}
