package mySample.contactForm;

import mySample.base.BaseSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static mySample.contactForm.ContactFormPage.Field;

public class ContactFormSteps extends BaseSteps {

    ContactFormPage contactFormPage;

    @Step
    public void openPage(){
        LOG.info("Open contact page");
        contactFormPage.open();
    }

    @Step
    public void acceptAllCookies(){
        $(contactFormPage.COOKIES_POPUP).shouldBeVisible();
        $(contactFormPage.ALLE_AKZEPTIEREN_BUTTON).click();
    }

    @Step
    public void verifyUserInContactFormPage(){
        LOG.info("verifying - in contact form");
        $(contactFormPage.TITLE).shouldBeVisible();
    }

    @Step("Entering value {1} to the field {0}")
    public void enterValueToField(Field fieldName, String value){
        LOG.info("Enter data: " + value + " To the field:" + fieldName);
        By fieldBy = defineSelector(fieldName);
        $(fieldBy).type(value);
    }

    @Step
    public void clickDatenschutzCheckbox(){
        $(contactFormPage.DATENSCHUTZ_CHECKBOX).click();
    }

    @Step
    public void submitForm(){
        $(contactFormPage.ABSENDEN_BUTTON).click();
    }

    @Step
    public void verifyConfirmationMessageAppears(){

    }

    private By defineSelector(Field fieldName){
        LOG.info("defining selector for field: " + fieldName);
        By selectorBy = null;
        switch (fieldName) {
            case NAME:
                selectorBy = contactFormPage.NAME_FIELD;
                break;
            case SURNAME:
                selectorBy = contactFormPage.SURNAME_FIELD;
                break;
            case STRASSE:
                selectorBy = contactFormPage.STRASSE_FIELD;
                break;
            case PLZ:
                selectorBy = contactFormPage.PLZ_FIELD;
                break;
            case ORT:
                selectorBy = contactFormPage.ORT_FIELD;
                break;
            case PHONE:
                selectorBy = contactFormPage.PHONE_FIELD;
                break;
            case EMAIL:
                selectorBy = contactFormPage.EMAIL_FIELD;
                break;
            case MESSAGE:
                selectorBy = contactFormPage.MESSAGE_FIELD;
                break;
            default:
                LOG.error("no such field");
        }
        return selectorBy;
    }

}
