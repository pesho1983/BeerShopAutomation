package BeerShop.steps.serenity;

import BeerShop.pages.OrdersPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OrdersPageSteps {

    OrdersPage ordersPage;

    @Step
    public void clickOnOrdersLink() {

        ordersPage.getOrdersLink().click();
    }

    @Step
    public void assertOrdersPageLoading(String url) {
        Assert.assertEquals(url, ordersPage.getDriver().getCurrentUrl());
    }

    @Step
    public void assertCompletedOrdersPageLoaded(String url) {

        Assert.assertEquals(url, ordersPage.getDriver().getCurrentUrl());
    }
}
