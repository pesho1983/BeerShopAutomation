package BeerShop.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import static java.sql.DriverManager.getDriver;


public class HeaderMenuImp extends WebElementFacadeImpl implements HeaderMenu {

    @FindBy(id = "login")
    private WebElementFacade login;

    public HeaderMenuImp( final WebDriver driver,
                              final ElementLocator locator,
                              final WebElement webElement,
                              final long timeoutInMilliseconds,
                              final long waitForTimeoutInMilliseconds )
    {
        super( driver,
                locator,
                webElement,
                timeoutInMilliseconds,
                waitForTimeoutInMilliseconds );

        PageFactory.initElements( driver,
                this );
    }


    @Override
    public void clickHomePageButton() {
//    homeButton.click();
    }

    @Override
    public void clickCatalogueButton() {

    }

    @Override
    public void clickAboutButton() {

    }

    @Override
    public void clickRegisterButton() {

    }

    @Override
    public void clickLoginButton() {
        login.click();
    }

    @Override
    public void clickFAQButton() {

    }

    @Override
    public void clickLogoButton() {

    }

    @Override
    public void typeInSearchBar(String search) {

    }

    @Override
    public void clickProfileButton() {

    }
}
