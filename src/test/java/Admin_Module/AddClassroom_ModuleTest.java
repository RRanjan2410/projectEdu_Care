package Admin_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddClassroom_ModuleTest {

	public static void main(String[] args) throws Throwable {
		//Step1: Get common data
		FileInputStream fis= new FileInputStream("./src/test/resources/common.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");

		//launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Step2: Login to the application
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		//add classroom
		driver.findElement(By.xpath("//span[.='Classroom']")).click();
		//Read data from excel sheet
				FileInputStream fi=new FileInputStream("./src/test/resources/StudentManagementSystem.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				String classr = wb.getSheet("Sheet4").getRow(0).getCell(0).getStringCellValue();
				String count = wb.getSheet("Sheet4").getRow(1).getCell(0).getStringCellValue();
				
				driver.findElement(By.id("name")).sendKeys(classr);
				driver.findElement(By.id("student_count")).sendKeys(count);
				driver.findElement(By.id("btnSubmit")).click();
				Thread.sleep(5000);
			
				// search classroom created or not
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(classr);
				
				if(classr.contains(classr))
				{
					System.out.println("classroom created");
				}
				else {
					System.out.println("classroom not created");
				}

	}

}
