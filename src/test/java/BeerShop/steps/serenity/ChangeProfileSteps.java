package BeerShop.steps.serenity;

import BeerShop.pages.ChangeProfilePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Map;

public class
ChangeProfileSteps {

    ChangeProfilePage changeProfilePage;

    @Step
    public void clickOnChangePasswordButton() {
        changeProfilePage.getChangePasswordButton().click();
    }

    @Step
    public void openChangeProfilePage() {
        changeProfilePage.open();
    }

    @Step
    public String getHeaderText() {
        return changeProfilePage.getHeader().getText();
    }

    @Step
    public void changeEmail(Map<String, String> data) {
        changeProfilePage.getEmail().type(data.get("email"));
    }

    @Step
    public void changeFirstName(Map<String, String> data) {
        changeProfilePage.getFirstName().type(data.get("firstName"));
    }

    @Step
    public void changeLastName(Map<String, String> data) {
        changeProfilePage.getLastName().type(data.get("lastName"));
    }

    @Step
    public void changeAddress(Map<String, String> data) {
        changeProfilePage.getAddress().type(data.get("address"));
    }

    @Step
    public void changePhone(Map<String, String> data) {
        changeProfilePage.getPhone().type(data.get("phone"));
    }

    @Step
    public void changeAge(Map<String, String> data) {
        changeProfilePage.getAge().type(data.get("age"));
    }

    @Step
    public void changeInfoAboutMe(Map<String, String> data) {
        changeProfilePage.getInfoAboutMe().type(data.get("info"));
    }

    @Step
    public void clickOnSaveButton() {
        changeProfilePage.getSubmitInfo().click();
    }

    @Step
    public void changeWithInvalidAge(String age) {
        changeProfilePage.getAge().type(age);
    }

    @Step
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertEquals("Your age must be 18+", changeProfilePage.getAgeErrorMessage().getText());
    }

    @Step
    public void verifySuccessMessageIsDisplayed() {
        Assert.assertEquals("Your profile has been updated.", changeProfilePage.getSuccessMessage().getText());
    }


    public void verifyInfoAboutMeIsAdded() {
        Assert.assertEquals("I don't like to drink beer", changeProfilePage.getDivAboutMe().getText());
    }

    @Step
    public void changeProfileWithInvalidData(String username, String email, String firstName, String lastName, String address, String phone, String age) {
        changeProfilePage.getUsername().type(username);
        changeProfilePage.getEmail().type(email);
        changeProfilePage.getFirstName().type(firstName);
        changeProfilePage.getLastName().type(lastName);
        changeProfilePage.getAddress().type(address);
        changeProfilePage.getPhone().type(phone);
        changeProfilePage.getAge().type(age);
    }
    @Step
    public void  verifyCorrectErrorMessageIsDisplayed(String errorMessage){
        Assert.assertEquals(errorMessage, changeProfilePage.getErrorMessageLabel().getText());
    }
}

