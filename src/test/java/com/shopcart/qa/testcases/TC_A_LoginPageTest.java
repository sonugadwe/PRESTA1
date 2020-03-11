package com.shopcart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.pages.HomePage;
import com.shopcart.qa.pages.LoginPage;

public class TC_A_LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;

	public TC_A_LoginPageTest() {
		super(); // it will called super class Testbase of constructor and call property file
	}

	@BeforeMethod
	public void setUp() {
		initialization();// method is coming from Test base class it will called initialization method
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void loginPageTitleTest() {
		String title = loginPage.validLoginPageTitle();
		Assert.assertEquals(title, "SHOPCART > Administration panel (PrestaShop™)");
		log.info("Title is verified");
	}
	@Test(priority=3)
	public void ShoplogoImg() {
		boolean logo = loginPage.validShoplogoImg();
		Assert.assertTrue(logo);
		log.info("ShoplogoImg is verified");
	}

	@Test(priority=4)
	public void ShopVersionTest() {
		Assert.assertTrue(loginPage.validShopVersion());
		log.info("ShopVersion is verified");

	}
	
	@Test(priority=5)
	public void ShopcartImgTest() {
		boolean img = loginPage.validShoplogoImg();
		Assert.assertTrue(img);
		log.info("ShopcartImg is verified");

	}
	@Test(priority=6)
	public void HomePage() {
		loginPage.clickOnHomePage();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

