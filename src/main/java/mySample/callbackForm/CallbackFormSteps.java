package mySample.callbackForm;

import mySample.base.BaseSteps;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class CallbackFormSteps extends BaseSteps {

    CallbackFormPage callbackFormPage;

    @Step
    public void verifyUserInCallbackFormPage(){
        LOG.info("verifying - in callback form");
        $(callbackFormPage.TITLE).shouldBeVisible();
    }

    @Step
    public void enterName(String name){
        //moveTo($(callbackFormPage.NAME_FIELD));
        $(callbackFormPage.NAME_FIELD).type(name);
    }
    @Step
    public void enterPhone(String phone){
        callbackFormPage.PHONE_FIELD.type(phone);
    }
    @Step
    public void clickDatenschutzCheckbox(){
        callbackFormPage.DATENSCHUTZ_CHECKBOX.click();
    }

    @Step
    public void verifyConfirmationMessage(){
        callbackFormPage.CONF_MESSAGE_VIELENDANK.isDisplayed();
        callbackFormPage.CONF_MESSAGE_WILLCONTACTASAP.isDisplayed();
    }

    @Step
    public void submitForm(){
        callbackFormPage.SUBMIT_BUTTON.click();
    }
}
