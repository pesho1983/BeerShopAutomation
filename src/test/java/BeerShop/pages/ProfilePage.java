package BeerShop.pages;

import BeerShop.Utils.Utils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "profile.php")
public class ProfilePage extends PageObject {

    @FindBy(xpath = "//a[@href='changeProfile.php']")
    private WebElementFacade changeInfoButton;

    @FindBy(xpath = "//div/p[contains(text(), \"First name:\")]")
    private WebElementFacade firstName;

    @FindBy(xpath = "//label[@for=\"image\"]")
    private WebElementFacade chooseFile;

    @FindBy(xpath = "//input[@type='submit' and @value='Upload Image']")
    private WebElementFacade uploadFile;

    @FindBy(xpath = "//textarea[@id=\"infoAboutMe\"]")
    private WebElementFacade infoAboutMe;

    @FindBy(xpath = "//input[@id=\"submitInfo\"]")
    private WebElementFacade submitInfo;

    @FindBy(xpath="(//div[@class='row justify-content-md-center'])[last()]")
    private WebElementFacade infoAboutMeValue;

    @FindBy(xpath = "//strong [contains(text(), \"Please select a picture.\")]" )
    private WebElementFacade noImageError;

    @FindBy(xpath = "//strong [contains(text(), \"Submitted file is not an image.\")]")
    private WebElementFacade fileError;

    @FindBy(xpath = "//a [@href=\"viewCart.php\" and @class=\"btn btn-warning mx-3 col-lg-2\"]")
    private WebElementFacade basket;

    @FindBy(xpath = "//a [@href=\"wallet.php\" and @class=\"btn btn-warning mx-3 col-lg-2\"]")
    private WebElementFacade wallet;


    public void clickBasket() {
        basket.click();
    }

    public void clickWallet() {
         wallet.click();
    }

    public String fileErrorText() {
        return fileError.getText();
    }

    public String noImageErrorText() {
        return noImageError.getText();
    }

    public String getInfoAboutMeValue() {
        return infoAboutMeValue.getText();
    }

    public void getSubmitInfo() {
         submitInfo.click();
    }

    public WebElementFacade getInfoAboutMe() {
        return infoAboutMe;
    }

    public void getChooseFile() {
        chooseFile.click();
    }

    public void getUploadFile() {
        uploadFile.click();
    }

    public String getFirstName() {
        return Utils.replaceWordWithWhitespace(this.firstName.getText(), "First name: ");
    }

    public ProfilePage clickOnChangeInfoButton() {
        Utils.javascriptWindowScroll(500);
        this.changeInfoButton.click();
        return this;
    }
}
