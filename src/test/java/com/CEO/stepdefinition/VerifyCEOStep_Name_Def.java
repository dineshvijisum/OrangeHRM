package com.CEO.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.Select;

import com.CEO.constatnt.Constatnts;
import com.CEO.pages_objects.DirectoryPage;
import com.CEO.pages_objects.HomePage;
import com.CEO.pages_objects.LoginPage;
import com.CEO.utilities.CommonUtils;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCEOStep_Name_Def {

	public static final Logger LOGGER=LogManager.getLogger(VerifyCEOStep_Name_Def.class);

	@Given("the user is logged in successfully and is on home page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {

		try {
			
			//v-17 we create in common page then every scenario before it will run
			/*
			 * DriverManager.getDriver().get(Constatnts.APP_URL);
			 * DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
			 * ofSeconds(10));
			 * 
			 * //v-10 LoginPage.getInstance().enterUserName(Constatnts.USERNAME);
			 * LoginPage.getInstance().enterPassword(Constatnts.PASSWORD);
			 * LoginPage.getInstance().clickLoginButton();
			 */

			//v-9 design pattern
			//LoginPage loginpage=new LoginPage();
			//loginpage.getUSERNAME().sendKeys(Constatnts.USERNAME);

			/*V-9 before we used public static webElwment
			 * LoginPage.USERNAME.sendKeys(Constatnts.USERNAME);
			 * LoginPage.PASSWORD.sendKeys(Constatnts.PASSWORD);
			 * LoginPage.LOGIN_BUTTON.click();
			 */
			
			//DriverManager.getDriver().manage().window().maximize();
			LOGGER.info("the user is logged in successfully and is on home page");
			
			String url=DriverManager.getDriver().getCurrentUrl();
			if(url.contains("dashboard")) {
				LOGGER.info("the user is logged in successfully and is on home page");
			}
		}
		catch(Exception ex) {
			LOGGER.error(ex);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(ex.getMessage());
		}
	}

	@When("the user clicks on the directory option in the menu bar")
	public void the_user_clicks_on_the_directory_option_in_the_menu_bar() {

		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			//v-10
			HomePage.getInstance().clickDirectory();

			/*
			 * //v-9after HomePage homePage=new HomePage(); 
			 * homePage.getDIRECTORY().click();
			 */

			//v-9before
			//HomePage.DIRECTORY.click();
			LOGGER.info("Directory check correct");
		}
		catch(Exception ex) {
			LOGGER.error(ex);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(ex.getMessage());
		}
	}

	@When("the user select the job title as {string} from the dropdown using {string}")
	public void the_user_select_the_job_title_as_from_the_dropdown(String jobTitle,String howTo) {
		
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//List<String> drop=DataTable.asList(String.class);

			CommonUtils.getInstance().selectFromDropDown(DirectoryPage.getInstance().getJOB_TITLE(), howTo, jobTitle);
			//v-14
			//DirectoryPage.getInstance().selectJobTitle(jobTitle);

			/*
			 * //V-9 after DirectoryPage directoryPage=new DirectoryPage();
			 * directoryPage.getJOB_TITLE().sendKeys(jobTitle);
			 */

			//V-9 before
			/*
			 * DirectoryPage.JOB_TITLE.sendKeys(jobTitle); //Select selectJob=new
			 * Select(DirectoryPage.JOB_TITLE); //selectJob.selectByVisibleText(jobTitle);
			 */        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 System.out.println("the user select the job title as {string} from the dropdown");

		}
		catch(Exception ex) {
			LOGGER.error(ex);
			CommonUtils.getInstance().takeScreenshot();
			
			//V-15 - failed scenario can able to get and after we can run
			Assert.fail(ex.getMessage());
		}
	}

	@When("clicks the search btn")
	public void clicks_the_search_btn() {
		//V-10

		try {
			DirectoryPage.getInstance().clickSearchBtn();

			/*
			 * //v-9 after DirectoryPage directoryPage=new DirectoryPage();
			 * directoryPage.getSEARCH_BTN().click();
			 */
			/*V-9 before 
			 * DirectoryPage.SEARCH_BTN.click(); 
			 * LOGGER.info("clicks the search btn");
			 */
		}
		catch(Exception ex) {
			LOGGER.error(ex);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(ex.getMessage());
		}
	}

	@Then("the user should see  the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedName) {
		//v-10

		try {
			String actualName=DirectoryPage.getInstance().getPersonName();

			/*
			 * //V-9 after
			 * 
			 * DirectoryPage directoryPage=new DirectoryPage(); String
			 * actualName=directoryPage.getTEXT_NAME().getText();
			 */
			/*V-9 before
			 * String actualName=DirectoryPage.TEXT_NAME.getText();
			 * //if(actualName==expectedName)
			 */		
			if(actualName.equalsIgnoreCase(expectedName)) {

				System.out.println("the user should see  the CEO name as ");
			}

		}

		catch(Exception ex) {
           LOGGER.error(ex);
           CommonUtils.getInstance().takeScreenshot();
           Assert.fail(ex.getMessage());
		}

	}
}
