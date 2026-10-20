package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import factory.BrowserFactory;
import helper.ConfigUtility;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setup() {

		System.out.println("Setting Up Browser");
		
		String browser = ConfigUtility.readProperty("Browser");
		
		String qaURL = ConfigUtility.readProperty("qaenv");
		
		driver = BrowserFactory.startBrowser(browser, qaURL);
		
	}

	@AfterClass
	public void tearDown() {

		System.out.println("Closing th Browser");

		driver.quit();

	}

}
