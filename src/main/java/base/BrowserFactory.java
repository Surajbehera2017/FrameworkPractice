package base;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	public static WebDriver driver = null;
	final static String CHROME = "Chrome";
	final static String FIREFOX = "ff";
	public static void BrowserInit(String Browser) throws Exception {

		switch (Browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\Mars_Workspace 2\\FrameworkPractice\\chromedriver.exe");
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-infobars");
			driver = new ChromeDriver(option);
			break;
		case FIREFOX:	
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Mars_Workspace 2\\FrameworkPractice\\geckodriver.exe");
			FirefoxBinary fbin = new FirefoxBinary(new File(Utils.getS("FirefoxPath")));
			//FirefoxProfile fprof = new FirefoxProfile();
			FirefoxOptions fOption=  new FirefoxOptions();
			
			fOption.setBinary(fbin);
		
			driver = new FirefoxDriver(fOption);
			break;
		}

	}
/*
	public static void main(String args[]) {
		BrowserFactory.BrowserInit("FIREFOX");
		driver.get("http://google.co.in");

	}
*/
}
