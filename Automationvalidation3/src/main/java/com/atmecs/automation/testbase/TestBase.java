package com.atmecs.automation.testbase;

/**
 * @author Ravikumar.Kannan
 */

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.utils.PropertyReader;

public class TestBase {

	public static WebDriver driver;
	Loggers log = new Loggers();

	String baseUrl;
	String browser;

	@BeforeTest
	public void invokeBrowser() {
		Properties property = PropertyReader.readProperties(FilePath.CONFIG_FILE);
		System.setProperty("webdriver.chrome.driver", FilePath.CHROME_FILE);
		baseUrl = property.getProperty("Url");
		browser = property.getProperty("Browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		log.info("Browser started" +"\n");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
