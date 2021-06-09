package mySample.geeks;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("page:geeks.page")
public class GeeksPage extends PageObject {

    @FindBy(xpath="//i[@class='gfg-icon gfg-icon_search gfg-icon_white gcse-search__icon']")
    WebElementFacade MAGNIFIER_ICON;

    @FindBy(id="gcse-search-input")
    WebElementFacade SEARCH_FIELD;
}
