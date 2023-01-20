package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataTest {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try
		{
			Driver driver=new Driver();
			//Step1: Register the database
			DriverManager.registerDriver(driver);

			//Step2: get connection for database
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "root");

			//Step3: Issue create statement
			Statement state = con.createStatement();
			String query = "select * from testcases ;";

			//Step4: Execute query
			ResultSet result = state.executeQuery(query);

			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			}
		}

		//Step5: get connection for database

		catch(Exception e){

		}
		finally {
			con.close();
			System.out.println("Database closed sucessfully");
		}

	}

}
