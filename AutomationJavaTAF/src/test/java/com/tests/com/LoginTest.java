package com.tests.com;

import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.Flow.LoginFlow;
import com.Pages.LoginPage;

public class LoginTest extends BaseTest {

	private LoginFlow objLoginflow;

	@Test
	public void loginToApplication() {
		this.setup();
		getDriver().get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		getDriver().manage().window().maximize();
//		LoginPage loginPage = new LoginPage(this.getDriver());
		objLoginflow=new LoginFlow(getDriver());
		
		objLoginflow.login();

	}
}
