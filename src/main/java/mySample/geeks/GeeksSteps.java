package mySample.geeks;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;


public class GeeksSteps extends UIInteractionSteps {

    private final Logger LOG = Logger.getLogger(getClass());
    GeeksHeaderPage geeksPage;

    @Step("Search for {0}")
    public void seachFor(String term){
        LOG.info("searching for: "+term);
        geeksPage.MAGNIFIER_ICON.click();
        geeksPage.SEARCH_FIELD.typeAndEnter(term);
    }
}
