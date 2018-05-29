package BeerShop.pages;

import BeerShop.Utils.Utils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static BeerShop.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "/catalog.php")
public class CatalogPage extends PageObject {

    @FindBy(xpath = "//div [@class=\"product justify-content-md-center\"]")
    private WebElementFacade productBox;

    @FindBy(xpath = ".//div [@class=\"product justify-content-md-center\"]/h2[text()]")
    private WebElementFacade productName;

    public WebElementFacade getProductBox() {
        return productBox;
    }

    public WebElementFacade getProduct() {
        return productName;
    }


    public void clickOnAddToCart(int product) {

        String result = Utils.productIndividualXpath(this.getProductBox(), "]]");
        String targetProduct = result + "][" + product + "]" + "/a";
        this.getDriver().findElement(By.xpath(targetProduct)).click();
    }


    public String getProductName(int product) {
        String result = Utils.productIndividualXpath(this.getProduct(), "]/h2[text()]");

        String targetProductName = result + "[" + product + "]" + "/h2";
        return this.getDriver().findElement(By.xpath(targetProductName)).getText();
    }
}

