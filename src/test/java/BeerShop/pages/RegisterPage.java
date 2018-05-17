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
    private WebElementFacade confirmPass;

    @FindBy(id = "firstName")
    private WebElementFacade firstname;

    @FindBy(id = "lastName")
    private WebElementFacade lasnname;

    @FindBy(id = "email")
    private WebElementFacade email;

    @FindBy(id = "phone")
    private WebElementFacade phone;

    @FindBy(id = "address")
    private WebElementFacade address;

    @FindBy(id = "age")
    private WebElementFacade age;

    public WebElementFacade getUsername() {
        return username;
    }

    public WebElementFacade getPassword() {
        return password;
    }

    public WebElementFacade getConfirmPass() {
        return confirmPass;
    }

    public WebElementFacade getFirstname() {
        return firstname;
    }

    public WebElementFacade getLasnname() {
        return lasnname;
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
