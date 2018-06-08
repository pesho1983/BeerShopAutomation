package BeerShop.steps.serenity;

import BeerShop.pages.ProfilePage;
import net.thucydides.core.annotations.Step;

public class ProfileSteps {

    ProfilePage profilePage;


    @Step
    public void clickOnChangeInfoButton() {
        profilePage.clickOnChangeInfoButton();
    }

}
