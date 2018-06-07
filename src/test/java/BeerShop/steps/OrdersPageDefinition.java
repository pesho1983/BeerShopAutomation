package BeerShop.steps;

import BeerShop.entities.User;
import BeerShop.pages.AdminProfilePage;
import BeerShop.pages.OldOrdersPage;
import BeerShop.steps.serenity.*;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;



public class OrdersPageDefinition {

    @Steps
    IndexSteps indexSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    OrdersPageSteps ordersPageSteps;
    @Steps
    AdminProfilePageSteps adminProfilePageSteps;
    @Steps
    OldOrdersSteps oldOrdersSteps;




    @Given("^the user should be logged as admin:$")
    public void theUserShouldBeLoggedAsAdmin(@Transpose List<User> user) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();

    }

    @When("^click on USER ORDERS link$")
    public void clickOnUSERORDERSLink() throws Throwable {
        adminProfilePageSteps.clickOnUserOrdersLink();
    }

    @Then("^the user should be redirected to \"([^\"]*)\"$")
    public void theUserShouldBeRedirectedToOrdersPageOrdersPhp(String url) {
        ordersPageSteps.assertOrdersPageLoading(url);
    }

    @And("^click on completed orders button$")
    public void clickOnCompletedOrdersButton() {
        ordersPageSteps.clickOnOrdersLink();
    }

    @Then("^the user should be redirected to completed orders page - \"([^\"]*)\"$")
    public void theUserShouldBeRedirectedToCompletedOrdersPageOldOrdersPhp(String url) {
        ordersPageSteps.assertCompletedOrdersPageLoaded(url);
    }

    @When("^the adminUser should navigate to completed orders page$")
    public void theAdminUserShouldNavigateToCompletedOrdersPage() {
        adminProfilePageSteps.clickOnUserOrdersLink();
        ordersPageSteps.clickOnOrdersLink();
    }

    @Then("^the adminUser should see order number \"([^\"]*)\" in the list of completed orders$")
    public void theAdminUserShouldSeeOrderNumberInTheListOfCopletedOrders(String orderId) {
        oldOrdersSteps.assertCompletedOrdersId(orderId);
    }
}
