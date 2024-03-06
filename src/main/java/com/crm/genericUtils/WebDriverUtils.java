package com.crm.genericUtils;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDriverUtils
{
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	public WebDriverWait webDriverWaitObj(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}

	public void waitUntilEleToBeVisible(WebDriver driver,int sec, WebElement element)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilEleToBeClickable(WebDriver driver, int sec, WebElement element)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilEleToBePresent(WebDriver driver,int sec)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Object Creation to handle DropDown 
	 * @param element
	 * @return
	 */
	public Select dropDownObj(WebElement element)
	{
		Select sel=new Select(element);
		return sel;
	}

	public void handleDropDown(WebElement element,int index)
	{
		dropDownObj(element).selectByIndex(index);
	}

	public void handleDropDown(WebElement element, String value)
	{
		dropDownObj(element).selectByValue(value);
	}

	public void handleDropDown(String text, WebElement element)
	{
		dropDownObj(element).selectByVisibleText(text);
	}

	public Actions actionObj(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}

	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		actionObj(driver).doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element)
	{
		actionObj(driver).contextClick(element).perform();
	}

	public void enterKeyPress(WebDriver driver)
	{
		actionObj(driver).sendKeys(Keys.ENTER).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		actionObj(driver).dragAndDrop(src, dest).perform();
	}

	public void mouseHoverHandle(WebDriver driver,WebElement element)
	{
		actionObj(driver).click(element).perform();
	}

	public Robot robotObj() throws Throwable 
	{
		Robot robot=new Robot();
		return robot;
	}

	public void enterKey() throws Throwable
	{
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}

	public void enterRelease() throws Throwable
	{
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}

	public void switchToWindow(WebDriver driver, String expwind)
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String win=it.next();
			String currenttitle=driver.switchTo().window(win).getTitle();
			if(currenttitle.contains(expwind))
			{
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}

	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		JavaUtils jlib=new JavaUtils();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+" "+jlib.getSystemDateInFormat()+".png";
		File dst=new File(path);
		String srcpath=dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return srcpath;
	}
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		
		js.executeScript("window.scrollBy(0,"+y+")", element);
		
		// js.executeScript("argument[0].scrollIntoView()", element);
	}
	
}











