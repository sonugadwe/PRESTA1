package com.shopcart.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.pages.CustomerPage;
import com.shopcart.qa.pages.LoginPage;
import com.shopcart.qa.pages.OrdersPage;

public class TC_D_OrdersPageTest extends TestBase {
	LoginPage loginPage;
	OrdersPage orderPage;
	CustomerPage customerPage;

	public TC_D_OrdersPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		orderPage = new OrdersPage();
		customerPage=new CustomerPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void validateOrders() {
		orderPage.Orders();
	}
	@Test(priority=2)
	public void validateInvoice() {
		orderPage.verifyInvoice();
	}
	@Test(priority=3)
	public void validateMerchandise_Returns() {
		orderPage.verifyMerchandise_Returns();
	}
	@Test(priority=4)
	public void validateDeliverySlips() {
		orderPage.VerifyDeliverySlips();
	}
	@Test(priority=5)
	public void validateCreditSlips() {
		orderPage.VerifyCreditSlips();
	}
	@Test(priority=6)
	public void validateStatuses() {
		orderPage.VerifyStatuses();
	}
	@Test(priority=7)
	public void validateOrderMessages() {
		orderPage.VerifyOrderMessages();
	}
	
	@Test(priority=7)
	public void customerPage() {
		customerPage=orderPage.ClickOnCustomer();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
