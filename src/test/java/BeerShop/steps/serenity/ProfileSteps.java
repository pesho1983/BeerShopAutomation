package BeerShop.steps.serenity;

import BeerShop.pages.ProfilePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;

public class ProfileSteps {

    ProfilePage profilePage;


    @Step
    public void clickOnChangeInfoButton() {
       ((JavascriptExecutor) profilePage.getDriver()).executeScript("window.scrollBy(0,500)", "");
       profilePage.getChangeInfoButton().click();
    }
}
