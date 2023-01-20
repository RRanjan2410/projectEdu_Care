package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="email")
	private WebElement userBtn;

	@FindBy(id="password")
	private WebElement pwdBtn;

	@FindBy(id="btnSubmit")
	private WebElement lgBtn;


	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUserBtn() {
		return userBtn;
	}


	public WebElement getPwdBtn() {
		return pwdBtn;
	}


	public WebElement getLgBtn() {
		return lgBtn;
	}
	
	//business library
	public void loginPage(String username,String password) {
		userBtn.sendKeys(username);
		pwdBtn.sendKeys(password);
		lgBtn.click();
	}



}
