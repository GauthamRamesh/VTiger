	package com.objectRepo;
	import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtils.JavaUtils;
import com.crm.genericUtils.WebDriverUtils;
	public class CreateOrganizationPage extends WebDriverUtils
	{
		// Declaration //
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createOrganizationImage;
		
		@FindBy(name = "accountname")
		private WebElement organizationNameField;
		
		@FindBy(xpath = "//input[@name='website']")
		private WebElement websiteField;
		
		@FindBy(name = "tickersymbol")
		private WebElement tickerSymbolField;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
		private WebElement memberOfImage;
		
		@FindBy(name = "search_text")
		private WebElement searchTextField;
		
		@FindBy(name = "search")
		private WebElement searchNowButton;
		
		@FindBy(name = "industry")
		private WebElement industryDropDown;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveButton;

		@FindBy(name = "phone")
		private WebElement phoneno;
		
		// Initialization //
		public CreateOrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		// Utilization  //
		public WebElement getCreateOrganizationImage() 
		{
			return createOrganizationImage;
		}

		public WebElement getOrganizationNameField() 
		{
			return organizationNameField;
		}

		public WebElement getPhoneno() {
			return phoneno;
		}

		public WebElement getWebsiteField() 
		{
			return websiteField;
		}

		public WebElement getTickerSymbolField()
		{
			return tickerSymbolField;
		}

		public WebElement getMemberOfImage() 
		{
			return memberOfImage;
		}

		public WebElement getSearchTextField() 
		{
			return searchTextField;
		}

		public WebElement getSearchNowButton()
		{
			return searchNowButton;
		}

		public WebElement getIndustryDropDown() 
		{
			return industryDropDown;
		}

		public WebElement getSaveButton() 
		{
			return saveButton;
		}
		
		// Business Logic //
		public void createOrganization()
		{
			createOrganizationImage.click();
		}
		
		public void enterDataToFields(String organizationName, String websiteInfo, String ticker, String ph)
		{
			JavaUtils jLib = new JavaUtils();
			organizationNameField.sendKeys(organizationName+jLib.getRandomNo());
			websiteField.sendKeys(websiteInfo);
			tickerSymbolField.sendKeys(ticker);
			phoneno.sendKeys(ph);
//			memberOfImage.click();
		}
		
		public void windowActions(String existingorganization, WebDriver driver) throws InterruptedException
		{
			// Switch to Child Window //
			switchToWindow(driver, "Accounts&action");
			searchTextField.sendKeys(existingorganization);
			searchNowButton.click();
			driver.findElement(By.xpath("//a[text()='"+existingorganization+"']")).click();
			acceptAlert(driver);
			Thread.sleep(1000);
			// Switch to Parent Window //
			switchToWindow(driver, "Contacts&action");
		}
		
		public void industryFieldDropDown(WebDriver driver)
		{
			//industryDropDown.click();
			waitUntilEleToBeClickable(driver, 20, industryDropDown);
			handleDropDown(industryDropDown, "Healthcare");
		}
		
		public void saveDetails()
		{
			saveButton.click();
		}
		
	}
