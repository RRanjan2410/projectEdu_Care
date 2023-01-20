package com.crm.GenricUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {
	
	public void getWindowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void elementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void select(WebElement element ,String value ) {
	Select s= new Select(element);
	s.deselectByValue(value);
	}
	
	public void select(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	public void select(String visibleText ,WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a= new Actions(driver);
		a.moveToElement(element);
	}
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dst);
	}
	
	public void doubleClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void rightClick(WebDriver driver) {
		Actions a= new Actions(driver);
		a.contextClick().perform();
	}
	
	public void enterKeyPress(WebDriver driver) {
		Actions a= new Actions(driver);
		a.sendKeys(Keys.ENTER);
	}
	
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot r= new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchTOFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver,String partialTitle) {
		
		//to get all the address of windows
		Set<String> allWh = driver.getWindowHandles();
		
		//iterate though windows
		Iterator<String> it = allWh.iterator();
		
		//check weather there is next window
		while(it.hasNext())
		{
			//capture first window id
			String wh = it.next();
			//switch to current window n get title
			 String cTitle = driver.switchTo().window(wh).getTitle();
		}
	}

}
