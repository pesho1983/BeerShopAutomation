package BeerShop.pages;

import BeerShop.Utils.Utils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("http://192.168.10.158/BeerShop/catalog.php")
public class CatalogPage extends PageObject {

    @FindBy(xpath = "//div [@class=\"product justify-content-md-center\"]")
    private WebElementFacade productBox;

    public WebElementFacade getProductBox() {
        return productBox;
    }

    public void clickOnAddToCart(int product){
        String result = Utils.productIndividualXpath(this.getProductBox(), "]]");
        String targetProduct = result + "][" + product + "]" + "/a";
        this.getDriver().findElement(By.xpath(targetProduct)).click();
    }
}
