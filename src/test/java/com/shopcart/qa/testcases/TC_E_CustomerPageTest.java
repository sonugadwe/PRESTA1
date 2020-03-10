package com.shopcart.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.pages.CustomerPage;
import com.shopcart.qa.pages.LoginPage;
import com.shopcart.qa.util.ExcelUtil;

public class TC_E_CustomerPageTest extends TestBase {
	LoginPage loginPage;
	CustomerPage customerPage;
	String sheetName = "CP";
	public static String sheet_Path = System.getProperty("user.dir") + "\\src\\test\\resources\\" + "CP1.xlsx";

	
	public TC_E_CustomerPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		customerPage=new CustomerPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@DataProvider(name = "getData")
	public Object[][] getData() {

		Object[][] data = null;
		try {
			data = ExcelUtil.getDataFromExcel(sheetName, sheet_Path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	@Test(priority=1, dataProvider="getData")
	public void validateCustomerData(String Fname1, String Lname1, String Email1, String Pass1) {
		customerPage.addNewCustomerFromExcel(Fname1, Lname1, Email1, Pass1);
	}
	/*
	@Test
	public void validNewCustomerDetails() {
		customerPage.addNewCustomerFromExcel();
	}*/
	@Test(priority=2)
	public void ValidatAddressesTest()
	{
		customerPage.VerifyAdrresses();
	}
	
	@Test(priority=3)
	public void ValidatGroupsTest()
	{
		customerPage.VerifyGroups();
	}
	
	@Test(priority=4)
	public void ValidatShippingCartsTest()
	{
		customerPage.VerifyShippingCarts();
	}
	
	@Test(priority=5)
	public void ValidatCustomerServicesTest()
	{
		customerPage.VerifyCustomerServices();
	}
	
	@Test(priority=6)
	public void ValidatContactsTest()
	{
		customerPage.VerifyContacts();
	}
	
	@Test(priority=8)
	public void validatTittlesTest()
	{
		customerPage.VerifyTittles();
	}
	
	@AfterMethod
	public void ExitPath ()
	{
		driver.quit();
	}

}
