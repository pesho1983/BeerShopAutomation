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
import cucumber.api.Transpose;
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

    @Given("^I am logged in with (.*) and (.*)$")
    public void iAmLoggedInWithUsernameAndPassword(String username, String password) throws Throwable {
        indexSteps.openURL();
        indexSteps.clickOnLoginNavLink();
        loginSteps.enterUsernameAndPassword(username, password);
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
}
