package com.CEO.stepdefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.CEO.constatnt.Constatnts;
import com.CEO.pages_objects.LoginPage;
import com.CEO.pages_objects.RecruitmentPage;
import com.CEO.utilities.CommonUtils;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_step_definition {
	
	
	private static  String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
	}
	
	//LaunchBrowser()
	//If we 
	
	//public static WebDriver driver;--v-7 alredy created in driver manager 
	public static final Logger LOGGER=LogManager.getLogger(Common_step_definition.class); //V-6
	
	//@before we should use in cucumber import
	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Execution Started");
		
		try{
			scenarioName=scenario.getName();
			LOGGER.info("Common Utils ");
			//V-12 common ut
			//CommonUtils commonutils=new CommonUtils();
			
			CommonUtils.getInstance().loadProperties();
			//when user need only one tab when they run then they should configure the if (driver==null) then only one browser open
			if(DriverManager.getDriver()==null) {
			DriverManager.launchBrowser();
			//CommonUtils.getInstance().initWebElements();
			login();
			
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}
	private void login() {
		DriverManager.getDriver().get(Constatnts.APP_URL);
		
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverManager.getDriver().manage().window().maximize();

		//v-10
		LoginPage.getInstance().enterUserName(Constatnts.USERNAME);
		LoginPage.getInstance().enterPassword(Constatnts.PASSWORD);
		LoginPage.getInstance().clickLoginButton();
		//RecruitmentPage.getInstance().recruitmentMenuClick();
		
	}
	
	/*
	 * @Given("the user navigates to {string} tab") public void
	 * the_user_navigates_to_tab(String tabName) { leaveNavBar.clickTab(tabName); }
	 */
	
	//v-20 failedsteps screen shot taken and print in the report
	@AfterStep
	public void attachScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
	}

	/*In video 7 web driver we handle so it's moving to driver manager javafile
	 * private void launchBrowser() { // TODO Auto-generated method stub
	 * 
	 * try { //Switch case parameter we can give the case parameter (chrome, fire
	 * fox etc..,)it we will receive from (client) propertie file switch
	 * (Constatnts.BROWSER) { case "chrome":
	 * System.setProperty("webdriver.chrome.driver", "msedgedriver.exe"); driver=new
	 * ChromeDriver(); break;
	 * 
	 * case "FireFox": System.setProperty("webdriver.gecko.driver",
	 * "msedgedriver.exe"); driver=new FirefoxDriver(); break;
	 * 
	 * case "edge": System.setProperty(Constatnts.EDGE_DRIVER,
	 * Constatnts.EDGE_DRIVER_LOCATAION); driver=new FirefoxDriver();
	 * driver.get("https://www.youtube.com/"); break;
	 * 
	 * default://in above switch case drivers not then it's default will execute
	 * System.setProperty("webdriver.edge.driver", ""); driver=new EdgeDriver();
	 * 
	 * break; }
	 * 
	 * } catch (Exception e) { // TODO: handle exception
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}
