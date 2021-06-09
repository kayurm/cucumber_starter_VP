Feature: Search in geeksforgeeks

  Scenario Outline: Search for a term
    Given user is on the geeksforgeeks page
    When user looks up <searchTerm>
    Then user should see a popup with results containing <searchTerm>

    Examples:
      | searchTerm |
      | appium     |
      | robot      |
