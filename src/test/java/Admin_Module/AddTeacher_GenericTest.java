package Admin_Module;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.AddTeacherPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class AddTeacher_GenericTest {

	public static void main(String[] args) throws Throwable {

		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		int n=jLib.getRandomNumber();
		//Step1: Get common data
		String url = fLib.readDataFromPropertyFile("url");
		String browser=fLib.readDataFromPropertyFile("browser");
		String un = fLib.readDataFromPropertyFile("username");
		String pw = fLib.readDataFromPropertyFile("password");

		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLaod(driver);
		driver.get(url);
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
	    driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		
	
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		driver.findElement(By.xpath("//a[.=' Add Teacher']")).click();

		ArrayList<String> al = eLib.getList("Sheet3", 0);
		int lastrow=eLib.getLastRowNo("Sheet3");
		for(int i=0;i<=lastrow;i++)
		{
			String value = eLib.readDataFromExcelSheet("Sheet3", i, 1);
			driver.findElement(By.id(al.get(i))).sendKeys(n+value);

		}
		WebElement gender = driver.findElement(By.id("gender"));
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\Rishi\\Desktop\\ash.jpg");

		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		driver.findElement(By.xpath("//a[text() = ' All Teacher']")).click();
		String expData = eLib.readDataFromExcelSheet("Sheet3", 2,1);

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expData);
		String actData = driver.findElement(By.xpath("//td[.='"+expData+"']")).getText();


		if(actData.contains(expData))
		{
			System.out.println("teacher added");
		}
		else {
			System.out.println("teacher not added");
		}


		//logout as Admin
		driver.findElement(By.xpath("//span[.='Admin A']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();

	}

}
