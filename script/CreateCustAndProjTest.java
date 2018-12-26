package com.actitime.script;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelLib;
import com.actitime.pom.ActiveProjAndCustPage;
import com.actitime.pom.CreateNewCustomerPage;
import com.actitime.pom.CreateNewProjectPage;
import com.actitime.pom.LoginPage;
import com.actitime.pom.OpenTasksPage;

public class CreateCustAndProjTest extends BaseLib{
	@Test
	public void createCustomerTest() throws InterruptedException{
		String username=ExcelLib.readExcelData(3, 2);
		String password=ExcelLib.readExcelData(3, 3);
		String customerName=ExcelLib.readExcelData(3, 4);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		Thread.sleep(2000);
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnTasks();
		wLib.implicitlywaitForSeconds(driver, 20);
		otp.clickOnProjAndCustLink();
		wLib.implicitlywaitForSeconds(driver, 20);
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnCreateNewCustBtn();
		wLib.implicitlywaitForSeconds(driver, 20);
		CreateNewCustomerPage cncp=new CreateNewCustomerPage(driver);
		cncp.createCustomer(customerName);
		wLib.implicitlywaitForMenutes(driver, 20);
		apcp.verifyCreateCustomerMsg();
		otp.clickOnLogoutLink();
	}
	@Test
	public void deleteCustomerTest() throws InterruptedException{
		String username=ExcelLib.readExcelData(5, 2);
		String password=ExcelLib.readExcelData(5, 3);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		Thread.sleep(2000);
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnTasks();
		wLib.implicitlywaitForSeconds(driver, 20);
		otp.clickOnProjAndCustLink();
		wLib.implicitlywaitForSeconds(driver, 20);
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.deleteCustomer();
		wLib.implicitlywaitForMenutes(driver, 20);
		apcp.verifyDeleteCustMsg();
		otp.clickOnLogoutLink();
	}
	@Test
	public void createProjectTest() throws InterruptedException{
		String username=ExcelLib.readExcelData(4, 2);
		String password=ExcelLib.readExcelData(4, 3);
		String customerName=ExcelLib.readExcelData(4, 4);
		String projectName=ExcelLib.readExcelData(4, 5);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		Thread.sleep(2000);
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnTasks();
		wLib.implicitlywaitForSeconds(driver, 20);
		otp.clickOnProjAndCustLink();
		wLib.implicitlywaitForSeconds(driver, 20);
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnCreateNewProjBtn();
		wLib.implicitlywaitForSeconds(driver, 20);
		CreateNewProjectPage cnpp=new CreateNewProjectPage(driver);
		cnpp.createProject(customerName, projectName);
		wLib.implicitlywaitForMenutes(driver, 20);
		apcp.verifycreateProjMsg();
		otp.clickOnLogoutLink();
	}
}
