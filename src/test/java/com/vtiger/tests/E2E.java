package com.vtiger.tests;




import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;






import com.vtiger.common.CommonFunctions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.NewLeadPage;

public class E2E extends BaseTest{
	

	
	@BeforeClass
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
	public void createLead() throws Exception
	{
		logger=report.startTest("createLead");
		LoginPage lp=new LoginPage(driver,logger);
		boolean output=lp.verifyTitle("vtiger CRM - Commercial Open Source CRM");
		Assert.assertEquals(output, true);		
		lp.Login("admin", "admin");
		HomePage hp=new HomePage(driver,logger);
		boolean output1=hp.verifyLink("Logout");
		Assert.assertEquals(output1, true);		
		boolean output2=hp.verifyLink("New Lead");
		Assert.assertEquals(output2, true);
		hp.clickLink("New Lead");
		NewLeadPage nlp=new NewLeadPage(driver,logger);
		nlp.fillLeadFormwithMandatoryFields("Modi", "BJP");
		boolean val=nlp.verifyLeadContent("Modi", "BJP");
		Assert.assertEquals(val, true);
		hp.clickLink("Logout");
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
