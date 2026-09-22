package com.CEO.stepdefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.CEO.constatnt.Constatnts;
import com.CEO.pages_objects.HomePage;
import com.CEO.pages_objects.RecruitmentPage;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Verify_RecruitmentPageSearch {
	
	public static final Logger LOGGER=LogManager.getLogger(Verify_RecruitmentPageSearch.class);
	
	@Given("the user is on the homepage rec")
	public void the_user_is_on_the_homepage_rec() {
		System.out.println("the_user_is_on_the_homepage_rec");
	}
	
	@When("the user is on home page click the Recuruitment btn")
	public void the_user_is_on_home_page_click_the_recuruitment_btn() {
		
		try {
			//DriverManager.getDriver().manage().window().maximize();
			LOGGER.info("the_user_is_on_the_homepage_rec");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		    HomePage.getInstance().recruitmentMenuClick();
		   // HomePage.getInstance().pimMenuClick();
		    
		    System.out.println("the_user_is_on_home_page_click_the_recuruitment_btn");
		    
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
	}

	@When("choose the Job title{string}")
	public void choose_the_job_title(String jobTitleValue) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("choose_the_job_title");
		RecruitmentPage.getInstance().selectJobTitle(jobTitleValue);
		// RecruitmentPage.getInstance().fieldsClick(jobTitleValue);
		    
		
	}
	@When("choose the vacancy{string}")
	public void choose_the_vacancy(String value) {
		RecruitmentPage.getInstance().selectVacancy(Constatnts.VacancyCh);
		
	}
	
	@When("choose the hiring manager {string}")
	public void choose_the_hiring_manager(String value) {
		RecruitmentPage.getInstance().selectHiringManager(Constatnts.HiringManager);
		
	}
	@When("choose the status {string}")
	public void choose_the_status(String value) {
		RecruitmentPage.getInstance().selectStatus(Constatnts.Status);
		
	}
	@When("choose the Date")
	public void choose_the_Date() {
		RecruitmentPage.getInstance().selectDateFrom();
	}
	
	@When("choose the ToDate")
	public void choose_the_ToDate() {
		RecruitmentPage.getInstance().selectDateTo();
	}
	
	@When("click the search")
	public void click_the_search() {
		RecruitmentPage.getInstance().clickSearch();
	}	
	@When("user get No Records Found then click add btn")
	public void user_get_No_Records_Found_then_click_add_btn() {
		RecruitmentPage.getInstance().validateSearch();
		RecruitmentPage.getInstance().firstName();
		//RecruitmentPage.getInstance().browse();
		
	}
	@When("I upload the resume {string}")
	public void i_upload_the_resume(String filePath) {
	    RecruitmentPage.getInstance().uploadResume(filePath);
	}

}
