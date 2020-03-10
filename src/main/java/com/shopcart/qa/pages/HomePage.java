package com.shopcart.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.util.TestUtil;
import com.shopcart.qa.util.WaitUtil;

public class HomePage extends TestBase{
	public static Actions act = new Actions(driver);

	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[@class='page-title']")
	WebElement pageTitle;

	@FindBy(css = "i.icon-shopping-cart")
	WebElement cart;

	@FindBy(id = "quick_select")
	WebElement quickAcess;

	@FindBy(xpath = "//li[@id='employee_infos']/a")
	WebElement systemAdmin;

	@FindBy(xpath = "//a[@class='toolbar_btn btn-help']")
	WebElement help;

	@FindBy(xpath = "//button[@id='datepickerExpand']")
	WebElement calenderLink;

	@FindBy(xpath = "//button[@class=\"btn btn-default dropdown-toggle\"]")
	static WebElement searchButton;

	@FindBy(css = "li.search-invoices.search-option >a")
	static WebElement searchInvoice;// click only

	@FindBy(xpath = "//*[@id='maintab-AdminDashboard']/a/span")
	WebElement dash_brd;

	@FindBy(xpath = "//*[@id='maintab-AdminCatalog']/a")
	WebElement catalogLink;

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void validCart() {
		//TestUtil.actions(cart, driver);
		act.moveToElement(cart).click();
		WaitUtil.waitForElement(driver, 5, cart);
	}
	public void clickOnQuickAcessLink() {
		TestUtil.actions(quickAcess, driver);
		WaitUtil.waitForElement(driver, 5, quickAcess);
		act.moveToElement(driver.findElement(By.cssSelector("#header_quick > li > ul > li:nth-child(3) > a")))
				.click();
		
	 TestUtil.actions(driver.findElement(By.cssSelector("#header_quick > li > ul > li:nth-child(3) > a")), driver);
	}
	
	public void clickOnSystemAdminLink() {
		TestUtil.actions(systemAdmin, driver);
		WaitUtil.waitForElement(driver, 5, systemAdmin);
		TestUtil.actions(driver.findElement(By.cssSelector("a#header_logout1")), driver);
	}
	
	public void clickOnHelpLink() {
		//TestUtil.actions(help, driver);
		help.click();
	}
	
	/*public void validCalenderDate() {
		calenderLink.click();
		Calender.calender();
	}
*/
	public void validDashBrd() {
		TestUtil.actions(dash_brd, driver);
	}

	public void checkSizeOfMenuList() {
		List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='menu']/li"));
		System.out.println("MenuList:"+menuList.size());
	}

	public void searchMenu() {
		driver.findElement(By.xpath("//input[@id='bo_query']")).click();
		TestUtil.actions(searchButton, driver);
		WaitUtil.waitForElement(driver, searchButton, 3);
		TestUtil.actions(searchInvoice, driver);
	}

	public CatalogPage1 clickOnCatalogLink() {
		return new CatalogPage1();
	}
	
	/*
	 * public OrderPage clickOnOrdersLink() { orderLink.click(); return new
	 * OrderPage(); }
	 */

}
