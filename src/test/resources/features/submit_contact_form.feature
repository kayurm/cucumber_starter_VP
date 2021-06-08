Feature: Callback Form
  As a user
  I want to be contacted by CLE
  So I submit callback request

  Background:
    Given user has opened Contact form on the website
    And user has accepted all cookies
    And user saw that Contact form was opened

  Scenario: Submit callback request
    When user enters "SomeName" into name field
    And user enters "SomeSurname" into Surname field
    And user enters "SomeStreet" into Street field
    And user enters "Zip" into PLZ field
    And user enters "Ort" into Ort field
    And user enters "email@some.com" into Email field
    And user enters "+121212" into Phone field
    And user enters "message" into Message field
    And user accepts the Datenschutzbestimmungen
    And user submits the Contact form
    Then User gets a confirmation message