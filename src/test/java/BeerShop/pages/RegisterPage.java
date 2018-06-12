package BeerShop.pages;

import BeerShop.Utils.Randomizer;
import BeerShop.entities.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;

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

    public void fillRegistrationForm(List<User> user) {
        this.username.type(Randomizer.randomizeValue(user.get(0).getUsername()));
        this.password.type(user.get(0).getPassword());
        this.confirmpass.type(user.get(0).getConfirmPassword());
        this.firstname.type(user.get(0).getFirstName());
        this.lastname.type(user.get(0).getLastName());
        this.email.type(Randomizer.randomizeValue(user.get(0).getEmail()));
        this.phone.type(Randomizer.randomizeValue(user.get(0).getPhone()));
        this.address.type(user.get(0).getAddress());
        this.age.type(Randomizer.randomizeValue(user.get(0).getAge()));
    }

    public RegisterPage clickOnAgreement(){
        this.agreement.click();
        return this;
    }

    public RegisterPage clickOnGDPR(){
        this.gdpr.click();
        return this;
    }

    public String getErrorMessageLabelStrong() {
        return errorMessageLabelStrong.getText();
    }

    public String getErrorMessageLabel() {
        return errorMessageLabel.getText();
    }

    public RegisterPage clickOnRegisterButton() {
        this.registerSubmit.click();
        return this;
    }

    public String getCurrentURL(){
        return this.getDriver().getCurrentUrl();
    }

}
