package com.CEO.pages_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CEO.webdriver_manager.DriverManager;

public class Dashboard {
	
	WebDriver driver=DriverManager.getDriver();
	
	private static Dashboard dashboardInstance=null;
	
	private Dashboard() {
		
	}
	
	public static Dashboard getInstance() {
		if(dashboardInstance==null) {
			dashboardInstance = new Dashboard();
		}
		return dashboardInstance;
	}
	
	By DASH_SIDEMENU=By.xpath("//*[@class='oxd-main-menu-item active']");
	
	/*
	 * @FindBy(xpath="//*[@class='oxd-main-menu-item active']") public WebElement
	 * DASH_SIDEMENU;
	 */
	
	//By TIMER_BTN=By.xpath("//*[@class='oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action']");
	
	By TIMER_BTN=By.xpath("oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action");
	/*
	 * @FindBy(
	 * xpath="//*[@class='oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action']"
	 * ) private WebElement TIMER_BTN;
	 */
	
	By NOTES_ENTER=By.xpath("//*[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
	
	public void dashMenu() {
		//DASH_SIDEMENU.click();
		driver.findElement(DASH_SIDEMENU).click();
	}
	
	public void timerBtn() {
		//TIMER_BTN.click();
		driver.findElement(TIMER_BTN).click();
		
	}
	
	public void notesEnter() {
	     driver.findElement(NOTES_ENTER).sendKeys("text good");
	}

}
