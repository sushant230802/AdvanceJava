package com.simpleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

	WebDriver driver;
	
	@BeforeTest
	public void before() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://testpages.eviltester.com/styled/validation/input-validation.html");
		Thread.sleep(3000);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div[3]/form/input[1]")).sendKeys("Aman");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[3]/form/input[2]")).sendKeys("Kumar Singh");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[3]/form/input[3]")).sendKeys("18");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[3]/form/select")).sendKeys("India");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[3]/form/textarea")).sendKeys("I am testing");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[3]/form/input[4]")).click();
		Thread.sleep(3000);
		
	}
	
	
	@AfterTest
	public void after() {
		driver.quit();
	}
}
