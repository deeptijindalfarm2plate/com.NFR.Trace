package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracequestionbank {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	Tracesignuppage oldemailaddress = new Tracesignuppage(driver, eto, actionutil);
	String oldemail = oldemailaddress.getEmailAddress();
	String randomString = new Random().toString();
	String randomValue = actionutil.generateRandomAlphanumeric(8);
	int randomNumber = new Random().nextInt(1000);
	String emailaddress = randomValue + randomNumber + "@yopmail.com";

	public Tracequestionbank(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[1]/div/span")
	private WebElement trace;

	/* X-path for trace button */
	@FindBy(xpath = "//span[contains(text(),'Question Bank')]")
	private WebElement questionbank;

	/* X-path for trace button */
	@FindBy(xpath = "//h5[@id='ADD_QUESTION']")
	private WebElement addnew;

	/* X-path for trace button */
	@FindBy(xpath = "//input[contains(@class, 'form-control')]")
	private WebElement dropdown;

	/* X-path for trace button */
	@FindBy(xpath = "//div[contains(text(), 'Company Level')]")
	private WebElement companylevel;

	/* X-path for trace button */
	@FindBy(xpath = "//div[contains(text(), 'Production Location Level')]")
	private WebElement productlevel;

	/* X-path for trace button */
	@FindBy(xpath = "//button[contains(text(), 'Add')]")
	private WebElement addbtn;

	/* X-path for trace button */
	@FindBy(xpath = "//p[contains(text(), '+ Add Another Field')]")
	private WebElement addques;

	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[1]")
	private WebElement ques1;

	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[2]")
	private WebElement ques2;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[3]")
	private WebElement ques3;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[4]")
	private WebElement ques4;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[5]")
	private WebElement ques5;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[6]")
	private WebElement ques6;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[7]")
	private WebElement ques7;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[8]")
	private WebElement ques8;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[9]")
	private WebElement ques9;
	/* X-path for trace button */
	@FindBy(xpath = "(//td//div//span//textarea)[10]")
	private WebElement ques10;
	
	/* X-path for trace button */
	@FindBy(xpath = "(//input[@class='ant-checkbox-input'])[10]")
	private WebElement check1;
	
	/* X-path for trace button */
	@FindBy(xpath = "(//input[@class='ant-checkbox-input'])[9]")
	private WebElement check2;
	/* X-path for trace button */
	@FindBy(xpath = "(//input[@class='ant-checkbox-input'])[8]")
	private WebElement check3;
	/* X-path for trace button */
	@FindBy(xpath = "(//input[@class='ant-checkbox-input'])[7]")
	private WebElement check4;
	/* X-path for trace button */
	@FindBy(xpath = "(//input[@class='ant-checkbox-input'])[6]")
	private WebElement check5;
	/* X-path for trace button */
	@FindBy(xpath = "//button/span[contains(text(), 'Create Sub Set')]")
	private WebElement subques;
	/* X-path for trace button */
	@FindBy(xpath = "//input[@name='name']")
	private WebElement name;
	
	/* X-path for trace button */
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement subsubmit;

	
	
	/* X-path for trace button */
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submit;

	/* X-path for trace button */
	@FindBy(xpath = "	//button[contains(text(),'Yes')]")
	private WebElement yesbtn;

	public void traceaddcomapnyquestions() throws InterruptedException {

		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(2000);
		actionutil.clickOnElement(questionbank, "click on questionbank");
		Thread.sleep(2000);
		actionutil.clickOnElement(addnew, "click on addnew");
		Thread.sleep(2000);
		actionutil.clickOnElement(dropdown, "click on dropdown");
		Thread.sleep(2000);
		actionutil.clickOnElement(companylevel, "click on companylevel");
		Thread.sleep(2000);
		actionutil.clickOnElement(addbtn, "click on addbtn");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques1, "click on ques1");
		Thread.sleep(2000);
		actionutil.typeText(ques1, "ques1", "ques1 is entered");
		Thread.sleep(2000);		
		actionutil.clickOnElement(addques, "click on addques");
		actionutil.clickOnElement(ques2, "click on ques2");
		Thread.sleep(2000);
		actionutil.typeText(ques2, "ques2", "ques2 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(addques, "click on addques");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques3, "click on ques3");
Thread.sleep(2000);
		actionutil.typeText(ques3, "ques3", "ques3 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(addques, "click on addques");
		actionutil.clickOnElement(ques4, "click on ques4");
		Thread.sleep(2000);
		actionutil.typeText(ques4, "ques4", "ques4 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(submit, "scroll to submit");
		actionutil.clickOnElement(addques, "click on addques");
		actionutil.clickOnElement(ques5, "click on ques5");
		Thread.sleep(2000);
		actionutil.typeText(ques5, "ques5", "ques5 is entered");
		Thread.sleep(2000);
	
		actionutil.clickOnElement(addques, "click on addques");
		actionutil.clickOnElement(ques6, "click on ques6");
		Thread.sleep(2000);
		actionutil.typeText(ques6, "ques6", "ques6 is entered");
		Thread.sleep(2000);
		
		actionutil.clickOnElement(addques, "click on addques");
		actionutil.clickOnElement(ques7, "click on ques7");
		Thread.sleep(2000);
		actionutil.typeText(ques7, "ques7", "ques7 is entered");
		Thread.sleep(2000);
		
		actionutil.clickOnElement(addques, "click on addques");
		actionutil.clickOnElement(ques8, "click on ques10");
		Thread.sleep(2000);
		actionutil.typeText(ques8, "ques8", "ques8 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(submit, "scrolled to submit");
		actionutil.clickOnElement(addques, "click on addques");
		actionutil.clickOnElement(ques9, "click on ques9");
		Thread.sleep(2000);
		actionutil.typeText(ques9, "ques9", "ques9 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(submit, "scrolled to addbtn");
		Thread.sleep(2000);
	
		actionutil.clickOnElement(addques, "click on addques");
		//actionutil.clickOnElement(addques, "click on addques");
		
			actionutil.clickOnElement(ques10, "click on ques10");
		Thread.sleep(2000);
		actionutil.typeText(ques10, "ques10", "ques10 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(submit, "scrolled to addbtn");
		Thread.sleep(2000);
		actionutil.clickOnElement(submit, "click on submit");
		Thread.sleep(2000);
		actionutil.clickOnElement(yesbtn, "click on yesbtn");
		Thread.sleep(7000);
		System.out.println("company level questions are submitted......");
		actionutil.clickOnElement(check1, "click on check1");
		Thread.sleep(2000);
		actionutil.clickOnElement(check2, "click on check2");
		Thread.sleep(2000);
		actionutil.clickOnElement(check3, "click on check3");
		Thread.sleep(2000);
		actionutil.clickOnElement(check4, "click on check4");
		Thread.sleep(2000);
		actionutil.clickOnElement(check5, "click on check5");
		Thread.sleep(2000);
		actionutil.clickOnElement(subques, "click on subques");
		Thread.sleep(3000);
		actionutil.clickOnElement(name, "click on name");
		Thread.sleep(3000);
		actionutil.typeText(name, "abc", "name is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(subsubmit, "click on subsubmit");
		Thread.sleep(5000);
		
		System.out.println("subques of comapny level submitted");
		
		
	}

	public void traceaddproductuestions() throws InterruptedException {

		Thread.sleep(8000);
		//actionutil.clickOnElement(trace, "click on trace");
		//Thread.sleep(2000);
		actionutil.clickOnElement(questionbank, "click on questionbank");
		Thread.sleep(2000);
		actionutil.clickOnElement(addnew, "click on addnew");
		Thread.sleep(2000);
		actionutil.clickOnElement(dropdown, "click on dropdown");
		Thread.sleep(2000);
		actionutil.clickOnElement(productlevel, "click on productlevel");
		Thread.sleep(2000);
		actionutil.clickOnElement(addbtn, "click on addbtn");
		Thread.sleep(2000);
		actionutil.clickOnElement(addques, "click on addques");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques1, "click on ques1");
		Thread.sleep(2000);
		actionutil.typeText(ques1, "ques1", "ques1 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques2, "click on ques2");
		Thread.sleep(2000);
		actionutil.typeText(ques2, "ques2", "ques2 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques3, "click on ques3");
		Thread.sleep(2000);
		actionutil.typeText(ques3, "ques3", "ques3 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques4, "click on ques4");
		Thread.sleep(2000);
		actionutil.typeText(ques4, "ques4", "ques4 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques5, "click on ques5");
		Thread.sleep(2000);
		actionutil.typeText(ques5, "ques5", "ques5 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques6, "click on ques6");
		Thread.sleep(2000);
		actionutil.typeText(ques6, "ques6", "ques6 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques7, "click on ques7");
		Thread.sleep(2000);
		actionutil.typeText(ques7, "ques7", "ques7 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques8, "click on ques10");
		Thread.sleep(2000);
		actionutil.typeText(ques8, "ques8", "ques8 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques9, "click on ques9");
		Thread.sleep(2000);
		actionutil.typeText(ques9, "ques9", "ques9 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(ques10, "click on ques10");
		Thread.sleep(2000);
		actionutil.typeText(ques10, "ques10", "ques10 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(submit, "click on submit");
		Thread.sleep(2000);
		actionutil.clickOnElement(yesbtn, "click on yesbtn");
		Thread.sleep(5000);
		System.out.println("product level questions are submitted......");
		
	}

}
