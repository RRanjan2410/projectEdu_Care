package Admin_Module;

import java.util.ArrayList;

import org.apache.poi.sl.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.GradePage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class CreateGrade_GenericTest {
	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String url = fLib.readDataFromPropertyFile("url");
		String browser=fLib.readDataFromPropertyFile("browser");
		String un = fLib.readDataFromPropertyFile("username");
		String pw = fLib.readDataFromPropertyFile("password");
		
		int n=jLib.getRandomNumber();
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		LoginPage lg=new LoginPage(driver);
		lg.loginPage(un, pw);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnGradeLink();
//		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
//		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
//		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
//		
//		driver.findElement(By.linkText("Grade")).click();

//		ArrayList<String> grd=new ArrayList<String>();
//		grd.add("name");
//		grd.add("admission_fee");
//		grd.add("hall_charge");
		
//      ArrayList<String> grd = eLib.getList("Sheet1", 0);
//      // int  last1= elip. CreateExcelData("Grade");
//		Sheet sh1=wb.getSheet("Sheet1");
//		for(int i=0;i<=lastrow;i++) {
//			//String grddata = eLib..getcell("Grade",i, 1)+random;
//			driver.findElement(By.id(grd.get(i))).sendKeys(grddata);
//		}
		GradePage gp=new GradePage(driver);
		gp.createGrade(eLib, jLib);
		gp.clickOnSub1();
		Thread.sleep(1000);
		gp.enterGrade();

		gp.clickOnSub2();
		Thread.sleep(5000);
		gp.searchData(driver, eLib);
		
//		ArrayList<String> al = eLib.getList("Sheet1", 0);
//		int lastrow=eLib.getLastRowNo("Sheet1");
//		for(int i=0;i<=lastrow;i++)
//		{
//			String value = eLib.readDataFromExcelSheet("Sheet1", i, 1);
//			driver.findElement(By.id(al.get(i))).sendKeys(value+n);
//
//		}
//		
//		
//		driver.findElement(By.id("btnSubmit")).click();
//		driver.findElement(By.id("mark_range_text_1")).sendKeys("78-90");
//		driver.findElement(By.id("mark_grade_text_1")).sendKeys("B+");
//		driver.findElement(By.id("btnSubmit1")).click();
	}

}
