package com.CEO.stepdefinition;

import java.time.Duration;

import com.CEO.pages_objects.Dashboard;
import com.CEO.pages_objects.MyInfoPage;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_PunchInTime {
	
	@Given("User is the home page then click the My info Page")
	public void user_is_the_home_page_then_click_the_my_info_page() {
	  try {
		  
		  DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  MyInfoPage.getInstance().myInfoClick();
		  
		 
		  
	  }
	 catch(Exception e) {
		 
	  }
	}
	
	@When("User click the dashboard  side bar menu")
	public void user_click_the_dashboard_side_bar_menu() {
		
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 Dashboard.getInstance().dashMenu();
	    
	}

	@Then("click the Punch in timer icon")
	public void click_the_punch_in_timer_icon() {
		
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Dashboard.getInstance().timerBtn();
		
		Dashboard.getInstance().notesEnter();
	   
	}

}
