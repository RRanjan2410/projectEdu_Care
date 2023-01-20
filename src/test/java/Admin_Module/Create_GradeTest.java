package Admin_Module;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_GradeTest {

	public static void main(String[] args) throws Throwable {
		Random ran=new Random();
		int random=ran.nextInt(500);
		
		//Step1: Get common data
		FileInputStream fis= new FileInputStream("./src/test/resources/common.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		
		//step2: Read data from excel sheet
		FileInputStream fi=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet6");
		//String data = sh.getRow(1).getCell(0).getStringCellValue()+random;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step3: Login to the application
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		//create Grade
		driver.findElement(By.xpath("//span[.='Grade']")).click();
		//driver.findElement(By.id("name")).sendKeys();
		//driver.findElement(By.id("admission_fee")).sendKeys("8000");
		//driver.findElement(By.id("hall_charge")).sendKeys("500");
		//driver.findElement(By.id("btnSubmit")).click();
		ArrayList<String> al=new ArrayList<String>();
		al.add("name");
		al.add("admission_fee");
		al.add("hall_charge");
		for (int i = 0; i <=sh.getLastRowNum(); i++) {
			String value = sh.getRow(i).getCell(1).getStringCellValue()+random;
			driver.findElement(By.name(al.get(i))).sendKeys(value);	
		
		driver.findElement(By.xpath("//button[.='Next']")).click();
		}
		//driver.findElement(By.xpath("//button[.='Next']")).click();
		Thread.sleep(1000);
		//String exp="Add eMarks Range & Grade";
		//String ele=driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		//if(exp.equalsIgnoreCase(ele))
		//{
		driver.findElement(By.id("mark_range_text_1")).sendKeys("78-90");
		driver.findElement(By.id("mark_grade_text_1")).sendKeys("B+");
		driver.findElement(By.id("btnSubmit1")).click();
         
		
//		driver.findElement(By.xpath("//button[.='Submit']")).submit();
//		//driver.findElement(By.xpath("//div[@class='panel-heading']")).click();
//		Thread.sleep(5000);

		//al.add("mark_range[]");
		//al.add("mark_grade[]");
		//driver.findElement(By.id("btnSubmit1")).click();
		
		
	}
	

}
