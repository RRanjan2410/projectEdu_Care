package com.crm.POM;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;

public class ClassroomPage {
	
	@FindBy(id = "name")
	private WebElement clsName;
	
	@FindBy(id = "student_count")
	private WebElement studentCount;
	
	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchClass;
	//initilization
	public ClassroomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getClsName() {
		return clsName;
	}

	public WebElement getStudentCount() {
		return studentCount;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getSearchClass() {
		return searchClass;
	
	//business lib
	
	}
	String expData=null;
	String value2=null;
	public void classroomData(ExcelUtility eLib,JavaUtility jLib) throws Throwable {
		
		expData=eLib.readDataFromExcelSheet("Sheet4",0, 1)+jLib.getRandomNumber();
		clsName.sendKeys(expData);

		 value2=eLib.readDataFromExcelSheet("Sheet4", 1, 1)+jLib.getRandomNumber();
		studentCount.sendKeys(value2);
		
		
		
		
	}
		public void submitButn() {
		submitBtn.click();
		}
		public void wait(WebDriver driver,WebDriverUtility wLib) {
		wLib.elementToBeVisible(driver, submitBtn);
		
		
	}
		
		public void serchData(WebDriver driver) {
			searchClass.sendKeys(expData);
			 String actualData = driver.findElement(By.xpath("//td[.='"+expData+"']")).getText();
			
			if(actualData.contains(expData)) {
				System.out.println("created");
			}
			else {
				System.out.println("not created");
			}
			
		
	}

}
