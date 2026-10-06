package com.CEO.pages_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CEO.constatnt.Constatnts;
import com.CEO.webdriver_manager.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeaveListPages {

	WebDriver driver=DriverManager.getDriver();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	
	private static LeaveListPages leaveInstance;
	private LeaveListPages() {
		
	}
	public static LeaveListPages getInstance() {
		if(leaveInstance==null) {
			leaveInstance=new LeaveListPages();
		}
		return leaveInstance;
	}
	
	By LeaveMenu=By.xpath("//span[text()='Leave']");
	By FromDate=By.xpath("//label[text()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	By TODATE=By.xpath("//label[text()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	By CLICKSEARC=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	By CHOOSELEAVESTATUS=By.xpath("(//*[@class='oxd-select-text oxd-select-text--active'])[1]");
	
	public void selectDropdownValue(By dropdownLocator, String value) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));

		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		dropdown.click();

		By option = By.xpath("//*[normalize-space(text())='" + value + "']");
		WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(option));
		optionElement.click();
	}
	
	public void leaveMenuCLick() {
		driver.findElement(LeaveMenu).click();
		
	}
	
	public void dateFieldChoose() {
		wait.until(ExpectedConditions.presenceOfElementLocated(FromDate));
		driver.findElement(FromDate).sendKeys(Constatnts.LeaveFromDate);
		wait.until(ExpectedConditions.presenceOfElementLocated(TODATE));
		driver.findElement(TODATE).sendKeys(Constatnts.LeaveToDate);
	}
	
	 public void selectLeaveStatus(String value) {
		  selectDropdownValue(CHOOSELEAVESTATUS, value);
	    }
	
	
	public void clickSearchbtn() {
		driver.findElement(CLICKSEARC).click();
	}
	
	
}
