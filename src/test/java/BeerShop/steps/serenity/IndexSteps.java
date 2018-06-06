package BeerShop.steps.serenity;

import BeerShop.pages.IndexPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

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


}
