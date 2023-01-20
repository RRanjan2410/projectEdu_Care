package Admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenricUtilities.BaseClass1;
import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.ClassroomPage;
import com.crm.POM.GradePage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class CreateGrade_POMTest4 extends BaseClass1{
	
//	public static void main(String[] args) throws Throwable {
//		ExcelUtility eLib=new ExcelUtility();
//		FileUtility fLib=new FileUtility();
//		JavaUtility jLib=new JavaUtility();
//		WebDriverUtility wLib=new WebDriverUtility();
//		
//		String url = fLib.readDataFromPropertyFile("url");
//		String browser=fLib.readDataFromPropertyFile("browser");
//		String un = fLib.readDataFromPropertyFile("username");
//		String pw = fLib.readDataFromPropertyFile("password");
//		
//		int n=jLib.getRandomNumber();
//		
//		WebDriver driver=new ChromeDriver();
//		driver.get(url);
//		LoginPage lg=new LoginPage(driver);
//		lg.loginPage(un, pw);
//		
//		HomePage hp=new HomePage(driver);
//		hp.clickOnGradeLink();
//		
//		GradePage gp=new GradePage(driver);
//		gp.createGrade(eLib, jLib);
//		gp.clickOnSub1();
//		gp.enterGrade(eLib, jLib);
//
//		gp.clickOnSub2();
//		Thread.sleep(5000);
//		gp.serchData(driver);
	@Test
	public void configGrade() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOnGradeLink();
		GradePage gp=new GradePage(driver);
		gp.createGrade(eLib, jLib);
		gp.clickOnSub1();
		gp.enterGrade();
		gp.clickOnSub2();
		Thread.sleep(5000);
		//gp.searchData(driver, eLib);
		//String finalGrade=eLib.readDataFromExcelSheet("Sheet6", 3, 1);
	}
}
