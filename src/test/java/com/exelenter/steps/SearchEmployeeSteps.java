package com.exelenter.steps;

import com.exelenter.base.BaseClass;
import com.exelenter.pages.PIMPage;
import io.cucumber.java.en.*;

public class SearchEmployeeSteps extends BaseClass {
    @Given("user is on Exelenter homepage")
    public void user_is_on_exelenter_homepage() {
        setUp();
    }

    @Given("user logs in with valid admin credentials")
    public void user_logs_in_with_valid_admin_credentials() {
        loginPage.loginToWebsiteViaConfigs("username", "password");
    }

    @Given("user navigates to the employee list page")
    public void user_navigates_to_the_employee_list_page() {
        pimPage.navigateToEmployeeListPage();

    }

    @Given("user enters an existing employee id in the id-search-field")
    public void user_enters_an_existing_employee_id_in_the_id_search_field() {

    }

    @When("user clicks on the search button")
    public void user_clicks_on_the_search_button() {

    }

    @Then("the employee information is displayed on the employee list table")
    public void the_employee_information_is_displayed_on_the_employee_list_table() {
        tearDown();
    }

    @And("user enters an existing employee id in the name-search-field")
    public void userEntersAnExistingEmployeeIdInTheNameSearchField() {

    }
}
