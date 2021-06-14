Feature: Contact Form with Scenario Outline Excel Feed

  Background:
    Given I have users data in excel file "userData.xlsx"
    And I opened Contact form on the website
    And I accepted all cookies


  Scenario Outline: Successfully submit Contact form
    When I read data from the spreadsheet named "happyPath"
    And I input values into fields taken from the sheet <row>
    And I accept Datenschutz and submit the form
    Then I expect successful confirmation message with all values in it
    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |

  Scenario Outline: Fail to submit Contact form with Bad User Data
    When I read data from the spreadsheet named 'negativeScenario'
    And I input values into fields taken from the sheet <row>
    And I accept Datenschutz and submit the form
    Then I expect error message
    Examples:
      | row |
      | 1   |
      | 2   |
