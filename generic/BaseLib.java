package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	public WebDriver driver;
	public WaitStatementLib wLib;
	@BeforeMethod
	@Parameters(value="browser")
	public void preCondition(String browser){
		if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Reporter.log("Firefox Launched", true);
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Chrome launched", true);
		}
		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\exefiles\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			Reporter.log("IE launched", true);
		}
		else{
			driver=new FirefoxDriver();
			Reporter.log("Firefox Launched", true);
		}
		driver.manage().window().maximize();
		driver.get("http://desktop-990a37p/login.do");
		Reporter.log("Navigating to the url", true);
		wLib=new WaitStatementLib();
		wLib.implicitlywaitForSeconds(driver, 20);
	}
	
	@AfterMethod
	public void postCondition(ITestResult r){
		if (r.isSuccess()) {
		}
		else{
			String fileName = r.getMethod().getMethodName();
			ScreenshotLib sLib=new ScreenshotLib();
			sLib.takeScreenshot(driver, fileName);
			Reporter.log("Screenshot has been taken", true);
		}
		driver.close();
		Reporter.log("Browsers closed", true);
	}
}
