package BeerShop.steps.serenity;

import BeerShop.pages.ChangeProfilePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ChangeProfileSteps {

    ChangeProfilePage changeProfilePage;

    @Step
    public void clickOnChangePasswordButton(){
        changeProfilePage.getChangePasswordButton().click();
    }

}
