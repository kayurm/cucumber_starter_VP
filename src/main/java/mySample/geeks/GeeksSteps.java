package mySample.geeks;

import mySample.base.BaseSteps;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;


public class GeeksSteps extends BaseSteps {

    GeeksPage geeksPage;

    @Step
    public void openPage(){
        LOG.info("Opening geeks page at: " + geeksPage.getDriver().getCurrentUrl());
        //geeksPage.open();
        geeksPage.openUrl("https://www.geeksforgeeks.org/");
    }

    @Step("Search for {0}")
    public void seachFor(String term){
        LOG.info("searching for: "+term);
        geeksPage.MAGNIFIER_ICON.click();
        geeksPage.SEARCH_FIELD.typeAndEnter(term);
    }
}
