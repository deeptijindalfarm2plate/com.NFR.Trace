package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;


public class Traceproductshare {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	int randomNumber1= new Random().nextInt(13);
	String randomNumber12 = actionutil.generateRandomNumber(13);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String proname = "wheat" + randomNumber1 + randomNumber;
 	String userDir = System.getProperty("user.dir");
	String imageaddress1 = userDir + "\\src\\test\\resources\\data\\img.jpg";
	String filePath = userDir +  "\\src\\test\\resources\\data\\file.txt";
	String imageaddress= "C:\\Users\\Deepti Jindal\\eclipse-workspace\\com.NFR.Trace\\src\\test\\resources\\data\\img.jpg";
	
    
	

	public Traceproductshare(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
}
	
	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[1]/div/span")
	private WebElement trace;
	
	/* X-path for Product */
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement products;
	
	/* X-path for Existing Product */
	@FindBy(xpath = "//h5[@id='EXISTING_PRODUCTS']")
	private WebElement existingproduct;
	
	/* X-path for Link share product*/
	@FindBy(xpath = "//h5[@id='LINK_SHARE_PRODUCT']")
	private WebElement share;
	
	/* X-path for Product category*/
	//@FindBy(xpath = "//div/input[@name='sharedProduct']")
	@FindBy(xpath ="(//label[contains(@class, 'ProductTypeSelector')])[2]")
	private WebElement sharedp;
	//*[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]
	
	/* X-path for product based food */
	@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[1]")	
	private WebElement prodid;
	
	/* X-path for product based food */
	@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[2]")
	private WebElement orgid;

	/* X-path for product description */
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content']/div[@class='product-label'])[1]")
	private WebElement prolabel;
	
	/* X-path for product existing */
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content']/div[@class='organization-label'])[1]")
	private WebElement orglabel;

	
	/* X-path for upload */
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	
	/* X-path for upload */
	@FindBy(xpath = "//div[@id='liveToast']")
	private WebElement toast;
	

	
	public void productsadd() throws InterruptedException, IOException
	 {
		Thread.sleep(8000);
		//actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(4000);
		actionutil.scrollDowntoelement(products);
		Thread.sleep(2000);
		 actionutil.clickOnElement(products, "Products is clicked");
		 Thread.sleep(5000);
		 actionutil.clickOnElement(share, "link share is clicked");
		 Thread.sleep(2000);
		 
		 actionutil.clickOnElement(sharedp, "shared radio is checked");
		 actionutil.clickOnElement(prodid, " Product id is checked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(prolabel, "prolabel is checked");
		 Thread.sleep(2000);
		actionutil.clickOnElement(orgid, "orgid is checked");
		 Thread.sleep(2000);
		actionutil.clickOnElement(orglabel, "orglabel is checked");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(submit, "submit is checked");
		 Thread.sleep(1000);
       String messageText = toast.getText();
	        System.out.println("Toast message: " + messageText);
	        String substring1 = "Success";
	        String substring2 = "was shared with";
	        boolean containsSubstring1 = messageText.contains(substring1);
	        boolean containsSubstring2 = messageText.contains(substring2);

	        Assert.assertTrue(containsSubstring1 && containsSubstring2, "Toast message does not contain the required substrings.");
			Basetest.logger.info("product shared successful");
			
		}
			
			
	}
