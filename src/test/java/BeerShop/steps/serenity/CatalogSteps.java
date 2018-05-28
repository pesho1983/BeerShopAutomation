package BeerShop.steps.serenity;

import BeerShop.pages.CatalogPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CatalogSteps {
    CatalogPage catalogPage;


    @Step
    public void redirectToCatalog() {
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
    public String getTitle() {
        return catalogPage.getTitle();
    }

    @Step
    public void assertProductIsloaded() {
        redirectToCatalog();
        Assert.assertEquals("TestBeer1912", getProductName(1));
    }

    @Step
    public void assertUserIsOnCatalogPage(){
        Assert.assertEquals("Catalog", getTitle());
    }
}
