package Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StudentManagement {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.='Classroom']")).click();
		driver.findElement(By.id("name")).sendKeys("Selenium by sandeep");
		driver.findElement(By.id("student_count")).sendKeys("23");
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Grade']")).click();
		driver.findElement(By.id("name")).sendKeys("S_BATCH_01");
		driver.findElement(By.id("admission_fee")).sendKeys("8000");
		driver.findElement(By.id("hall_charge")).sendKeys("500");
		driver.findElement(By.id("btnSubmit")).click();

		driver.findElement(By.id("mark_range_text_1")).sendKeys("85-95");
		driver.findElement(By.id("mark_grade_text_1")).sendKeys("A");
		driver.findElement(By.id("btnSubmit1")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Subject']")).click();
		driver.findElement(By.id("name")).sendKeys("selenuim");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		driver.findElement(By.xpath("//a[.=' Add Teacher']")).click();
		driver.findElement(By.xpath("//input[@id='index_number']")).sendKeys("SEL_OO1");
		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys("sandeep");
		driver.findElement(By.xpath("//input[@id='i_name']")).sendKeys("Sandeep Kothian");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Bengaluru");
		WebElement gender = driver.findElement(By.id("gender"));
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("123-456-7890");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sandeep@gmail.com");
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\Rishi\\Desktop\\as.png");
		
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.=' All Teacher']/child::i")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Sandeep");
		




		
		


	}

}
