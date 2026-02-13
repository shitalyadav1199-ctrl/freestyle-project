Feature: Dynamic Controls

  Scenario: Remove checkbox dynamically
    Given user is on dynamic controls page
    When user clicks remove
    Then message should appear
