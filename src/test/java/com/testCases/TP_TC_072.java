package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CreateService;
import com.pageObjects.LoginPage;
//Test to create a service
public class TP_TC_072 extends BaseClass{
	@Test
	  public void CreateServiceTest()throws IOException, InterruptedException
	  {
		//Creating Softassert class object
		 SoftAssert softAssert=new SoftAssert();  
		 
		 //----------Login---------
		 
		 logger.info("Test Case TP_TC_072 started");
		  LoginPage lp=new LoginPage(driver);//Creating object of LoginPage
		  lp.clickloginlandingbtn(); //To click Login Button on Home page or landing page
		  logger.info("Login in Landing Page Clicked");
		  
		  lp.setUsername(username1);//to enter username
		  logger.info("Entered Username"); 
		  
		  lp.setPassword(password);//to enter password
		  logger.info("Entered Password");
		  
		  lp.clickloginbtn1();
		  logger.info("Login Clicked");//Enter Login
		  
		//======Created a Service=========//
		  
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
		  
		  cs.selectCategoryField();//to click on catagery field
		  cs.CategoryAutomobile();//Select Automobile catagory
		  cs.subCategoryField();//to click subcategory field
		  cs.selectCatergoryList("class");//select Automobile subcategory
		  
		  String price=randomeNum();//Create variable to store random variable
		  cs.txtPriceField(price);//to enter price in eeds
		  logger.info("Price in eeds Entered");
		  
		  cs.SilderBarMaxLimit();//select slide bar to maximum
		  
		  String refund=randomeNum();
		  cs.refundValidField(refund);//to input number of days to request refund
		  logger.info("Refund Valid Days Entered");
		  
		  cs.btnSubmitServicePage();
		  logger.info("Submit Button Clicked");
		  
		  //============Service Created==========
		  
		  
		  //storing the success message in a string variable
		  
		  /*String actual_text=driver.findElement(By.xpath("//*[@id=\"dismiss\"]/div/div")).getText();
		  String expected_text="Service has been added";
		 */
		  
		  
		  //Get Current URL of View Need Page
		  String text=driver.getCurrentUrl();
		
		  //compare it with actual URL
		  if(text.contains("https://qatest.twoplugs.com/viewservice/"))
		 {
			softAssert.assertTrue(true);
			logger.info("Service Created and displayed on 'Service Details Page'");  
		  }
		  else
		  { 
			  // to capture screenshot on failure
			  captureScreen(driver, "CreateServiceTest"); 
		      softAssert.fail();
		      logger.info("Service Created but not displayed on 'Service Details Page'");
		  }
		  cs.clkdropDownLogout();//clicking dropdown for sign out
		  cs.clkbtnSignOut();//clicked sign out
		  logger.info("Sign Out Clicked");

		  softAssert.assertAll();
	  }
	  
	  
	  
}
