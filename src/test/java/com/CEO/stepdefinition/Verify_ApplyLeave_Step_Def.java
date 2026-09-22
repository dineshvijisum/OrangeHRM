package com.CEO.stepdefinition;

import com.CEO.pages_objects.ApplyLeavePage;
import com.CEO.pages_objects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_ApplyLeave_Step_Def {
	
	@When("Click the Apply tab")
	public void Click_the_Apply_tab() {
	HomePage.getInstance().leaveClick();
		//ApplyLeavePage.getInstance().applyBtnCLick();
		
	}
	@Given("the leave type {string}")
	public void the_leave_type(String leavetype) {
		
	}
	@Given ("enter the From and To date")
	public void enter_the_From_and_To_date() {
		
	}
	@Given("choose the duration")
	public void choose_the_duration() {
		
	}
	@Given("enter the comments")
	public void enter_the_comments() {
		
	}
	@Given("click the save btn")
	public void click_the_save_btn() {
		
	}
	
	@Then("user should see the error")
	public void user_should_see_the_error() {
		
	}

}
