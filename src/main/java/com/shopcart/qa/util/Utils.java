package com.shopcart.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {
	public static WebDriver driver;

	public static void driverchromeWindowimpliTime(String URL, long Itime0, long Ptime01) {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Itime0, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Ptime01, TimeUnit.SECONDS);
	}

	public static void driverfirefoxWindowimpliTime(String URL, long time0, long time01) {
		System.setProperty("Webdriver.gecko.driver", "firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(time0, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(time01, TimeUnit.SECONDS);
	}

	public static void enterWebData(String Xpath, String Data) {

		driver.findElement(By.xpath(Xpath)).sendKeys(Data);
	}

	public static void Clickentry(String Xpath) {

		driver.findElement(By.xpath(Xpath)).sendKeys(Keys.ENTER);
	}

	public static void HidebyJs(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("document.getElementById(" + element + ").style.display='none';");
	}
	public static void OpenbyJs(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("document.getElementByClassName(" + element + ").style.display='show';");
	}

	public static void ClickByJs(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public static void SendTextByJs(WebDriver driver, WebElement e, String Elementvalue) {

		((JavascriptExecutor) driver).executeScript("document.getElementsId(" + e + ").value=(" + Elementvalue + ");");
		// ((JavascriptExecutor)driver).executeScript("arguments[0].value=Elementvalue;",element);

	}

	public static void Scroll_UP_ByJs(WebDriver driver) {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void Scroll_Down_ByJs(WebDriver driver) {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

	}

	public static String ScrollIntoView_ByJs(WebDriver driver, WebElement element) {

		String siv = ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element)
				.toString();

		return siv;

	}

	public static void RefreshBrowser_ByJs(WebDriver driver) {

		((JavascriptExecutor) driver).executeScript("history.go(0)");

	}

	public static String getPageTittle_ByJs(WebDriver driver) {

		String PageTittle = ((JavascriptExecutor) driver).executeScript("return document.title;").toString();
		// String PageTittle1 = ((JavascriptExecutor)driver).executeScript("return
		// document.URL;").toString();
		// String PageTittle2 = ((JavascriptExecutor)driver).executeScript("return
		// document.domain;").toString();

		return PageTittle;
	}

	public static String getPageSourceText_ByJs(WebDriver driver) {

		// String PageSourceTittle = ((JavascriptExecutor)driver).executeScript("return
		// document.documentElement.innerText;").toString();
		String PageSourceTittle1 = ((JavascriptExecutor) driver).executeScript("return document.body.innerHTML;")
				.toString();

		return PageSourceTittle1;
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public static void flash(WebElement element, WebDriver driver) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 500; i++) {
			changeColor("#000000", element, driver);// 1
			changeColor(bgcolor, element, driver);// 2
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public static String GenerateAlert_ByJs(WebDriver driver, String message) {

		String Alert = ((JavascriptExecutor) driver).executeScript("alert(" + message + ");").toString();

		return Alert;
	}

	public static void drawBorder_ByJs(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element).toString();

	}

	public static void ChangeColour_ByJs(WebDriver driver, WebElement element, String colour) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor =(" + colour + ");", element);

		try {

			Thread.sleep(30);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void getSizeOfWindow_ByJs(WebDriver driver, WebElement element, String border) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=(" + border + ")", element).toString();

	}

	public static void NavigatetoDifferentPage_ByJs(WebDriver driver, String URL) {

		((JavascriptExecutor) driver).executeScript("window.location =(" + URL + ")");

	}
	

	/*public static void ListOfWebElement(String xpath, String EnterListOfValuesToAssert) {

		WebElement element = driver.findElement(By.xpath(xpath));

		String ListOfValues = EnterListOfValuesToAssert;

		if (element.getText().equals(ListOfValues)) {
			element.click();
		}
	}

	public static void ListOfWebElements(String xpath, int EnterListOfValuesToAssert) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));

		int count = element.size();
		int ListOfValues = EnterListOfValuesToAssert;

		for (int i = 0; i < count; i++) {

			WebElement e = element.get(i);

			if (count == ListOfValues) {
				e.click();
			}

		}
	}
*/
}
