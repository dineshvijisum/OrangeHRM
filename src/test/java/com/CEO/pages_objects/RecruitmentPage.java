package com.CEO.pages_objects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CEO.constatnt.Constatnts;
import com.CEO.utilities.CommonUtils;
import com.CEO.webdriver_manager.DriverManager;

public class RecruitmentPage {

	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	// span[text()='Recruitment']

	// *[@class='oxd-main-menu-item active']

	private static RecruitmentPage recruitmentInstance;

	private RecruitmentPage() {

	}

	public static RecruitmentPage getInstance() {
		if (recruitmentInstance == null) {
			recruitmentInstance = new RecruitmentPage();
		}
		return recruitmentInstance;
	}

	By Recruitmenu = By.xpath("//span[text()='Recruitment']");

	By JOB_TITLE = By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]");

	//By JOB_TITLE1 = By.xpath("//div[contains(@class,'oxd-select-option')][normalize-space()='" + Constatnts.JobTitle + "']");

	By VACANCY = By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[2]");

	By HIRINGMANAGER = By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[3]");
	
	By STATUS = By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[4]");
	
	By DATEOFAPPLICATIONFROM=By.xpath("//input[@placeholder='From']");
	
	By DATEOFAPPLICATIONTO=By.xpath("//input[@placeholder='To']");
	
	By SEARCHTHEFILTER=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	
	By TEXTNORECORD=By.xpath("//span[text()='No Records Found']");
	
	By IFNORECORDCLICADDBUTTON=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	
	
	By FIRSTNAME=By.name("firstName");
	
	By LASTNAME=By.name("lastName");
	
	By EMAIL=By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]");
	
	By BROWSE=By.xpath("//*[@class='oxd-file-div oxd-file-div--active']");
	
	By RESUME_FILE_INPUT = By.xpath("//input[@type='file']");
	
	By SUBMIT = By.xpath("//button[@type='submit']");
	
	// By
	// VACANCY1=By.xpath("//div[contains(@class,'oxd-select-option')][normalize-space()='Senior
	// QA Lead']\"");

	// By
	// VACANCY1=By.xpath("//div[@class='oxd-select-dropdown']//div[@role='option'][normalize-space()='Senior
	// QA Lead']");
	// By VACANCY1 =
	// By.xpath("//div[@class='oxd-select-dropdown']//div[@role='option'][normalize-space()='"
	// + "Senior QA Lead"+ "']");

	//By value = By.xpath("//*[normalize-space(text())='" + value + "']");
	
	public void selectDropdownValue(By dropdownLocator, String value) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));

		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		dropdown.click();

		By option = By.xpath("//*[normalize-space(text())='" + value + "']");
		WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(option));
		optionElement.click();
	}

	public void recruitmentMenuClick() {

		driver.findElement(Recruitmenu).click();
	}

	/*
	 * public void fieldsClick(String jobTitleValue) {
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated
	 * (By.cssSelector(".oxd-form-loader"))); WebElement
	 * jobTitle=wait.until(ExpectedConditions. elementToBeClickable(JOB_TITLE));
	 * jobTitle.click();
	 * 
	 * WebElement
	 * jobTitle1=wait.until(ExpectedConditions.elementToBeClickable(JOB_TITLE1));
	 * jobTitle1.click();
	 * 
	 * 
	 * 
	 * //its a not type dropdown so can't able to sendkeys
	 * //jobTitle.sendKeys(jobTitleValue);
	 * 
	 * 
	 * No use because its 'div'tag not 'select tag Select select =new
	 * Select(jobTitle); select.selectByIndex(2);
	 * 
	 * }
	 * 
	 * public void vacancyClick(String jobTitleValue) {
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
	 * ".oxd-form-loader"))); WebElement
	 * vacancy=wait.until(ExpectedConditions.elementToBeClickable(VACANCY));
	 * vacancy.click(); WebElement vacancy1
	 * =wait.until(ExpectedConditions.elementToBeClickable(VACANCY1));
	 * vacancy1.click();
	 * 
	 * }
	 */
	

	
	 public void selectJobTitle(String value) {
		  selectDropdownValue(JOB_TITLE, Constatnts.JobTitle);
	    }
	 
	 public void selectVacancy(String value) {
		 selectDropdownValue(VACANCY, value);
	 }
	 
	 public void selectHiringManager(String value) {
		 selectDropdownValue(HIRINGMANAGER, value);
	 }
	 public void selectStatus(String value) {
		 selectDropdownValue(STATUS, value);
	 }
	 
	 public void selectDateFrom() {
		 //using send keys 
		// driver.findElement(DATEOFAPPLICATIONFROM).sendKeys("01/10/2026"+Keys.ENTER);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));
	       WebElement dateFrom=wait.until(ExpectedConditions.elementToBeClickable(DATEOFAPPLICATIONFROM));
		// driver.findElement(DATEOFAPPLICATIONFROM).sendKeys(Constatnts.DateFrom);
	       
	       dateFrom.sendKeys(Constatnts.DateFrom);
		 
	 }
	 
	 public void selectDateTo() {
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));
       WebElement dateTo=wait.until(ExpectedConditions.elementToBeClickable(DATEOFAPPLICATIONTO));
		// dateTo.click();
		dateTo.sendKeys(Constatnts.DateTo);
	 }
	 
	 public void clickSearch() {
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));

		 driver.findElement(SEARCHTHEFILTER).click();
	 }
	 
	 public void validateSearch() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));
		 boolean noRecordsFound = isElementPresent(TEXTNORECORD);
		 
		 if (noRecordsFound) {
		        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(IFNORECORDCLICADDBUTTON));
		        addButton.click();
		    } else {
		        System.out.println("Records found — skipping Add button click.");
		    }
		 
		 	
		}
	 public void firstName() {
		 driver.findElement(FIRSTNAME).sendKeys("Dinesh");
		 driver.findElement(LASTNAME).sendKeys("Kumar V");
		 driver.findElement(EMAIL).sendKeys("dinesh@gamil.com");
		 
	 }
	 
	// By RESUME_FILE_INPUT = By.xpath("//input[@type='file']");

	 public void uploadResume(String filePath) {
	     wait.until(ExpectedConditions.presenceOfElementLocated(RESUME_FILE_INPUT));
	     WebElement fileInput = driver.findElement(RESUME_FILE_INPUT);
	     fileInput.sendKeys(filePath);
	     
	     driver.findElement(SUBMIT).click();
	 
		 
			/*
			 * driver.findElement(BROWSE).click();
			 * 
			 * String filePath="C:\\Users\\dines\\Downloads\\ChoiceOrder_405635.pdf";
			 * StringSelection selection=new StringSelection(filePath);
			 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,
			 * null);
			 * 
			 * try { Robot robot=new Robot(); robot.keyPress(KeyEvent.VK_CONTROL);
			 * robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V);
			 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_ENTER);
			 * robot.keyRelease(KeyEvent.VK_ENTER);
			 * 
			 * } catch(Exception e) {
			 * 
			 * }
			 */
		 
	 }
	 
	 
	 public boolean isElementPresent(By locator) {
		    try {
		        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		        return true;
		    } catch (org.openqa.selenium.TimeoutException e) {
		        return false;
		    }
		}
	 
	 


}
