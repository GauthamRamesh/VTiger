package com.crm.genericUtils;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;
public class DataBaseUtils 
{
	Connection con=null;
	/**
	 * This method is used to connect to the DataBase
	 * @throws SQLException
	 */
	public void connectToDb() throws SQLException
	{
		// Register DataBase //
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUserName,IpathConstants.DBPassword);
	}
	
	/**
	 * This method is used to compare actual data and expected data from DataBase
	 * @param query
	 * @param colIndex
	 * @param expdata
	 * @throws SQLException
	 */
	public void executeAndGetData(String query, int colIndex, String expdata) throws SQLException
	{
		Statement stmt=con.createStatement();
		ResultSet resultSet=stmt.executeQuery(query);
		
		boolean flag=false;
		while(resultSet.next())
		{
			String actualdata=resultSet.getString(colIndex);
			if(actualdata.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("---Data Verified---");
		}
		else
		{
			System.out.println("---Data not Verified---");
		}
	}
	
	/**
	 * This method is used to close DataBase Connection
	 * @throws SQLException
	 */
	public void closeDb() throws SQLException
	{
		con.close();
	}
}







