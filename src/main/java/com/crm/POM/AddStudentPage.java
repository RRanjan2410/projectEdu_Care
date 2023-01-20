package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtilities.ExcelUtility;
import com.crm.GenricUtilities.JavaUtility;
import com.crm.GenricUtilities.WebDriverUtility;

public class AddStudentPage {
	

	@FindBy(xpath = "//a[.=' Add Student']")
	private WebElement addStudentLink;
	
	@FindBy(id = "index_number")
	private WebElement studIndex;
	
	@FindBy(id = "full_name")
	private WebElement studFullName;
	
	@FindBy(id = "i_name")
	private WebElement studInitialName;
	
	@FindBy(id = "address")
	private WebElement studAddress;
	
	@FindBy(id = "email")
	private WebElement studEmail;
	
	@FindBy(id = "phone")
	private WebElement studPhno;
	
	@FindBy(id = "b_date")
	private WebElement studBday;
	
	@FindBy(xpath = "//select[@id='gender']")
	private WebElement studGender;
	
	@FindBy(id = "fileToUpload")
	private WebElement studPhoto;
	
	@FindBy(id = "g_full_name")
	private WebElement parentFullName;
	
	@FindBy(id = "g_i_name")
	private WebElement parentInitialName;
	
	@FindBy(id = "g_address")
	private WebElement parentAddress;
	
	@FindBy(id = "g_email")
	private WebElement parentEmail;
	
	@FindBy(id = "g_phone")
	private WebElement parentPhno;
	
	@FindBy(id = "g_b_date")
	private WebElement parentBday;
	
	@FindBy(id = "g_gender")
	private WebElement parentGender;
	
	@FindBy(id = "g_fileToUpload")
	private WebElement parentPhoto;
	
	@FindBy(id = "btnSubmit")
	private WebElement nextButton;
	
	@FindBy(xpath = "//select[@id='grade']")
	private WebElement addGrade;
	
	@FindAll({@FindBy(id = "checkbox"),@FindBy(name = "checkbox[]"),@FindBy(xpath = "//input[@type='checkbox']")})
	private WebElement checkBox;
	
	@FindBy(id = "btnSubmit1")
	private WebElement submit;
	
	@FindBy(xpath = "//div[@class='panel panel-info']/descendant::span[@class='glyphicon glyphicon-remove']")
	private WebElement closeBtn;
	
	
	//Initialization
	
	public AddStudentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization


	public WebElement getAddStudentLink() {
		return addStudentLink;
	}

	public WebElement getStudIndex() {
		return studIndex;
	}

	public WebElement getStudFullName() {
		return studFullName;
	}

	public WebElement getStudInitialName() {
		return studInitialName;
	}

	public WebElement getStudAddress() {
		return studAddress;
	}

	public WebElement getStudEmail() {
		return studEmail;
	}

	public WebElement getStudPhno() {
		return studPhno;
	}

	public WebElement getStudBday() {
		return studBday;
	}

	public WebElement getStudGender() {
		return studGender;
	}

	public WebElement getStudPhoto() {
		return studPhoto;
	}

	public WebElement getParentFullName() {
		return parentFullName;
	}

	public WebElement getParentInitialName() {
		return parentInitialName;
	}

	public WebElement getParentAddress() {
		return parentAddress;
	}

	public WebElement getParentEmail() {
		return parentEmail;
	}

	public WebElement getParentPhno() {
		return parentPhno;
	}

	public WebElement getParentBday() {
		return parentBday;
	}

	public WebElement getParentGender() {
		return parentGender;
	}

	public WebElement getParentPhoto() {
		return parentPhoto;
	}

	public WebElement getNextButton() {
		return nextButton;
	}
	
	public WebElement getCloseBtn() {
		return closeBtn;
	}

	//business Lib

	public void clickOnAddStudentLink() {
		addStudentLink.click();
	}
	
	public void addStudentData(ExcelUtility eLib,JavaUtility jLib,String visibletext,WebDriverUtility wLib) throws Throwable {
		String sindex = eLib.readDataFromExcelSheet("Sheet5", 0, 1)+jLib.getRandomNumber();
		studIndex.sendKeys(sindex);
		String sname = eLib.readDataFromExcelSheet("Sheet5", 1, 1)+jLib.getRandomNumber();
		studFullName.sendKeys(sname);
		String sIname=eLib.readDataFromExcelSheet("Sheet5", 2, 1)+jLib.getRandomNumber();
		studInitialName.sendKeys(sIname);
		String saddress = eLib.readDataFromExcelSheet("Sheet5", 3, 1)+jLib.getRandomNumber();
		studAddress.sendKeys(saddress);
		String semail = eLib.readDataFromExcelSheet("Sheet5", 4, 1);
		studEmail.sendKeys(jLib.getRandomNumber()+semail);
		String sphone = eLib.readDataFromExcelSheet("Sheet5", 5, 1);
		studPhno.sendKeys(jLib.getRandomNumber()+sphone);
		String sdob = eLib.readDataFromExcelSheet("Sheet5", 6, 1);
		studBday.sendKeys(jLib.getRandomNumber()+sdob);
		
		String pname = eLib.readDataFromExcelSheet("Sheet5", 7, 1)+jLib.getRandomNumber();
		parentFullName.sendKeys(pname);
		String pIname=eLib.readDataFromExcelSheet("Sheet5", 8, 1)+jLib.getRandomNumber();
		parentInitialName.sendKeys(pIname);
		String paddress = eLib.readDataFromExcelSheet("Sheet5", 9, 1)+jLib.getRandomNumber();
		parentAddress.sendKeys(paddress);
		String pemail = eLib.readDataFromExcelSheet("Sheet5", 10, 1);
		parentEmail.sendKeys(jLib.getRandomNumber()+pemail);
		String pphone = eLib.readDataFromExcelSheet("Sheet5", 11, 1);
		parentPhno.sendKeys(jLib.getRandomNumber()+pphone);
		String pdob = eLib.readDataFromExcelSheet("Sheet5", 12, 1);
		parentBday.sendKeys(jLib.getRandomNumber()+pdob);
		wLib.select("Male",studGender );
		 wLib.select("Male",parentGender );
		 String sphoto = eLib.readDataFromExcelSheet("Sheet5", 13, 1);
			studPhoto.sendKeys(sphoto);
			String pphoto=eLib.readDataFromExcelSheet("Sheet5", 14, 1);
			parentPhoto.sendKeys(pphoto);
		
	}
//	public void sgender(WebDriverUtility wLib) {
//		 
//	 }
//	
//	
//	public void studPhoto(ExcelUtility eLib) throws Throwable {
//		
//	}
//	public void pgender(WebDriverUtility wLib) {
//		
//	 }
//	
//	public void parentPhoto(ExcelUtility eLib) throws Throwable {
//		

	
	public void submit1() {
		nextButton.click();
	}
	public void addGrade(WebDriverUtility wLib,String visibletext) {
		wLib.select("grade128", addGrade);
	}
	
	public void clickCheckBox() {
		checkBox.click();
	}
	public void submit2() {
		submit.click();
	}
	public void finalClose() {
		closeBtn.click();
	}
}
