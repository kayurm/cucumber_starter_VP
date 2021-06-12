package mySample.contactForm;

import mySample.base.BaseSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.assertj.core.api.Assertions.fail;

public class ContactFormSteps extends BaseSteps {

    ContactFormPage contactFormPage;

    @Step
    public void openPage() {
        LOG.info("Open contact page");
        contactFormPage.open();
    }

    @Step
    public void verifyUserInContactFormPage() {
        LOG.info("verifying - being in contact form");
        $(contactFormPage.TITLE).shouldBeVisible();
    }

    @Step("Entering value {1} to the field {0}")
    public void enterValueToField(String fieldName, String value) {
        LOG.info("Entering data: " + value + " To the field:" + fieldName);
        By fieldBy = defineSelector(fieldName);
        $(fieldBy).type(value);
    }

    @Step
    public void clickDatenschutzCheckbox() {
        LOG.info("clicking datenschutz checkbox");
        $(contactFormPage.DATENSCHUTZ_CHECKBOX).click();
    }

    @Step
    public void submitForm() {
        LOG.info("clicking Absenden");
        $(contactFormPage.ABSENDEN_BUTTON).click();
    }

    @Step
    public void verifyConfirmationMessageAppears() {
        LOG.info("verifying conf.message");
        setImplicitTimeout(10, SECONDS);
        $(contactFormPage.GESCHAEFT_CONF_MESSAGE).shouldBeVisible();
        resetImplicitTimeout();
    }

    private By defineSelector(String fieldName) {
        LOG.info("defining selector for field: " + fieldName);
        By selectorBy = null;
        switch (fieldName.toLowerCase()) {
            case "name":
                selectorBy = contactFormPage.NAME_FIELD;
                break;
            case "surname":
                selectorBy = contactFormPage.SURNAME_FIELD;
                break;
            case "strasse":
            case "street":
                selectorBy = contactFormPage.STRASSE_FIELD;
                break;
            case "plz":
            case "zip":
                selectorBy = contactFormPage.PLZ_FIELD;
                break;
            case "ort":
            case "city":
                selectorBy = contactFormPage.ORT_FIELD;
                break;
            case "phone":
                selectorBy = contactFormPage.PHONE_FIELD;
                break;
            case "email":
                selectorBy = contactFormPage.EMAIL_FIELD;
                break;
            case "message":
                selectorBy = contactFormPage.MESSAGE_FIELD;
                break;
            default:
                fail("No such filed: " + fieldName);
        }
        return selectorBy;
    }

}
