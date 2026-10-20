package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import factory.BrowserFactory;
import helper.Utility;

public class MyTestNGListener implements ITestListener 
{
	
	public void onTestSuccess(ITestResult result) {
	    ChainTestListener.log("Test Passed "+result.getMethod().getMethodName());
	  }
	
	public void onTestFailure(ITestResult result) {
	   ChainTestListener.log("Test Failed "+result.getMethod().getMethodName()+" "+result.getThrowable().getMessage());
	  }
	
	public void onTestSkipped(ITestResult result) {
	    ChainTestListener.log("Test Skipped "+result.getMethod().getMethodName());
	  }
	

}
