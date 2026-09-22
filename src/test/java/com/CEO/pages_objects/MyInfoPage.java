package com.CEO.pages_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CEO.utilities.CommonUtils;
import com.CEO.webdriver_manager.DriverManager;

public class MyInfoPage {

	WebDriver driver = DriverManager.getDriver();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	/*
	 * @FindBy(xpath = "//*[@class='oxd-main-menu-item active']") private WebElement
	 * MY_INFO;
	 */

	// By MY_INFO=By.xpath("//*[@class='oxd-main-menu-item active']");

	/*
	 * @FindBy(xpath =
	 * "//*[@class='oxd-input oxd-input--active orangehrm-firstname']") private
	 * WebElement EMP_FIRSTNAME;
	 */

	By EMP_FIRSTNAME = By.xpath("//*[@class='oxd-input oxd-input--active orangehrm-firstname']");

	By EMP_MIDDLENAME = By.xpath("//*[@class='oxd-input oxd-input--active orangehrm-middlename']");

	By EMP_LASTNAME = By.xpath("//*[@class='oxd-input oxd-input--active orangehrm-lastname']");

	private static MyInfoPage myinfoInstance = null;

	private MyInfoPage() {

	}

	public static MyInfoPage getInstance() {

		if (myinfoInstance == null) {
			myinfoInstance = new MyInfoPage();
		}
		return myinfoInstance;
	}

	/*
	 * public void myInfoClick() { //MY_INFO.click();
	 * driver.findElement(MY_INFO).click(); }
	 */

	public void empFirstNameEnter() {
		// EMP_FIRSTNAME.sendKeys("Dinesh");

		// Wait until OrangeHRM form loader disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));

		// Wait until First Name field is clickable
		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(EMP_FIRSTNAME));

		// Select existing value
		firstName.click();
		firstName.sendKeys(Keys.CONTROL, "a");

		// Delete existing value
		firstName.sendKeys(Keys.BACK_SPACE);
		firstName.sendKeys("Lohi");

		// Enter new value if required
		// firstName.sendKeys("Dinesh");

		/*
		 * Old code not working try {
		 * CommonUtils.getInstance().highlightElement(driver.findElement(EMP_FIRSTNAME))
		 * ; //DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
		 * ofSeconds(20)); driver.findElement(EMP_FIRSTNAME).click();
		 * 
		 * }catch(Exception ex) { ex.printStackTrace(); }
		 * 
		 * try { WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(EMP_FIRSTNAME));
		 * }catch(Exception ex1) {
		 * 
		 * }
		 * 
		 * try { driver.findElement(EMP_FIRSTNAME).sendKeys(Keys.CONTROL, "a");
		 * 
		 * }catch(Exception ex2) {} try {
		 * 
		 * driver.findElement(EMP_FIRSTNAME).sendKeys(Keys.BACK_SPACE); }catch(Exception
		 * ex3) {}
		 * //DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
		 * ofSeconds(20));
		 * 
		 * //driver.findElement(EMP_FIRSTNAME).sendKeys(Keys.BACK_SPACE);
		 * //DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
		 * ofSeconds(20)); //driver.findElement(EMP_FIRSTNAME).sendKeys("Dinesh");
		 */

	}

	public void empMiddleName() {

		wait.until(ExpectedConditions.invisibilityOfElementLocated
				(By.cssSelector(".oxd-form-loader")));
		WebElement empMiddleName = wait.until(ExpectedConditions
				.elementToBeClickable(EMP_MIDDLENAME));

		empMiddleName.click();
		empMiddleName.sendKeys(Keys.CONTROL, "a");
		empMiddleName.sendKeys(Keys.BACK_SPACE);
		empMiddleName.sendKeys("The");

		// DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(EMP_MIDDLENAME).click();

		// DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(EMP_MIDDLENAME).clear();
		// DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(EMP_MIDDLENAME).sendKeys("Kumar");
	}

	
	 public void empLastName() {
		 
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));
		 WebElement empLastName=wait.until(ExpectedConditions.elementToBeClickable(EMP_LASTNAME));
		 
		 empLastName.click();
		 empLastName.sendKeys(Keys.CONTROL,"a");
		 empLastName.sendKeys(Keys.BACK_SPACE);
		 empLastName.sendKeys("King");
		 
		 /*
	 * DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
	 * ofSeconds(20)); driver.findElement(EMP_LASTNAME).click();
	 * DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
	 * ofSeconds(20)); driver.findElement(EMP_LASTNAME).clear();
	 * DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.
	 * ofSeconds(20)); driver.findElement(EMP_LASTNAME).sendKeys("V"); }
	 * 
	 * 
	 * 
	 */
		 
	 }

}
