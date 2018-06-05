package BeerShop.steps;


import BeerShop.entities.User;
import BeerShop.steps.serenity.AdministratorSteps;
import BeerShop.steps.serenity.CatalogSteps;
import BeerShop.steps.serenity.LoginSteps;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

public class AdministratorDefinitionSteps {

    @Steps
    AdministratorSteps adminSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    CatalogSteps catalogSteps;

    @Given("^I am on the log in page$")
    public void iAmOnTheLogInPage() {
        loginSteps.navigateToLoginPage();
    }

    @When("^Filling the form with admin access credentials:$")
    public void fillingTheFormWithAdminAccessCredentials(@Transpose List<User> user) {
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();

    }

    @When("^Filling the beer description without picture:$")
    public void filling_the_beer_description_without_picture(Map<String, String> data) {
        adminSteps.fillingBeerDescriptionForm(data);
        adminSteps.clickSaveBeerBtn();
    }

    @Then("^You are logged in as \"([^\"]*)\"$")
    public void youAreLoggedInAsAdmin(String admin) {
        adminSteps.assertLoggedInAsAdmin(admin);
    }

    @And("^Redirected to \"([^\"]*)\"$")
    public void redirectedTo(String message) {
        adminSteps.assertUserIsOnAdminPage(message);
    }

    @Then("^Error message \"([^\"]*)\" appears$")
    public void errorMessageAppears(String message) {
        loginSteps.asserOnErrorMsg(message);
    }

    @And("^The user is on the \"([^\"]*)\"$")
    public void theUserIsOnThe(String message) {
        loginSteps.assertUserIsOnLogin(message);
    }

    @Given("^You are logged in as administrator:$")
    public void youAreLoggedInAsAdministrator(@Transpose List<User> user) {
        loginSteps.navigateToLoginPage();
        loginSteps.enterUsernameAndPassword(user);
        loginSteps.pressSubmitButton();
    }

    @When("^You are on the \"([^\"]*)\" page$")
    public void youAreOnThePage(String arg0) {
        adminSteps.navigateToAddBeerPage();
    }


    @And("^Filling the beer description:$")
    public void fillingTheBeerDescription(Map<String, String> data) {
        adminSteps.fillingBeerDescriptionForm(data);
        adminSteps.generateRandomImage();
        adminSteps.clickSaveBeerBtn();
    }

    @Then("^Product is loaded to the catalog$")
    public void productIsLoadedToTheCatalog() {
        catalogSteps.assertProductIsloaded();
    }

    @And("^Pressing the \"([^\"]*)\" button$")
    public void pressingTheButton(String arg0) {
        adminSteps.clickOnBackToProductsBtn();
    }

    @Then("^You are redirected to the beer catalog$")
    public void youAreRedirectedToTheBeerCatalog() {
        catalogSteps.assertUserIsOnCatalogPage();
    }

    @Then("^You are redirected to \"([^\"]*)\" page$")
    public void you_are_redirected_to_page(String title) {
        adminSteps.assertUserIsOnAdminPage(title);
    }


    @Then("^Successful message pops up:\"([^\"]*)\"$")
    public void successfulMessagePopsUp(String message) {
        adminSteps.asserMessageOnUpload(message);
        adminSteps.clickOnBackToProductsBtn();
        adminSteps.clickOnNthBeerDeleteElement(1);
        adminSteps.pressPopUpConfirmation();

    }


    @And("^Pressing the delete button for a single beer$")
    public void pressingTheDeleteButtonForASingleBeer() {
        adminSteps.clickOnNthBeerDeleteElement(1);
        adminSteps.pressPopUpConfirmation();
    }


    @Then("^process is stopped and user remains on \"([^\"]*)\" page$")
    public void process_is_stopped_and_user_remains_on_page(String title) {
        adminSteps.assertUserIsOnPage(title);
    }

    @Then("^Successful message \"([^\"]*)\" pops up$")
    public void successful_message_pops_up(String successfulMessage) {
        adminSteps.assertSuccessMsg(successfulMessage);
        adminSteps.editSuccessMsgText();
    }

    @When("^Filling the beer name (.*)$")
    public void filling_the_beer_name_EDIT(String data) throws Exception {
        adminSteps.navigateToEditBeerPage();
        adminSteps.clickOnNthBeerEditElement(1);
        adminSteps.fillBeerEditName(data);
        adminSteps.clickSaveBeerBtn();
    }

    @When("^Filling the beer description (.*)$")
    public void filling_the_beer_description_DESCRIPTION_EDIT(String data) {
        adminSteps.navigateToEditBeerPage();
        adminSteps.clickOnNthBeerEditElement(1);
        adminSteps.fillBeerEditDescription(data);
        adminSteps.clickSaveBeerBtn();
    }

    @When("^Filling the beer quantity (.*)$")
    public void fillingTheBeerQuantityBeerQuantity(String quantity) {
        adminSteps.navigateToEditBeerPage();
        adminSteps.clickOnNthBeerEditElement(1);
        adminSteps.fillBeerEditQuantity(quantity);
        adminSteps.clickSaveBeerBtn();
    }

    @When("^Filling the beer price (.*)$")
    public void fillingTheBeerPriceBeerPrice(String price) {
        adminSteps.navigateToEditBeerPage();
        adminSteps.clickOnNthBeerEditElement(1);
        adminSteps.fillBeerEditPrice(price);
        adminSteps.clickSaveBeerBtn();
    }

    @When("^You are on the Edit beer page$")
    public void youAreOnTheEditBeerPage() {
        adminSteps.navigateToEditBeerPage();
    }

    @Then("^Successful message \"([^\"]*)\" on beer deletion pops$")
    public void successfulMessageOnBeerDeletionPops(String deletedMsg) {
        adminSteps.assertSuccessMsgOnDeletingBeer(deletedMsg);
    }

    @And("^Complete the beer description without picture:$")
    public void completeTheBeerDescriptionWithoutPicture(Map<String, String> data)  {
        adminSteps.fillingBeerDescriptionForm(data);
        adminSteps.clickSaveBeerBtn();
    }

    @When("^changing the beer picture$")
    public void changing_the_beer_picture() throws Exception {
        adminSteps.clickOnNthBeerEditElement(1);
        adminSteps.generateRandomImage();
        adminSteps.clickSaveBeerBtn();
    }

}