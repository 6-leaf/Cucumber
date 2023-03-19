package com.exelenter.steps;

import com.exelenter.base.BaseClass;
import com.exelenter.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseClass {
    @Given("user is on the exelenter webpage")
    public void user_is_on_the_exelenter_webpage() {setUp();
    }

    @Then("welcome message is displayed in dashboard page")
    public void welcome_message_is_displayed_in_dashboard_page() {
        String expectedWelcomeMsg = "Welcome Admin";
        String actualWelcomeMsg = dashboardPage.welcome.getText();
        Assert.assertEquals("Admin login NOT successful",expectedWelcomeMsg, actualWelcomeMsg);
    }

    @When("user pass the valid username and invalid password")
    public void user_pass_the_valid_username_and_invalid_password() {
        loginPage.loginToWebsiteViaConfigs("username","invalidpassword");
    }

    @When("user pass the valid username and empty password")
    public void user_pass_the_valid_username_and_empty_password() {
        loginPage.loginToWebsiteViaConfigs("username","emptypassword");
    }

    @Then("login error message for invalid password is displayed")
    public void login_error_message_for_invalid_password_is_displayed() {
        String expectedLoginErrorMsg = "Invalid credentials";
        String actualLoginErrorMsg = loginPage.loginErrorMessage.getText();
        Assert.assertEquals("Login Error Message is Incorrect",expectedLoginErrorMsg, actualLoginErrorMsg);
    }

    @Then("login error message for empty password is displayed")
    public void login_Error_Message_For_Empty_Password_Is_Displayed() {
        Assert.assertEquals("Login Error Message is Incorrect", "Password cannot be empty", loginPage.loginErrorMessage.getText());
        //Assert.fail(); // Failing this for rerun failed.txt, please fix after you are done testing.
    }


}
