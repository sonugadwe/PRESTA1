package com.shopcart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.util.TestUtil;
import com.shopcart.qa.util.Utils;
import com.shopcart.qa.util.WaitUtil;

public class CatalogPage1 extends TestBase {

	@FindBy(xpath = "//*[@id='maintab-AdminCatalog']/a")
	WebElement cat_Link;

	@FindBy(xpath = "//*[@id='subtab-AdminProducts']/a")
	WebElement Prod_Link;

	@FindBy(css = "#page-header-desc-product-new_product")
	WebElement add_Link;

	@FindBy(xpath = "//input[@id='virtual_product']")
	WebElement virt_Prd;
	
	@FindBy(xpath = "//*[@id=\"name_1\"]")
	WebElement name;

	@FindBy(xpath = "//input[@id='reference']")
	WebElement refCode;

	@FindBy(xpath = "//input[@id='ean13']")
	WebElement ean13;

	@FindBy(xpath = "//input[@id='upc']")
	WebElement upc;

	@FindBy(css = "#product-informations > div:nth-child(12) > div.col-lg-9 > span > label:nth-child(4)")
	WebElement Nobtn;

	@FindBy(css = "#product-informations > div:nth-child(12) > div.col-lg-9 > span > label:nth-child(2)")
	WebElement Yesbtn;

	@FindBy(id = "online_only")
	WebElement check;

	@FindBy(xpath = "//i[@class='process-icon-save']")
	WebElement savbtn;

	@FindBy(xpath = "//li[@id='subtab-AdminCategories']")
	WebElement admn_Cat;

	@FindBy(xpath = "//li[@id='subtab-AdminTracking']")
	WebElement admn_track;

	public CatalogPage1() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void VerifyNewProduct() { Actions act=new Actions(driver);
	 * act.moveToElement(cat_Link).build().perform();
	 * act.moveToElement(Prod_Link).click().build().perform(); add_Link.click();
	 * virt_Prd.click();
	 * 
	 * name.sendKeys("sonu"); refCode.sendKeys("spg12"); ean13.sendKeys("14"); int
	 * maxlength = 13; String typedValue = ean13.getAttribute("value");
	 * 
	 * // Get the length of typed value int size = typedValue.length();
	 * 
	 * // Assert with expected if (size <= maxlength) {
	 * System.out.println("Max character functionality is working fine."); }
	 * 
	 * else { System.out.println("No limit is set."); } upc.sendKeys("18");
	 * Nobtn.click();
	 * 
	 * WebElement redirect_type =
	 * driver.findElement(By.xpath("//select[@name='redirect_type']"));
	 * redirect_type.click(); Select s = new Select(redirect_type);
	 * s.selectByIndex(0);
	 * 
	 * WebElement visibility =
	 * driver.findElement(By.xpath("//select[@id='visibility']"));
	 * visibility.click(); Select s1 = new Select(visibility);
	 * s1.selectByValue("both");
	 * 
	 * WebElement
	 * options=driver.findElement(By.xpath("//input[@name=\"online_only\"]"));
	 * options.click();
	 * 
	 * WebElement condition =
	 * driver.findElement(By.xpath("//select[@id='condition']")); condition.click();
	 * Select s2 = new Select(condition); s2.selectByVisibleText("Used");
	 * 
	 * check.click(); savbtn.click();
	 * 
	 * WaitUtil.waitForElement(driver, savbtn, 3); Utils.GenerateAlert_ByJs(driver,
	 * "Data Successfully creation");
	 * 
	 * WaitUtil.waitForElement(driver, savbtn, 3);
	 * 
	 * }
	 */

	public void VerifyNewProductByExcel(String Name, String Rcode, String JanCode, String UPCCode) {
		Actions act = new Actions(driver);
		act.moveToElement(cat_Link).build().perform();
		act.moveToElement(Prod_Link).click().build().perform();
		add_Link.click();
		virt_Prd.click();
		System.out.println(11);
		
		name.sendKeys(Name);
		System.out.println(22);
		refCode.sendKeys(Rcode);
		ean13.sendKeys(JanCode);
		int maxlength = 13;
		String typedValue = ean13.getAttribute("value");

		// Get the length of typed value
		int size = typedValue.length();

		// Assert with expected
		if (size <= maxlength) {
			System.out.println("Max character functionality is working fine.");
		}

		else {
			System.out.println("No limit is set.");
		}
		upc.sendKeys(UPCCode);
		Nobtn.click();

		WebElement redirect_type = driver.findElement(By.xpath("//select[@name='redirect_type']"));
		redirect_type.click();
		Select s = new Select(redirect_type);
		s.selectByIndex(0);

		WebElement visibility = driver.findElement(By.xpath("//select[@id='visibility']"));
		visibility.click();
		Select s1 = new Select(visibility);
		s1.selectByValue("both");

		WebElement options = driver.findElement(By.xpath("//input[@name=\"online_only\"]"));
		options.click();
 
		WebElement condition = driver.findElement(By.xpath("//select[@id='condition']"));
		condition.click();
		Select s2 = new Select(condition);
		s2.selectByVisibleText("Used");

		check.click();
		savbtn.click();

	}

	public void verifyCategoreis() {
		// TestUtil.actions(catalogLink, driver);
		//Actions mov = new Actions(driver);
		//mov.moveToElement(cat_Link).build().perform();
		TestUtil.actions(cat_Link, driver);
		driver.findElement(By.xpath("//*[@id='subtab-AdminCategories']/a")).click();
	}

	public void verifyMonitoring() { // TestUtil.actions(catalogLink, driver);
		Actions mov = new Actions(driver);
		mov.moveToElement(cat_Link).build().perform();
		driver.findElement(By.xpath("//*[@id='subtab-AdminTracking']/a")).click();
	}
	

	public OrdersPage ClickOnOrdersPage() {
		return new OrdersPage();
	}

}
