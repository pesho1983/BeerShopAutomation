package BeerShop.steps.serenity;

import BeerShop.pages.AdministratorPage;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class AdministratorSteps {

    AdministratorPage adminPage;

    @Step
    public String getTitle() {
        return adminPage.getTitle();
    }

    @Step
    public String getLoggedUserText() {
        return adminPage.getProfileUsername().getText();
    }

    @Step
    public void navigateToAddBeerPage() {
        adminPage.getAddBeerBtn().click();
    }

    @Step
    public void navigateToEditBeerPage() {
        adminPage.getEditBeerBtn().click();
    }

    @Step
    public void navigateToOrdersPage() {
        adminPage.getUserOrdersBtn().click();
    }

    @Step
    public void fillingBeerDescriptionForm(Map<String, String> data) {
        adminPage.getNewProductName().type(data.get("beerName"));
        adminPage.getNewProductDescription().type(data.get("beerDescription"));
        adminPage.getNewProductPrice().type(data.get("beerPrice"));
        adminPage.getNewProductQuantity().type(data.get("beerQuantity"));
    }

    @Step
    public void clickSaveBeerBtn(){
        adminPage.getNewProductSavebtn();
    }
}
