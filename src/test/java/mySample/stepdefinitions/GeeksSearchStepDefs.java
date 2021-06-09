package mySample.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.geeks.GeeksSteps;
import net.thucydides.core.annotations.Steps;

public class GeeksSearchStepDefs {

    @Steps
    GeeksSteps geeks;

    @Given("user is on the geeksforgeeks page")
    public void user_is_on_the_geeksforgeeks_page() {
        geeks.openPage();
    }

    @When("^user looks up (.*)$")
    public void user_looks(String searchTerm) {
        geeks.seachFor(searchTerm);
    }

    @Then("^user should see a popup with results containing (.*)$")
    public void user_should_see_results(String searchTerm) {
        System.out.println("should be implemented. Search term: "+searchTerm);
    }
}
