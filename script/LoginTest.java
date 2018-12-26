package com.actitime.script;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelLib;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LoginPage;

public class LoginTest extends BaseLib {
	@Test 
	public void loginTest() throws InterruptedException{
		String username=ExcelLib.readExcelData(1, 2);
		String password=ExcelLib.readExcelData(1, 3);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		Thread.sleep(2000);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyHomePageTitle();
	}
	@Test
	public void invalidLoginTest(){
		String username=ExcelLib.readExcelData(2, 2);
		String password=ExcelLib.readExcelData(2, 3);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		wLib.explicitWait(driver, 10, lp.getErrorMsg());
		lp.verifyErrorMsg();
	}
}
