package mySample.contactForm;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://new-ws-fit.canadalife.de/kontaktformular/")
public class ContactFormPage extends PageObject {

    public enum Field {NAME,SURNAME, STRASSE,PLZ,ORT,EMAIL,PHONE,MESSAGE}
    final By TITLE = By.xpath("//div[@class='cl-form-section__title' and text()='Allgemeine Anfrage']");
    final By NAME_FIELD = By.name("firstName");
    final By SURNAME_FIELD = By.name("surname");
    final By STRASSE_FIELD = By.name("street");
    final By PLZ_FIELD = By.name("zipCode");
    final By ORT_FIELD = By.name("city");
    final By EMAIL_FIELD = By.name("emailAddress");
    final By PHONE_FIELD = By.name("telephone");
    final By MESSAGE_FIELD = By.name("message");
    final By DATENSCHUTZ_CHECKBOX = By.xpath("//span[text()='Einwilligung in Datenschutzbestimmungen']");
    final By ABSENDEN_BUTTON = By.xpath("//span[text()='Einwilligung in Datenschutzbestimmungen']");

    final By ALLE_AKZEPTIEREN_BUTTON = By.xpath("//div[@class='cookie-dialog__button-accept-all']");
    final By COOKIES_POPUP = By.xpath("//div[@class='cookie-dialog__modal-popup']");
}
