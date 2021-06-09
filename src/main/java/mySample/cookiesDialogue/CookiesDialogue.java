package mySample.cookiesDialogue;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CookiesDialogue extends PageObject {

    By ALLE_AKZEPTIEREN_BUTTON = By.xpath("//div[@class='cookie-dialog__button-accept-all']");
    By COOKIES_POPUP = By.xpath("//div[@class='cookie-dialog__modal-popup']");
}
