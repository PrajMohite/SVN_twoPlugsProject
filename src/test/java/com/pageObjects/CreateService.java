package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateService 
{
	public WebDriver ldriver;
	
	// Constructor
	public CreateService(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//======Create a service=========//
	
		// Selecting create new button to select service need 
		@FindBy(xpath="//span[contains(@class,\"w-icons-caret\")]")
		@CacheLookup // is used to improve the performance
		WebElement btnCreateNew;

		// Selecting Service from drop down list
		@FindBy(xpath="//a[contains(text(),'Service')]")
		@CacheLookup // is used to improve the performance 
		WebElement btnService;
		
		//==== Completing Add a service page =====//
		
		// Send values to field title for adding title to page "Add a Service"
		@FindBy(xpath="//input[@id='name']")
		@CacheLookup // is used to improve the performance 
		WebElement txtTitle;
		
		// Send values to description field 
		@FindBy(xpath="//textarea[@id='description']")
		@CacheLookup // is used to improve the performance 
		WebElement txtdescription;
		
		
		// Select category 
		@FindBy(xpath="//div[@class='jq-selectbox__select-text placeholder']")
		@CacheLookup 
		WebElement selectCategory;
		
		
		// Select from Category list
		@FindBy(xpath="//li[contains(text(),'Automobile')]")
		@CacheLookup
		WebElement CategoryList;
		
		// Select Sub-category field
		@FindBy(xpath="/html[1]/body[1]/div[7]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]")
		@CacheLookup
		WebElement subCategory;
		 
		
		// Select from Sub-Category list
		@FindBy(xpath="//div[@id='subcategory_id-styler']//li[contains(text(),'Automobile')]")
		@CacheLookup
		WebElement subCategoryList;
		
		// Updating price field 
		@FindBy(xpath="//input[@id='price']")
		@CacheLookup
		WebElement txtPrice;
		
		// Refund Bar
		@FindBy(xpath="//div[@id='slider-range-max3']")
		@CacheLookup
		WebElement sliderBar;
		
		//Refund valid field
		@FindBy (xpath="//input[@id='refund_valid']")
		@CacheLookup
		WebElement txtrefundValid;
		
		//Click Submit button
		@FindBy (xpath="//button[contains(@type,'submit')]")
		@CacheLookup
		WebElement btnSubmit;
		
		
		//======= Log out ======//
		@FindBy(xpath="//span[@class='caret']")
		@CacheLookup
		WebElement dorpDownLogout;
		
		@FindBy(xpath="//span[contains(text(),'Sign Out')]")
		@CacheLookup
		WebElement btnSignout;
		//========================================================================//
		
		public void clkbtnCreateNew()
		{
			btnCreateNew.click();
		}
		
		public void clkbtnService()
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(btnService));
			btnService.click();
		}
		public void txtTitleField(String uvalue)
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(txtTitle));
			txtTitle.click();
			txtTitle.sendKeys(uvalue);
		}
		public void txtdescriptionField(String description)
		{
			txtdescription.sendKeys(description);
		}
		public void selectCategoryField()
		{
			selectCategory.click();
		}

		public void CategoryAutomobile()
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 40);
			wait.until(ExpectedConditions.visibilityOf(CategoryList));
			wait.until(ExpectedConditions.elementToBeClickable(CategoryList));
			CategoryList.click();
		}
		public void subCategoryField() throws InterruptedException
		{
			Thread.sleep(3000);
			subCategory.click();
		}
		
		public void selectCatergoryList(String catName)
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 40);
			subCategoryList.getAttribute(catName);			
			wait.until(ExpectedConditions.visibilityOf(subCategoryList));
			wait.until(ExpectedConditions.elementToBeClickable(subCategoryList));
			subCategoryList.click();
		}
		public void txtPriceField(String price)
		{
			txtPrice.sendKeys(price);
		}
		public void SilderBarMaxLimit()
		{
			// Sectecting the maximum option in the slider bar
			WebElement ele=sliderBar;
			Actions act=new Actions(ldriver);
			act.moveToElement(ele).dragAndDropBy(ele, 400, 0).build().perform();
			
		}
		public void refundValidField (String days)
		{
			txtrefundValid.sendKeys(days);
		}
		public void btnSubmitServicePage()
		{
			btnSubmit.click();
		}	
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




