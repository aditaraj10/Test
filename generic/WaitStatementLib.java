package com.actitime.generic;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	public void implicitlywaitForSeconds(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public void implicitlywaitForMenutes(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	public void explicitWait(WebDriver driver,int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void fluentWait(WebDriver driver,int totalTime,int pollingTime,WebElement element)
	{
		FluentWait<WebDriver> fw=new FluentWait<WebDriver>(driver);
		fw.withTimeout(totalTime, TimeUnit.MINUTES);
		fw.pollingEvery(pollingTime, TimeUnit.SECONDS);
		fw.ignoring(NoSuchElementException.class);
		fw.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	

}
