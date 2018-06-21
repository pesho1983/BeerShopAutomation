package BeerShop.steps.serenity;

import BeerShop.Utils.Utils;
import BeerShop.Utils.constants.UserProfileConstants;
import BeerShop.pages.ProfilePage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ProfileSteps {

    ProfilePage profilePage;

    public String PICTURE = "C:\\Users\\mashdzhiyan\\Desktop\\pictures\\Surikat_3";
    public String FILE = "C:\\Users\\mashdzhiyan\\Desktop\\pictures\\Q.pdf";


    @Step
    public void clickOnChangeInfoButton() {
        profilePage.clickOnChangeInfoButton();
    }

    @Step
    public void redirect_to_profile(){
        profilePage.open();
    }

    @Step
    public String getCurrentTitle() {
        return profilePage.getDriver().getTitle();
    }


    @Step
    public void chooseImage(){
        profilePage.getChooseFile();
        getDriver().switchTo().activeElement().sendKeys(PICTURE);


    }

    @Step
    public void chooseFile(String file){
        profilePage.getChooseFile();
        switch (file) {
            case "file": getDriver().switchTo().activeElement().sendKeys(FILE); break;
            case "image": getDriver().switchTo().activeElement().sendKeys(PICTURE); break;
        }
        profilePage.getChooseFile();
        getDriver().switchTo().activeElement().sendKeys(FILE);


    }

    @Step
    public void uploadImage(){
        profilePage.getUploadFile();
        profilePage.getDriver().navigate().refresh();
    }


    @Step
    public void updateInfo(String keyword){
        profilePage.getInfoAboutMe().type(keyword);
        profilePage.getInfoAboutMe().sendKeys(Keys.PAGE_DOWN);
        profilePage.getSubmitInfo();
        profilePage.getSubmitInfo();
    }

    @Step
    public String InfoValue(){
        return profilePage.getInfoAboutMeValue();
    }

    @Step
    public void uploadBlankImage(){
        profilePage.getUploadFile();
    }

    @Step
    public String getNoImageErrorMessage(){
        return profilePage.noImageErrorText();
    }

    @Step
    public String getFileError(){
        return profilePage.fileErrorText();
    }

    public void assertImage() {
        Assert.assertEquals("//img/@src[contains(., 'Surikat')]",PICTURE);
    }

    public void assertErrorMessage(String message) {
        switch (message){
            case UserProfileConstants.NO_IMAGE_ERROR_MESSAGE:
                Assert.assertEquals(message, profilePage.noImageErrorText());
                break;
            case UserProfileConstants.FILE_ERROR_MESSAGE:
                Assert.assertEquals(message, profilePage.fileErrorText());
                break;
        }
    }

    public void assertInfoAboutMe(String infoAboutMe) {
        Assert.assertEquals(infoAboutMe, profilePage.getInfoAboutMeValue());
    }

    public void clickWallet() {
        profilePage.clickWallet();
    }

}
