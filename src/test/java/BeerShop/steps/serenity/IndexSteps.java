package BeerShop.steps.serenity;

import BeerShop.pages.IndexPage;
import net.thucydides.core.annotations.Step;

import org.junit.Assert;


public class IndexSteps {
    IndexPage indexPage;

    @Step
    public void openURL() {
        indexPage.open();
    }

    @Step
    public void clickOnLoginNavLink() {
        indexPage.getLogin().click();
    }

    @Step
    public void assertLastSoldBeer(String lastSoldBeer){
        Assert.assertEquals(lastSoldBeer, indexPage.getLastSoldBeer().getText());
    }

}
