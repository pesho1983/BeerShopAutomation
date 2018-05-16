package BeerShop.steps.serenity;

import BeerShop.pages.AdminPage;
import BeerShop.pages.AdminProfilePage;
import BeerShop.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginAdminSteps {
    AdminPage adminPage;
    AdminProfilePage adminProfilePage;
    LoginPage loginPage;
    public String FILE = "C:\\Users\\sivanova\\Desktop\\2500.jpg";

   @Step
   public void goToLoginPage(){

       loginPage.open();
    }

    @Step
    public void loginAsAdmin(Map<String,String> data){
        loginPage.getUsername().type(data.get("username"));
        loginPage.getPassword().type(data.get("password"));
        loginPage.getSignIn().click();
    }

    @Step
    public void clickButtonAddBeer(){
       adminPage.getAddBeer().click();

    }



    @Step
    public void addNewBeer(Map<String,String> data) {
        adminProfilePage.getName().type(data.get("name"));
        adminProfilePage.getDescription().type(data.get("description"));
        adminProfilePage.getPrice().type(data.get("price"));
        adminProfilePage.getQuantity().type(data.get("quantity"));
        adminProfilePage.getPicture().click();
        getDriver().switchTo().activeElement().sendKeys(FILE);
        adminProfilePage.getSaveButton().click();
       // adminProfilePage.getDriver().navigate().refresh();
        }

}
