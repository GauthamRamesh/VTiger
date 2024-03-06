	package com.objectRepo;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
    import com.crm.genericUtils.WebDriverUtils;
	public class HomePage extends WebDriverUtils
	{
		// Declaration //
		@FindBy(linkText = "Organizations")
		private WebElement organizationlink;
	
		@FindBy(linkText = "Contacts")
		private WebElement contactslink;
	
		@FindBy(linkText = "Opportunities")
		private WebElement opportunitieslink;
	
		@FindBy(linkText = "Products")
		private WebElement productslink;
	
		@FindBy(linkText = "Documents")
		private WebElement documentslink;
	
		@FindBy(linkText = "Email")
		private WebElement emaillink;
	
		@FindBy(linkText = "Trouble Tickets")
		private WebElement troubleticketslink;
	
		@FindBy(linkText = "Dashboard")
		private WebElement dashboardlink;
	
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorimage;
	
		@FindBy(linkText = "Sign Out")
		private WebElement signoutlink;
	
		// Initialization //
		public HomePage(WebDriver driver) 
		{
			PageFactory.initElements(driver,this);
		}
	
		// Utilization //
		public WebElement getOrganizationlink() 
		{
			return organizationlink;
		}
	
		public WebElement getContactslink() 
		{
			return contactslink;
		}
	
		public WebElement getOpportunitieslink() 
		{
			return opportunitieslink;
		}
	
		public WebElement getProductslink() 
		{
			return productslink;
		}
	
		public WebElement getDocumentslink() 
		{
			return documentslink;
		}
	
		public WebElement getEmaillink() 
		{
			return emaillink;
		}
	
		public WebElement getTroubleticketslink() 
		{
			return troubleticketslink;
		}
	
		public WebElement getDashboardlink() 
		{
			return dashboardlink;
		}
	
		public WebElement getAdministratorimage() 
		{
			return administratorimage;
		}
	
		public WebElement getSignoutlink() 
		{
			return signoutlink;
		}
	
		// Business Logic //
		public void clickOnOrgLink()
		{
			organizationlink.click();
		}
		
		public void clickOnContLink() 
		{
			contactslink.click();
		}
		
		public void clickOnOpporLink() 
		{
			opportunitieslink.click();
		}
		
		public void clickOnProdtLink() 
		{
			productslink.click();
		}
		
		public void clickOnDocmtLink() 
		{
			documentslink.click();
		}
		
		public void clickOnEmailLink() 
		{
			emaillink.click();
		}
		
		public void clickOnTroubleTickLink() 
		{
			troubleticketslink.click();
		}
		
		public void clickOnDashBrdLink() 
		{
			dashboardlink.click();
		}
		
		public void administratorImage(WebDriver driver)
		{
			mouseHoverHandle(driver, administratorimage);
			signoutlink.click();
		}
		
	}
