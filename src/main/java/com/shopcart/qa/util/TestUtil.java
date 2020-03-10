package com.shopcart.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {
	static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;

	public static void actions(WebElement locator, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(locator).build().perform();
		
	}

	public static void Actions01(WebDriver driver) {

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();

		// act.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public static void Actions02(WebElement element, WebDriver driver) {

		Actions act = new Actions(driver);
		act.clickAndHold(element).moveByOffset(0, 500).release().build().perform();
	}

	public static void dropDown(WebElement locator, String data) {
		Select s = new Select(locator);
		s.selectByVisibleText(data);

	}

	public static String takeScreenshotAtEndOfTest(WebDriver driver, String screenShotPath) throws Exception {
	//	TakesScreenshot ts = (TakesScreenshot) Login_TestCase.driver;
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotName=null;
		String dest = System.getProperty("user.dir") + "/Errorscreenshot/" + screenshotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

	}

