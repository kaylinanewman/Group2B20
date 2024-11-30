
  Feature: Creating Login Details for an Employee in the HRMS Application
  As an HR administrator
  I want to create login details for an employee in the HRMS application
  So that the employee can log in with the provided credentials

  Background:
    #Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashboard page
    When user clicks on PIM option
    And user clicks on add employee option


  @createLogin
  Scenario Outline: Create Login details for employees
    When user enters "<FirstName>" "<MiddleName>" and "<LastName>" in the name fields
    When the login details fields are enabled
    And I enter in the Username field
    And I enter Strong password in the Password field
    Then I enter the password for reconfirm password
    #And I select "Enabled" from the "Status" dropdown
    And I click on save button
    #And user created login details successfully
    When I logs out of the website
    And I enters employee username and password
    And I click on login button
    Then user is navigated to employee dashboard page

    Examples:
    |FirstName| MiddleName | LastName  |
    |Sira     | Test       |  User     |


