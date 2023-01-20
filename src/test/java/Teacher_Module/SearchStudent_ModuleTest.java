package Teacher_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchStudent_ModuleTest {

	public static void main(String[] args) throws Throwable {
		Random ran=new Random();
		int random=ran.nextInt();
		String gr="grade128";
		//Step1: Get common data
		FileInputStream fis= new FileInputStream("./src/test/resources/common.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String un1=p.getProperty("username1");
		String pw = p.getProperty("password");

		//step2: Read data from excel sheet
		FileInputStream fi=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet5");
		
		/*String pindex = wb.getSheet("Sheet5").getRow(8).getCell(0).getStringCellValue();
		String pfname = wb.getSheet("Sheet5").getRow(9).getCell(0).getStringCellValue();
		String pnamei = wb.getSheet("Sheet5").getRow(10).getCell(0).getStringCellValue();
		String paddress = wb.getSheet("Sheet5").getRow(11).getCell(0).getStringCellValue();
		String pemail = wb.getSheet("Sheet5").getRow(12).getCell(0).getStringCellValue();
		String pphno = wb.getSheet("Sheet5").getRow(13).getCell(0).getStringCellValue();
		String pdob = wb.getSheet("Sheet5").getRow(14).getCell(0).getStringCellValue();*/

		//String data = sh.getRow(1).getCell(0).getStringCellValue()+random;

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Step3: Login to the application
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();

		driver.findElement(By.xpath("//span[.='Student']")).click();
		driver.findElement(By.xpath("//a[.=' Add Student']")).click();
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("index_number");
		al.add("full_name");
		al.add("i_name");
		al.add("address");
		al.add("email");
		al.add("phone");
		al.add("b_date");
		al.add("g_full_name");
		al.add("g_i_name");
		al.add("g_address");
		al.add("g_email");
		al.add("g_phone");
		al.add("g_b_date");
		
		for (int i = 0; i <=6; i++) {
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(al.get(i))).sendKeys(value);	

		}

		/*driver.findElement(By.xpath("//input[@name='index_number']")).sendKeys(index);
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name='i_name']")).sendKeys(namei);
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phno);
		driver.findElement(By.xpath("//input[@name='b_date']")).sendKeys(dob);*/
		WebElement gender = driver.findElement(By.id("gender"));
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\Rishi\\Desktop\\63.jpg");
		Thread.sleep(1000);
		
		
		
		for (int i = 7; i <=12; i++) {
			String value = sh.getRow(i).getCell(1).toString();
			driver.findElement(By.name(al.get(i))).sendKeys(value);	

		}
		/*driver.findElement(By.xpath("//input[@name='index_number']")).sendKeys(pindex);
		driver.findElement(By.xpath("//input[@name='g_full_name']")).sendKeys(pfname);
		driver.findElement(By.xpath("//input[@name='g_i_name']")).sendKeys(pnamei);
		driver.findElement(By.xpath("//input[@name='g_address']")).sendKeys(paddress);
		driver.findElement(By.xpath("//input[@name='g_email']")).sendKeys(pemail);
		driver.findElement(By.xpath("//input[@name='g_phone']")).sendKeys(pphno);
		driver.findElement(By.xpath("//input[@name='g_b_date']")).sendKeys(pdob);*/
		WebElement pgender = driver.findElement(By.id("g_gender"));
		Select ps=new Select(pgender);
		ps.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@name='g_fileToUpload']")).sendKeys("C:\\Users\\Rishi\\Desktop\\35.jpg");
		
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		WebElement grade = driver.findElement(By.id("grade"));
		Select g= new Select(grade);
		g.selectByVisibleText(gr);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSubmit1']/child::span")).click();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,0)");
		//driver.findElement(By.xpath("//button[@id='btnSubmit1' and text()='Paid']")).click();
		driver.findElement(By.xpath("//div[@class='panel panel-info']/descendant::span[@class='glyphicon glyphicon-remove']")).click();
		
		//logout as Admin
		driver.findElement(By.xpath("//span[.='Admin A']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
		//login as Teacher
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(un1);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		//search for Student
		driver.findElement(By.xpath("//span[.='My Student']")).click();
		WebElement g1 = driver.findElement(By.id("grade"));
		Select s1=new Select(g1);
		s1.selectByVisibleText(gr);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys();
		String search = driver.findElement(By.xpath("//h3[.='My Student']")).getText();
		String tab = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']")).getText();
		
		
		
		if(search.contains(tab))
		{
			System.out.println("Student is present in database");
		}
		else {
			System.out.println("Student details not in database");
		}
		
		//logout as teacher
		
		driver.findElement(By.xpath("//span[.='nawaz1']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();




	}

}
