package com.shopcart.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.pages.CatalogPage1;
import com.shopcart.qa.pages.LoginPage;
import com.shopcart.qa.pages.OrdersPage;
import com.shopcart.qa.util.ExcelUtil;

public class TC_C_CatalogPageTest1 extends TestBase {

	LoginPage loginPage;
	CatalogPage1 catalogPage1;
	OrdersPage orderPage;
	String sheetName = "PSC";
	public static String sheet_Path = System.getProperty("user.dir") + "\\src\\test\\resources\\" + "Presta2.xlsx";


	public TC_C_CatalogPageTest1() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		catalogPage1 = new CatalogPage1();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() {

		Object[][] data = null;
		try {
			data = ExcelUtil.getDataFromExcel(sheetName,sheet_Path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void productCatalogTest(String Name, String Rcode, String JanCode, String UPCCode) {
		catalogPage1.VerifyNewProductByExcel(Name, Rcode, JanCode, UPCCode);
	}

	//@Test public void validAddNewProduct() {
	 //catalogPage1.VerifyNewProductByExcel(); }
	 
	@Test(priority = 2)
	public void catagoryTest() {
		catalogPage1.verifyCategoreis();
	}

	@Test(priority = 3)
	public void TrackingTest() {
		catalogPage1.verifyMonitoring();
	}

	@Test(priority = 4)
	public void OrdersPage() {

		orderPage = catalogPage1.ClickOnOrdersPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
