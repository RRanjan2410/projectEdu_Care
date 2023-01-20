package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//decleration
	
	@FindBy(linkText = "Classroom")
	private WebElement clsRoomLink;
	
	@FindBy(linkText = "Grade")
	private WebElement grAdeLink;
	
	@FindBy(linkText = "Subject")
	private WebElement subJetLink;
	
	@FindBy(linkText = "Teacher")
	private WebElement teaCherLink;
	
	@FindBy(linkText = " All Teacher")
	private WebElement allTeacherLink;
	
	@FindBy(linkText = "Student")
	private WebElement stuDentLink;
	
	@FindBy(linkText = " All Student")
	private WebElement allStudentLink;
	
	@FindBy(linkText = " Leave Student")
	private WebElement leaveStudentLink;
	
	@FindBy(xpath = "//span[.='Admin A']")
	private WebElement clickAdminLink;
	
	@FindBy(xpath = "//a[.='Sign out']")
	private WebElement signOutLink;
	
	//initilization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utiliztaion

	public WebElement getClsRoomLink() {
		return clsRoomLink;
	}

	public WebElement getGrAdeLink() {
		return grAdeLink;
	}

	public WebElement getSubJetLink() {
		return subJetLink;
	}

	public WebElement getTeaCherLink() {
		return teaCherLink;
	}

	public WebElement getStuDentLink() {
		return stuDentLink;
	}

	public WebElement getClickAdminLink() {
		return clickAdminLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public WebElement getAllTeacherLink() {
		return allTeacherLink;
	}

	public WebElement getAllStudentLink() {
		return allStudentLink;
	}

	public WebElement getLeaveStudentLink() {
		return leaveStudentLink;
	}

	//business Library
	public void clickOnClassromLink() {
		clsRoomLink.click();
	}
	public void clickOnGradeLink() {
		grAdeLink.click();
	}
	public void clickOnSubjectLink() {
		subJetLink.click();
	}
	public void clickOnTeacherLink() {
		teaCherLink.click();
	}
	public void clickOnStudentLink() {
		stuDentLink.click();
	}
	
	public void clickOnAllTeacherLink() {
		allTeacherLink.click();
	}
	public void clickOnAllStudentLink() {
		allStudentLink.click();
	}
	public void clickOnLeaveStudentlink() {
		leaveStudentLink.click();
	}
	public void clickOnAdminLink() {
		clickAdminLink.click();
	}
	public void clickOnSignOutbutton() {
		signOutLink.click();
	}
}

