package com.crm.genericUtils;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.objectRepo.*;

public class BaseClass 
{
	public DataBaseUtils dlib=new DataBaseUtils();
	public FileUtils flib=new FileUtils();
	public ExcelUtils elib=new ExcelUtils();
	public JavaUtils jlib=new JavaUtils();
	public WebDriverUtils wlib=new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException
	{
		dlib.connectToDb();
		System.out.println("Connect to DB");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException
	{
		String BROWSER=flib.readDataFromPropertyFile("Browser");
		String URL=flib.readDataFromPropertyFile("URL");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) 
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("---Invalid Browser---");
		}
		
		sdriver=driver;
		// Maximize Window //
		wlib.maximizeWindow(driver);
		
		// Enter URL //
		driver.get(URL);
		
		// Wait for Page Load //
		wlib.waitForPageLoad(driver, 20);
		
		System.out.println("---Browser Launched---");
	}
	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws IOException
	{
		String USERNAME=flib.readDataFromPropertyFile("UserName");
		String PASSWORD=	flib.readDataFromPropertyFile("Password");
		
		// Login To Application //
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----Logged into Application----");
	}
	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() throws InterruptedException
	{
		Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		hp.administratorImage(driver);
		System.out.println("---Logged out from Application---");
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("----Browser Closed----");
	}
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException
	{
		dlib.closeDb();
		System.out.println("----Disconnected from DB----");
	}
	
}


// For CrossBrowser Execution //
/*@Parameters("BROWSER")
@BeforeClass(alwaysRun = true)
public void launchBrowser(String BROWSER) throws IOException

{
//	String BROWSER=flib.readDataFromPropertyFile("Browser");
	String URL=flib.readDataFromPropertyFile("URL");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox")) 
	{
		driver=new FirefoxDriver();
	}
	else if (BROWSER.equalsIgnoreCase("edge")) 
	{
		driver=new EdgeDriver();
	}
	else
	{
		System.out.println("---Invalid Browser---");
	}*/








