package BeerShop.steps;

import BeerShop.entities.User;
import BeerShop.steps.serenity.RegisterSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.List;

public class RegisterDefinitionSteps {
    @Steps
    RegisterSteps registerSteps;


    @Given("^user is on the register page$")
    public void userIsOnTheRegisterPage() {
        registerSteps.openRegisterPage();
    }

    @When("^user fill registration form with$")
    public void fillRegistrationForm(List<User> user) {
        registerSteps.fillRegistrationForm(user);
    }

    @And("^click on register button$")
    public void clickOnRegisterButton() {
        registerSteps.clickOnRegisterButton();
    }

    @Then("^user is redirected to \"([^\"]*)\" url$")
    public void userIsRedirectedToUrl(String url) {
        registerSteps.assertExactURL(url);
    }

    @When("^user fill registration form with with unchecked checkboxes for$")
    public void userfillRegistrationFormWithUncheckedCheckboxesFor(List<User> user) {
        registerSteps.fillRegistrationFormWithoutCheckbox(user);
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
