Feature: Callback Form
  As a user
  I want to be contacted by CLE
  So I submit callback request

  Background:
    Given user has opened 'Callback form' on the website
    And user has accepted all cookies dialogue

  Scenario: Submit callback request
    When user enters "SomeName" into name field
    And user enters "+11111" into phone field
    And user accepts the Datenschutzbestimmungen
    And user submits the form
    Then a new tab is opened with the confirmation message