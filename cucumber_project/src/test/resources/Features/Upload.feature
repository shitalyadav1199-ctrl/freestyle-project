Feature: File Upload

  Scenario: Upload file
    Given user is on upload page
    When user uploads a file
    Then file should be uploaded
