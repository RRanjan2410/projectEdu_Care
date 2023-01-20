package Teacher_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;

public class MySubject_GenericTest {

	public static void main(String[] args) throws Throwable {
		
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String gr="grade128";
		
		//use common data
		String url = fLib.readDataFromPropertyFile("url");
		String un1 = fLib.readDataFromPropertyFile("username1");
		String pw = fLib.readDataFromPropertyFile("password");
		
		
		//open the browser
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		//login to application as teacher
		
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un1);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		//click on my subject and search the subject
		driver.findElement(By.xpath("//span[.='My Student']")).click();
		
		WebElement grade = driver.findElement(By.id("grade"));
		Select s=new Select(grade);
		s.selectByVisibleText(gr);
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		int n = jLib.getRandomNumber();
		 
		String expData = eLib.readDataFromExcelSheet("Sheet5", 2,1 );
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expData);
		String actData = driver.findElement(By.xpath("//td[.='"+expData+"']")).getText();
	
		if(actData.contains(expData))
		{
			System.out.println("Student is present");
		}
		else {
			System.out.println("Student not present");
		}	
	}
}
