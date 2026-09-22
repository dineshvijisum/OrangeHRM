package com.CEO.pages_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DirectoryPage {
	//v-10-singleton design pattern--so use the lazyIniatialized singleton class

	private static DirectoryPage directoryInstance=null;

	private DirectoryPage() {
		
	}

	public static DirectoryPage getInstance(){
		if(directoryInstance==null) {
			directoryInstance=new DirectoryPage();
		}
		return directoryInstance;
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
	private WebElement JOB_TITLE;

	@FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement SEARCH_BTN;

	@FindBy(xpath = "//*[@class='oxd-text oxd-text--span']")
	private WebElement TEXT_NAME;
	
	//V-14 we commonly create dropdown select in utility
	/*
	 * public void selectJobTitle(String jobTitle) { Select selectJob=new
	 * Select(JOB_TITLE); selectJob.selectByVisibleText(jobTitle);
	 * 
	 * }
	 */
	
	public void clickSearchBtn() {
		
		SEARCH_BTN.click();
	}

	public String getPersonName() {
		
		return TEXT_NAME.getText();
	}
	
	public WebElement getJOB_TITLE() { return JOB_TITLE; }

	/*
	 * //v-9 video
	 * 
	 * public WebElement getJOB_TITLE() { return JOB_TITLE; }
	 * 
	 * public WebElement getSEARCH_BTN() { return SEARCH_BTN; }
	 * 
	 * public WebElement getTEXT_NAME() { return TEXT_NAME; }
	 */
	




	/*V-9 video before
	 * @FindBy(xpath =
	 * "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
	 * public static WebElement JOB_TITLE;
	 * 
	 * @FindBy(xpath =
	 * "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"
	 * ) public static WebElement SEARCH_BTN;
	 * 
	 * @FindBy(xpath = "//*[@class='oxd-text oxd-text--span']") public static
	 * WebElement TEXT_NAME;
	 */

}
