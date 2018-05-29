package BeerShop.steps;

import BeerShop.steps.serenity.RegisterSteps;

import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class RegisterDefinitionSteps {
    @Steps
    RegisterSteps registerSteps;


    @Given("^user is on the register page$")
    public void userIsOnTheRegisterPage() {
        registerSteps.openRegisterPage();
    }

    @When("^user enters valid data$")
    public void userEntersValidData(@Transpose Map<String, String> data) {
        registerSteps.fillValidData(data);
    }

    @And("^click on register button$")
    public void clickOnRegister() {
        registerSteps.register();
    }

    @Then("^user is redirected to login \"([^\"]*)\" url$")
    public void userIsRedirectedToUrl(String url) {
        registerSteps.successRegister(url);
    }


    @When("^user enters invalid data for$")
    public void userEntersInvalidData(@Transpose Map<String, String> data) {
        registerSteps.fillInvalidData(data);
    }

    @Then("^user is redirected to register \"([^\"]*)\" url$")
    public void userIsRedirectedToRegisterUrl(String url) {
        registerSteps.deniedRegisterWithCheckbox(url);
    }


    @When("^user enters invalid data with unchecked checkboxes for$")
    public void userEntersInvalidDataWithUncheckedCheckboxesFor(@Transpose Map<String, String> data) {
        registerSteps.fillInvalidDataWithoutCheckbox(data);
    }


    @Then("^user is redirected to register # \"([^\"]*)\" url$")
    public void userIsRedirectedToRegister1Url(String url) {
        registerSteps.deniedRegisterWithoutCheckbox(url);
    }


    @Then("^an frontend error message  \"([^\"]*)\" appears$")
    public void anErrorMessageAppears(String error) {
        registerSteps.verifyCorrectErrorMessageIsDisplayed(error);
    }

    @Then("^an backend error message  \"([^\"]*)\" appears$")
    public void anBackendErrorMessageAppears(String error) {
        registerSteps.verifyCorrectBackendErrorMessageIsDisplayed(error);
    }
}
