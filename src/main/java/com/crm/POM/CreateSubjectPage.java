package com.crm.POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.JavaUtility;

public class CreateSubjectPage {
	
	@FindBy(id = "name")
	private WebElement subName;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchSubject;
	
	public CreateSubjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubName() {
		return subName;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
		
		public WebElement getSearchSubject() {
			return searchSubject;
	}

		//business lib
		
		String expData=null;
	public void createSubject(ExcelUtility eLib,JavaUtility jLib) throws Throwable {
		 expData = eLib.readDataFromExcelSheet("Sheet2", 0, 1)+jLib.getRandomNumber();
		 subName.sendKeys(expData);
		
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
	public void serchData(WebDriver driver) {
		searchSubject.sendKeys(expData);
		 String actualData = driver.findElement(By.xpath("//td[.='"+expData+"']")).getText();
		
		if(actualData.contains(expData)) {
			System.out.println("created");
		}
		else {
			System.out.println("not created");
		}
	}
}


