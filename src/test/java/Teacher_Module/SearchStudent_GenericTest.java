package Teacher_Module;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.AddStudentPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class SearchStudent_GenericTest {

	public static void main(String[] args) throws Throwable {
		//WebDriver driver= null;
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		jLib.getRandomNumber();
		//Step1: Get common data
		String url = fLib.readDataFromPropertyFile("url");
		String browser=fLib.readDataFromPropertyFile("browser");
		String un = fLib.readDataFromPropertyFile("username");
		String un1=fLib.readDataFromPropertyFile("username1");
		String pw = fLib.readDataFromPropertyFile("password");

		String gr="grade128";
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLaod(driver);
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();

		//click on student and add Student
		driver.findElement(By.xpath("//span[.='Student']")).click();
		driver.findElement(By.xpath("//a[.=' Add Student']")).click();

		//step2: Read data from excel sheet
		int n = jLib.getRandomNumber();
		ArrayList<String> al=eLib.getList("Sheet5", 0);
		System.out.println(al);
		int lastrownum=eLib.getLastRowNo("Sheet5");
		System.out.println(lastrownum);
		String expname = eLib.readDataFromExcelSheet("Sheet5", 0, 1);
		for(int i=0;i<=lastrownum;i++)
		{
			String value=eLib.readDataFromExcelSheet("Sheet5",i, 1);
			driver.findElement(By.name(al.get(i))).sendKeys(n+value);

		}
		WebElement gender = driver.findElement(By.id("gender"));
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\Rishi\\Desktop\\63.jpg");


		WebElement pgender = driver.findElement(By.id("g_gender"));
		Select ps=new Select(pgender);
		ps.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@name='g_fileToUpload']")).sendKeys("C:\\Users\\Rishi\\Desktop\\35.jpg");

		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();

		WebElement grade = driver.findElement(By.id("grade"));
		Select g= new Select(grade);
		g.selectByVisibleText(gr);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSubmit1']/child::span")).click();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,0)");
		//driver.findElement(By.xpath("//button[@id='btnSubmit1' and text()='Paid']")).click();
	driver.findElement(By.xpath("//div[@class='panel panel-info']/descendant::span[@class='glyphicon glyphicon-remove']")).click();

		//logout as Admin
		driver.findElement(By.xpath("//span[.='Admin A']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();

		//login as Teacher
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un1);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();

		driver.findElement(By.xpath("//span[.='My Student']")).click();
		WebElement g1 = driver.findElement(By.id("grade"));
		Select s1=new Select(g1);
		s1.selectByVisibleText(gr);
		driver.findElement(By.xpath("//button[.='Submit']")).click();

		String expData = n+expname;

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expData);
		String actData = driver.findElement(By.xpath("//a[text()='"+expData+"']")).getText();

		if(actData.contains(expData))
		{
			System.out.println("Student is present");
		}
		else {
			System.out.println("Student not present");
		}


		//logout as teacher
	driver.findElement(By.xpath("//span[.='nawaz1']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
	}
}


