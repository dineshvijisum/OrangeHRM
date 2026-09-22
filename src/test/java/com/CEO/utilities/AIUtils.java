package com.CEO.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AIUtils {
	
	public static WebElement smartFind(By locator) {
        Object DriverFactory;
		WebDriver driver = DriverFactory.getDriver();
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {

            // AI logic placeholder
            System.out.println("Trying AI-based alternative locator...");

            // Example fallback logic
            return driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
        }
	}

}
