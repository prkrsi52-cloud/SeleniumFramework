package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}
	
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
	
	}
