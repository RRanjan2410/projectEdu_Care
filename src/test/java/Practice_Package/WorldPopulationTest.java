package Practice_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulationTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		String text = driver.findElement(By.xpath("//div[@class='maincounter-number']")).getText();
		System.out.println(text);

	}

}
