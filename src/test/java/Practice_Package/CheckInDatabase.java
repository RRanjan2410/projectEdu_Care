package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CheckInDatabase {

	public static void main(String[] args) throws InterruptedException, SQLException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("EduCare239");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Rishi");
		WebElement drop = driver.findElement(By.xpath("//select[@name='status']"));
		Select s=new Select(drop);
		s.selectByValue("Created");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		Connection con=null;
		Driver drive=new Driver();
			DriverManager.registerDriver(drive);
			con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "select * from project where created_by='Rishi';";
			ResultSet result = state.executeQuery(query);
			boolean flag = false;
			while(result.next())
			{
				String actualProject = result.getString(4);
				System.out.println(actualProject);
				if(actualProject.equalsIgnoreCase("EduCare23"))
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				System.out.println("project is created");
			}
			else
			{
				System.out.println("project is not created");
			}
		

		
		con.close();

	}

}
