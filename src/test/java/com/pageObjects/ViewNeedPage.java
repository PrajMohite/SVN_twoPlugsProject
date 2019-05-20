package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewNeedPage {
public WebDriver ldriver;
	
	//Constructor
	public ViewNeedPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
    
	//Locating Edit button on View Need Page
	@FindBy(xpath="//a[@class='pull-right edit-link']")
	@CacheLookup
	WebElement edit;
	
	//Method to click Edit button on View Need Page
	public void clkedit() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(edit));
		edit.click();
		
	}
	

}
