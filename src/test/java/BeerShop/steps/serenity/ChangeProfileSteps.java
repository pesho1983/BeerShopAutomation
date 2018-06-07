package BeerShop.steps.serenity;

import BeerShop.Utils.Utils;
import BeerShop.pages.ChangeProfilePage;
import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import java.util.Map;


public class
ChangeProfileSteps {

    ChangeProfilePage changeProfilePage;
    LoginPage loginPage;
    String selectedImage;


    @Step
    public void clickOnChangePasswordButton() {
        changeProfilePage.clickOnChangePasswordButton();
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
    public void changeInfoAboutMe(String info) {
        changeProfilePage.getInfoAboutMe().type(info);
    }

    @Step
    public void clickOnSaveButton() {
        changeProfilePage.getSubmitInfo().click();
    }


    @Step
    public void verifySuccessMessageIsDisplayed(String successMessage) {
        Assert.assertEquals(successMessage, changeProfilePage.getSuccessMessage().getText());
    }


    public void verifyInfoAboutMeIsAdded(String info) {
        Assert.assertEquals(info, changeProfilePage.getDivAboutMe().getText());
    }

    @Step
    public void changeProfileWithInvalidData(Map<String, String> data) {
        changeProfilePage.getUsername().type(data.get("username"));
        changeProfilePage.getEmail().type(data.get("email"));
        changeProfilePage.getFirstName().type(data.get("firstName"));
        changeProfilePage.getLastName().type(data.get("lastName"));
        changeProfilePage.getAddress().type(data.get("address"));
        changeProfilePage.getPhone().type(data.get("phone"));
        changeProfilePage.getAge().type(data.get("age"));
    }

    @Step
    public void verifyCorrectErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, changeProfilePage.getErrorMessageLabel().getText());
    }

    @Step
    public void verifyUsernameIsDisplayed(String username) {
        Assert.assertEquals(username, loginPage.getProfileNavLink().getText());
    }

    @Step
    public void clickOnChooseAFileButton() {
        changeProfilePage.getChooseFile().click();
    }

    @Step
    public void uploadImg(String imgLocation) {
        changeProfilePage.getDriver().switchTo().activeElement().sendKeys(imgLocation);
    }

    @Step
    public void generateRandomImage() {
        selectedImage = Utils.getRandomImageFromFolder();
        uploadImg(selectedImage);
    }

    @Step
    public void clickOnUploadImage() {
        changeProfilePage.getSubmitButton().click();
    }

    @Step
    public void verifyIfPictureIsChanged() {
        String uploadedImage = changeProfilePage.getPictureName().getAttribute("src");
        Assert.assertEquals(selectedImage.substring(selectedImage.length() - 37), uploadedImage.substring(uploadedImage.length() - 37));
    }

    @Step
    public void verifyErrorMessageForUploadImageIsDisplayed(String errorMessage){
        Assert.assertEquals(errorMessage, changeProfilePage.getErrorMessageImage());
    }
}

