package Admin_Module;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenricUtilities.BaseClass1;
import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;
import com.crm.POM.ClassroomPage;
import com.crm.POM.HomePage;
import com.crm.POM.LoginPage;

//@Listeners(com.crm.GenricUtilities.ListenerImplementaion.class)
public class AddClassroom_POMTest1  extends BaseClass1{
//	public static void main(String[] args) throws Throwable {
//		ExcelUtility eLib=new ExcelUtility();
//		FileUtility fLib=new FileUtility();
//		JavaUtility jLib=new JavaUtility();
//		WebDriverUtility wLib=new WebDriverUtility();
//
//		int n = jLib.getRandomNumber();
		//Step1: Get common data
//		String url = fLib.readDataFromPropertyFile("url");
//		String browser=fLib.readDataFromPropertyFile("browser");
//		String un = fLib.readDataFromPropertyFile("username");
//		String pw = fLib.readDataFromPropertyFile("password");
//
//		WebDriver driver=new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLaod(driver);
//		driver.get(url);
//		LoginPage lp=new LoginPage(driver);
//		lp.loginPage(un, pw);
//		HomePage hm=new HomePage(driver);
//		hm.clickOnClassromLink();
//		ClassroomPage cl=new ClassroomPage(driver);
//		cl.classroomData(eLib, jLib);
//		cl.submitButn();
//		
//		
//		Thread.sleep(5000);
//		cl.serchData(driver);
//		
//		hm.clickOnAdminLink();
//		hm.clickOnSignOutbutton();
		@Test(/*retryAnalyzer = com.crm.GenricUtilities.RetryAnalyserImpClass.class*/)
		public void executeConfig() throws Throwable {
			HomePage hp=new HomePage(driver);
			hp.clickOnClassromLink();
			
			ClassroomPage cl=new ClassroomPage(driver);
			//cl.classroomData(eLib, jLib);
			cl.submitButn();
			Thread.sleep(5000);
			
			cl.serchData(driver);
			
		}
			
//	@Test
//	public void testSample1() {
//		System.out.println("---sample1---");
//		
//	}
//	
//	@Test
//	public void testSample2() {
//		System.out.println("---sample2---");
//	}


}
