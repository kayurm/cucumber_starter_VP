package mySample.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.contactForm.ContactFormSteps;
import mySample.cookiesDialogue.CookiesSteps;
import net.thucydides.core.annotations.Steps;

import java.util.List;


public class SubmitContactFormStepsDefs {

    @Steps
    CookiesSteps cookiesDialogue;

    @Steps
    ContactFormSteps contactForm;

    @Given("user has opened Contact form on the website")
    public void userOpensContactForm(){
        contactForm.openPage();
    }

    @Given("user has accepted all cookies")
    public void userHasAcceptedAllCookies() {
        cookiesDialogue.acceptAllCookies();
    }

    @Given("user saw that Contact form was opened")
    public void userSawCallbackFormWasOpened() {
        contactForm.verifyBeingInContactFormPage();
    }

    @When("user types into fields following values")
    public void userTypesValuesToFields(DataTable dataTable) {
       List<List<String>> fieldsValues = dataTable.asLists(String.class);
       for(List<String> fieldValue: fieldsValues){
           contactForm.enterValueToField(fieldValue.get(0), fieldValue.get(1));
       }
    }

    @When("user accepts the Datenschutzbestimmungen")
    public void userAcceptsTheDatenschutzbestimmungen() {
        contactForm.clickDatenschutzCheckbox();
    }

    @When("user submits the Contact form")
    public void userSubmitsContactForm() {
        contactForm.submitForm();
    }

    @Then("User gets a confirmation message")
    public void userGetsConfirmationMessage() {
        contactForm.verifyConfirmationMessageAppears();
    }
}
