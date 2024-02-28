package com.demo.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.demo.util.WebActionUtil;
import com.demo.baseutil.Basetest;

public class Gmail {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static WebActionUtil actionutil;
	public long eto = 30;
	

	
	/* X-path for First Name */
	@FindBy(xpath = "//*[@id=\"identifierId\"]")
	private static WebElement email;

	
	/* X-path for Next Button */
	@FindBy(id = "identifierNext")
	private static WebElement nxtBtn;
	
	/* X-path for Next Button */
	@FindBy(id = "password")
	private static WebElement gmailPasswordField;

	public void opengmail() throws InterruptedException {

		
//		  WebDriver driver = new ChromeDriver();
//		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		  driver.manage().window().maximize();
//		  driver.get("https://accounts.google.com/");
//		  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(
//		  "qa-testing@vtnetzwelt.com");
//		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(
//		  "qa-testing@Test@123");
//		  driver.findElement(By.xpath("//button[@name='Login']")).click();
		 

		/**
		 * Description: Opening new tab
		 */
	
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("window.open()");
//        String[] handles = driver.getWindowHandles().toArray(new String[0]);
//        driver.switchTo().window(handles[1]);
		System.out.println("t1");
//		driver.get(prop.getProperty("Gmail_URL"));
        // method Keys.chord
		Thread.sleep(4000);
		email = driver.findElement(By.id("identifierId"));
		 
		 System.out.println("t2");
		System.out.println(email.getAttribute("autocomplete"));
		 Thread.sleep(2000);
		 
		actionutil.clickOnElement(email, "Clicking on email textbox");
		try {
		actionutil.typeText(email, "iottesting32@gmail.com", "Email field");
		}
		catch(Exception e) {
		System.out.println("jay mha kal2");	
		}
		actionutil.clickOnElementUsingJS(nxtBtn, "Next Btn");
        Thread.sleep(4000);
        actionutil.typeText(gmailPasswordField, "Test@123", "Email field");
        actionutil.clickOnElementUsingJS(nxtBtn, "Next Btn");
        Thread.sleep(4000);
	}
}