package com.CEO.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CEO.constatnt.Constatnts;
import com.CEO.pages_objects.Dashboard;
import com.CEO.pages_objects.DirectoryPage;
import com.CEO.pages_objects.HomePage;
import com.CEO.pages_objects.LoginPage;
import com.CEO.pages_objects.MyInfoPage;
import com.CEO.pages_objects.RecruitmentPage;
import com.CEO.pages_objects.TimeTimeSheets;
import com.CEO.stepdefinition.Common_step_definition;
import com.CEO.webdriver_manager.DriverManager;

import io.cucumber.core.options.Constants;

public class CommonUtils {
	
	private static final Logger LOGGER=LogManager.getLogger(CommonUtils.getInstance());
	
	//WebDriver driver = DriverManager.getDriver();
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
	private static CommonUtils commonUtilsInstance;
	/*
	 * WebDriver driver; WebDriverWait wait;
	 */
	
	
	private CommonUtils() {
		//driver = DriverManager.getDriver();          // your existing driver source
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//constructor block the explicit object in other class
		
	}
	
	public static CommonUtils getInstance() {
		if(commonUtilsInstance==null) {
			commonUtilsInstance=new CommonUtils();
		}
		return commonUtilsInstance;
	}
	
	//V-5---public static void loadProperties()---properties file project level used---

	public void loadProperties() {
		
	
		//FileReader reader=null;

		//V-5--this one comment because properties file we move to resources folder---
		/*
		 * try { reader=new FileReader("config.properties");
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace(); }
		 */
		Properties properties=new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
			//properties.load(getClass().getResourceAsStream("/config.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		Constatnts.APP_URL=properties.getProperty("APP_URL");
		Constatnts.BROWSER=properties.getProperty("BROWSER");
		Constatnts.USERNAME=properties.getProperty("UserName");
		Constatnts.PASSWORD=properties.getProperty("Password");
		Constatnts.TIMESHEETEMPNAME=properties.getProperty("TimeSheetEmpName");
		Constatnts.VacancyCh=properties.getProperty("VacancyCh");
		Constatnts.JobTitle=properties.getProperty("JobTitle");
		Constatnts.HiringManager=properties.getProperty("HiringManager");
		Constatnts.Status=properties.getProperty("Status");
		Constatnts.DateFrom=properties.getProperty("DateFrom");
		Constatnts.DateTo=properties.getProperty("DateTo");
		Constatnts.LeaveFromDate=properties.getProperty("LeaveFromDate");
		Constatnts.LeaveToDate=properties.getProperty("LeaveToDate");
		Constatnts.LeaveStatus=properties.getProperty("LeaveStatus");
		/*V-7 driver manager create so we can use without declared browser path
		 * Constatnts.CHROME_DRIVER_Location=properties.getProperty(
		 * "CHROME_DRIVER_Location");
		 * Constatnts.EDGE_DRIVER_LOCATAION=properties.getProperty(
		 * "EDGE_DRIVER_LOCATAION");
		 * Constatnts.FIREFOX_DRIVER_LOCATION=properties.getProperty(
		 * "FIREFOX_DRIVER_LOCATION");
		 */




	}
	
	//@findby used then PageFactory.initElements is must or  don't use
	public void initWebElements() {
		
		//PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
		//PageFactory.initElements(DriverManager.getDriver(), RecruitmentPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), MyInfoPage.getInstance());
		//PageFactory.initElements(DriverManager.getDriver(), Dashboard.getInstance());
		//PageFactory.initElements(DriverManager.getDriver(), MyInfoPage.getInstance());
		//PageFactory.initElements(DriverManager.getDriver(), TimeTimeSheets.getInstance());
		//PageFactory.initElements(DriverManager.getDriver(), getClass());
	}
	
	public void takeScreenshot() {
		
		File screenShot=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			//Exception occurs in whole project can see
			//FileUtils.copyFile(screenShot, new File("screenshot.png"));
			
			//Which scenario willfile then the image name is scanario name then 
			FileUtils.copyFile(screenShot, new File(Common_step_definition.getScenarioName()+".png"));
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void highlightElement(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}

	public void selectFromDropDown(WebElement dropDown,String howTo,String value) {
		Select select=new Select(dropDown);
		
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
			
		case "value":
			select.selectByValue(value);
			break;
			
		case "text":
			select.selectByVisibleText(value);
			break;

		default:
			LOGGER.info("Please provide a valid selections are: text,value, index");
			break;
		}
	}
		
	/*
	 * public void selectDropdownValue(By dropdownLocator, String value) {
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
	 * ".oxd-form-loader")));
	 * 
	 * WebElement dropdown =
	 * wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	 * dropdown.click();
	 * 
	 * By option = By.xpath("//*[normalize-space(text())='" + value + "']");
	 * WebElement optionElement =
	 * wait.until(ExpectedConditions.elementToBeClickable(option));
	 * optionElement.click(); }
	 */
		
	
}













