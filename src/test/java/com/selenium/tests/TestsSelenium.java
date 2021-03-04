package com.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsSelenium {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test-web.conjuntos.jelpit.com/login");
		
		
		
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		
		WebElement correo=driver.findElement(By.id("loginInMail"));
		assertNotNull(correo);
		correo.sendKeys("angelmoreno@yopmail.com");
		
		Thread.sleep(200);
		
		WebElement pass=driver.findElement(By.id("loginInPass"));
		assertNotNull(pass);
		pass.sendKeys("calidad1*");
		
		WebElement login= driver.findElement(By.id("loginUser"));
		login.click();
		
		Thread.sleep(1000000);
		
		WebElement text = driver.findElement(By.id("but_accountButton"));
		assertEquals("ANGEL MORENO",text.getText());
		
		
		
	}
	
	

	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	
}
 