package mySample.navigation;

import mySample.callbackForm.CallbackFormPage;
import mySample.callbackForm.CallbackFormSteps;
import mySample.geeks.GeeksHeaderPage;
import net.thucydides.core.annotations.Step;


public class NavigateTo {

    GeeksHeaderPage geeksPage;
    CallbackFormPage callbackFormPage;

    @Step("Open the Geeks home page")
    public void theGeeksHomePage(){
        geeksPage.open();
    }

    @Step
    public void theCallbackFormPage(){
        callbackFormPage.open();
    }
}
