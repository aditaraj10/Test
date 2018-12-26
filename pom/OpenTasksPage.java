package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenTasksPage extends BasePage{
	@FindBy(xpath="//a[text()='Projects & Customers']")
	private WebElement projAndCustLink;
	
	public OpenTasksPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnProjAndCustLink(){
		projAndCustLink.click();
	}
}
