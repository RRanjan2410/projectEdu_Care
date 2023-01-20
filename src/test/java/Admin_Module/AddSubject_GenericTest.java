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
import com.crm.POM.CreateSubjectPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class AddSubject_GenericTest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		jLib.getRandomNumber();
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

		driver.findElement(By.xpath("//span[.='Subject']")).click();

		ArrayList<String> al=eLib.getList("Sheet2", 0);
		System.out.println(al);
		int lastrownum=eLib.getLastRowNo("Sheet2");
		System.out.println(lastrownum);
		for(int i=0;i<=lastrownum;i++)
		{
			String value=eLib.readDataFromExcelSheet("Sheet2",i, 1);
			driver.findElement(By.id(al.get(i))).sendKeys(value);
		}

		driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(5000);
		

		String expData = eLib.readDataFromExcelSheet("Sheet2", 0,1);

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expData);
		String actData = driver.findElement(By.xpath("//td[.='"+expData+"']")).getText();


		if(actData.contains(expData))
		{
			System.out.println("subject created");
		}
		else {
			System.out.println("Subject not created");
		}

		/*WebElement getLast = driver.findElement(By.name("example1_length"));
		Select se=new Select(getLast);
		se.selectByValue("100");*/

		String adata = driver.findElement(By.xpath("(//tbody/descendant::tr[last()]/td[2])[1]")).getText();
		System.out.println(adata);

		//logout as Admin
		driver.findElement(By.xpath("//span[.='Admin A']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		

	}

}
