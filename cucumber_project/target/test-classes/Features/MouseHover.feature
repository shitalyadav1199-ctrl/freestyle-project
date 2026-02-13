Feature: Mouse Hover

  Scenario: Hover on image
    Given user is on hover page
    When user hovers on image
    Then user name should be displayed
