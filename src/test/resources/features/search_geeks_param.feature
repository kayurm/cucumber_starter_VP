Feature: Search in geeksforgeeks with param

  @BeforeSetData
  Scenario: Search for a parametrized term
    Given user is on the geeksforgeeks page
    When user searches for searchTerm
    Then user should see a popup with results with searchTerm