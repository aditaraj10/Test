package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class ActiveProjAndCustPage {
	@FindBy(xpath="//input[@value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(xpath="//input[@value='Create New Project']")
	private WebElement createNewProjBtn;
	@FindBy(className="successmsg")
	private WebElement successMsg;
	@FindBy(xpath="//a[text()='HDFC']/../../../../../..//input")
	private WebElement hdfcCustChkBx;
	@FindBy(xpath="//input[@value='Delete Selected']")
	private WebElement deleteSelectedBtn;
	@FindBy(id="deleteButton")
	private WebElement deleteConfirmBtn;
	public ActiveProjAndCustPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void clickOnCreateNewCustBtn(){
		createNewCustBtn.click();
	}
	public void clickOnCreateNewProjBtn(){
		createNewProjBtn.click();
	}
	public void verifyCreateCustomerMsg(){
		Assert.assertTrue(successMsg.isDisplayed(),"Create Customer msg is not displayed");
		Reporter.log(successMsg.getText(),true);
	}
	public void deleteCustomer(){
		hdfcCustChkBx.click();
		deleteSelectedBtn.click();
		deleteConfirmBtn.click();
	}
	public void verifyDeleteCustMsg(){
		Assert.assertTrue(successMsg.isDisplayed(),"Customer is not deleted");
		Reporter.log(successMsg.getText(), true);
	}
	public void verifycreateProjMsg(){
		Assert.assertTrue(successMsg.isDisplayed(),"Create Project msg is not displayed");
		Reporter.log(successMsg.getText(),true);
	}
}
