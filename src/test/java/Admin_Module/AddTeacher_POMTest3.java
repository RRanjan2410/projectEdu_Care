package Admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenricUtilities.BaseClass1;
import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.AddTeacherPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

public class AddTeacher_POMTest3 extends BaseClass1 {
//	public static void main(String[] args) throws Throwable {
//
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
//		
//		HomePage hp=new HomePage(driver);
//		hp.clickOnTeacherLink();
//		AddTeacherPage at=new AddTeacherPage(driver);
//		at.clickonAddTeacherLink();
//		
//		at.addTeacherData(eLib, jLib, "Male", wLib);
//		at.gender(wLib);
//		at.uploadPhoto(eLib);
//		at.clickOnBtn();
//		
//		hp.clickOnAdminLink();
//		hp.clickOnSignOutbutton();
	@Test(groups = {"regression"})
	public void configTeacher() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOnTeacherLink();
		AddTeacherPage at=new AddTeacherPage(driver);
		at.clickonAddTeacherLink();
		at.addTeacherData(eLib, jLib, "Male", wLib);
		at.gender(wLib);
		at.uploadPhoto(eLib);
		at.clickOnBtn();
		Thread.sleep(5000);
	}
}
