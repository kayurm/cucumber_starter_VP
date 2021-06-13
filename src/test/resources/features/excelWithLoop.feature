Feature: Contact Form with looped Excel Feed

  Background:
    Given I have users data in excel file "userData.xlsx"
    And I opened Contact form on the website
    And I accepted all cookies
    And I verified I was in the Contact form

  Scenario: Successfully submit Contact form
    When I read data from the spreadsheet named "happyPath"
    And I input each value into fields on the form and submit the form I expect confirmation message with all values


  Scenario: Fail to submit Contact form with Bad User Data
    When I read data from the spreadsheet named 'negativeScenario'
    And I input each value into fields on the form and submit the form I expect error message
