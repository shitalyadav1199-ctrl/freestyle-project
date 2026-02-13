Feature: Dropdown

  Scenario: Select dropdown option
    Given user is on dropdown page
    When user selects "Option 2"
    Then option should be selected
