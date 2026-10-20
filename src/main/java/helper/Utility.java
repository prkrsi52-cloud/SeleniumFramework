package helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static WebDriver startBrowser(String browser, String applicationURL) {

		System.out.println("********************Running test on***************" + browser);

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome") || browser.contains("Google Chrome") || browser.contains("GC")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Firefox") || browser.contains("Mozilla Firefox")
				|| browser.contains("MF")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Edge") || browser.contains("MicroSoft Edge") || browser.contains("ME")) {

			driver = new EdgeDriver();

		} else {

			System.out.println("Sorry currently " + browser + "not supported");

		}

		driver.get(applicationURL);

		System.out.println("********************Session is ready and Test will be running on***************" + browser);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		return driver;
	}
	public static void typeOnElement(WebDriver driver, By locator, String textToType) {

		Utility.checkElement(driver, locator).sendKeys(textToType);

	}
	
	public static String takeScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot)driver;

		return ts.getScreenshotAs(OutputType.BASE64);
	}

	public static WebElement checkElement(WebDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));

		return ele;

	}

	public static void clickElement(WebDriver driver, By locator) {

		try {
			Utility.checkElement(driver, locator).click();
			
		} catch (Exception e) {
			System.out.println("Element Not Found " + e.getMessage());

			Actions act = new Actions(driver);

			try {
				act.click(driver.findElement(locator)).perform();
			} catch (Exception e1) {
				System.out.println("Element Not Found......Trying with JavaScript");

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click()", driver.findElement(locator));
			}
		}
	}


}
