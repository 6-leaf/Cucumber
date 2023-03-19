package com.exelenter.pages;

import com.exelenter.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends BaseClass {
    @FindBy (id = "empsearch_id")
    public WebElement employeeIdSearchField;

    @FindBy (id = "empsearch_employee_name_empName")
    public WebElement employeeNameSearchField;

    @FindBy (id = "searchBtn")
    public WebElement employeeListSearchButton;

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }


    public void searchEmployeeById(String empId){
        sendText(employeeIdSearchField, empId);
    }

    public void searchEmployeeByName(String empName){
        sendText(employeeNameSearchField, empName);
    }
}
