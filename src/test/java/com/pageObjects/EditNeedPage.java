package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditNeedPage {
public WebDriver ldriver;
	
	//Constructor
	
	public EditNeedPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 //Locationg Sub-category button
		@FindBy(xpath="/html[1]/body[1]/div[7]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]")
		@CacheLookup
		WebElement SubCatdownarrow;
		
		//Locationg All form subcategory
		@FindBy(xpath="//*[@id=\"subcategory_id-styler\"]/div[2]/ul/li[1]")
		@CacheLookup
		WebElement SubCatAll;
		
		//Locating submit button
		@FindBy(xpath="//button[@type='submit']")
		@CacheLookup
		WebElement submit;
		
		//Method to click Sub-category button
		public void clkSubCatdownarrow()
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(SubCatdownarrow));
			SubCatdownarrow.click();
		}
		
		//Method to click All from Sub-category
		public void clkSubCatAll() 
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 40);
			//subCategoryList.getAttribute(catName);
			wait.until(ExpectedConditions.visibilityOf(SubCatAll));
			wait.until(ExpectedConditions.elementToBeClickable(SubCatAll));
			SubCatAll.click();		
		}
		
		//Method to click Submit button
		public void clksubmit()
		{		
			WebDriverWait wait = new WebDriverWait(ldriver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(submit));
			submit.click();
		}
		
	
}
