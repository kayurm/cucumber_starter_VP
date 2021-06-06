package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.geeks.GeeksSteps;
import mySample.navigation.NavigateTo;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="testdata/geeks.csv")
public class GeeksSearchParamStepDefinitions {

    private String searchTerm;

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    @Test
    public void data_driven_test() {
        System.out.println("SEARCH TERM: "+searchTerm);
        navigateTo.theGeeksHomePage();
        geeks.seachFor(searchTerm);
        System.out.println("should be implemented. Search term: "+searchTerm);
    }

    @Steps
    GeeksSteps geeks;

    @Steps
    NavigateTo navigateTo;


    @When("user looks up (.*)")
    public void user_looks_up_something() {
        geeks.seachFor(searchTerm);
    }

    @Then("user should see a popup with results containing (.*)")
    public void user_should_see_results_containing_something() {
        System.out.println("should be implemented. Search term: "+searchTerm);
    }
}
