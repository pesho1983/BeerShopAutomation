package BeerShop.steps.serenity;

import BeerShop.pages.CatalogPage;
import BeerShop.pages.IndexPage;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;
import org.junit.Assert;

import static BeerShop.Utils.Utils.WEBSITE_URL;

public class CatalogSteps {
    CatalogPage catalogPage;
    IndexPage indexPage;

    @Step
    public void openCatalogPage(){
        indexPage.open();
        indexPage.clickOnCatalogNavLink();
    }

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

    @Step
    public void clickOnSortButton(){
        catalogPage.clickOnSortButton();
    }

    @Step
    public void sortProducts(String option){
        catalogPage.clickOnSelectOrderBy();
        catalogPage.sortProductsBy(option);
    }

    @Step
    public void assertOrderByOption(String option){
        Assert.assertTrue(catalogPage.compareProduct(option));
    }
}
