Feature: Creating Login Details for an Employee in the HRMS Application
  As an HR administrator
  I want to create login details for an employee in the HRMS application
  So that the employee can log in with the provided credentials

  Background:
    #Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashbaord page
    When user clicks on PIM option
    And user clicks on add employee option


  Scenario: Enabling login details creation
    When I check the "Create Login Details" checkbox
    Then the login details fields should be enabled


  Scenario: Providing a unique username ,password and confirming the password
    Given the login details fields are enabled
    When I enter "sidra12345" in the Username field
    And I enter Strong password in the Password field
    Then the password field should display a hint message
    And the password should meet the complexity requirements
    Then I enter the password for reconfirm password
    Then the system should validate that the confirm password matches the password

  @login123
  Scenario: Setting the login status
    Given the login details fields are enabled
    When I select "Enabled" from the "Status" dropdown
    Then the status should be set to "Enabled"

  @createLogin
  Scenario: Create Login details for employees
    When user enters "Siri" "Test" and "User" in the name fields
    When the login details fields are enabled
    And I enter "Sidra07" in the Username field
    And I enter Strong password in the Password field
    Then I enter the password for reconfirm password
    #And I select "Enabled" from the "Status" dropdown
    And I click on save button
    #And user created login details successfully
    When I logs out of the website
    And I enters employee username and password
    And I click on login button
    Then user is navigated to employee dashbaord page


