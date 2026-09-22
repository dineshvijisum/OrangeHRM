package com.CEO.stepdefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.CEO.constatnt.Constatnts;
import com.CEO.pages_objects.DirectoryPage;
import com.CEO.pages_objects.HomePage;
import com.CEO.pages_objects.RecruitmentPage;
import com.CEO.pages_objects.TimeTimeSheets;
import com.CEO.utilities.CommonUtils;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_Pending_Timesheets {


	private static final Logger LOGGER=LogManager.getLogger(Verify_Pending_Timesheets.class);

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		try {
			String url=	DriverManager.getDriver().getCurrentUrl();
			if(url.contains("Dashbord")) {
				LOGGER.info("the user is logged in successfully and is on home page");

			}

		}catch(Exception e){
			e.printStackTrace();

		}
	}

	@When("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {

		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		HomePage.getInstance().clickTimesideBar();
		System.out.println("the user clicks on the time option from the menu");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//TimeTimeSheets.getInstance().clickEmpName(null);
		TimeTimeSheets.getInstance().enterEmployeClick();
		//TimeTimeSheets.getInstance().enterEmployeTimeSheets(Constatnts.TIMESHEETEMPNAME);

	}


	// find by drop down choose 
	@When("the user enters the name as {string} using dropdown {string}") 
	public void the_user_enters_the_name_as_using_dropdown(String string,String howTo) {
		try {

			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100)); 
			System.out.println("the user enters the name as");
			TimeTimeSheets.getInstance().enterEmployeTimeSheets(Constatnts.TIMESHEETEMPNAME);
			//CommonUtils.getInstance().selectFromDropDown(TimeTimeSheets.getInstance().clickEmployeeField(), howTo, string);
			//TimeTimeSheets.getInstance().enterEmployeTimeSheets(string);
			//CommonUtils.getInstance().selectFromDropDown(TimeTimeSheets.getInstance().enterEmployeTimeSheets(),howTo, string); 
		}catch(Exception e) {
			e.printStackTrace(); } }


	//@When("the user enters the name as {string} from the dropdownfield {string}")
	/*
	 * @When("the user enters the name as {string} using dropdown") public void
	 * the_user_enters_the_name_as_using_dropdown(String string) { try {
	 * 
	 * DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
	 * ofSeconds(10)); System.out.println("the user enters the name as");
	 * TimeTimeSheets.getInstance().clickEmpName(string);
	 * //TimeTimeSheets.getInstance().enterEmployeTimeSheets(string);
	 * //CommonUtils.getInstance().selectFromDropDown(TimeTimeSheets.getInstance().
	 * enterEmployeTimeSheets(),howTo, string); }catch(Exception e) {
	 * e.printStackTrace(); } }
	 */

	@When("clicks on the view button")
	public void clicks_on_the_view_button() {

		try {

			TimeTimeSheets.getInstance().clickViewBtn();
			System.out.println("clicks on the view button");

		}catch(Exception e) {
			e.printStackTrace();
			

		}
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String string) {
		System.out.println("the user should see the message as");
	}

}
