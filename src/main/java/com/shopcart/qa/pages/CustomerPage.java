package com.shopcart.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.qa.base.TestBase;
import com.shopcart.qa.util.TestUtil;

public class CustomerPage extends TestBase {
	public Actions act = new Actions(driver);

	@FindBy(xpath = "//*[@id='maintab-AdminParentCustomer']/a/span")
	WebElement customer;

	@FindBy(xpath = "//*[@id=\"subtab-AdminCustomers\"]/a")
	WebElement cust_Link;

	@FindBy(xpath= "//*[@id='firstname']")
	WebElement f_name;

	@FindBy(id = "lastname")
	WebElement l_name;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(xpath="//input[@id='passwd']")
	WebElement pass;

	@FindBy(xpath = "//*[@id='customer_form_submit_btn']")
	WebElement save_btn;

	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void addNewCustomerFromExcel(String Fname, String Lname,String Email,String Pass) {
		act.moveToElement(customer).build().perform();
		cust_Link.click();

		driver.findElement(By.xpath("//*[@id='page-header-desc-customer-new_customer']")).click();

		String gender = "Mr.";
		WebElement RadioButtonMr = driver.findElement(By.xpath("//*[@id='gender_1']"));
		WebElement RadioButtonMrs = driver.findElement(By.xpath("//*[@id='gender_2']"));

		if (gender.equalsIgnoreCase("Mr.")) {
			RadioButtonMr.click();
		}
		if (gender.equalsIgnoreCase("Mrs.")) {
			RadioButtonMrs.click();
		}

		f_name.sendKeys(Fname);
		l_name.sendKeys(Lname);
		email.sendKeys(Email);
		pass.sendKeys(Pass);
		WebElement days = driver.findElement(By.name("days"));
		Select s = new Select(days);
		s.selectByIndex(6);

		WebElement months = driver.findElement(By.name("months"));
		Select s1 = new Select(months);
		s1.selectByVisibleText("August");

		WebElement years = driver.findElement(By.name("years"));
		Select s2 = new Select(years);
		s2.selectByValue("2020");

		List<WebElement> li = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(li.size());
		for (int i = 0; i <= li.size() - 1; i++) {
			li.get(2).click();
		}

		/*List<WebElement >els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for ( WebElement el : els ) {
		    if ( !el.isSelected() ) {
		        el.click();
		    }
		}*/
		WebElement defaultGrp = driver.findElement(By.name("id_default_group"));
		Select s3 = new Select(defaultGrp);
		s3.selectByVisibleText("Customer");

		save_btn.click();
	}


	public void VerifyAdrresses() {
		act.moveToElement(customer).build().perform();

		driver.findElement(By.xpath("//*[@id=\"subtab-AdminAddresses\"]/a")).click();

	}

	public void VerifyGroups() {
		act.moveToElement(customer).build().perform();

		driver.findElement(By.xpath("//*[@id=\"subtab-AdminGroups\"]/a")).click();

	}

	public void VerifyShippingCarts() {
		act.moveToElement(customer).build().perform();
		driver.findElement(By.id("subtab-AdminCarts")).click();

	}

	public void VerifyCustomerServices() {
		act.moveToElement(customer).build().perform();

		driver.findElement(By.id("subtab-AdminCustomerThreads")).click();

	}

	public void VerifyContacts() {
		TestUtil.actions(customer, driver);
		driver.findElement(By.id("subtab-AdminContacts")).click();

	}

	public void VerifyTittles() {
		act.moveToElement(customer).build().perform();

		driver.findElement(By.id("subtab-AdminGenders")).click();

	}


/*public void addNewCustomerFromExcel() {
	act.moveToElement(customer).build().perform();
	cust_Link.click();

	driver.findElement(By.xpath("//*[@id='page-header-desc-customer-new_customer']")).click();

	String gender = "Mrs.";
	WebElement RadioButtonMr = driver.findElement(By.xpath("//*[@id='gender_1']"));
	WebElement RadioButtonMrs = driver.findElement(By.xpath("//*[@id='gender_2']"));

	if (gender.equalsIgnoreCase("Mr.")) {
		RadioButtonMr.click();
	}
	if (gender.equalsIgnoreCase("Mrs.")) {
		RadioButtonMrs.click();
	}

	f_name.sendKeys("sonu");
	l_name.sendKeys("g");
	email.sendKeys("sg@gmail.com");
	pass.sendKeys("123");

	WebElement days = driver.findElement(By.name("days"));
	Select s = new Select(days);
	s.selectByIndex(6);

	WebElement months = driver.findElement(By.name("months"));
	Select s1 = new Select(months);
	s1.selectByVisibleText("August");

	WebElement years = driver.findElement(By.name("years"));
	Select s2 = new Select(years);
	s2.selectByValue("1994");

	List<WebElement> li = driver.findElements(By.xpath("//input[@type='checkbox']"));
	System.out.println(li.size());
	for (int i = 0; i <= li.size() - 1; i++) {
		li.get(2).click();
	}

	WebElement defaultGrp = driver.findElement(By.name("id_default_group"));
	Select s3 = new Select(defaultGrp);
	s3.selectByVisibleText("Customer");

	save_btn.click();

}*/
	/*
	 * @DataProvider(name = "getTestData") public Object[][] getTestData() { return
	 * new Object[][] { { "sonu", "12345", "123", "435" }, { "Priyanka", "143",
	 * "456", "789" }, { "Arthy", "741", "564", "741" }, { "Shilpa", "890", "963",
	 * "58523" } };
	 * 
	 * }
	 */
}