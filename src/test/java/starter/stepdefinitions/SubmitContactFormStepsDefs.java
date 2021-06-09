package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.contactForm.ContactFormPage;
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
//        cookiesDialogue.withDriver(contactForm.getDriver());
//        cookiesDialogue.acceptAllCookies();
        contactForm.acceptAllCookies();
    }
    @Given("user saw that Contact form was opened")
    public void userSawCallbackFormWasOpened() {
//        contactForm.withDriver(cookiesDialogue.getDriver());
//        contactForm.verifyUserInContactFormPage();
        contactForm.verifyUserInContactFormPage();
    }
    @When("user types into fields following values")
    public void userTypesValuesToFields(DataTable fieldsValuesTable) {
       List<List<String>> fieldsValuesList = fieldsValuesTable.asLists(String.class);
       for(List<String> fieldValue: fieldsValuesList){
           contactForm.enterValueToField(fieldValue.get(0), fieldValue.get(1));
       }
    }



//    }
//    @When("user enters {string} into Surname field")
//    public void userEntersToSurnameField(String value) {
//        contactForm.enterValueToField(ContactFormPage.Field.SURNAME, value);
//    }
//    @When("user enters {string} into Street field")
//    public void userEntersToStreetField(String value) {
//        contactForm.enterValueToField(ContactFormPage.Field.STRASSE, value);
//    }
//    @When("user enters {string} into PLZ field")
//    public void userEntersToPlzField(String value) {
//        contactForm.enterValueToField(ContactFormPage.Field.PLZ, value);
//    }
//    @When("user enters {string} into Ort field")
//    public void userEntersToOrtField(String value) {
//        contactForm.enterValueToField(ContactFormPage.Field.ORT, value);
//    }
//    @When("user enters {string} into Email field")
//    public void userEntersToEmailField(String value) {
//        contactForm.enterValueToField(ContactFormPage.Field.EMAIL, value);
//    }
//    @When("user enters {string} into Phone field")
//    public void userEntersToPhoneField(String value) {
//        contactForm.enterValueToField(ContactFormPage.Field.PHONE, value);
//    }
//    @And("user enters {string} into Message field")
//    public void userEntersIntoMessageField(String value) {
//        contactForm.enterValueToField(ContactFormPage.Field.MESSAGE, value);
//    }
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
        System.out.println("to implement");
    }


}
