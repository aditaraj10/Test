package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjectPage {
	@FindBy(name="customerId")
	private WebElement selCustDropdwn;
	@FindBy(name="name")
	private WebElement projNameTxtFld;
	@FindBy(name="createProjectSubmit")
	private WebElement createProjSubBtn;
	
	public CreateNewProjectPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void createProject(String customerName, String projectName){
		Select sel=new Select(selCustDropdwn);
		sel.selectByVisibleText(customerName);
		projNameTxtFld.sendKeys(projectName);
		createProjSubBtn.click();
	}
}
