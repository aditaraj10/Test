package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
/**
 * 
 * @author Diganta D.
 * @Description: All the loginpage webelements and methods are saved in this page.
 *
 */

public class LoginPage {
	@FindBy(name="username")
	private WebElement unTxtBx;
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	@FindBy(className="errormsg")
	private WebElement errorMsg;
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	/**
	 * @param username
	 * @param password 
	 */
	public void login(String username, String password){
		unTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);
		loginBtn.click();
	}
	public void verifyErrorMsg(){
		String expMsg="Username or Password is invalid. Please try again.";
		Assert.assertEquals(expMsg, errorMsg.getText(),"Error msg is not displayed");
		Reporter.log("Error msg is displayed successfully", true);
	}
}
