package mySample.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import mySample.geeks.GeeksSteps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="testdata/geeks.csv")
public class GeeksSearchParamStepDefs {

    private final Logger LOG = Logger.getLogger(getClass());
    private String searchTerm;

//    @Steps
//    GeeksSearchStepDefs geeksSearchStepDefs;

    @Steps
    GeeksSteps geeks;

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    public String getSearchTerm() {
        return searchTerm;
    }

    @Before(value="BeforeSetData", order=1)
    public void readCsvFile(){
        dataDrivenTest();
    }

    @Test
    public void dataDrivenTest() {
        LOG.info("SEARCH TERM in 'Test': "+searchTerm);
        Serenity.setSessionVariable("searchTerm").to(searchTerm);
    }

    @When("user searches for searchTerm")
    public void userSearches() {
        LOG.info("SEARCH TERM in 'When': "+searchTerm);
        geeks.seachFor(Serenity.sessionVariableCalled("searchTerm"));
    }

    @Then("user should see a popup with results with searchTerm")
    public void user_should_see_results() {
        System.out.println("should be implemented. Search term: " + Serenity.sessionVariableCalled("searchTerm"));
    }

//    @Test
//    public void data_driven_test() {
//        LOG.info("SEARCH TERM: "+searchTerm);
//
//        //GIVEN
//        geeksSearchStepDefs.user_is_on_the_geeksforgeeks_page();
//
//        //WHEN
//        geeksSearchStepDefs.user_looks(searchTerm);
//
//        //THEN
//        geeksSearchStepDefs.user_should_see_results(searchTerm);
//    }

}
