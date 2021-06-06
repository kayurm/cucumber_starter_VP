package mySample.navigation;

import mySample.geeks.GeeksHeaderPage;
import net.thucydides.core.annotations.Step;


public class NavigateTo {

    GeeksHeaderPage geeksPage;

    @Step("Open the Geeks home page")
    public void theGeeksHomePage(){
        geeksPage.open();
    }
}
