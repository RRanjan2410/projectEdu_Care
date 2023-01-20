package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class UpdateDataInTYDatabase {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		//Step1: Register in database
		Driver driver=new Driver();
		//Step1: Register in database
		DriverManager.registerDriver(driver);
		
		//Step2:Get the connection from database
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		//update for issue 

	}

}
