package com.CEO.webdriver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.CEO.constatnt.Constatnts;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static WebDriver driver=null;


	public static WebDriver getDriver() {
		return driver;
	}


	public static void launchBrowser() {
		// TODO Auto-generated method stub

		try {
			//Switch case parameter we can give the case parameter (chrome, fire fox etc..,)it we will receive from (client) propertie file
			switch (Constatnts.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;

			case "FireFox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				driver.get("https://www.youtube.com/");
				break;

			default://in above switch case drivers not then it's default will execute
				WebDriverManager.chromedriver().setup();
				driver=new EdgeDriver();

				break;
			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

	}

}
