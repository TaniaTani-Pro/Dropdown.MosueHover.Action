package com.Dropdown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoover {
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.adidas.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void mouseHoover() throws InterruptedException {
		WebElement women = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div/div/div[1]/div[2]/div[3]/div/div[1]/div[2]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(women).build().perform();
		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div[1]/div/div/div/div/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/ul/li[2]/a"))
				.click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

}
