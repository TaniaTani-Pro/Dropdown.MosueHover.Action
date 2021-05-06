package com.Dropdown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicDropdown {
	public WebDriver driver;

	@BeforeTest
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void dropdownTest() throws InterruptedException {
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(year);
		yearSelect.selectByIndex(10);
		Thread.sleep(2000);
		yearSelect.selectByValue("2016");
		Thread.sleep(2000);
		yearSelect.selectByVisibleText("2019");
		Thread.sleep(2000);
	}

	@AfterTest
	public void quit() {
		driver.close();
	}
}
