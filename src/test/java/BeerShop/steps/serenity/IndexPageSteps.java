package BeerShop.steps.serenity;

import BeerShop.pages.AdminPanelPage;
import BeerShop.pages.IndexPage;
import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class IndexPageSteps {
    IndexPage indexPage;
    LoginPage loginPage;
    AdminPanelPage adminPanelPage;

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
