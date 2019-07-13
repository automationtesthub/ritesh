package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vtiger.common.CommonFunctions;

public class LoginPage {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public LoginPage(WebDriver driver, ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	//################## Locator definition############################
	
	By tb_username=By.name("user_name");
	By tb_pwd=By.name("user_password");
	By dp_Theme=By.name("login_theme");
	By btn_Login=By.name("Login");
	By txt_ErrorMsgLogin=By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
	By img_LogoLogin=By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	
	
	
//################################################################
// Method Name: verifyTitle --Parameters...
// Created By : 
// Date:
// Modified By: 
// Date	
//############################################################
	
	public boolean verifyTitle(String expTitle) throws Exception
	{
		if(expTitle.equals(driver.getTitle().trim()))// if 1.1 started here
		{
			logger.log(LogStatus.PASS, "Expected Title:"+expTitle+" and Actual title:"+driver.getTitle()+" has been matched suucesfully");
			return true;
		}
		else
		{
			String filename=CommonFunctions.getscreenshot(driver);
			
			logger.log(LogStatus.FAIL, "Expected Title:"+expTitle+" and Actual title:"+driver.getTitle()+" does not match <span class='test-status label pass'><a href="+filename+">Screenshot</a></span>");
			
			return false;
		}
	}
	
	
	public void Login(String user, String pwd)
	{
		driver.findElement(tb_username).clear();
		logger.log(LogStatus.PASS, "Textbox cleared successfully");
		driver.findElement(tb_username).sendKeys(user);
		logger.log(LogStatus.PASS, "Text:"+user+" entered successfully within username textbox");
		driver.findElement(tb_pwd).clear();
		logger.log(LogStatus.PASS, "Password field cleared successfully");
		driver.findElement(tb_pwd).sendKeys(pwd);
		logger.log(LogStatus.PASS, "Password entered successfully");
		driver.findElement(btn_Login).click();
		logger.log(LogStatus.PASS, "Login button clicked successfully");
	}
	
	
	public boolean VerifyLoginErrorMsg()
	{
		try
		{
			if(driver.findElement(txt_ErrorMsgLogin).isDisplayed())
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
	
	
	public boolean VerifyLoginPageLogo()
	{
		try
		{
			if(driver.findElement(img_LogoLogin).isDisplayed())
			{
				logger.log(LogStatus.PASS, "Error msg validated suucesfully");
				return true;
			}
			else
			{
				logger.log(LogStatus.FAIL, "Invalid error msg");
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
