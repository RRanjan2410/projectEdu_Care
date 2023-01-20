package Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateMMT {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action= new Actions(driver);
		action.moveByOffset(0, 0).click().build().perform();
		//WebElement value = driver.findElement(By.xpath("//body[@class='desktop in webp']"));
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(value));
		Thread.sleep(4000);
		Actions action1= new Actions(driver);
		action1.moveByOffset(0, 0).click().build().perform();
		
		String src="delhi";
		 driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		WebElement from = driver.findElement(By.id("fromCity"));
		from.sendKeys(src);
		driver.findElement(By.xpath("//p[.='New Delhi, India']")).click();
		
		String dest="bengaluru";
		 //driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		WebElement to = driver.findElement(By.id("toCity"));
		to.sendKeys(dest);
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		
		
		}

}
