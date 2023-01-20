package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllTeacher {
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchAllTeacher;
	
	//initilzation
	public AllTeacher(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	
	public WebElement getSearchAllTeacher() {
		return searchAllTeacher;
	}
	
	//bussiness L
		
	}
	

