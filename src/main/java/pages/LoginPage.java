package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	By username = By.id("email1");
	
	By password = By.id("password1");
	
	By loginButton = By.xpath("//button[normalize-space()='Sign in']");
	
	By signIn = By.xpath("//h2[normalize-space()='Sign In']");
	
	By footerLinks = By.xpath("//div[@class='footer-inside-div']//a[@href]");
	
	By signUpLink = By.xpath("//div[@class='footer-inside-div']//a[@href]");
	
	public boolean isSignUpLinkPresent() {
		
		boolean status = Utility.checkElement(driver, footerLinks).isDisplayed();
		
		return status;
		
	}
	
	public int countFooterLinks() {
		
	int count =	driver.findElements(footerLinks).size();
	
	return count;
		
	}
		
	public boolean isSignUpPresent() {
		
		boolean status = Utility.checkElement(driver, signIn).isDisplayed();
		
		return status;
		
		
	}
	
	public DashboardPage loginToApplication(String uname, String pass) {
		
		Utility.typeOnElement(driver, username, uname);
		
		Utility.typeOnElement(driver, password, pass);
		
		Utility.clickElement(driver, loginButton);
		
		DashboardPage dashboard = new DashboardPage(driver);
		
		return dashboard;
		
		
	}

}
