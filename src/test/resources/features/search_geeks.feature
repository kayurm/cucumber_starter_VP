Feature: Search in geeksforgeeks

  Scenario: Search for a term
    Given user is on the geeksforgeeks page
    When user looks up "something"
    Then user should see a popup with results containing "something"
