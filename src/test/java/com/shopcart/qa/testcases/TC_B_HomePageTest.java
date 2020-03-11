package com.shopcart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.pages.CatalogPage1;
import com.shopcart.qa.pages.HomePage;
import com.shopcart.qa.pages.LoginPage;

public class TC_B_HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CatalogPage1 catalogPage1;

	public TC_B_HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();// method is coming from Test base class it will called initialization method
		loginPage = new LoginPage();
		homePage=new HomePage() ;
		catalogPage1 = new CatalogPage1();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String expectedTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(expectedTitle, "SHOPCART > Administration panel (PrestaShop™)");
		log.info("Verify HomePage Title:" + expectedTitle);
	}

	@Test(priority = 2)
	public void verifyCartTest() {
		homePage.validCart();
		log.info("No new orders have been placed in cart");

	}

	@Test(priority = 3)
	public void verifyQuickAcessTest() {
		homePage.clickOnQuickAcessLink();
		log.info("Quick Acces open");
	}

	@Test(priority = 4)
	public void verifySystemAdminLinkTest() {
		homePage.clickOnSystemAdminLink();
	}

	@Test(priority = 5)
	public void verifyHelpLinkTest() {
		homePage.clickOnHelpLink();
		log.info("Help Link open");
	}

	/*
	 * @Test(priority = 6) public void verifyCalenderDateTest() {
	 * homePage.validCalenderDate(); }
	 */

	@Test(priority = 7)
	public void verifyDashbrdTest() {
		homePage.validDashBrd();
		log.info("Dashoboard is verify");
	}

	@Test(priority = 8)
	public void menuListSizeTest() {
		homePage.checkSizeOfMenuList();
		
	}

	@Test(priority = 9)
	public void searchMenuTest() {
		homePage.searchMenu();
		log.info("Search menu open");
	}

	@Test(priority = 10)
	public void CatalogPageTest() {
		catalogPage1 = homePage.clickOnCatalogLink();
		log.info("catalog link open");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
