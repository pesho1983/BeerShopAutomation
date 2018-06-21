package BeerShop.pages;

import BeerShop.entities.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

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

}
