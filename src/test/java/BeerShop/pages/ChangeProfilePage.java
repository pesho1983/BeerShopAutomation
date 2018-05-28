package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/changeProfile.php")
public class ChangeProfilePage extends PageObject {


    @FindBy(xpath = "//a[@href=\"passwordChange.php\"]")
    private WebElementFacade changePasswordButton;

    @FindBy(css = ".page-header h1")
    private WebElementFacade header;

    @FindBy(name = "username")
    private WebElementFacade username;

    @FindBy(name = "email")
    private WebElementFacade email;

    @FindBy(name = "first_name")
    private WebElementFacade firstName;

    @FindBy(name = "last_name")
    private WebElementFacade lastName;

    @FindBy(name = "address")
    private WebElementFacade address;

    @FindBy(name = "phone")
    private WebElementFacade phone;

    @FindBy(name = "age")
    private WebElementFacade age;

    @FindBy(id = "infoAboutMe")
    private WebElementFacade infoAboutMe;

    @FindBy(id = "submitInfo")
    private WebElementFacade submitInfo;

    @FindBy(id = "age-error")
    private WebElementFacade ageErrorMessage;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElementFacade successMessage;

    @FindBy(xpath = "//label[not(contains(@style, 'display: none'))]")
    private WebElementFacade errorMessageLabel;

    @FindBy(xpath = "//div[(contains (@style, 'overflow: auto'))]")
    private WebElementFacade divAboutMe;

    public WebElementFacade getErrorMessageLabel() {
        return errorMessageLabel;
    }

    public WebElementFacade getChangePasswordButton() {
        return changePasswordButton;
    }

    public WebElementFacade getHeader() {
        return header;
    }

    public WebElementFacade getUsername() {
        return username;
    }

    public WebElementFacade getEmail() {

        return email;
    }

    public WebElementFacade getFirstName() {
        return firstName;
    }

    public WebElementFacade getLastName() {

        return lastName;
    }

    public WebElementFacade getAddress() {

        return address;
    }

    public WebElementFacade getPhone() {
        return phone;
    }

    public WebElementFacade getAge() {

        return age;
    }

    public WebElementFacade getInfoAboutMe() {

        return infoAboutMe;
    }

    public WebElementFacade getSubmitInfo() {
        return submitInfo;
    }

    public WebElementFacade getAgeErrorMessage() {
        return ageErrorMessage;
    }

    public WebElementFacade getSuccessMessage() {

        return successMessage;
    }

    public WebElementFacade getDivAboutMe() {
        return divAboutMe;
    }
}
