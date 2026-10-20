package testcases;

import org.testng.Assert;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.Dataproviders;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginToApplication extends BaseClass {

	LoginPage login;

	DashboardPage dashboard;

	@Test(priority = 1, dataProvider  = "logincredentials", dataProviderClass = Dataproviders.class)
	public void loginWithValidCredentials(String user, String pass) {

		login = new LoginPage(driver);

		dashboard = login.loginToApplication(user, pass);
		
		ChainTestListener.log("User is able to login");

		Assert.assertTrue(dashboard.getWelcomeText().contains("Welcome"), "Login Failed");
		
		ChainTestListener.log("User is able to see Welcome Message");

	}
    @Test(priority = 2)
	public void logoutFromApplication() {

		dashboard.logoutFromApplication();
		
		ChainTestListener.log("User is able to logout");

		Assert.assertTrue(login.isSignUpPresent(), "Logout Failed");

	}

	@Test(priority = 3)
	public void countFooterLinks() {

		int count = login.countFooterLinks();

		Assert.assertEquals(count, 4, "Footer Links Mismatched");
		
		ChainTestListener.log("Footer links verified");

	}
	
	@Test(priority = 4)
	public void verifyNewUserLinks() {

		boolean status = login.isSignUpLinkPresent();
		
		Assert.assertTrue(status);

	}
	

}
