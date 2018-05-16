package BeerShop.steps.serenity;

import BeerShop.pages.AdminPage;
import BeerShop.pages.IndexPage;
import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class IndexPageSteps {
    IndexPage indexPage;
    LoginPage loginPage;
    AdminPage adminPage;

    @Step
    public void goToHomePage() {

        indexPage.open();
    }

    @Step
    public void clickOnLogin(){
        indexPage.getLogin().click();

    }

    @Step
    public void logInAsAdmin(){
        loginPage.getUsername().type("admin");
        loginPage.getPassword().type("parola123A!");
        loginPage.getSignIn().click();
    }
   /* @Step
    public void assertMessage() {
        Assert.assertEquals(" Please sign in",loginPage.getNote().getText());
    }*/
}
