package Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DiffrentAnnotations {
	
	@BeforeSuite
	public void conecToDb() {
		System.out.println("connect to database");
	}
	
	@BeforeClass
	public void openBrowser() {
		System.out.println("launch the browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("login to the application");
	}
	
	@Test
	public void createClass() {
		System.out.println("classroom created");
	}
	
	@Test(priority = 1,dependsOnMethods ="createClass" )
	public void createGrade() {
		System.out.println("Grade added");
	}
	
	@Test(priority = 2)
	public void addTeacher() {
		System.out.println("teacher added");
	}
	
	@Test(priority = 3,dependsOnMethods = "createClass")
	public void addStudent() {
		System.out.println("Student added");
	}
	
	@Test(priority = 4)
	public void addSubject() {
		System.out.println("subject added");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("logout of the application");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("close the browser");
	}
	  
	
	@AfterSuite
	public void disconectToDb() {
		System.out.println("discnnect from database");
	}	

}
