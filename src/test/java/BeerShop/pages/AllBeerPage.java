package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://192.168.10.158/BeerShop/listAllBeers.php")

public class AllBeerPage extends PageObject {


    @FindBy(css=".btn.btn-primary.mb-3.ml-4")
    private WebElementFacade createNewProduct;

    public WebElementFacade getCreateNewProduct() {
        return createNewProduct;
    }
}
