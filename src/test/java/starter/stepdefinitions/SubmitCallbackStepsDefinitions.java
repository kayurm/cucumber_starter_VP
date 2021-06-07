package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.callbackForm.CallbackFormSteps;
import mySample.cookiesDialogue.CookiesSteps;
import mySample.navigation.NavigateTo;
import net.thucydides.core.annotations.Steps;

public class SubmitCallbackStepsDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    CookiesSteps cookiesDialogue;

    @Steps
    CallbackFormSteps callbackForm;

    @Given("user has opened 'Callback form' on the website")
    public void userOpensCallbackForm(){
        navigateTo.theCallbackFormPage();
    }

    @And("user has accepted all cookies dialogue")
    public void userHasAcceptedAllCookiesDialogue() {
        cookiesDialogue.acceptAllCookies();
    }

    @When("user enters {string} into name field")
    public void userEntersName(String name) {
        callbackForm.withDriver(cookiesDialogue.getDriver());
        callbackForm.enterName(name);
    }

    @And("user enters {string} into phone field")
    public void userEntersPhone(String phone) {
        callbackForm.enterPhone(phone);
    }

    @And("user accepts the Datenschutzbestimmungen")
    public void userAcceptsTheDatenschutzbestimmungen() {
        callbackForm.clickDatenschutzCheckbox();
    }

    @And("user submits the form")
    public void userSubmitsCallbackForm() {
        callbackForm.submitForm();
    }

    @Then("a new tab is opened with the confirmation message")
    public void aNewTabIsOpenedWithTheConfirmationMessage() {
        callbackForm.switchTab(callbackForm.getDriver());
        callbackForm.verifyConfirmationMessage();
    }
}
