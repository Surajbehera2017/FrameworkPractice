package pages;

import org.openqa.selenium.By;

import base.IElement;

public class loginPage{

	
	public static IElement inputBoxUsername = new IElement(By.xpath("//input[@name='uid']"));
	public static IElement inputBoxPassword = new IElement(By.xpath("//input[@name='password']"));
	public static IElement btnLogin = new IElement(By.xpath("//input[@name='btnLogin']"));
}
