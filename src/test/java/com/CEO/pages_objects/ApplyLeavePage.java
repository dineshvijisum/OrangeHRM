package com.CEO.pages_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CEO.webdriver_manager.DriverManager;

public class ApplyLeavePage {
	
	WebDriver driver=DriverManager.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	
	private static ApplyLeavePage applyLeaveInstance=null;
	private ApplyLeavePage() {
		
	}
	public static ApplyLeavePage getInstance() {
		if(applyLeaveInstance==null) {
			applyLeaveInstance=new ApplyLeavePage();
		}
		return applyLeaveInstance;
	}
	By Leave=By.xpath("//a[contains(@href,'leave')]");
	By APPLYBTN=By.xpath("//*[text()='Apply']");
	By LEAVE_TYPE=By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
	
	
	public void leaveClick() {
	WebElement leaveMenu=wait.until(ExpectedConditions.presenceOfElementLocated(Leave));
	leaveMenu.click();
	}
	
	public void applyBtnCLick() {
		driver.findElement(APPLYBTN).click();
	}
	

}
