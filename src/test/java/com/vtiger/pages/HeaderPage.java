package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class HeaderPage {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public HeaderPage(WebDriver driver, ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	//################## Locator definition############################
	
	
	
	
	
	public boolean verifyLink(String lnktext)
	{
		try
		{
			if(driver.findElement(By.linkText(lnktext)).isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			return false;
		}
	}
	
	
	public void clickLink(String lnktext)
	{
		driver.findElement(By.linkText(lnktext)).click();
	}
	
	
	
	
	
	
	public LoginPage clickLogout(String lnktext)
	{
		driver.findElement(By.linkText(lnktext)).click();
		return new LoginPage(driver,logger);
	}
	

}
