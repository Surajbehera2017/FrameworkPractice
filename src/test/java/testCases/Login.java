package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BrowserFactory;
import base.Utils;
import pages.HomePage;
import pages.loginPage;

public class Login {
	@BeforeTest
	public void beforemethod() throws Exception {
		BrowserFactory.BrowserInit("FIREFOX");
		BrowserFactory.driver.get(Utils.testDataInit("URL", "testData1"));
		loginPage.inputBoxUsername.sendKeys(Utils.testDataInit("Username", "testData1"));
		loginPage.inputBoxPassword.sendKeys(Utils.testDataInit("Password", "testData1"));
		loginPage.btnLogin.click();
		Assert.assertTrue(HomePage.msgWelcome.getText().equalsIgnoreCase("Welcome To Manager's Page of Guru99 Bank"));
	}

	@Test
	public void applicationLogin() {
		BrowserFactory.driver.quit();
	}
	
	
}
