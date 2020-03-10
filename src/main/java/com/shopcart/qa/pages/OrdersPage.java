package com.shopcart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.util.TestUtil;

public class OrdersPage extends TestBase {

	@FindBy(xpath="//*[@id='maintab-AdminParentOrders']/a/span")
	WebElement orders_Link;
	
	public OrdersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Orders() {
		TestUtil.actions(orders_Link, driver);
		driver.findElement(By.xpath("//li[@id='subtab-AdminOrders']/a")).click();
		
	}
	public void verifyInvoice() {
		TestUtil.actions(orders_Link, driver);
		driver.findElement(By.xpath("//*[@id='subtab-AdminInvoices']/a")).click();
	}
	public void verifyMerchandise_Returns() {
		TestUtil.actions(orders_Link, driver);
		driver.findElement(By.xpath("//*[@id='subtab-AdminReturn']/a")).click();
	}
	public void VerifyDeliverySlips() 
	{
		TestUtil.actions(orders_Link, driver);
		driver.findElement(By.id("subtab-AdminDeliverySlip")).click();
	      
	}
	
	public void VerifyCreditSlips() 
	{
		TestUtil.actions(orders_Link, driver);
		driver.findElement(By.id("subtab-AdminSlip")).click();
	      
	}
	
	public void VerifyStatuses() 
	{		TestUtil.actions(orders_Link, driver);
		driver.findElement(By.id("subtab-AdminStatuses")).click();
	      
	}
	
	public void VerifyOrderMessages() 
	{		TestUtil.actions(orders_Link, driver);
			driver.findElement(By.id("subtab-AdminOrderMessage")).click();
	      
	}
	
	public CustomerPage ClickOnCustomer() 
	{
		return new CustomerPage();
		
		
	}
	
	

}
