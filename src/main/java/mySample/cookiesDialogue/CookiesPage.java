package mySample.cookiesDialogue;

import mySample.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesPage extends BasePage {

    By ALLE_AKZEPTIEREN_BUTTON = By.xpath("//div[@class='cookie-dialog__button-accept-all']");
    By COOKIES_POPUP = By.xpath("//div[@class='cookie-dialog__modal-popup']");
}
