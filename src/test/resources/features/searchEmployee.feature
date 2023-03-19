Feature: Searching existing employees

  Background:
    And user logs in with valid admin credentials
    * user navigates to the employee list page

  Scenario: Search for an employee by id
#    Given user is on Exelenter homepage ==> This line replaced by Hooks
#    And user logs in with valid admin credentials  ==> This line replaced by Background
#    * user navigates to the employee list page     ==> This line replaced by Background
    * user enters an existing employee id in the id-search-field
    When user clicks on the search button
    Then  the employee information is displayed on the employee list table

  Scenario: Search for an employee by name
#    Given user is on Exelenter homepage
#    And user logs in with valid admin credentials     ==> This line replaced by Background
#    * user navigates to the employee list page        ==> This line replaced by Background
    * user enters an existing employee name in the name-search-field
    When user clicks on the search button
    Then  the employee information is displayed on the employee list table