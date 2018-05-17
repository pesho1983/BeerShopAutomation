package BeerShop.Utils;

import BeerShop.pages.BasketPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Utils {
    public static String productIndividualXpath(WebElementFacade target, String replace){
        String targetProduct = target.getWrappedElement().toString();
        String toRemove = targetProduct.substring(0, 78);
        return targetProduct.replace(toRemove, "").replace(replace, "");
    }
}

