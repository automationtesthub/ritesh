package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends HeaderPage {
		
	private WebDriver driver;
	private ExtentTest logger;
	
	public HomePage(WebDriver driver, ExtentTest logger)
	{
		super(driver,logger);
		this.driver=driver;
		this.logger=logger;
	}
	
	By tabHome=By.xpath("//a[@class='currentTab'][text()='Home']");
	
	public boolean VerifyHomePageTab()
	{
		try
		{
			if(driver.findElement(tabHome).isDisplayed())
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
	
	
	
	

}
