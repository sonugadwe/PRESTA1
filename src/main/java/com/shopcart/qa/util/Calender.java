package com.shopcart.qa.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shopcart.qa.base.TestBase;

public class Calender extends TestBase {
	public static void selectDateCalender() {
		int from_Date= Integer.parseInt(prop.getProperty("From_Date"));
		int to_Date= Integer.parseInt(prop.getProperty("To_Date"));

		while(!driver.findElement(By.cssSelector("#datepicker > div > div > div > div:nth-child(1) > div > div > div.daterangepicker-days > table > thead > tr:nth-child(1) > th.month-switch")).getText().contains("April"))
		{
		driver.findElement(By.cssSelector("#datepicker > div > div > div > div:nth-child(1) > div > div > div.daterangepicker-days > table > thead > tr:nth-child(1) > th.next")).click();
		}


		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=driver.findElements(By.className("day")).size();

		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.className("day")).get(i).getText();
		if(text.equalsIgnoreCase("16"))
		{
		driver.findElements(By.className("day")).get(i).click();
		break;
		}

		}
	}

	public static void selectDateUsingCalender(String monthPath, String nextMonthPath, String dateTable) {

		int Year = Integer.parseInt(prop.getProperty("EnterdYear"));
		int a = Integer.parseInt(prop.getProperty("presentYear"));
		 int b= Integer.parseInt(prop.getProperty("futureValidYear"));
		// aftyer todays date one month calendar
		 if ( a<=Year && Year<= b )
		{
			while (true) {
				String test = driver.findElement(By.xpath(monthPath)).getText();
				if (prop.getProperty("Month").equals(test)) {
					System.out.println("Selected month is " + test);
					break;

				} else {
					driver.findElement(By.xpath(nextMonthPath)).click();
				}
			}

			List<WebElement> allDates = driver.findElements(By.xpath(dateTable));
			for (WebElement sdate : allDates) {
				String calenderDate = sdate.getText();
				if (calenderDate.equals(prop.getProperty("Date"))) {
					sdate.click();
				}
			}
		}

		else {
			System.out.println("Invalid Year");
		}

	}
	
	public static void calender() {
		List<WebElement> month=driver.findElements(By.cssSelector("#datepicker > div > div > div > div:nth-child(1) > div > div > div.daterangepicker-months > table > tbody > tr > td>span"));
		System.out.println(month.size());
		
		for(int i=0; i<month.size(); i++) {
			String month_text=month.get(i).getText();
			System.out.println(month_text);
		}
	}


}
