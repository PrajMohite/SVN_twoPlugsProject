package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CreateService;
import com.pageObjects.LoginPage;

//Testing the functionality by not Select a Category  Button
public class TP_TC_075 extends BaseClass
{

	@Test
	public void SelCatNegative() throws IOException, InterruptedException{
		//Creating Softassert class object
		 SoftAssert softAssert=new SoftAssert();  
		 
		 //----------Login---------
		 
		 logger.info("Test Case TP_TC_075 started");
		 LoginPage lp=new LoginPage(driver);//Creating object of LoginPage
		  lp.clickloginlandingbtn();//To click Login Button on Home page or landing page
		  logger.info("Login in Landing Page Clicked");
		  
		  lp.setUsername(username1);//to enter username
		  logger.info("Entered Username");
		  
		  lp.setPassword(password);//to enter password
		  logger.info("Entered Password");
		  
		  lp.clickloginbtn1();//Enter Login
		  logger.info("Login Clicked");
		  
		  CreateService cs=new CreateService(driver);//creating object of CreateService page object class
		  cs.clkbtnCreateNew();// to click create new button to select service or need
		  cs.clkbtnService();//Select Service from dropdown
		  logger.info("Clicked on Create new Service");
		  
		  String title=randomestring();//Variable generation to store random string
		  cs.txtTitleField(title);//Fill in data in the Title field
		  logger.info("Title Entered");
		  
		  String discription=randomestring();//Variable generation to store random string
		  cs.txtdescriptionField(discription);//Fill in data in the Description field
		  logger.info("Discription Entered");
		  
		  String price=randomeNum();//Create variable to store random variable
		  cs.txtPriceField(price);//to enter price in eeds
		  logger.info("Price in eeds Entered");
		  
		  cs.SilderBarMaxLimit();//select slide bar to maximum limit
		  
		  String refund=randomeNum();
		  cs.refundValidField(refund);//to input number of days to request refund
		  logger.info("Refund Valid Days Entered");
		  
		  cs.btnSubmitServicePage();
		  logger.info("Submit Button Clicked");
		  
		//============Service Created==========		  
		  
		  
		  String bodyText = driver.findElement(By.tagName("body")).getText();
		  if(bodyText.contains("YOU HAVE TO SELECT A CATEGORY"))
		  {  
			  softAssert.assertTrue(true);
			  logger.info("\"Error Message Displayed\"");
		  }
		  else
		  {
			//to capture screenshot when if method fails
			  captureScreen(driver, "CreateNeedTest"); 
			  softAssert.fail("Error message did not display");;
		  }
		  
		  cs.clkdropDownLogout();//clicking dropdown for sign out
		  cs.clkbtnSignOut();//clicked sign out
		  softAssert.assertAll();
	}
	
}
