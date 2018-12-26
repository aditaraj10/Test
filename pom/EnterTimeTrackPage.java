package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	private String homePageTitle;
	public EnterTimeTrackPage(WebDriver driver){
		homePageTitle=driver.getTitle();
	}
	public void verifyHomePageTitle(){
		String expTitle="actiTIME - Enter Time-Track";
		Assert.assertEquals(homePageTitle, expTitle, "Home page title is not verified");
		Reporter.log("login successfully", true);
		Reporter.log("Home page title is verified successfully", true);
	}
}
