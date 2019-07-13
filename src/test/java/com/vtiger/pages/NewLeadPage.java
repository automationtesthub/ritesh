package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewLeadPage extends HeaderPage {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public NewLeadPage(WebDriver driver, ExtentTest logger)
	{
		super(driver,logger);
		this.driver=driver;
		this.logger=logger;
	}
	
	
	By tabLead=By.xpath("//a[@class='currentTab'][text()='Leads']");
	By tbLastName=By.name("lastname");
	By tbCompany=By.name("company");
	By btnSave=By.name("button");
	
	
	
	public void fillLeadFormwithMandatoryFields(String lname, String comp)
	{
		driver.findElement(tbLastName).clear();
		logger.log(LogStatus.PASS, "Textbox cleared successfully");
		driver.findElement(tbLastName).sendKeys(lname);
		logger.log(LogStatus.PASS, "lastname entered successfully");
		driver.findElement(tbCompany).clear();
		driver.findElement(tbCompany).sendKeys(comp);
		logger.log(LogStatus.PASS, "Company entered successfully");
		driver.findElement(btnSave).click();
		logger.log(LogStatus.PASS, "Clicked successfully");
	}
	
	public boolean verifyLeadContent(String lname, String comp)
	{
		if((driver.findElement(By.xpath("//td[@class='dataLabel'][text()='Last Name:']/following::td[text()='"+lname+"']")).isDisplayed()) && (driver.findElement(By.xpath("//td[@class='dataLabel'][text()='Company:']/following::td[text()='"+comp+"']")).isDisplayed()))
		{
			logger.log(LogStatus.PASS, "Expected Title and Actual content has been matched suucesfully");
			return true;
		}
		else
		{
			logger.log(LogStatus.FAIL, "Expected Title and Actual content does not match");
			return false;
		}
	}
	
	

}
