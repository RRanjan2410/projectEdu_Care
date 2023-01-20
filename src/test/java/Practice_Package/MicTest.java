package Practice_Package;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicTest {

	public static void main(String[] args) throws Throwable {
		
	    ChromeOptions option=new ChromeOptions();
	    option.addArguments("use-fake-ui-for-media-stream");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mictests.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("mic-launcher")).click();
		
		String text = driver.findElement(By.xpath("//li[@class='notice-done done_testingComplete']")).getText();
		System.out.println(text);
		
		
		

	}

}
