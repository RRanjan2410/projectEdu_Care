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
import com.crm.POM.ClassroomPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class AddClassroom_GenericTest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		int n = jLib.getRandomNumber();
		//Step1: Get common data
		String url = fLib.readDataFromPropertyFile("url");
		String browser=fLib.readDataFromPropertyFile("browser");
		String un = fLib.readDataFromPropertyFile("username");
		String pw = fLib.readDataFromPropertyFile("password");

		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLaod(driver);
		driver.get(url);
		
		
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();

		driver.findElement(By.xpath("//span[.='Classroom']")).click();
		
		
		Thread.sleep(5000);
		
		
		ArrayList<String> al=eLib.getList("Sheet4", 0);
		System.out.println(al);
		int lastrownum=eLib.getLastRowNo("Sheet4");
		System.out.println(lastrownum);
		for(int i=0;i<=lastrownum;i++)
		{
			String value=eLib.readDataFromExcelSheet("Sheet4",i, 1);
			driver.findElement(By.id(al.get(i))).sendKeys(value+n);
		}
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		WebElement success=driver.findElement(By.id("update_Success"));
		wLib.elementToBeVisible(driver, success);

	String expData = eLib.readDataFromExcelSheet("Sheet4", 0,1);
		
	

	String data = driver.findElement(By.xpath("//input[@type='search']")).getText();
		String actData = driver.findElement(By.xpath("//td[.='"+expData+"']")).getText();


		if(actData.contains(expData))
		{
			System.out.println("classroom created");
		}
		else {
			System.out.println("classroom not created");
		}

		//logout as Admin
		driver.findElement(By.xpath("//span[.='Admin A']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();

	}

}
