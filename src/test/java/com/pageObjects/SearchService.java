package com.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchService 
{
public WebDriver ldriver;
	
	// Constructor
	public SearchService (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//=== Looking for  service==//
	
	// Click on service box after login
	@FindBy(xpath=("//span[@class='w-icons-search']"))
	@CacheLookup
	WebElement serviceBox;
	
	// Selecting services in the search page 
	@FindBy(linkText=("//a[contains(text(),'Services')]"))
	@CacheLookup
	WebElement clkServices;
	
	// Sending values to search in the search box
	@FindBy(xpath=("//input[@placeholder='Search for a service or need']"))
	@CacheLookup
	WebElement txtSearchValue;
	
	// Click on search button
	@FindBy(xpath=("//*[@id=\"tabs\"]/a"))
	@CacheLookup
	WebElement clkSearch;
	
	// select Rent a luxury car ==// //a[text()='App Configuration']
	@FindBy(xpath=("//a[text()='AA Star: Rent a luxury Car']"))
	@CacheLookup
	WebElement clkRntAcar;
	
	// Selecting "i want this" button
	@FindBy(xpath=("//span[contains(text(),'I want this')]"))
	@CacheLookup
	WebElement btnIwantThis; 
	
	// clikcing agreement from popup button
	@FindBy(xpath=("//div[@id='chk_buyer_disclaimer-styler']"))
	@CacheLookup
	WebElement clkDisclaimerOption;
	
	// Clicking on Buy option
	@FindBy(xpath=("//span[contains(text(),'Buy')]"))
	@CacheLookup
	WebElement clkBuy;
	
	// CLick to close pop up button for payment 
	@FindBy(xpath=("//div[@id='myModalPayment']//span[contains(text(),'×')]"))
	@CacheLookup
	WebElement clkExitPaymentPopUp;
	//===================================================================//
	public void clkserviceBox()
	{
		serviceBox.click();
	}
	public void clkServicesSection()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		wait.until(ExpectedConditions.visibilityOf(clkServices));
		clkServices.click();
	}
	
	// Sendkeys value for this method i"
	public void txtSearchValue(String sValue)
	{
		txtSearchValue.sendKeys(sValue);
	}
	
	public void clkSerachButton()
	{
		clkSearch.click();
	}
	public void clkRntAcarOption()
	{
		clkRntAcar.click();
	}
	
	//===============Lets negotiate Page Option =====//
	
		@FindBy(xpath=("//span[contains(text(),'Let`s negotiate')]"))
		@CacheLookup
		WebElement btnLetsNegotiate;
		
		public void btnLetsNegotiate()
		{
			btnLetsNegotiate.click();
		}
		
		// =====Price box =====//
		@FindBy(xpath=("//input[@id='price']"))
		@CacheLookup
		WebElement txtPriceBox;
		
		public void txtPriceBox()
		{	WebDriverWait wait = new WebDriverWait(ldriver,40);
			wait.until(ExpectedConditions.visibilityOf(txtPriceBox));
		//	txtPriceBox.click();
		//	txtPriceBox.clear();
			
			Actions actions = new Actions(ldriver);
			// Clearing text field 
			actions.click(txtPriceBox)
			    .keyDown(Keys.CONTROL)
			    .sendKeys("a")
			    .keyUp(Keys.CONTROL)
			    .sendKeys(Keys.BACK_SPACE)
			    .build()
			    .perform();
			
		}
		public void textPriceBoxCharValue(String charr)
		{
			WebDriverWait wait = new WebDriverWait(ldriver,40);
			wait.until(ExpectedConditions.visibilityOf(txtPriceBox));
		//	txtPriceBox.click();
		//	txtPriceBox.clear();
			
			Actions actions = new Actions(ldriver);
			// Clearing text field 
			actions.click(txtPriceBox)
			    .keyDown(Keys.CONTROL)
			    .sendKeys("a")
			    .keyUp(Keys.CONTROL)
			    .sendKeys(Keys.BACK_SPACE)
			    .sendKeys(charr)
			    .build()
			    .perform();
		}
		
		// CLick on sale agreement button
		
		@FindBy(xpath=("//div[@id='agreeterm-styler']"))
		@CacheLookup
		WebElement clkSaleAgreement;
		
		public void clkSaleAgreement()
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(clkSaleAgreement));
			clkSaleAgreement.click();
		}
		
		// Click on Send Button
		
		@FindBy(xpath=("//*[@id=\"contract_send\"]"))
		@CacheLookup
		WebElement btnSend;
		
		public void btnSend()
		{
			btnSend.click();
		}
		
		@FindBy(xpath=("//div[@id='myModalCatering']//button[@type='button']"))
		@CacheLookup
		WebElement btnCloseNegotiation;
		
		public void btnCloseNegotiation()
		{
			btnCloseNegotiation.click();
		}
		
		
	//===========================================//	
	
	// ==== OPtiont to select i want this button =====//
	public void btnIwantThis()
	{
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		WebElement flag=btnIwantThis;
		js.executeScript("arguments[0].scrollIntoView();", flag);
		btnIwantThis.click();
	//	WebDriverWait wait = new WebDriverWait(ldriver, 40);
	//	wait.until(ExpectedConditions.visibilityOf(btnIwantThis));
		
	}
	public void clkDisclaimerOption()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		wait.until(ExpectedConditions.visibilityOf(clkDisclaimerOption));
		clkDisclaimerOption.click();
	}
	public void clkBuy()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		wait.until(ExpectedConditions.visibilityOf(clkBuy));
		clkBuy.click();
		
	}
	public void clkExitPaymentPopUp()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		wait.until(ExpectedConditions.visibilityOf(clkExitPaymentPopUp));
		clkExitPaymentPopUp.click();
	}
	
	
	
}
