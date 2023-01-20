package Admin_Module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddTeacher_ModuleTest {

	public static void main(String[] args) throws Throwable {
		//Get common data
		FileInputStream fis= new FileInputStream("./src/test/resources/common.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");

		//launch browser
		//String expT="all_teacher";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Login to the application
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();

		// Add teacher
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		driver.findElement(By.xpath("//a[.=' Add Teacher']")).click();
		//Read data from excel sheet
		FileInputStream fi=new FileInputStream("./src/test/resources/StudentManagementSystem.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		String index = wb.getSheet("Sheet3").getRow(0).getCell(0).getStringCellValue();
		String fname = wb.getSheet("Sheet3").getRow(1).getCell(0).getStringCellValue();
		String namei = wb.getSheet("Sheet3").getRow(2).getCell(0).getStringCellValue();
		String address = wb.getSheet("Sheet3").getRow(3).getCell(0).getStringCellValue();
		String phno = wb.getSheet("Sheet3").getRow(4).getCell(0).getStringCellValue();
		String email = wb.getSheet("Sheet3").getRow(5).getCell(0).getStringCellValue();


		driver.findElement(By.xpath("//input[@id='index_number']")).sendKeys(index);
		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='i_name']")).sendKeys(namei);
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys(address);
		WebElement gender = driver.findElement(By.id("gender"));
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phno);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\Rishi\\Desktop\\as.png");

		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		Thread.sleep(5000);
		Set<String> allid = driver.getWindowHandles();
		String mainid = driver.getWindowHandle();
		for(String wid :allid)
		{
			if(!wid.equals(mainid))
			{
				driver.switchTo().window(wid);
				driver.findElement(By.xpath("//span[.='Teacher']")).click();
				driver.findElement(By.xpath("//a[text() = ' All Teacher']")).click();
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(namei);
				System.out.println("teacher is added");
			}
			else {
				System.out.println("teacher not added");
			}
		}
	}
}


