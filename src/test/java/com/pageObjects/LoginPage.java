package com.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	public WebDriver ldriver;
	
	//Constructor
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	
	// Login Page 
	
	// Click login button on main page 
		// click action on 1st login button
		@FindBy(xpath="//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li/a[@class='btn border']/span[1]")
		@CacheLookup // is used to improve the performance 
		WebElement btnloginlanding;
		
		//Input user name
		@FindBy(xpath="//*[@id=\"signInEmail\"]")
		@CacheLookup
		WebElement txtusername;

		//input password
		@FindBy(xpath="//input[@id='signInPassword']")
		@CacheLookup
		WebElement txtpassword;
		
		// Click login after user name and password
		@FindBy (xpath="//span[contains(text(),'LOG IN')]")
		@CacheLookup
		WebElement btnlogin1;
		
		public void clickloginlandingbtn()
		{
			btnloginlanding.click();
		}
		public void setUsername(String uname)
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 25); 
			wait.until(ExpectedConditions.visibilityOf(txtusername));
			Actions actions = new Actions(ldriver);
			// Clearing text field 
			actions.click(txtusername)
			    .keyDown(Keys.CONTROL)
			    .sendKeys("a")
			    .keyUp(Keys.CONTROL)
			    .sendKeys(Keys.BACK_SPACE)
			    .click()
			    .sendKeys(uname)
			    .build()
			    .perform();
			
		}
		
		public void setPassword(String pwd)
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 25); 
			wait.until(ExpectedConditions.visibilityOf(txtpassword));
			Actions actions = new Actions(ldriver);
			// Clearing text field 
			actions.click(txtpassword)
			    .keyDown(Keys.CONTROL)
			    .sendKeys("a")
			    .keyUp(Keys.CONTROL)
			    .sendKeys(Keys.BACK_SPACE)
			    .click()
			    .sendKeys(pwd)
			    .build()
			    .perform();
			
		}
		public void clickloginbtn1()
		{
			btnlogin1.click(); 
		}
		
		
		
		//======= Log out ======//
		@FindBy(xpath="//span[@class='caret']")
		@CacheLookup
		WebElement dorpDownLogout;
		
		@FindBy(xpath="//span[contains(text(),'Sign Out')]")
		@CacheLookup
		WebElement btnSignout;
		
		// ===============Log out====================== //
			public void clkdropDownLogout() throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(ldriver, 50);
				wait.until(ExpectedConditions.elementToBeClickable(dorpDownLogout));
				Thread.sleep(3000);
				dorpDownLogout.click();
			}
			public void clkbtnSignOut()
			{
				WebDriverWait wait = new WebDriverWait(ldriver, 25);
				wait.until(ExpectedConditions.visibilityOf(btnSignout));
				wait.until(ExpectedConditions.elementToBeClickable(btnSignout));
				btnSignout.click();
			}
	} 




