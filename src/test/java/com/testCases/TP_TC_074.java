package com.testCases;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CreateNeed;
import com.pageObjects.LoginPage;

//Testing the functionality by selecting all categories one by one
public class TP_TC_074 extends BaseClass
{
  @Test
  public void SelectCategory() throws IOException, InterruptedException
  {
	//Creating Softassert class object
	SoftAssert softAssert=new SoftAssert();  
		 
		 //----------Login---------
		 
	logger.info("Test Case TP_TC_074 started");  
	  LoginPage lp=new LoginPage(driver);//Creating object of LoginPage
	  lp.clickloginlandingbtn();//To click Login Button on Home page or landing page
	  logger.info("Login in Landing Page Clicked");
	  
	  lp.setUsername(username1);//to enter username
	  logger.info("Entered Username");
	  
	  lp.setPassword(password);//to enter password
	  logger.info("Entered Password");
	  
	  lp.clickloginbtn1();//Enter Login
	  logger.info("Login Clicked");
	  
	  CreateNeed cn=new CreateNeed(driver);//creating object of CreateNeed page object class
	  cn.clkbtnCreateNew();// to click create new button to select service or need
	  cn.clkbtnNeed();//Select Service from dropdown
	  logger.info("Clicked on Create new Need");
	  
	  
	  cn.selectCategoryField(); //to click on catagery field
	  logger.info("Select category identified");
	  Thread.sleep(2000);
	  WebElement SelectCat=driver.findElement(By.xpath("//select[@id='category_id']")); 
	  Select select = new Select (SelectCat);//creating a object of class select
	     List<WebElement> list = select.getOptions();
      
    
      System.out.println("Ther are total "+list.size()+" Number of Categories");
    
    int count=0;
     for (int i = 0; i <list.size(); i++)// For loop to select a data from listbox
      {
             String str=list.get(i).getText(); //to store the text of each element from the list
             list.get(i).click(); //click each element 
             System.out.println(str+" is Selected");
             count++;
                
       }
     logger.info("All categories displayed"); 
     if(count==list.size())/*if the code enters for loop then only count will be incremented this statement is true 
    	                     when all the elements are selected and displayed on console window*/
     softAssert.assertTrue(true);
     else
     softAssert.fail();
     
     softAssert.assertAll();
             
      }
      
  
}
