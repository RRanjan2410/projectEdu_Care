package Teacher_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenricUtilities.BaseClass1;
import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.AddStudentPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;
@Listeners(com.crm.GenricUtilities.ListenerImplementaion.class)

public class SearchStudent_POMTest5 extends BaseClass1 {
	
//	public static void main(String[] args) throws Throwable {
//		//WebDriver driver= null;
//		ExcelUtility eLib=new ExcelUtility();
//		FileUtility fLib=new FileUtility();
//		JavaUtility jLib=new JavaUtility();
//		WebDriverUtility wLib=new WebDriverUtility();
//
//		jLib.getRandomNumber();
////		//Step1: Get common data
//		String url = fLib.readDataFromPropertyFile("url");
//		String browser=fLib.readDataFromPropertyFile("browser");
//		String un = fLib.readDataFromPropertyFile("username");
//		String un1=fLib.readDataFromPropertyFile("username1");
//		String pw = fLib.readDataFromPropertyFile("password");
//
//		//String gr="grade128";
//		WebDriver driver=new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLaod(driver);
//		driver.get(url);
//		
//		LoginPage lg=new LoginPage(driver);
//		lg.loginPage(un, pw);
//		
//		HomePage hm=new HomePage(driver);
//		hm.clickOnStudentLink();
//		
//		AddStudentPage ads=new AddStudentPage(driver);
//		ads.clickOnAddStudentLink();
//		ads.addStudentData(eLib, jLib, "Male", wLib);
//		ads.submit1();
//		
//		ads.addGrade(wLib, "grade128");
//		ads.clickCheckBox();;
//		ads.submit2();
//		ads.finalClose();
//		hm.clickOnAdminLink();
//		hm.clickOnSignOutbutton();
	@Test(groups = {"smoke","regression"})
	public void configStudent() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOnStudentLink();
		
		AddStudentPage asp=new AddStudentPage(driver);
		asp.clickOnAddStudentLink();
		asp.addStudentData(eLib, jLib, "Male", wLib);
		asp.submit1();
		asp.addGrade(wLib, "grade128");
		asp.clickCheckBox();
		asp.submit2();
		asp.finalClose();
	}
}
