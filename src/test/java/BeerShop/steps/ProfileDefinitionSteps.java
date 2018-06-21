package BeerShop.steps;

import BeerShop.Utils.Utils;
import BeerShop.steps.serenity.ProfileSteps;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Map;

public class ProfileDefinitionSteps {

    private static String infoAboutMe = "";

    @Steps
    ProfileSteps profileSteps;

    @When("^a (.*) is chosen and uploaded$")
    public void aPictureIsChosenAndUploaded(String file)  {
        profileSteps.chooseFile(file);
        profileSteps.uploadImage();
    }

    @Then("^user profile should be updated$")
    public void userProfileShouldBeUpdated()  {
        profileSteps.redirect_to_profile();
        profileSteps.assertImage();
    }

    @When("^no picture is chosen and upload button is clicked$")
    public void noPictureIsChosenAndUploadButtonIsClicked()  {
        profileSteps.uploadBlankImage();
    }

    @Then("^user should see message \"([^\"]*)\"$")
    public void userShouldSeeMessage(String message)  {
        profileSteps.assertErrorMessage(message);
    }

    @When("^a non-picture file is chosen and upload button is clicked$")
    public void aNonPictureFileIsChosenAndUploadButtonIsClicked()  {
        profileSteps.chooseFile("File");
        profileSteps.uploadImage();
    }

    @When("^user updates info about me field:$")
    public void userUpdatesInfoAboutMeField(@Transpose Map<String, String> data)  {
        infoAboutMe = data.get("info");
        profileSteps.updateInfo(infoAboutMe);
    }

    @Then("^user info about me should be updated$")
    public void userInfoAboutMeShouldBeUpdated()  {
        profileSteps.assertInfoAboutMe(infoAboutMe);
    }

    @Given("^user is at bottom of profile page$")
    public void userIsAtBottomOfProfilePage()  {
        Utils.javascriptWindowScroll(1000);
    }

    @When("^user clicks the \"([^\"]*)\" link$")
    public void userClicksTheLink(String button){
        profileSteps.clickWallet();
    }
}
