package pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;

import base.IElement;

public class HomePage {

	public static IElement msgWelcome = new IElement(By.xpath("//marquee[contains(text(),'Welcome To')]"),3);
	// td[contains(text(),'Manger Id :')]
	public static IElement msgUserID = new IElement(By.xpath("// td[contains(text(),'Manger Id :')]"));
}
