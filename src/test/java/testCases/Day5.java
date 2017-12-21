package testCases;

import org.testng.annotations.Test;

import base.BrowserFactory;
import base.IElement;
import base.Utils;
import pages.HomePage;
import pages.loginPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Day5 {
	WebDriverWait wait;
	@DataProvider()
	public Object[][] credentials() throws Exception {

		Object[][] TestData = new Object[2][2];
		TestData[0][0] = Utils.getS("Username1");
		TestData[0][1] = Utils.getS("Password1");

		TestData[1][0] = Utils.getS("Username2");
		TestData[1][1] = Utils.getS("Password2");

		return TestData;
		// return new Object[][]
		// {{"Username1",Utils.getS("Username1")},{"Username2",Utils.getS("Username2")}};

	};

	@Test(dataProvider = "credentials")
	void ValidCredentials(String Username, String Password) throws Exception {
		
		BrowserFactory.BrowserInit("FIREFOX");
		BrowserFactory.driver.get(Utils.getS("URL"));
		wait = new WebDriverWait(BrowserFactory.driver,1);
		
		loginPage.inputBoxUsername.sendKeys(Username);
		loginPage.inputBoxPassword.sendKeys(Password);
		System.out.println(Username+"*********--------*********"+Password);
		
		loginPage.btnLogin.click();
		if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		{BrowserFactory.driver.switchTo().alert().accept();}
		Assert.assertTrue(HomePage.msgUserID.getText().equalsIgnoreCase("Manger Id : "+Utils.getS("Username1")));
		BrowserFactory.driver.close() ;
	}
	
	@Test()
	void invalidCredentials()
	{
		BrowserFactory.BrowserInit(Browser);
		
		
		
	}
}
