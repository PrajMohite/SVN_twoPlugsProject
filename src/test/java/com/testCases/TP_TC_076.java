package com.testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CreateNeed;
import com.pageObjects.EditNeedPage;
import com.pageObjects.LoginPage;
import com.pageObjects.ViewNeedPage;
//Testing the functionality by click on  Subcategory 
public class TP_TC_076 extends BaseClass
{
	
	@Test
	public void SubCatAll() throws IOException, InterruptedException
	{
		//Creating Softassert class object
		 SoftAssert softAssert=new SoftAssert();  
		 
		 //----------Login---------
		 
		 logger.info("Test Case TP_TC_076 started");
		 LoginPage lp=new LoginPage(driver);//Creating object of LoginPage
		  lp.clickloginlandingbtn();//To click Login Button on Home page or landing page
		  logger.info("Login in Landing Page Clicked");
		  
		  lp.setUsername(username1);
		  logger.info("Entered Username");//to enter username
		  
		  lp.setPassword(password);//to enter password
		  logger.info("Entered Password");
		  
		  lp.clickloginbtn1();//Enter Login
		  logger.info("Login Clicked");
		  
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
		  logger.info("Category down arrow clicked");
		  cn.CategoryHealth();//Select 'Health & Medical' category
		  logger.info("Health & Medical Category Selected");
		  cn.subCategoryField();//to click subcategory field
		  logger.info("Sub-Category down arrow clicked");
		  cn.selectCatergoryList();//select Medical subcategory
		  logger.info("'Medical' option form sub-Category is selected");
		  
		  String price=randomeNum();//Variable generation to store random number
		  cn.txtPriceField(price);//to enter price in eeds
		  logger.info("Price in eeds Entered");
		  
		  cn.btnSubmitNeed();//to click submit button
		  logger.info("Submit Button Clicked");
		  
		  ViewNeedPage vp=new ViewNeedPage(driver);//create object of ViewNeedPage class
		  vp.clkedit();//click edit button on ViewNeedPage
		  logger.info("Edit button on View Need Page clicked");
		  
		  EditNeedPage enp=new EditNeedPage(driver);//create object of EditNeedPage class
		  enp.clkSubCatdownarrow();
		  logger.info("Sub-Category down arrow clicked");
		  
		  enp.clkSubCatAll();
		  logger.info("Option 'All' from Sub-Category Selected");
		  
		  enp.clksubmit();//to click submit button
		  logger.info("Save clicked");
		  
		//Get Current URL of View Need Page
          String text=driver.getCurrentUrl();
		
		  
		  if(text.contains("https://qatest.twoplugs.com/viewservice/"))
		  {
			softAssert.assertTrue(true);
			logger.info("Need Updated to Subcategory 'All' and displayed on 'Need Details Page'");  
		  }
		  else
		  {
			//to capture screenshot when if method fails
			  captureScreen(driver, "CreateNeedTest"); 
			  softAssert.fail("Need is not Updated to Subcategory 'All' and does not submited");;
			
		  }
		  cn.clkdropDownLogout();//clicking dropdown for sign out
		  cn.clkbtnSignOut();//clicked sign out
		  logger.info("Logout Clicked");
		  softAssert.assertAll();
		
	}

}
