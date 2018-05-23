package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OldOrdersPage extends PageObject {

    @FindBy(xpath = "//tr[not(@class)]")
    private WebElementFacade completedOrderAllRows;



    public List<WebElementFacade> getOrderIds(){
        List<WebElementFacade> allIdElements = findAll(By.cssSelector("th"));
        return allIdElements;

    }
}
