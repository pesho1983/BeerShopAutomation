package BeerShop.steps.serenity;

import BeerShop.Utils.Utils;
import BeerShop.pages.ProfilePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;

public class ProfileSteps {

    ProfilePage profilePage;


    @Step
    public void clickOnChangeInfoButton() {
       profilePage.withAction().sendKeys(Keys.END).perform();
       profilePage.getChangeInfoButton().click();
    }

    @Step
    public String getUserFirstName(){
        profilePage.open();
        return Utils.replaceWordWithWhitespace(profilePage.getFirstName().getText(), "First name: ");
    }
}
