package com.crm.genericUtils;
import java.io.*;
import java.util.Properties;
public class FileUtils 
{
	/**
	 * This method is used to read the Data from Property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
}
