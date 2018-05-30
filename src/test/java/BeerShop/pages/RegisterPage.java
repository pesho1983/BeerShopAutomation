package BeerShop.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/register.php")

public class RegisterPage extends PageObject {
    @FindBy(id = "register_submit")
    private WebElementFacade registerSubmit;

    @FindBy(name = "agreement")
    private WebElementFacade agreement;

    @FindBy(name = "gdpr")
    private WebElementFacade gdpr;

    @FindBy(id = "username")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "confirmPass")
    private WebElementFacade confirmpass;

    @FindBy(id = "firstName")
    private WebElementFacade firstname;

    @FindBy(id = "lastName")
    private WebElementFacade lastname;

    @FindBy(id = "email")
    private WebElementFacade email;

    @FindBy(id = "phone")
    private WebElementFacade phone;

    @FindBy(id = "address")
    private WebElementFacade address;

    @FindBy(id = "age")
    private WebElementFacade age;

    @FindBy(xpath = "//label[not(contains(@style, 'display: none'))]")
    private WebElementFacade errorMessageLabel;

    @FindBy(xpath = "//strong[not(contains(@style, 'display: none'))]")
    private WebElementFacade errorMessageLabelStrong;

    public String getErrorMessageLabelStrong() {
        return errorMessageLabelStrong.getText();
    }

    public String getErrorMessageLabel() {
        return errorMessageLabel.getText();
    }

    public WebElementFacade getUsername() {
        return username;
    }

    public WebElementFacade getPassword() {
        return password;
    }

    public WebElementFacade getConfirmPass() {
        return confirmpass;
    }

    public WebElementFacade getFirstname() {
        return firstname;
    }

    public WebElementFacade getLastname() {
        return lastname;
    }

    public WebElementFacade getEmail() {
        return email;
    }

    public WebElementFacade getPhone() {
        return phone;
    }

    public WebElementFacade getAddress() {
        return address;
    }

    public WebElementFacade getAge() {
        return age;
    }

    public WebElementFacade getAgreement() {
        return agreement;
    }

    public WebElementFacade getGdpr() {
        return gdpr;
    }

    public WebElementFacade getRegisterSubmit() {
        return registerSubmit;
    }

}
