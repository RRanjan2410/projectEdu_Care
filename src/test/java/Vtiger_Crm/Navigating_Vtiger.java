package Vtiger_Crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.FileUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;

public class Navigating_Vtiger {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		//get common data
		String url = fLib.readDataFromPropertyFile("url2");
		String un2 = fLib.readDataFromPropertyFile("username2");
		String pw2 = fLib.readDataFromPropertyFile("password2");
		
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLaod(driver);
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un2);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw2);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		WebElement cli = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(cli).perform(); 
		
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']")).click();

	}

}
