package com.shopcart.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shopcart.qa.util.TestUtil;

public class TestBase {
	public static Properties prop = null;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class);


	public TestBase() {
		try {
			prop = new Properties();
			// InputStream input =
			// TestBase.class.getClassLoader().getResourceAsStream("config.properties");
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\" + "config.properties");
			prop.load(fis);

			// prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/" + "log4j.properties");
	}

	

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if ("chrome".equals(browserName)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("Firfox".equalsIgnoreCase(browserName)) {
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	

	}
	
}

