package com.crm.GenricUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	/**
	 * @author Rishi
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {

		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUSENAME, IPathConstant.DBPASSWORD);
	}

	public String executeQueryAndgetData(String query, int columnINdex,String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data = result.getString(columnINdex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData))//comparing
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+"project is created");
			return expData;
		}
		else
		{
			System.out.println("project not created");
			return "";
		}
	}
	public void closeDB() throws Throwable {
		//to close database
		con.close();
	}
}
