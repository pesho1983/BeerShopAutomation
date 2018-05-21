package BeerShop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class OldOrdersPage extends PageObject {

    @FindBy(xpath = "//tr[not(@class)]")
    private WebElementFacade completedOrdersFirstRow;

    public WebElementFacade getCompletedOrdersFirstRow() {
        return completedOrdersFirstRow;
    }

    public WebElementFacade getOrderId(){
        WebElementFacade orderIdElement = completedOrdersFirstRow.find(By.xpath("//th[@class]"));
//                findElement(By.xpath("//th[@class]"));
        return orderIdElement;
    }
}
