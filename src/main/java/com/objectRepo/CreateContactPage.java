package com.objectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.genericUtils.WebDriverUtils;

public class CreateContactPage extends WebDriverUtils
{
		// Declaration //
		@FindBy(linkText = "Contacts")
		private WebElement contactsLink;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createContactsImage;
		
		@FindBy(name = "salutationtype")
		private WebElement firstNameDropDown;
		
		@FindBy(name = "firstname")
		private WebElement firstName;
		
		@FindBy(name = "lastname")
		private WebElement lastName;
		
		@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
		private WebElement organizationLookup;
		
		@FindBy(id="search_txt")
		private WebElement searchTextField;
		
		@FindBy(name = "search")
		private WebElement searchButton;
		
		@FindBy(xpath = "//a[text()='\"+orgname+\"']")
		private WebElement organizationName;
		
		@FindBy(name = "leadsource")
		private WebElement leadSourceDropDown;
		
		@FindBy(id = "title")
		private WebElement titleField;
		
		@FindBy(id = "department")
		private WebElement departmentField;
		
		@FindBy(id = "email")
		private WebElement emailField;
		
		@FindBy(id = "assistant")
		private WebElement assistantField;
		
		@FindBy(id = "assistantphone")
		private WebElement assistantPhoneField;
		
		@FindBy(xpath = "(//input[@title='Save [Alt+S]'])")
		private WebElement saveButton;
		
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement contInfoElement;
		
		// Initialization //
	   public CreateContactPage(WebDriver driver) 
	   {
		   PageFactory.initElements(driver, this);
	   }

	   
	   // Utilization //
	   
	   public WebElement getContactsLink() {
			return contactsLink;
		}

		public WebElement getCreateContactsImage() {
			return createContactsImage;
		}

		public WebElement getFirstNameDropDown() {
			return firstNameDropDown;
		}

		public WebElement getFirstName() {
			return firstName;
		}

		public WebElement getLastName() {
			return lastName;
		}

		public WebElement getOrganizationLookup() {
			return organizationLookup;
		}

		public WebElement getSearchTextField() {
			return searchTextField;
		}

		public WebElement getSearchButton() {
			return searchButton;
		}

		public WebElement getOrganizationName() {
			return organizationName;
		}

		public WebElement getLeadSourceDropDown() {
			return leadSourceDropDown;
		}

		public WebElement getTitleField() {
			return titleField;
		}

		public WebElement getDepartmentField() {
			return departmentField;
		}

		public WebElement getEmailField() {
			return emailField;
		}

		public WebElement getAssistantField() {
			return assistantField;
		}

		public WebElement getAssistantPhoneField() {
			return assistantPhoneField;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}

		public WebElement getContInfoElement() {
			return contInfoElement;
		}
	   
		// Business Logic //
		public void contactLink()
		{
			 contactsLink.click();
			 createContactsImage.click();
		}
		
		public void enterContactDetails(String firstname, String lastname)
		{
			handleDropDown(firstNameDropDown, "Mr.");
			firstName.sendKeys(firstname);
			lastName.sendKeys(lastname);
			organizationLookup.click();
		}
		public void windowActionsForContPage(WebDriver driver, String orgname) throws InterruptedException 
		{
			// Switch to Child Window //
			switchToWindow(driver, "Accounts&action");
			searchTextField.sendKeys(orgname);
			searchButton.click();
			driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			Thread.sleep(1000);
			// Switch to Parent Window //
			switchToWindow(driver, "Contacts&action");
		}
		
		public void leadDropDown(String empDD)
		{
			handleDropDown(empDD, leadSourceDropDown);
		}
		
		public void enterAllContactFields(String title, String department, String email, String assistant, String assistantphone)
		{
			titleField.sendKeys(title);
			departmentField.sendKeys(department);
			emailField.sendKeys(email);
			assistantField.sendKeys(assistant);
			assistantPhoneField.sendKeys(assistantphone);
		}
		
		public void save() 
		{
			saveButton.click();
		}
		
		public void compareToCreateContact(WebDriver driver, String lastname)
		{
			waitUntilEleToBeVisible(driver, 20, contInfoElement);
			String actualcont=contInfoElement.getText();
			if(actualcont.contains(lastname))
			{
				System.out.println("Contacts Created Successfully");
			}
			else
			{
				System.out.println("Contacts not Created");
			}
		}
}






