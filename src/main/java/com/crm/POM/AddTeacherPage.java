package com.crm.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;

public class AddTeacherPage {
	@FindBy(xpath  = "//a[.=' Add Teacher']")
	private WebElement addTeacherLink;
	
	@FindBy(id = "index_number")
	private WebElement indexNum;
	
	@FindBy(id = "full_name")
	private WebElement fullName;
	
	@FindBy(id = "i_name")
	private WebElement nameWithInitial;
	
	@FindBy(id = "address")
	private WebElement addRess;
	
	@FindBy(id = "gender")
	private WebElement genDer;
	
	@FindBy(id = "phone")
	private WebElement phNo;
	
	@FindBy(id = "email")
	private WebElement emailId;
	
	@FindBy(id = "fileToUpload")
	private WebElement uploadPhoto;
	
	@FindBy(id = "btnSubmit")
	private WebElement subBttn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchClass;
	
	//utilization
	public AddTeacherPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddTeacherLink() {
		return addTeacherLink;
	}

	public WebElement getIndexNum() {
		return indexNum;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getNameWithInitial() {
		return nameWithInitial;
	}

	public WebElement getAddRess() {
		return addRess;
	}

	public WebElement getGenDer() {
		return genDer;
	}

	public WebElement getPhNo() {
		return phNo;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getUploadPhoto() {
		return uploadPhoto;
	}

	public WebElement getSubBttn() {
		return subBttn;
	}
	public WebElement getSearchClass() {
		return searchClass;
	}
	//business lib
	public void clickonAddTeacherLink() {
		addTeacherLink.click();
	}
	String expData=null;
	public void addTeacherData(ExcelUtility eLib,JavaUtility jLib,String visibletext,WebDriverUtility wLib) throws Throwable {
	String index=	eLib.readDataFromExcelSheet("Sheet3", 0, 1)+jLib.getRandomNumber();
	indexNum.sendKeys(index);
	String name=	eLib.readDataFromExcelSheet("sheet3", 1, 1)+jLib.getRandomNumber();
	fullName.sendKeys(name);
	String expData=	eLib.readDataFromExcelSheet("sheet3", 2, 1)+jLib.getRandomNumber();
	nameWithInitial.sendKeys(expData);
	String address=	eLib.readDataFromExcelSheet("sheet3", 3, 1)+jLib.getRandomNumber();
	addRess.sendKeys(address);
	
	String phno=	eLib.readDataFromExcelSheet("sheet3", 4, 1);
	phNo.sendKeys(jLib.getRandomNumber()+phno);
	String email=	eLib.readDataFromExcelSheet("sheet3", 5, 1);
	emailId.sendKeys(jLib.getRandomNumber()+email);
	}
	 public void gender(WebDriverUtility wLib) {
		 wLib.select("Male",genDer );;
	 }
	public void uploadPhoto(ExcelUtility eLib) throws Throwable {
		String photo = eLib.readDataFromExcelSheet("Sheet3", 6, 1);
		uploadPhoto.sendKeys(photo);
	}
	public void clickOnBtn() {
		subBttn.click();
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
