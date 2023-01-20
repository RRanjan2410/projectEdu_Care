package Admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenricUtilities.BaseClass1;
import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.CreateSubjectPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class AddSubject_POMTest2 extends BaseClass1{
//	public static void main(String[] args) throws Throwable {
//		ExcelUtility eLib=new ExcelUtility();
//		FileUtility fLib=new FileUtility();
//		JavaUtility jLib=new JavaUtility();
//		WebDriverUtility wLib=new WebDriverUtility();
//
//		jLib.getRandomNumber();
//		//Step1: Get common data
//		String url = fLib.readDataFromPropertyFile("url");
//		String browser=fLib.readDataFromPropertyFile("browser");
//		String un = fLib.readDataFromPropertyFile("username");
//		String pw = fLib.readDataFromPropertyFile("password");
//
//		WebDriver driver=new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLaod(driver);
//		driver.get(url);
//		LoginPage lg=new LoginPage(driver);
//		lg.loginPage(un, pw);
//		HomePage hm=new HomePage(driver);
//		hm.clickOnSubjectLink();
//		
//		CreateSubjectPage csp=new CreateSubjectPage(driver);
//		csp.createSubject(eLib, jLib);
//		csp.submitBtn();
//		
//		Thread.sleep(5000);
//		csp.serchData(driver);
//		hm.clickOnAdminLink();
//		hm.clickOnSignOutbutton();
	@Test(groups = {"smoke"})
	public void configSubject() throws Throwable {
		HomePage hp= new HomePage(driver);
		hp.clickOnSubjectLink();
		
		CreateSubjectPage csp=new CreateSubjectPage(driver);
		csp.createSubject(eLib, jLib);
		csp.submitBtn();
		Thread.sleep(5000);
		csp.serchData(driver);
	}
}
