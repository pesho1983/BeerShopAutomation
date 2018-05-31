package BeerShop.steps.serenity;

import BeerShop.Utils.Randomizer;
import BeerShop.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class RegisterSteps {

    RegisterPage registerPage;


    @Step
    public void openRegisterPage() {
        registerPage.open();
    }

    @Step
    public void fillValidData(Map<String, String> data) {
        registerPage.getUsername().type(Randomizer.randomizeValue(data.get("username")));
        registerPage.getPassword().type(data.get("password"));
        registerPage.getConfirmPass().type(data.get("password"));
        registerPage.getFirstname().type(data.get("firstname"));
        registerPage.getLastname().type(data.get("lastname"));
        registerPage.getEmail().type(Randomizer.randomizeValue(data.get("email").concat("@abv.bg")));
        registerPage.getAddress().type(data.get("address"));
        registerPage.getPhone().type(Randomizer.randomizeValue(data.get("phone")));
        registerPage.getAge().type(Randomizer.randomizeValue(data.get("age")));
        registerPage.getAgreement().click();
        registerPage.getGdpr().click();
    }

    @Step
    public void fillInvalidData(Map<String, String> data) {
        registerPage.getUsername().type(data.get("username"));
        registerPage.getPassword().type(data.get("password"));
        registerPage.getConfirmPass().type(data.get("confirmpass"));
        registerPage.getFirstname().type(data.get("firstname"));
        registerPage.getLastname().type(data.get("lastname"));
        registerPage.getEmail().type(data.get("email"));
        registerPage.getAddress().type(data.get("address"));
        registerPage.getPhone().type(data.get("phone"));
        registerPage.getAge().type(data.get("age"));
        registerPage.getAgreement().click();
        registerPage.getGdpr().click();
    }

    @Step
    public void fillInvalidDataWithoutCheckbox(Map<String, String> data) {
        registerPage.getUsername().type(data.get("username"));
        registerPage.getPassword().type(data.get("password"));
        registerPage.getConfirmPass().type(data.get("confirmpass"));
        registerPage.getFirstname().type(data.get("firstname"));
        registerPage.getLastname().type(data.get("lastname"));
        registerPage.getEmail().type(data.get("email"));
        registerPage.getAddress().type(data.get("address"));
        registerPage.getPhone().type(data.get("phone"));
        registerPage.getAge().type(data.get("age"));
    }


    @Step
    public void register() {
        registerPage.getRegisterSubmit().click();
    }

    @Step
    public void successRegister(String url) {
        Assert.assertEquals(url, registerPage.getDriver().getCurrentUrl());
    }

    @Step
    public void deniedRegisterWithCheckbox(String url) {
        Assert.assertEquals(url, registerPage.getDriver().getCurrentUrl());
    }

    @Step
    public void deniedRegisterWithoutCheckbox(String url) {
        Assert.assertEquals(url, registerPage.getDriver().getCurrentUrl());
    }

    @Step
    public void  verifyCorrectErrorMessageIsDisplayed(String errorMessage){
        Assert.assertEquals(errorMessage, registerPage.getErrorMessageLabel());
    }
    @Step
    public void  verifyCorrectBackendErrorMessageIsDisplayed(String errorMessage){
        Assert.assertEquals(errorMessage, registerPage.getErrorMessageLabelStrong());
    }
}
