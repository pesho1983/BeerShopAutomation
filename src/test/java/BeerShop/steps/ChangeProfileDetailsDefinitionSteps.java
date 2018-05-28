package BeerShop.steps;


import BeerShop.pages.ChangeProfilePage;
import BeerShop.pages.LoginPage;
import BeerShop.pages.ProfilePage;
import BeerShop.steps.serenity.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

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
    public void iAmOnProfilePage(Map<String, String> data) {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(data);
        loginSteps.pressSubmitButton();
        loginSteps.clickOnProfileNavLink();
    }

    @And("^Profile page is loaded$")
    public void clickOnChangeInfoButton() { //changeProfileSteps.openChangeProfilePage();
        profileSteps.clickOnChangeInfoButton();
    }

    @And("^Change your details header should be displayed$")
    public void changeYourDetailsHeaderShouldBeDisplayed() throws Throwable {
        Assert.assertEquals("Change your details", changeProfileSteps.getHeaderText());
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

    @Then("^Success message is displayed$")
    public void successMessageIsDisplayed() throws Throwable {
        changeProfileSteps.verifySuccessMessageIsDisplayed();
    }

    @And("^Username is displayed$")
    public void usernameIsDisplayed() throws Throwable {
      Assert.assertEquals("ivan05", loginPage.getProfileNavLink().getText());
    }

    @When("^I change the info about me$")
    public void iChangeTheInfoAboutMe(Map<String, String> data) throws Throwable {
       changeProfileSteps.changeInfoAboutMe(data);
    }

    @And("^I click on Save info$")
    public void theInfoIsSaved() throws Throwable {
        changeProfileSteps.clickOnSaveButton();
    }

    @When("^I change my (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iChangeMyEmailFirstNameLastNameAddressPhoneAndAge(String username, String email, String firstName, String lastName, String address, String phone, String age) throws Throwable {
        changeProfileSteps.changeProfileWithInvalidData(username, email, firstName, lastName, address, phone, age);
    }

    @Then("^Correct (.*) is displayed$")
    public void errormessageIsDisplayed(String errorMessage) throws Throwable {
        changeProfileSteps.verifyCorrectErrorMessageIsDisplayed(errorMessage);
    }

    @Then("^Info about me is updated$")
    public void infoAboutMeIsUpdated() throws Throwable {
        changeProfileSteps.verifyInfoAboutMeIsAdded();
    }
}

