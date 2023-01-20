package com.crm.POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.JavaUtility;

public class GradePage {
	@FindBy(id = "name")
	private WebElement gNmae;
	
	@FindBy(id = "admission_fee")
	private WebElement admissionFee;
	
	@FindBy(id = "hall_charge")
	private WebElement hallCharge;
	
	@FindBy(id = "btnSubmit")
	private WebElement submitButton1;
	
	@FindAll({@FindBy(id = "mark_range_text_1"),@FindBy(name = "mark-range form-control")})
	private WebElement enterRange;
	
	@FindAll({@FindBy(id = "mark_grade_text_1"),@FindBy(name = "mark-grade form-control")})
	private WebElement enterGrade;
	
	@FindBy(id = "btnSubmit1")
	private WebElement submittBtn2;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchGrade;
	
	public GradePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getgNmae() {
		return gNmae;
	}

	public WebElement getAdmissionFee() {
		return admissionFee;
	}

	public WebElement getHallCharge() {
		return hallCharge;
	}

	public WebElement getSubmitButton() {
		return submitButton1;
	}
	

	public WebElement getEnterRange() {
		return enterRange;
	}

	public WebElement getEnterGrade() {
		return enterGrade;
	}
	

	public WebElement getSubmittBtn() {
		return submittBtn2;
	}
	public WebElement getSearchClass() {
		return searchGrade;
	
	}
String expData=null;
	public void createGrade(ExcelUtility eLib,JavaUtility jLib) throws Throwable {
		String expData = eLib.readDataFromExcelSheet("Sheet6", 0, 1)+jLib.getRandomNumber();
		gNmae.sendKeys(expData);
		String v1 = eLib.readDataFromExcelSheet("Sheet6", 1, 1);
		admissionFee.sendKeys(v1);
		String v2 = eLib.readDataFromExcelSheet("Sheet6", 2, 1);
		hallCharge.sendKeys(v2);
//		int lastrownum=eLib.getLastRowNo("Sheet1");
//		for(int i=0;i<=lastrownum;i++) {
//		String value1=eLib.readDataFromExcelSheet("Sheet1",i, 1);
//		driver.findElement(By.id(value.get(i))).sendKeys(value1+jLib.getRandomNumber());
//		}
	}
	//business Library
	
	public void clickOnSub1() {
		submitButton1.click();
	}
	
//	public void enterGrade(ExcelUtility eLib,JavaUtility jLib) throws Throwable {
//		String marksrange = eLib.readDataFromExcelSheet("Sheet1", 3, 1);
//		String grade=eLib.readDataFromExcelSheet("Sheet1", 4, 1);
//		
//	}
	
	public void enterGrade() throws Throwable {
		enterRange.sendKeys("85-100");
		enterGrade.sendKeys("A");
		
	}
	public void clickOnSub2() {
			submittBtn2.click();
	}
	public void searchData(WebDriver driver,ExcelUtility eLib) throws Throwable {
		searchGrade.sendKeys(expData);
		 String actualData = driver.findElement(By.xpath("//td[.='"+expData+"']")).getText();
		
		if(actualData.contains(expData)) {
			System.out.println("created");
		}
		else {
			System.out.println("not created");
		}
//eLib.writeDataIntoExcelSheet("Sheet6", 3, 1, expData);
}

	
}
