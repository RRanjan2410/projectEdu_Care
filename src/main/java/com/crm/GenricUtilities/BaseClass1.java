package com.crm.GenricUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.POM.ClassroomPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class BaseClass1 {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	
	@BeforeSuite
	public void configDB() throws Throwable {
		//dLib.connectToDB();
		System.out.println("======= connect to DB ======");
	}
	@Parameters("browser")
	@BeforeClass
	//public void configBC() throws Throwable {
		public void configBC(String browser) throws Throwable {
		System.out.println("====== launch the Browser ======");
		String URL=fLib.readDataFromPropertyFile("url");
		//String browser=fLib.readDataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "./com.crm.eduCare/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		sdriver=driver;
		//driver=new ChromeDriver();
		driver.get(URL);
		wLib.waitForPageLaod(driver);
		wLib.maximizeWindow(driver);
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("==== login to app ====");
		String un=fLib.readDataFromPropertyFile("username");
		String pw=fLib.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(un, pw);
	}
	
	@AfterMethod
	public void configAF() {
		System.out.println("==== logout from app ====");
		HomePage hp=new HomePage(driver);
		hp.clickOnAdminLink();
		hp.clickOnSignOutbutton();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("==== close the browser =====");
		driver.quit();
	}
	
	@AfterSuite
	public void configDb() throws Throwable {
		System.out.println("==== disconnect database ====");
		//dLib.con.close();
	}

}
