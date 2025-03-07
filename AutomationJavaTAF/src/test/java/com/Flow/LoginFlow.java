package com.Flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Base.BaseLogger;
import com.Pages.LoginPage;
import com.utils.WrapperClass;

public class LoginFlow {
	private WebDriver driver;
    private WrapperClass wrapper;
    private LoginPage objLoginPage;
    private BaseLogger objBaseLogger;
    
	// Constructor
	public LoginFlow(WebDriver driver) {
		this.driver = driver;
		objLoginPage=new LoginPage(driver);
		objBaseLogger =new BaseLogger();
		
	}

	// Actions
	public void login() {
		 objBaseLogger.logReporter("Enter the UserName in inputbox", objLoginPage.enterTextOnUserNameField("admin@yourstore.com"));
		 objBaseLogger.logReporter("Enter the Password", objLoginPage.enterTextOnPassword("admin"));
		 objBaseLogger.logReporter("Click on submit button", objLoginPage.clickOnsubmit());
		;
	}
}
