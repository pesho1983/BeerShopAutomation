package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

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
    private WebElementFacade wrongPassword;

    @FindBy(xpath = "//a[@class=\"btn btn-danger\"]")
    private WebElementFacade backToProfileButton;



    public WebElementFacade getOldPassword() {
        return oldPassword;
    }

    public WebElementFacade getNewPassword() {
        return newPassword;
    }

    public WebElementFacade getConfirmPassword() {
        return confirmPassword;
    }

    public WebElementFacade getSaveButton() {
        return saveButton;
    }

    public WebElementFacade getSuccessMessage() {
        return successMessage;
    }

    public WebElementFacade getWrongPassword() {
        return wrongPassword;
    }

    public WebElementFacade getBackToProfileButton() {
        return backToProfileButton;
    }

}
