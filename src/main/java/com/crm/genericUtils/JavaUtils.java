package com.crm.genericUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class JavaUtils 
{
	/**
	 * This method is used to append random number
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	
	/**
	 * This method is used to get System update
	 * @return
	 */

	public String getSystemDate()
	{
		Date dt=new Date();
		String date=dt.toString();
		return date;
	}
	
	
	/**
	 * This method is used to get the Date format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt=new Date();
		String date=dateFormat.format(dt);
		return date; 
	}
}









