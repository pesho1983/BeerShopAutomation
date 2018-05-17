package BeerShop.steps.serenity;

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
        registerPage.getUsername().type(data.get("username"));
        registerPage.getPassword().type(data.get("password"));
        registerPage.getConfirmPass().type(data.get("password"));
        registerPage.getFirstname().type(data.get("firstname"));
        registerPage.getLasnname().type(data.get("lastname"));
        registerPage.getEmail().type(data.get("email"));
        registerPage.getAddress().type(data.get("address"));
        registerPage.getPhone().type(data.get("phone"));
        registerPage.getAge().type(data.get("age"));
    }

    @Step
    public void agreeWithTerms() {
        registerPage.getAgreement().click();
        registerPage.getGdpr().click();
    }

    @Step
    public void register() {
        registerPage.getRegisterSubmit().click();
    }

    @Step
    public void result(){
        Assert.assertEquals("http://192.168.10.158/BeerShop/login.php#", registerPage.getDriver().getCurrentUrl());
    }

}
