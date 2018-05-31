package BeerShop.steps.serenity;

import BeerShop.Utils.Utils;
import BeerShop.pages.AdministratorPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
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
    public void clickOnNthBeerEditElement(int n) {
        adminPage.getNthEditBeerBtn(n).click();
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
    public String editSuccessMsgText() {
        return adminPage.getEditBeerSuccessMessage().getText();
    }

    @Step
    public String successfulBeerMsgText() {
        return adminPage.getSuccessBeerMsg().getText();
    }

    @Step
    public String getDeletedBeerText() {
        return adminPage.getDeletedBeerMessageElement().getText();
    }

    @Step
    public void fillingBeerDescriptionForm(Map<String, String> data) {
        adminPage.getNewProductName().type(data.get("beerName"));
        adminPage.getNewProductDescription().type(data.get("beerDescription"));
        adminPage.getNewProductPrice().type(data.get("beerPrice"));
        adminPage.getNewProductQuantity().type(data.get("beerQuantity"));
    }

    @Step
    public void clickSaveBeerBtn() {
        adminPage.getNewProductSavebtn().click();
    }

    @Step
    public void generateRandomImage() {
        adminPage.uploadImg(Utils.getRandomImageFromFolder());
    }

    @Step
    public void clickOnBackToProductsBtn() {
        adminPage.getBackToCatalogBtn().click();
    }

    @Step
    public void fillBeerEditName(String info) {
        adminPage.getNewProductName().type(info);
    }

    @Step
    public void fillBeerEditDescription(String data) {
        adminPage.getNewProductDescription().type(data);
    }

    @Step
    public void fillBeerEditQuantity(String quantity) {
        adminPage.getNewProductQuantity().type(quantity);
    }

    @Step
    public void fillBeerEditPrice(String price) {
        adminPage.getNewProductPrice().type(price);
    }

    @Step
    public void clickOnNthBeerDeleteElement(int n) {
        adminPage.getNthDeleteBeerBtn(n).click();
    }

    @Step
    public void pressPopUpConfirmation() {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    //Assert Steps

    @Step
    public void assertLoggedInAsAdmin(String adminUsername) {
        Assert.assertEquals(adminUsername, getLoggedUserText());
    }

    @Step
    public void assertSuccessMsgOnDeletingBeer(String deletedMessage) {
        Assert.assertEquals(deletedMessage, getDeletedBeerText());
    }

    @Step
    public void assertSuccessMsg(String message) {
        Assert.assertEquals(message, editSuccessMsgText());
    }

    @Step
    public void assertUserIsOnPage(String pageTitle) {
        Assert.assertEquals(pageTitle, getTitle());
    }

    @Step
    public void asserMessageOnUpload(String message) {
        Assert.assertEquals(message, successfulBeerMsgText());
    }

    @Step
    public void assertUserIsOnAdminPage(String message) {
        Assert.assertEquals(message, getTitle());
    }
}
