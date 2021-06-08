package mySample.cookiesDialogue;

import mySample.base.BaseSteps;
import net.thucydides.core.annotations.Step;

public class CookiesSteps extends BaseSteps {

    CookiesDialogue cookiesDialogue;

    @Step
    public void acceptAllCookies(){
        $(cookiesDialogue.COOKIES_POPUP).shouldBeVisible();
        $(cookiesDialogue.ALLE_AKZEPTIEREN_BUTTON).click();
    }
}
