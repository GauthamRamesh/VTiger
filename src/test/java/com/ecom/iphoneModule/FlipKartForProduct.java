package com.ecom.iphoneModule;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class FlipKartForProduct 
{
	@Test
	public void fetchNameAndPrice() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("Data");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Iphone",Keys.ENTER);
		 List<WebElement> elem = driver.findElements(By.xpath("//div[@class='_13oc-S']/descendant::div[@class='_4rR01T']"));
		 int size=elem.size();
		 System.out.println(size);
		 for(int i=0;i<size;i++)
		 {
			 WebElement element=elem.get(i);
			 String productname=element.getText();
			 System.out.println(productname);
			WebElement price=driver.findElement(By.xpath("//div[text()='"+productname+"']/ancestor::a[@class='_1fQZEK']/descendant::div[@class='_30jeq3 _1_WHN1']"));
			String productprice=price.getText();
			System.out.println(productprice);
			sheet.createRow(i).createCell(0).setCellValue(productname+" --->"+productprice);
			FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
			book.write(fos);
		}
	}
}
