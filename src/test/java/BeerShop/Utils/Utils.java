package BeerShop.Utils;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Utils {
    public static String productIndividualXpath(WebElementFacade target, String replace){
        String targetProduct = target.getWrappedElement().toString();
        String toRemove = targetProduct.substring(0, 78);
        return targetProduct.replace(toRemove, "").replace(replace, "");
    }

    public static String replaceWordWithWhitespace(String text, String toReplace){
        return text.replace(toReplace, "");
    }
    public static String replaceWordWithRegex(String text, String regex){
        return text.replaceAll(regex, "");
    }

    public static void acceptAlert(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 3000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }
}

