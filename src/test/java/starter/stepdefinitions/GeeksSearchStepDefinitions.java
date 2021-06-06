package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.geeks.GeeksSteps;
import mySample.navigation.NavigateTo;
import net.thucydides.core.annotations.Steps;

public class GeeksSearchStepDefinitions {

    @Steps
    GeeksSteps geeks;

    @Steps
    NavigateTo navigateTo;

    @Given("user is on the geeksforgeeks page")
    public void user_is_on_the_geeksforgeeks_page() {
        navigateTo.theGeeksHomePage();
    }

    @When("user looks up {string}")
    public void user_looks_up_something(String searchTerm) {
        geeks.seachFor(searchTerm);
    }

    @Then("user should see a popup with results containing {string}")
    public void user_should_see_results_containing_something(String searchTerm) {
        System.out.println("should be implemented. Search term: "+searchTerm);
    }
}
