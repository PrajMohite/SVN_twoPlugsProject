package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LoginPage;

public class TC_TP_001 extends BaseClass
{
	@Test(priority=1)
	public void loginTest() throws IOException, InterruptedException
	{	
		// Login page 
		LoginPage LoginPage = new LoginPage(driver);
		
		
		LoginPage.clickloginlandingbtn();
		logger.info("Clicking on Login button to enter user name and password");
		
		LoginPage.setUsername(username1);
		logger.info("providing user name");
		
		logger.info("providing password");
		LoginPage.setPassword(password);
		
		LoginPage.clickloginbtn1();
		logger.info("Clicking on login button to access TwoPlugs main home page");
		
		// Validating the login - "Home Page" title
		// after logging into Sun
		Thread.sleep(3000);
		if(driver.getTitle().equals("twoPLUGS - A plug for your Service and another for your Need"))
		{
			Assert.assertTrue(true);
			logger.info("login success");
		}
		else
		{
			captureScreen(driver,"loginTest");
			// to capture screen on failure and here after driver
						// we use the name of the current test method i.e. loginTest
			logger.error("login is failed : Screen shot taken");
			Assert.assertTrue(false);
		}
		System.out.println(" " + "Page Title  : " + driver.getTitle());
		logger.info("Vaidating title page - Home page, after login");
	} 
}
