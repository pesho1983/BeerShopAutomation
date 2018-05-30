package BeerShop.steps.serenity;

import BeerShop.pages.AdminPanelPage;
import BeerShop.pages.AddBeerPage;
import BeerShop.pages.LoginPage;
import cucumber.api.Transpose;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AddBeerSteps {
    AdminPanelPage adminPanelPage;
    AddBeerPage addBeerPage;
    LoginPage loginPage;
    public String FILE = "C:\\Users\\sivanova\\Desktop\\1003.jpg";

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
       adminPanelPage.getAddBeer().click();

    }

    @Step
    public void addNewBeer(Map<String,String> data) {
        addBeerPage.getName().type(data.get("name"));
        addBeerPage.getDescription().type(data.get("description"));
        addBeerPage.getPrice().type(data.get("price"));
        addBeerPage.getQuantity().type(data.get("quantity"));
        addBeerPage.getPicture().click();
        getDriver().switchTo().activeElement().sendKeys(FILE);
        addBeerPage.getSaveButton().click();

        }

    @Step
    public void fillCredentials(@Transpose Map<String,String> data) {
        addBeerPage.getName().type(data.get("name"));
        addBeerPage.getDescription().type(data.get("description"));
        addBeerPage.getPrice().type(data.get("price"));
        addBeerPage.getQuantity().type(data.get("quantity"));
        addBeerPage.getPicture().click();
        getDriver().switchTo().activeElement().sendKeys(FILE);
        addBeerPage.getSaveButton().click();
    }
     @Step
    public void assertSuccessfulMessage(String message){
         Assert.assertEquals(message,addBeerPage.getSuccessfullMessage().getText());

     }

     @Step
    public void assertDangerMessage(String message){
       Assert.assertEquals(message,addBeerPage.getDangerMessage().getText());

     }
     @Step
    public void assertMessageSameName(String message){
       Assert.assertEquals(message,addBeerPage.getDangerMessageSameName().getText());
     }
}
