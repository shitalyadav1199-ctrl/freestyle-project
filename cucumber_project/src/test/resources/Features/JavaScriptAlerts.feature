Feature: JavaScript Alerts

  Scenario: Handle all JavaScript alerts
    Given user is on javascript alerts page
    When user handles JS Alert
    And user handles JS Confirm
    And user handles JS Prompt
    Then result message should be displayed
