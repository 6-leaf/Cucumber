Feature: Searching existing employees
  Scenario: Search for an employee by id
    Given user is on Exelenter homepage
#    And user logs in with valid admin credentials
#    * user navigates to the employee list page
#    * user enters an existing employee id in the id-search-field
#    When user clicks on the search button
    Then  the employee information is displayed on the employee list table

  Scenario: Search for an employee by name
    Given user is on Exelenter homepage
    And user logs in with valid admin credentials
    * user navigates to the employee list page
    * user enters an existing employee id in the name-search-field
    When user clicks on the search button
    Then  the employee information is displayed on the employee list table