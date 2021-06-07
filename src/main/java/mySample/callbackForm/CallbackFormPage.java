package mySample.callbackForm;

import mySample.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://new-ws-fit.canadalife.de/kunden/rueckruf-anfordern/")
public class CallbackFormPage extends BasePage {

    By TITLE = By.xpath("//h1[text()='Rückruf anfordern'");

    @FindBy(name = "fields[3]")
    WebElementFacade NAME_FIELD;

    @FindBy(name = "fields[33]")
    WebElementFacade PHONE_FIELD;

    @FindBy(xpath = "//label[@for='optin_forminput4']")
    WebElementFacade DATENSCHUTZ_CHECKBOX;

    @FindBy(xpath = "//button[@type='submit']")
    WebElementFacade SUBMIT_BUTTON;

    @FindBy(xpath = "//h1[text()='Vielen Dank!']")
    WebElementFacade CONF_MESSAGE_VIELENDANK;

    @FindBy(xpath = "//h2[text()='Wir melden uns so schnell wie möglich bei Ihnen.']")
    WebElementFacade CONF_MESSAGE_WILLCONTACTASAP;

//    @WhenPageOpens
//    public void waitUntilElementsAppear() {
//        NAME_FIELD.waitUntilVisible();
//        SUBMIT_BUTTON.waitUntilVisible();
//    }
}
