package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class AddProjectTest {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		try
		{
			Driver driver=new Driver();
			//Step1: Register the database
			DriverManager.registerDriver(driver);

			//Step2: get connection for database
			con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			//Step3: Issue create statement
			Statement state = con.createStatement();
			String query = "insert into project values ('TY_project_024','Rishi','sdet45','21/12/2022','created',3);";

			//Step4: Execute query
			result = state.executeUpdate(query);

		}

		catch(Exception e){

		}
		finally {
			if(result==1)
			{
				System.out.println("Values inserted sucessfully");
			}
			else
			{
				System.out.println("Values not inserted");
			}
			con.close();
			System.out.println("Database closed sucessfully");
		}

	}


}
