package com.CEO.pages_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CEO.webdriver_manager.DriverManager;

public class TimeTimeSheets {

	WebDriver driver=DriverManager.getDriver();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//finby example for drop down
	//@FindBy(xpath="//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active oxd-autocomplete-text-input--error']")
	//private WebElement Emp_Name;

	//By Emp_Name=By.xpath("//*[contains(@class,'oxd-autocomplete-text-input')]");

	By Emp_Name = By.xpath(
		    "//div[contains(@class,'oxd-autocomplete-text-input')]//input"
		);
	By View_Btn=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	
	

	private static TimeTimeSheets timeInstance;

	private TimeTimeSheets() {

	}
	public static TimeTimeSheets getInstance() {
		if(timeInstance==null) {
			timeInstance=new TimeTimeSheets();
		}
		return timeInstance;
	}
	
	/*
	 * public void clickEmpName(String empName) {
	 * driver.findElement(Emp_Name).click();
	 * driver.findElement(Emp_Name).sendKeys(empName); }
	 */

	
	/*
	 * public WebElement clickEmployeeField() { return Emp_Name;
	 * 
	 * }
	 */
	
	 public void enterEmployeClick() {
		 wait.until(ExpectedConditions.invisibilityOfElementLocated
				 (By.cssSelector(".oxd-form-loader")));
		 WebElement empName=wait.until(ExpectedConditions
				 .elementToBeClickable(Emp_Name));
		 empName.click();
	 
	  
	 }
	 
	
	 public void enterEmployeTimeSheets(String empName) { 
			
		 wait.until(ExpectedConditions.invisibilityOfElementLocated
				 (By.cssSelector(".oxd-form-loader")));
		 WebElement empEnter=wait.until(ExpectedConditions
				 .elementToBeClickable(Emp_Name));
		 
		 empEnter.sendKeys(empName);
		 
		 
		 /*
			 * try { driver.findElement(Emp_Name).sendKeys(empName); //return empName;
			 * }catch(Exception e) { e.printStackTrace();
			 * 
			 * try { WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(Emp_Name));
			 * }catch(Exception ex1) {
			 * 
			 * }
			 */
		 }
		 
		 
	  
	 
	 

	public void clickViewBtn() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated
				(By.cssSelector(".oxd-form-loader")));
		WebElement clickViewBtn=wait.until(ExpectedConditions
				.elementToBeClickable(View_Btn));
		clickViewBtn.click();
		//driver.findElement(View_Btn).click();
	}

}
