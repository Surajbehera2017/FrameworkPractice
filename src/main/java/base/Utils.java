package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.interactions.Actions;

import pages.HomePage;

public class Utils {

	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		getS("key");
	}

	public static String testDataInit(String key, String testSet) {
		String value = null;
		switch (testSet) {

		case "testData1":
			Map<String, String> testData1 = new HashMap<>();
			testData1.put("FirefoxPath", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			testData1.put("URL", "http://demo.guru99.com/V4/");
			testData1.put("Username", "mngr104786");
			testData1.put("Password", "hupAguh");
			value = testData1.get(key);
			break;
		case "testData2":
			Map<String, String> testData2 = new HashMap<>();
			testData2.put("FirefoxPath", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			testData2.put("URL", "http://demo.guru99.com/V4/");
			testData2.put("Username", "mngr1047861");
			testData2.put("Password", "hupAguh1");
			value = testData2.get(key);

		}
		return value;
	}

	public static String getS(String key) throws Exception {
		String s1 = null;
		try {
			JSONParser parse1 = new JSONParser();

			Object obj = parse1
					.parse(new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\testCases\\Data.json"));
			JSONObject jObj = (JSONObject) obj;

			s1 = (String) jObj.get(key);
			//System.out.println(s1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	
	public void action1()
	{
		Actions act = new Actions(BrowserFactory.driver);
	}

}
