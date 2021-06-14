package mySample.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mySample.contactForm.ContactFormSteps;
import mySample.cookiesDialogue.CookiesSteps;
import mySample.dataDriven.ExcelReader;
import net.thucydides.core.annotations.Steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ExcelDataFeedStepDefs {


    @Steps
    CookiesSteps cookiesDialogue;

    @Steps
    ContactFormSteps contactForm;

    @Steps
    ExcelReader excelReader;

    @Given("I have users data in excel file {string}")
    public void iHaveUsersDataInExcel(String fileName) {
        excelReader.setDataFile(fileName);
    }

    @Given("I opened Contact form on the website")
    public void iOpenContactForm() {
        contactForm.openPage();
    }

    @Given("I accepted all cookies")
    public void iAcceptedAllCookies() {
        cookiesDialogue.acceptAllCookies();
    }

    @Given("I verified I was in the Contact form")
    public void verifyContactFormIsOpened() {
        contactForm.verifyBeingInContactFormPage();
    }

    @When("I read data from the spreadsheet named {string}")
    public void iReadDataFromTheSpreadsheet(String sheetName) {
        excelReader.readSheetFromDataFile(sheetName);
    }


    /**
     *      VARIANT 1. LOOPED TEST (see feature 'excelWithLoop.feature')
     *      I don't like it as:
     *      - if one of the iterations (with a row of dataset) fails, the test itself fails, and using try-catch won't be good for reporting
     *      - iterations are dependable, as I need to go back to the Input page (or open it again) after I finish a new iteration
     */
    @When("I input each value into fields on the form and submit the form I expect confirmation message with all values")
    public void iInputEachValueIntoFields() {
        List<LinkedHashMap<String, String>> dataMap = excelReader.getSheetDataAsMap();

        for (LinkedHashMap<String, String> record : dataMap) {
            for (Map.Entry<String, String> entry : record.entrySet()) {
                contactForm.enterValueToField(entry.getKey(), entry.getValue());
            }
            contactForm
                    .clickDatenschutzCheckbox()
                    .submitForm()
                    .verifyConfirmationMessageAppears()
                    .verifyValuesInConfirmationScreen()
                    .openPage();
        }
    }

    @When("I input each value into fields on the form and submit the form I expect error message")
    public void iInputEachValueIntoFieldsExpectErrorMessage() {
        List<LinkedHashMap<String, String>> dataMap = excelReader.getSheetDataAsMap();

        for (LinkedHashMap<String, String> record : dataMap) {
            for (Map.Entry<String, String> entry : record.entrySet()) {
                contactForm.enterValueToField(entry.getKey(), entry.getValue());
            }
            contactForm
                    .clickDatenschutzCheckbox()
                    .submitForm()
                    .verifyErrorMessageAppears();
        }
    }


    /**
     *      VARIANT 2. TEST with 'Scenario outline' usage (see feature 'excelWithScenarioOutline.feature')
     *      I like this approach more, as it's iterable by cucumber and each test is independent
     */
    @When("^I input values into fields taken from the sheet (\\d+)$")
    public void iInputValuesIntoFieldsFromRowNumber(int row) {
        List<LinkedHashMap<String, String>> dataMap = excelReader.getSheetDataAsMap();
        LinkedHashMap<String, String> dataRowMap = dataMap.get(row-1);
        for (Map.Entry<String, String> entry : dataRowMap.entrySet()) {
            contactForm.enterValueToField(entry.getKey(), entry.getValue());
        }
    }

    @When("I accept Datenschutz and submit the form")
    public void iAcceptDatenschutzAndSubmitTheForm() {
        contactForm
                .clickDatenschutzCheckbox()
                .submitForm();
    }

    @Then("I expect successful confirmation message with all values in it")
    public void iExpectSuccessfulConfirmationMessageWithValues() {
        contactForm
                .verifyConfirmationMessageAppears()
                .verifyValuesInConfirmationScreen();
    }

    @Then("I expect error message")
    public void iExpectErrorMessage() {
        contactForm
                .verifyErrorMessageAppears();
    }
}
