package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IElement extends BrowserFactory implements WebElement {
	WebDriverWait w;
	WebElement e = null;
	IElement ele;
	int wait = 0;
	By locator;
	final int MAXTRIES = 3;

	public IElement(By locator) {
		this.locator = locator;
	}

	public IElement(By locator, int wait) {
		this.locator = locator;
		this.wait = wait;
	}

	public static void main(String args[]) {

	}

	public void init() {

		/*if(e!=null)
		{scrollIntoView();return; }*/
		try {
			w = new WebDriverWait(driver, wait);
			e = w.until(ExpectedConditions.elementToBeClickable(locator));
			scrollIntoView();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}

	public void refresh() {
		init();
		driver.navigate().refresh();
		return;
	}

	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {

		return null;
	}

	public void clear() {
		init();
		e.clear();
		return;
	}

	public void click() {

		for (int i = 0; i < MAXTRIES; ++i) {
			init();
			try {
				e.click();
				return;
			} catch (StaleElementReferenceException e) {
				refresh();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public IElement findElement(By arg0) {
		return null;
	}

	public List<WebElement> findElements(By arg0) {
		this.locator = arg0;
		return null;
	}

	public String getAttribute(String arg0) {

		return null;
	}

	public String getCssValue(String arg0) {

		return null;
	}

	public Point getLocation() {

		return null;
	}

	public Rectangle getRect() {

		return null;
	}

	public Dimension getSize() {

		return null;
	}

	public String getTagName() {

		return null;
	}

	public String getText() {
		init();
		return e.getText();
	}

	public boolean isDisplayed() {

		return false;
	}

	public boolean isEnabled() {

		return false;
	}

	public boolean isSelected() {

		return false;
	}

	public void sendKeys(CharSequence... arg0) {
		init();
		e.sendKeys(arg0);
	}

	public void submit() {

	}

	public void scrollIntoView() {
		String arg = "arguments[0].scrollIntoView();";

		for (int i = 0; i < MAXTRIES; i++) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(arg, e);
				return;
			} catch (StaleElementReferenceException e) {
				refresh();
			}
		}
	}
}
