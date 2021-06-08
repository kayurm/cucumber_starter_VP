package mySample.geeks;

import mySample.base.BaseSteps;
import net.thucydides.core.annotations.Step;


public class GeeksSteps extends BaseSteps {

    GeeksHeaderPage geeksPage;

    @Step
    public void openPage(){
        LOG.info("Open contact page");
        geeksPage.open();
    }

    @Step("Search for {0}")
    public void seachFor(String term){
        LOG.info("searching for: "+term);
        geeksPage.MAGNIFIER_ICON.click();
        geeksPage.SEARCH_FIELD.typeAndEnter(term);
    }
}
