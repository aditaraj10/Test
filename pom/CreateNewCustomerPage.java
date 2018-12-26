package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerPage {
	@FindBy(name="name")
	private WebElement custNameTxtFld;
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustSubmitBtn;
	
	public CreateNewCustomerPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void createCustomer(String customerName){
		custNameTxtFld.sendKeys(customerName);
		createCustSubmitBtn.click();
	}
}
