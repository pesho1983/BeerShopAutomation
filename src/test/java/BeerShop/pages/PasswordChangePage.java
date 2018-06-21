package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

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

    public WebElementFacade getNewPasswordValidationMessage() {
        return newPasswordValidationMessage;
    }

    public WebElementFacade getConfirmPasswordValidationMessage() {
        return confirmPasswordValidationMessage;
    }

    public WebElementFacade getOldPasswordValidationMessage() {
        return oldPasswordValidationMessage;
    }

    public WebElementFacade getOldPassword() {
        return oldPassword;
    }

    public WebElementFacade getNewPassword() {
        return newPassword;
    }

    public WebElementFacade getConfirmPassword() {
        return confirmPassword;
    }

    public PasswordChangePage clickOnSaveButton() {
        this.saveButton.click();
        return this;
    }

    public WebElementFacade getSuccessMessage() {
        return successMessage;
    }

    public WebElementFacade getWrongPasswordMessage() {
        return wrongPasswordMessage;
    }

    public WebElementFacade getRequiredPasswordSymbolsMessage() {
        return requiredPasswordSymbolsMessage;
    }

    public WebElementFacade getMatchPasswordMessage() {
        return matchPasswordMessage;
    }

    public PasswordChangePage clickOnBackToProfileButton() {
        this.backToProfileButton.click();
        return this;
    }

}
