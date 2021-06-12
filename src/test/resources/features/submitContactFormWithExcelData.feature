Feature: Contact Form

  Background:
    Given I have users data in excel file 'userData.xlsx'
    And I opened Contact form on the website
    And I accepted all cookies

  Scenario: Successfully submit Contact form
    When I read data from the spreadsheet named 'happyPath'
    And I input each value into fields on the form
    And I accept the Datenschutzbestimmungen
    And I submit the Contact form
    Then I get a confirmation message with all values being shown

  Scenario: Fail to submit Contact form with Bad User Data
    When I read data from the spreadsheet named 'negativeScenario'
    And I input each value into fields on the form
    And I accept the Datenschutzbestimmungen
    And I submit the Contact form
    Then I get the message saying there was a validation error
    And I ensure there is no successful confirmation message
