Feature: Adding Dependents

  Background:
    Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashboard page
    And user clicks on PIM option
    And user clicks on Employee List

  @addDependents
  Scenario Outline:Adding Dependents
    When user enters "<employeeID>" number
    And user clicks on Search button
    When user clicks on desired id number
    Then user is navigated to Personal Details page
    Then user clicks on Dependents button
    And user clicks on Add button
    Then user verifies that Name, Relationship and Date of Birth fields are displayed and editable
    Then user enters "<Name>"
    Then user selects "<relationship>" from dropdown menu
    And user selects date of birth "<year>" and "<month>" and "<day>"
    And user clicks on Save button
    And dependent is successfully saved


    Examples:
      | employeeID | Name | relationship | year | month | day |
      |112943A     |Maria Taylor|Child   | 2018 |Jul    |11   |



  @noName
  Scenario Outline: Adding Dependents with incomplete or invalid dependent information
    When user enters "<employeeID>" number
    And user clicks on Search button
    When user clicks on desired id number
    Then user clicks on Dependents button
    And user clicks on Add button
    Then user enters "<Name>"
    Then user selects "<relationship>" from dropdown menu
    And user selects date of birth "<year>" and "<month>" and "<day>"
    And user clicks on Save button
    And user can see "<Error Message>" error message
    Examples:
      | employeeID | Name | relationship | year | month | day | Error Message |
      |112943A    |       |Child        | 2018 |Jul    |  11 |  Required     |

  @noRelationship
  Scenario Outline: Adding Dependents with incomplete or invalid dependent information
    When user enters "<employeeID>" number
    And user clicks on Search button
    When user clicks on desired id number
    Then user clicks on Dependents button
    And user clicks on Add button
    Then user enters "<Name>"
    And user clicks on Save button
    And user can see "<Error Message>" message
    Examples:
      | employeeID | Name | Error Message |
      |112943A    |Silvia Taylor| Required|



  #@editingDependent
 # Scenario Outline:Editing a Dependent
   # When user enters "<employeeID>" number
   # And user clicks on Search button
   # When user clicks on desired id number
   # Then user clicks on Dependents button
    #And user selects the "<Name>" of the dependent to be edited
   # Then user selects "<relationship>" from dropdown menu to edit
   # And user "<Specifies Relationship>"
   # And user saves the changes successfully

   # Examples:
   #   | employeeID | Name | relationship | Specifies Relationship |
   #   |112943A     |Maria Taylor|other   | Mother                 |

 # @removeDependent
  #Scenario Outline:Deleting a Dependent
   # When user enters "<employeeID>" number
   # And user clicks on Search button
   # When user clicks on desired id number
   # Then user clicks on Dependents button
   # And selects the "<Name>" of the dependent to be deleted
   # And deletes the dependent from list
   # Then dependent is successfully deleted
  #  Examples:
   #   | employeeID | Name |
  #    |112943A     |Maria Taylor|

