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

    @FindBy(xpath = "//input[@class=\"btn btn-default\"]")
    private WebElementFacade picture;

    @FindBy(xpath = "//input[@value=\"Save\"]")
    private WebElementFacade saveButton;

    @FindBy(className ="btn btn-danger")
    private WebElementFacade backButton;

    @FindBy(xpath = "//div[@class=\"alert alert-success\"]")
    private WebElementFacade successfullMessage;

    public WebElementFacade getBackButton() {
        return backButton;
    }


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
}
