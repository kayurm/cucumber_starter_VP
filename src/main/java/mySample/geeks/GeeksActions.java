package mySample.geeks;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class GeeksActions extends UIInteractionSteps {

    GeeksHeaderPage geekspage;

    @Step("Search for {0}")
    public void seachFor(String searchTerm){
        geekspage.magnifierIcon.click();
        geekspage.searchField.typeAndEnter(searchTerm);
    }
}
