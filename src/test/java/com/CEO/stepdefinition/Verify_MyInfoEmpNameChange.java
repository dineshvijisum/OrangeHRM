package com.CEO.stepdefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.CEO.pages_objects.HomePage;
import com.CEO.pages_objects.MyInfoPage;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_MyInfoEmpNameChange {
	private static final Logger LOGGER=LogManager.getLogger(Verify_Pending_Timesheets.class);
	
	@Given("User is the home page then click the My info Page1")
	public void user_is_the_home_page_then_click_the_my_info_page1() {
		
		  try { String url= DriverManager.getDriver().getCurrentUrl();
		  if(url.contains("Dashbord")) {
		  LOGGER.info("the user is logged in successfully and is on home page");
		  
		  }
		  
		  }catch(Exception e){ e.printStackTrace();
		  
		  }
		 
		
		  try {
		 
		  DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		  HomePage.getInstance().myInfoClick();
		 
		  } catch(Exception e) {
		  
		  }
		 
	}

	@When("user navigate page then click the employee name field")
	public void user_navigate_page_then_click_the_employee_name_field() {
		
		/*
		 * DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
		 * ofSeconds(20)); HomePage.getInstance().myInfoClick();
		 */
		
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		MyInfoPage.getInstance().empFirstNameEnter();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		MyInfoPage.getInstance().empMiddleName();
	   
	}

	@Then("enter the name as Dinesh Kumar V")
	public void enter_the_name_as_dinesh_kumar_v() {
		
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		MyInfoPage.getInstance().empLastName();
	    
	}


}
