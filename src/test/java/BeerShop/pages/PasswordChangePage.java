package BeerShop.pages;

import BeerShop.Utils.constants.PasswordChangeConstants;
import BeerShop.entities.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

import java.util.List;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "passwordChange.php")
public class PasswordChangePage extends PageObject {

    @FindBy(name = "old_password")
    private WebElementFacade oldPassword;

    @FindBy(name = "password")
    private WebElementFacade newPassword;

    @FindBy(name = "confirmPass")
    private WebElementFacade confirmPassword;

    @FindBy(xpath = "//input[@value=\"Save\"]")
    private WebElementFacade saveButton;

    @FindBy(xpath = "//div[@class=\"alert alert-success\"]")
    private WebElementFacade successMessage;

    @FindBy(xpath = "//strong[contains(text(), \" Wrong password!\")]")
    private WebElementFacade wrongPasswordMessage;

    @FindBy(xpath = "//strong[contains(text(), \"Password must contains\")]")
    private WebElementFacade requiredPasswordSymbolsMessage;

    @FindBy(xpath = "//strong[contains(text(), \" Passwords do not match.\")]")
    private WebElementFacade matchPasswordMessage;

    @FindBy(xpath = "//a[@class=\"btn btn-danger\"]")
    private WebElementFacade backToProfileButton;

    @FindBy(id="old_password-error")
    private WebElementFacade oldPasswordValidationMessage;

    @FindBy(id="password-error")
    private WebElementFacade newPasswordValidationMessage;

    @FindBy(id="confirmPass-error")
    private WebElementFacade confirmPasswordValidationMessage;

    public String getNewPasswordValidationMessage() {
        return this.newPasswordValidationMessage.getText();
    }

    public String getConfirmPasswordValidationMessage() {
        return this.confirmPasswordValidationMessage.getText();
    }

    public String getOldPasswordValidationMessage() {
        return this.oldPasswordValidationMessage.getText();
    }

    public void enterPassword(List<User> user) {
        this.oldPassword.type(user.get(0).getPassword());
    }

    public void enterNewPassword(List<User> user){
        this.newPassword.type(user.get(0).getNewPassword());
    }

    public void enterConfirmPassword(List<User> user){
        this.confirmPassword.type(user.get(0).getConfirmPassword());
    }

    public PasswordChangePage clickOnSaveButton() {
        this.saveButton.click();
        return this;
    }

    public String getSuccessMessage() {
        return this.successMessage.getText();
    }

    public String getWrongPasswordMessage() {
        return this.wrongPasswordMessage.getText();
    }

    public String getRequiredPasswordSymbolsMessage() {
        return this.requiredPasswordSymbolsMessage.getText();
    }

    public String getMatchPasswordMessage() {
        return this.matchPasswordMessage.getText();
    }

    public PasswordChangePage clickOnBackToProfileButton() {
        this.backToProfileButton.click();
        return this;
    }

    public void assertPasswordFieldValidationMessage(String defaultValidation, String fieldValidation){
        switch (fieldValidation){
            case PasswordChangeConstants.EMPTY_CURRENT_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, getOldPasswordValidationMessage());
                break;
            case PasswordChangeConstants.EMPTY_NEW_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, getNewPasswordValidationMessage());
                break;
            case PasswordChangeConstants.EMPTY_CONFIRM_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, getConfirmPasswordValidationMessage());
                break;
            case PasswordChangeConstants.ALL_EMPTY_FIELD:
                Assert.assertEquals(defaultValidation, getOldPasswordValidationMessage());
                Assert.assertEquals(defaultValidation, getNewPasswordValidationMessage());
                Assert.assertEquals(defaultValidation, getConfirmPasswordValidationMessage());
                break;
            case PasswordChangeConstants.CHANGE_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, getSuccessMessage());
                break;
            case PasswordChangeConstants.CURRENT_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, getWrongPasswordMessage());
                break;
            case PasswordChangeConstants.NEW_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, getRequiredPasswordSymbolsMessage());
                break;
            case PasswordChangeConstants.CONFIRM_NEW_PASSWORD_FIELD:
                Assert.assertEquals(defaultValidation, getMatchPasswordMessage());
                break;
        }
    }

}
