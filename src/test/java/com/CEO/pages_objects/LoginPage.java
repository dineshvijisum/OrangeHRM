package com.CEO.pages_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CEO.utilities.CommonUtils;
import com.CEO.webdriver_manager.DriverManager;
import com.github.dockerjava.api.model.Driver;

public class LoginPage {
	
	WebDriver driver=DriverManager.getDriver();
	//v-9 video After
	/*V-18 this command
	 * @FindBy(name = "username") private WebElement USERNAME;
	 * 
	 * @FindBy(name="password") private WebElement PASSWORD;
	 * 
	 * @FindBy(xpath =
	 * "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"
	 * ) private WebElement LOGIN_BUTTON;
	 */
	
	//V-18
	By USERNAME=By.name("username");
	By PASSWORD=By.name("password");
	By LOGIN_BUTTON=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
	
	By TEXTCORRECT=By.xpath("//*[@class='oxd-text oxd-text--p orangehrm-copyright']/parent::div");
	//v-10-singleton design pattern--so use the lazyIniatialized singleton class
	private static LoginPage loginInstance;
	
	private LoginPage() {
		
	}
	
	public static LoginPage getInstance(){
		if(loginInstance==null) {
			loginInstance=new LoginPage();
		}
		return loginInstance;
	}
	
	
	public void enterUserName(String userName) {
		try {
			CommonUtils.getInstance().highlightElement(driver.findElement(USERNAME));
			driver.findElement(USERNAME).sendKeys(userName);
		}catch(Exception ex) {
			ex.printStackTrace();
			
			try {
				WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
			}catch(Exception ex1) {
				
			}
		}
		
		
		/*
		 * CommonUtils.getInstance().highlightElement(USERNAME);
		 * USERNAME.sendKeys(userName);
		 */
	}
	public void enterPassword(String password) {
		//-v-18
		//PASSWORD.sendKeys(password);
		driver.findElement(PASSWORD).sendKeys(password);
	}
	
	public void orangeText() {
		CommonUtils.getInstance().highlightElement(driver.findElement(TEXTCORRECT));
	}
	public void clickLoginButton() {
		//V-18
		//LOGIN_BUTTON.click();
		driver.findElement(LOGIN_BUTTON).click();
	}
	
	/*getter methode
	 * //v-9 public WebElement getUSERNAME() {
	 *  return USERNAME; 
	 *  }
	 * 
	 * public WebElement getPASSWORD() {
	 *  return PASSWORD; 
	 *  }
	 * 
	 * public WebElement getLOGIN_BUTTON() { 
	 * return LOGIN_BUTTON; 
	 * }
	 */
	
	
	
	/*V-9 video before
	 * @FindBy(name = "username") public static WebElement USERNAME;
	 * 
	 * @FindBy(name="password") public static WebElement PASSWORD;
	 * 
	 * @FindBy(xpath =
	 * "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"
	 * ) public static WebElement LOGIN_BUTTON;
	 */

}
