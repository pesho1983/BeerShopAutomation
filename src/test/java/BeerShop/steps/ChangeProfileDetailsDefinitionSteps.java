package BeerShop.steps;


import BeerShop.Utils.Utils;
import BeerShop.entities.User;
import BeerShop.pages.ChangeProfilePage;
import BeerShop.pages.LoginPage;
import BeerShop.pages.ProfilePage;
import BeerShop.steps.serenity.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Transpose;
import net.thucydides.core.annotations.Steps;


import java.util.List;
import java.util.Map;

public class ChangeProfileDetailsDefinitionSteps {
    @Steps
    LoginSteps loginSteps;
    @Steps
    IndexSteps indexSteps;
    @Steps
    ChangeProfileSteps changeProfileSteps;
    @Steps
    ChangeProfilePage changeProfilePage;
    @Steps
    ProfilePage profilePage;
    @Steps
    ProfileSteps profileSteps;
    @Steps
    PasswordChangeSteps passwordChangeSteps;
    @Steps
    LoginPage loginPage;

    @Given("^I am logged in$")
    public void iAmOnProfilePage(@Transpose List<User> user) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();
        loginSteps.clickOnProfileNavLink();
    }

    @Given("^I am logged in with$")
    public void iAmLoggedInWithUsernameAndPassword(List<User> user) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();
        loginSteps.clickOnProfileNavLink();
    }

    @And("^Profile page is loaded$")
    public void clickOnChangeInfoButton() { //changeProfileSteps.openChangeProfilePage();
        profileSteps.clickOnChangeInfoButton();
    }

    @When("^I change my details$")
    public void iChangeMyDetails(Map<String, String> data) throws Throwable {
        changeProfileSteps.changeEmail(data);
        changeProfileSteps.changeFirstName(data);
        changeProfileSteps.changeLastName(data);
        changeProfileSteps.changeAddress(data);
        changeProfileSteps.changePhone(data);
        changeProfileSteps.changeAge(data);
    }

    @And("^Click on Save button$")
    public void clickOnSaveButton() {
        passwordChangeSteps.clickOnSaveButton();

    }

    @Then("^Success message \"([^\"]*)\" is displayed$")
    public void successMessageIsDisplayed(String successMessage) throws Throwable {
        changeProfileSteps.verifySuccessMessageIsDisplayed(successMessage);
    }

    @And("^My (.*) is displayed$")
    public void usernameIsDisplayed(String username) throws Throwable {
        changeProfileSteps.verifyUsernameIsDisplayed(username);
    }

    @When("^I change the (.*) about me$")
    public void iChangeTheInfoAboutMe(String info) throws Throwable {
        changeProfileSteps.changeInfoAboutMe(info);
    }

    @And("^I click on Save info$")
    public void theInfoIsSaved() throws Throwable {
        Utils.javascriptWindowScroll(500);
        changeProfileSteps.clickOnSaveButton();
    }

    @When("^I change my details with invalid data$")
    public void iChangeMyEmailFirstNameLastNameAddressPhoneAndAge(@Transpose Map<String, String> data) throws Throwable {
        changeProfileSteps.changeProfileWithInvalidData(data);
    }

    @Then("^Correct (.*) is displayed$")
    public void errormessageIsDisplayed(String errorMessage) throws Throwable {
        changeProfileSteps.verifyCorrectErrorMessageIsDisplayed(errorMessage);
    }

    @Then("^The (.*) about me is updated$")
    public void infoAboutMeIsUpdated(String info) throws Throwable {
        changeProfileSteps.verifyInfoAboutMeIsAdded(info);
    }

    @When("^I select a new picture$")
    public void iSelectANewPicture() throws Throwable {
        changeProfileSteps.clickOnChooseAFileButton();
        changeProfileSteps.generateRandomImage();
        changeProfileSteps.clickOnUploadImage();
    }

    @Then("^My profile picture is changed$")
    public void myProfilePictureIsChanged() throws Throwable {
        changeProfileSteps.verifyIfPictureIsChanged();
    }

    @When("^I click on upload file, without choosing a file$")
    public void iClickOnUploadFileWithoutChoosingAFile() throws Throwable {
      changeProfileSteps.clickOnUploadImage();

    }

    @Then("^(.*) for missing picture is displayed$")
    public void errormessageForMissingPictureIsDisplayed(String errorMessage) throws Throwable {
        changeProfileSteps.verifyErrorMessageForUploadImageIsDisplayed(errorMessage);
    }
}

