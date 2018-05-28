package BeerShop.steps.serenity;

import BeerShop.pages.OldOrdersPage;
import BeerShop.pages.OrdersPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

public class OldOrdersSteps {


    OldOrdersPage oldOrdersPage;

    @Step
    public boolean returnOrderIdIsTrue(String orderId) {
        List<WebElementFacade> ordersIdList = oldOrdersPage.getOrderIds();
        for ( WebElementFacade currentOrder: ordersIdList ) {
            if (currentOrder.getText().equals(orderId)){
                return true;
            }

        }
        return false;
    }

    @Step
    public void assertCompletedOrdersId(String orderId) {

        Assert.assertTrue(returnOrderIdIsTrue(orderId));
    }
}
