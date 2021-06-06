Feature: Search in geeksforgeeks with param

  Scenario: Search for a parametrized term
    Given user is on the geeksforgeeks page
    When user looks up <searchTerm>
    Then user should see a popup with results containing <searchTerm>