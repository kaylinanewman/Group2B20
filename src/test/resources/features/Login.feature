Feature: Login scenarios

  @login
  Scenario: Valid Admin Login
    #Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashboard page or landing page