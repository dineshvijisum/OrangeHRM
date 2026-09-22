package com.CEO.pages_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	By FromDate=By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]");
	By TODATE=By.xpath("(//*[@class='oxd-input oxd-input--active'])[3]");
	
	
	public void leaveMenuCLick() {
		driver.findElement(LeaveMenu).click();
		
	}
	
	public void dateFieldChoose() {
		wait.until(ExpectedConditions.presenceOfElementLocated(FromDate));
		driver.findElement(FromDate).sendKeys(Constatnts.LeaveFromDate);
		wait.until(ExpectedConditions.presenceOfElementLocated(TODATE));
		driver.findElement(TODATE).sendKeys(Constatnts.LeaveToDate);
	}
	
	
}
