package com.curso;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JenkinsTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8181/login");
	}
	
	@Test
	public void testLogin() {
		WebElement inputName = driver.findElement(By.name("j_username"));
		WebElement inputPass = driver.findElement(By.name("j_password"));
		inputName.sendKeys("dalvarez_lopez");
		inputPass.sendKeys("g4RFjaox");

		WebElement submit = driver.findElement(By.name("Submit"));
		submit.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Panel de control [Jenkins]", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
