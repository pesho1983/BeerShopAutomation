package BeerShop.pages;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WebElementFacade;

@ImplementedBy(HeaderMenuImp.class)
interface HeaderMenu extends WebElementFacade {

    void clickHomePageButton();

    void clickCatalogueButton();

    void clickAboutButton();

    void clickRegisterButton();

    void clickLoginButton();

    void clickFAQButton();

    void clickLogoButton();

    void typeInSearchBar(String search);

    void clickProfileButton();
}
