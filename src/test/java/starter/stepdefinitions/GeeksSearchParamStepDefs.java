package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.geeks.GeeksSteps;
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

    @Steps
    GeeksSteps geeks;

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    public String getSearchTerm() {
        return searchTerm;
    }

    @Test
    public void data_driven_test() {
        LOG.info("SEARCH TERM: "+searchTerm);
        geeks.openPage();
        geeks.seachFor(searchTerm);
        System.out.println("should be implemented. Search term: "+searchTerm);
    }

    @When("user looks up (.*)")
    public void user_looks_up() {
        geeks.seachFor(searchTerm);
    }

    @Then("user should see a popup with results containing (.*)")
    public void user_should_see_results() {
        System.out.println("should be implemented. Search term: "+searchTerm);
    }
}
