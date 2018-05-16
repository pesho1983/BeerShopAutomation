package BeerShop.steps.serenity;

import BeerShop.pages.PasswordChangePage;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class PasswordChangeSteps {

    PasswordChangePage passwordChangePage;

    @Step
    public void enterOldPassNewPassAndConfirmPass(Map<String, String> data){
        passwordChangePage.getOldPassword().type(data.get("oldPassword"));
        passwordChangePage.getNewPassword().type(data.get("newPassword"));
        passwordChangePage.getConfirmPassword().type(data.get("confirmPassword"));
    }

    @Step
    public void clickOnSaveButton() {
        passwordChangePage.getSaveButton().click();
    }


}
