package com.vtiger.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.common.CommonFunctions;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	
	@BeforeClass(alwaysRun = true)
	public void StartApp()
	{
		if(report==null)
		{
			report=CommonFunctions.setupResult();
		}
		
		if(driver==null)
		{
		LaunchApp();	
		}
	}
	
	
	@Test
	public void validateTitle() throws Exception
	{
		logger=report.startTest("validateTitle");
		LoginPage lp=new LoginPage(driver,logger);
		boolean output=lp.verifyTitle("vtiger CRM - Commercial Open Source CRM123");
		//Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
	}
	
	
	@Test	
	public void validateLogo()
	{
		logger=report.startTest("validateLogo");
		LoginPage lp=new LoginPage(driver,logger);
		boolean output=lp.VerifyLoginPageLogo();
		Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
	}
	
	@Test
	public void validateInvalidLogin()
	{
		logger=report.startTest("validateInvalidLogin");
		LoginPage lp=new LoginPage(driver,logger);
		lp.Login("abc", "xyz");
		boolean output=lp.VerifyLoginErrorMsg();
		Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
	}
	
	@Test
	public void validatevalidLogin()
	{
		logger=report.startTest("validatevalidLogin");
		LoginPage lp=new LoginPage(driver,logger);
		lp.Login("admin", "admin");
		HomePage hp=new HomePage(driver,logger);
		boolean output=hp.verifyLink("Logout");
		Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
	}
	
	
	@AfterClass
	public void tierDown()
	{
		report.flush();
		if(driver!=null)
		{
		closeApp();
		}
	}

}
