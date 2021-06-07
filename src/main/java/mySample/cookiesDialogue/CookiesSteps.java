package mySample.cookiesDialogue;

import mySample.base.BaseSteps;
import net.thucydides.core.annotations.Step;

public class CookiesSteps extends BaseSteps {

    CookiesPage cookiesPage;

    @Step
    public void acceptAllCookies(){
        element(cookiesPage.COOKIES_POPUP).shouldBeVisible();
        element(cookiesPage.ALLE_AKZEPTIEREN_BUTTON).click();
    }
}
