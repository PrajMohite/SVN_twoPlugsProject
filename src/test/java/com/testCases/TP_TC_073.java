package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CreateNeed;
import com.pageObjects.LoginPage;

//TestCase to create a Need
public class TP_TC_073 extends BaseClass {

	@Test
	  public void CreateNeedTest()throws IOException, InterruptedException
	  {
		//Creating Softassert class object
		 SoftAssert softAssert=new SoftAssert(); 
		 
		//----------Login---------
		 logger.info("Test Case TC_TP_073 started");
		  LoginPage lp=new LoginPage(driver);//Creating object of LoginPage
		  lp.clickloginlandingbtn();//To click Login Button on Home page or landing page
		  logger.info("Login in Landing Page Clicked");
		  
		  lp.setUsername(username1);//to enter username
		  logger.info("Entered Username");
		  
		  lp.setPassword(password);//to enter password
		  logger.info("Entered Password");
		  
		  lp.clickloginbtn1();
		  logger.info("Login Clicked");//Enter Login
		  
		//======Created a Need=========//
		  
		  CreateNeed cn=new CreateNeed(driver);//creating object of CreateNeed page object class
		  cn.clkbtnCreateNew();// to click create new button to select service or need
		  cn.clkbtnNeed();//Select Service from dropdown
		  logger.info("Clicked on Create new Need");
		  
		  String Title=randomestring();//Variable generation to store random string
		  cn.txtTitleField(Title);//Fill in data in the Title field
		  logger.info("Title Entered");
		  
		  String descripetion=randomestring();//Variable generation to store random string
		  cn.txtdescriptionField(descripetion);//Fill in data in the Description field
		  logger.info("Discription Entered");
		  
		  cn.selectCategoryField();//to click on catagery field
		  cn.CategoryHealth();//Select 'Health & Medical' category
		  cn.subCategoryField();//to click subcategory field
		  cn.selectCatergoryList();//select Medical subcategory
		  logger.info("Category and sub-Category are selected");
		  
		  String price=randomeNum();//Variable generation to store random number
		  cn.txtPriceField(price);//to enter price in eeds
		  logger.info("Price in eeds Entered");
		  
		  cn.btnSubmitNeed();//to click submit button
		  logger.info("Submit Button Clicked");
		 
		  //Get Current URL of View Need Page
		  String text=driver.getCurrentUrl();
		
		  //compare it with actual URL
		  if(text.contains("https://qatest.twoplugs.com/viewservice/"))
		  {
			  softAssert.assertTrue(true);
			logger.info("Need Created and displayed on 'Need Details Page'");  
		  }
		  else
		  {
			  //to capture screenshot when if method fails
			  captureScreen(driver, "CreateNeedTest"); 
			  softAssert.fail("Need Created but not displayed on 'Need Details Page'");;
			
		  }
		  cn.clkdropDownLogout();//clicking dropdown for sign out
		  cn.clkbtnSignOut();//clicked sign out
		  logger.info("Logout Clicked");
		  softAssert.assertAll();
			  
		  
	  }
	
}
