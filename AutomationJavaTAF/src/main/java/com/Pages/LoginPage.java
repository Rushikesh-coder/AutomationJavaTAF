package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WrapperClass;

public class LoginPage {
	private WebDriver driver;
    private WrapperClass wrapper;

	private By usernameField = By.xpath("//input[@type='email']");
	private By passwordField = By.xpath("//input[@class='password']");
	private By loginButton = By.xpath("//button[text()='Log in']");

	// Constructor
	public LoginPage(WebDriver driver) {
//		this.driver = driver;
		 this.wrapper = new WrapperClass(driver);
	}

//	// Actions
//	public void login(String username, String password) {
//		driver.findElement(usernameField).sendKeys(username);
//		driver.findElement(passwordField).sendKeys(password);
//		driver.findElement(loginButton).click();
//	}
	
	public boolean enterTextOnUserNameField(String userName) {
		boolean blnVal= this.wrapper.enterText(usernameField, userName);
		return blnVal;
	}
	
	
	public boolean enterTextOnPassword(String Password) {
		boolean blnVal= this.wrapper.enterText(passwordField, Password);
		return blnVal;
	}
	
	public boolean clickOnsubmit() {
		boolean blnVal=this.wrapper.clickElement(loginButton);
		return blnVal;
	}
	
	
}
