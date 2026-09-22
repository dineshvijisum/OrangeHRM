package com.CEO.pages_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CEO.webdriver_manager.DriverManager;

public class HomePage {
	//v-10-singleton design pattern--so use the lazyIniatialized singleton class

	WebDriver driver=DriverManager.getDriver();
	
	
	//WebElement find
	
	

	By TimeMenu=By.xpath("//span[text()='Time']");
	
	By Recruitmenu=By.xpath("//span[text()='Recruitment']");
	
	By MY_INFO=By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a");
	
	By Leave=By.xpath("//a[contains(@href,'leave')]");
	
	
	
	//By PimMenu=By.xpath("//*[class='oxd-main-menu-item']");
	
	//SingleTon Design Pattern 

	private static HomePage homeInstance;

	private HomePage() {

	}

	public static HomePage getInstance(){
		if(homeInstance==null) {
			homeInstance=new HomePage();
		}
		return homeInstance;
	}

	
	//WebElement Action Functionality methods
	


	public void clickTimesideBar() {
		driver.findElement(TimeMenu).click();
	}



	/*
	 * public void clickDirectory() { DIRECTORY.click();
	 * 
	 * }
	 */
	
	public void recruitmentMenuClick() {

		driver.findElement(Recruitmenu).click();
	}
	
	public void myInfoClick() {
		//MY_INFO.click();
		driver.findElement(MY_INFO).click();
	}
	
	public void leaveClick() {
		driver.findElement(Leave).click();;
	}
	
	
	/*
	 * public void pimMenuClick() { driver.findElement(PimMenu).click(); }
	 */

	/*
	 * //V-9 design pattern 
	 * public WebElement getDIRECTORY() { return DIRECTORY; }
	 */
	//v-9 video after
	//@FindBy(linkText = "Directory")
	//private WebElement DIRECTORY;

	/*v-9 videobefore
	 * @FindBy(linkText = "Directory") 
	 * public static WebElement DIRECTORY;
	 */
}
