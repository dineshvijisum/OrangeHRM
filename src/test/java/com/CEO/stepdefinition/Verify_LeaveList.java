/**
 * 
 */
package com.CEO.stepdefinition;

import java.time.Duration;

import com.CEO.constatnt.Constatnts;
import com.CEO.pages_objects.LeaveListPages;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * 
 */
public class Verify_LeaveList {

@Given("User is the home page then click the My info Page12")
public void user_is_the_home_page_then_click_the_my_info_page12() {
   
	DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	LeaveListPages.getInstance().leaveMenuCLick();
	
}

@Given("Choose the From dateand To Date")
public void choose_the_from_dateand_to_date() {
	LeaveListPages.getInstance().dateFieldChoose();
   
}

@Given("choose the Leave with status {string}")
public void choose_the_leave_with_status(String value) {
   LeaveListPages.getInstance().selectLeaveStatus(Constatnts.LeaveStatus);
}

@Then("Click the search button")
public void click_the_search_button() {
    LeaveListPages.getInstance().clickSearchbtn();
}


}
