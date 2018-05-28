package BeerShop.steps.serenity;

import BeerShop.pages.AdminProfilePage;
import net.thucydides.core.annotations.Step;

public class AdminProfilePageSteps {

    AdminProfilePage adminProfilePage;

    @Step
    public void clickOnUserOrdersLink() {
        adminProfilePage.getOrdersLink().click();
    }
}
