package com.shopcart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.qa.base.TestBase;

public class LoginPage extends TestBase{
	// Page factory=Object repository

		// initializing Page objects:
		public LoginPage() {
			// page factory method initialize element with driver and current class object
			// this is current class object initialize all variables with driver
			// driver is coming from base class
			PageFactory.initElements(driver, this);
		}

		@FindBy(id = "email")
		WebElement email;

		@FindBy(id = "passwd")
		WebElement password;

		@FindBy(name = "submitLogin")
		WebElement login;

		@FindBy(xpath = "//img[@id='logo']")
		WebElement logo;

		@FindBy(xpath = "//*[@id='shop-img']/img")
		WebElement shoplogo;

		@FindBy(xpath = "//div[@class=\"text-center\"]")
		WebElement shopVersion;

		// Actions:
		public String validLoginPageTitle() {
			return driver.getTitle();

		}

		public Boolean validShopcartImg() {
			return logo.isDisplayed();
		}

		public Boolean validShoplogoImg() {
			return shoplogo.isDisplayed();
		}

		public boolean validShopVersion() {
			return shopVersion.isDisplayed();
		}


		public void login(String un, String pwd) {
			email.sendKeys(un);
			password.sendKeys(pwd);
			login.click();
			// After clicking login button it will go to home page thats y it will return
			// home page class object
		}
		public HomePage clickOnHomePage() {
			return new HomePage();
		}
	}

