Feature: Callback Form
  As a user
  I want to be contacted by CLE
  So I submit callback request

  Background:
    Given user has opened Contact form on the website
    And user has accepted all cookies
    And user saw that Contact form was opened

  Scenario: Submit callback request
    When user types into fields following values
      | name    | Brendan           |
      | surname | Pite              |
      | strasse | auto street       |
      | plz     | 12345             |
      | ort     | Koeln             |
      | email   | auto@email.com    |
      | phone   | 123456789         |
      | message | please contact me |
    And user accepts the Datenschutzbestimmungen
    And user submits the Contact form
    Then User gets a confirmation message