package BeerShop.steps.serenity;


import BeerShop.Utils.Randomizer;
import BeerShop.Utils.Utils;
import BeerShop.entities.User;
import BeerShop.pages.AdminPanelPage;
import BeerShop.pages.AddBeerPage;
import BeerShop.pages.AllBeerPage;
import BeerShop.pages.LoginPage;
import cucumber.api.Transpose;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AddBeerSteps {
    AdminPanelPage adminPanelPage;
    AddBeerPage addBeerPage;
    LoginPage loginPage;
    AllBeerPage allBeerPage;


   @Step
   public void goToLoginPage(){

       loginPage.open();
    }

    @Step
    public void loginAsAdmin(List<User> user){
        loginPage.getUsername().type(user.get(0).getUsername());
        loginPage.getPassword().type(user.get(0).getPassword());
        loginPage.getSignIn().click();
    }


    @Step
    public void clickButtonAddBeer(){
       adminPanelPage.getAddBeer().click();

    }

    @Step
    public void addNewBeer(Map<String,String> data) {
        addBeerPage.getName().type(Randomizer.randomizeValue(data.get("name")));
        addBeerPage.getDescription().type(data.get("description"));
        addBeerPage.getPrice().type(data.get("price"));
        addBeerPage.getQuantity().type(data.get("quantity"));
        addBeerPage.getPicture().click();
        getDriver().switchTo().activeElement().sendKeys(Utils.getRandomImageFromFolderBeer());
        addBeerPage.getSaveButton().click();

        }

    @Step
    public void fillCredentials(@Transpose Map<String,String> data) {
        addBeerPage.getName().type(Randomizer.randomizeValue(data.get("name")));
        addBeerPage.getDescription().type(data.get("description"));
        addBeerPage.getPrice().type(data.get("price"));
        addBeerPage.getQuantity().type(data.get("quantity"));
        addBeerPage.getPicture().click();
        getDriver().switchTo().activeElement().sendKeys(Utils.getRandomImageFromFolderSameBeer());
        addBeerPage.getSaveButton().click();
    }

    @Step
    public void fillCredentialsExistingName(@Transpose Map<String,String> data) {
        addBeerPage.getName().type(data.get("name"));
        addBeerPage.getDescription().type(data.get("description"));
        addBeerPage.getPrice().type(data.get("price"));
        addBeerPage.getQuantity().type(data.get("quantity"));
        addBeerPage.getPicture().click();
        getDriver().switchTo().activeElement().sendKeys(Utils.getRandomImageFromFolderBeer());
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

     @Step
    public void clickOnBackToRead(){
       addBeerPage.getReadProducts().click();
     }

     @Step
    public void assertTitleAllBeer(String title)
     {
       Assert.assertEquals(title,allBeerPage.getTitle());
     }
}
