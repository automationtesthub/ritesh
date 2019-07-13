package com.vtiger.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vtiger.common.config;

public class BaseTest {
	
public WebDriver driver;
public static ExtentReports report=null;
public static ExtentTest logger; 
public static String extentReport;
	

	public void LaunchApp()
	{		
		System.setProperty("webdriver.chrome.driver",config.ChromePath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.url);
		driver.manage().timeouts().implicitlyWait(config.globaltimeout, TimeUnit.SECONDS);		
		
	}
	
	public void closeApp()
	{
		
		driver.close();
		driver.quit();
		
		
	}

}
