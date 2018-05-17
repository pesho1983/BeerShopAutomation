package BeerShop.steps;

import BeerShop.steps.serenity.RegisterSteps;
import cucumber.api.PendingException;
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
    public void userEntersValidData(Map<String, String> data) {
        registerSteps.fillValidData(data);
    }

    @And("^user accepts terms and gdpr$")
    public void userAcceptsTermsAndGdpr() {
        registerSteps.agreeWithTerms();
    }

    @And("^click on register$")
    public void clickOnRegister() {
        registerSteps.register();
    }

    @Then("^user is redirected to login page$")
    public void userIsRedirectedToLoginPage() {
        registerSteps.result();
    }
}
