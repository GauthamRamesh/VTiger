package com.crm.genericUtils;
import java.io.*;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtils 
{
	/**
	 * This method is used to read the Data from Excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetname,int row,int cell) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		String value=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to get the Last row number
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetname) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
		return rowcount;
	}
	
	/**
	 * This method is used to write the Data into Excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetname,int row,int cell,String value) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
		
		FileOutputStream fout=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * This method is used to read multiple data by using HashMap
	 * @param sheetname
	 * @param cell
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> readMultipleData(String sheetname,int cell) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		
		HashMap<String,String> map=new HashMap<String, String>();
		
		for(int i=0;i<rowcount;i++)
		{
			String key=sh.getRow(i).getCell(cell).getStringCellValue();
			String value=sh.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}

	public Object[][] dataProvider(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastrow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}















