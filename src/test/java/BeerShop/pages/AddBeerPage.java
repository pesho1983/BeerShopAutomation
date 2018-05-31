package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.10.158/BeerShop/addBeer.php")
public class AddBeerPage extends PageObject {


    @FindBy(name="name")
    private WebElementFacade name;

    @FindBy(name="description")
    private WebElementFacade description;

    @FindBy(name="price")
    private WebElementFacade price;

    @FindBy(name="quantity")
    private WebElementFacade quantity;

    @FindBy(css = ".btn.btn-default")
    private WebElementFacade picture;

    @FindBy(css=".btn.btn-success")
    private WebElementFacade saveButton;

    @FindBy(xpath="//div[contains (text(),'must be unique')]")
    private WebElementFacade dangerMessageSameName;

//    @FindBy(className ="btn btn-danger")
//    private WebElementFacade backButton;

    @FindBy(css=".alert.alert-success")
    private WebElementFacade successfullMessage;

    @FindBy(xpath="//div[contains (text(),'Image')]")
    private WebElementFacade dangerMessage;

//    public WebElementFacade getBackButton() {
//        return backButton;
//    }


    public WebElementFacade getName() {
        return name;
    }

    public WebElementFacade getDescription() {
        return description;
    }

    public WebElementFacade getPrice() {
        return price;
    }

    public WebElementFacade getQuantity() {
        return quantity;
    }

    public WebElementFacade getPicture() {
        return picture;
    }

    public WebElementFacade getSaveButton() {
        return saveButton;
    }

    public WebElementFacade getSuccessfullMessage() {
        return successfullMessage;
    }

    public WebElementFacade getDangerMessage() {
        return dangerMessage;
    }
    public WebElementFacade getDangerMessageSameName() {
        return dangerMessageSameName;
    }
}
