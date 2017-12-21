package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BrowserFactory;
import base.Utils;
import pages.loginPage;

public class Day2 {
  @Test
  public void negativeScenario() throws Exception {
	  BrowserFactory.BrowserInit("FIREFOX");
	  BrowserFactory.driver.get(Utils.getS("URL"));
	  loginPage.inputBoxUsername.sendKeys(Utils.getS("Username2"));
	  loginPage.inputBoxPassword.sendKeys(Utils.getS("Password2"));
	  loginPage.btnLogin.click();
	  
	  String alText = BrowserFactory.driver.switchTo().alert().getText();
	  Assert.assertTrue(alText.equalsIgnoreCase("User or Password is not valid"));
	  BrowserFactory.driver.switchTo().alert().accept();
	  BrowserFactory.driver.quit();
  }
}
