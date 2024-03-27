package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;


public class Traceproduct {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	int randomNumber1= new Random().nextInt(13);
	String randomNumber12 = actionutil.generateRandomNumber(13);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String proname = "wheat" + randomNumber;
 	String userDir = System.getProperty("user.dir");
	String imageaddress1 = userDir + "\\src\\test\\resources\\data\\img.jpg";
	String imageaddress= "C:\\Users\\Deepti Jindal\\eclipse-workspace\\com.NFR.Trace\\src\\test\\resources\\data\\img.jpg";
	
    
	

	public Traceproduct(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
}
	
	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[4]/aside/div/ul/li[1]/div/span")
	private WebElement trace;
	
	/* X-path for Product */
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement products;
	
	/* X-path for Existing Product */
	@FindBy(xpath = "//h5[@id='EXISTING_PRODUCTS']")
	private WebElement existingproduct;
	
	/* X-path for Add New product*/
	@FindBy(xpath = "//h5[@id='ADD_NEW_PRODUCT']")
	private WebElement addnew;
	
	/* X-path for Product category*/
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[4]/div[1]/div/div[1]")
	private WebElement productcategory;
	//*[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]
	
	/* X-path for product based food */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[4]/div[1]/div/div[2]/ul/li[1]")
	private WebElement productbasedfood;

	/* X-path for productname */
	@FindBy(xpath = "//input[@id='add_product_productName']")
	private WebElement productname;

	/* X-path for productid */
	@FindBy(xpath = "//input[@id='add_product_gtin_input']")
	private WebElement productid;
	
	/* X-path for checkbox */
	@FindBy(xpath = "//input[@id='gtin-checkbox']")
	private WebElement checkbox;
	
	/* X-path for Autogenerate */
	@FindBy(xpath = "//button[@id='add_product_autogenerate_button']")
	private WebElement autogenerate;

	/* X-path for product description */
	@FindBy(xpath = "//textarea[@id='add_product_description_input']")
	private WebElement productdesc;
	
	/* X-path for upload */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[5]/div[2]/div[1]/div[2]/button")
	private WebElement upload;
	
	
	//span[text()='Upload Photo/Video']
	//button[@class='FileUpload_uploadButton__9mScn undefined']
	
	/* X-path for Ingredient name */
	@FindBy(xpath = "//input[@id='add_product_ingredients_input']")
	private WebElement ingredientname;
	

	/* X-path for Ingredient add */
	@FindBy(xpath = "//button[@id='add_product_ingredients_add_button']")
	private WebElement ingredientadd;
	
	/* X-path for Consumption */
	@FindBy(xpath = "//textarea[@id='add_product_guidelines_input']")
	private WebElement consumption;
	
	/* X-path for UOM */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[4]/div[1]/div/div[2]/ul/li[1]")
	private WebElement uom;
	
	/* X-path for Nutrition quanity */
	@FindBy(xpath = "//input[@id='add_product_nutrition_quantity_input']")
	private WebElement nutritionqty;
	
	/* X-path for Nutrition fact */
	@FindBy(xpath = "//input[@id='add_product_nutrition_name_input']")
	private WebElement nuritionfact;
	
	/* X-path for Nutrition drop */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[8]/div[2]/div/div[1]/div/div[2]/div[3]/div/div/div")
	private WebElement nuritiondrop;
	
	/* X-path for Nutrition value */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[8]/div[2]/div/div[1]/div/div[2]/div[3]/div/div/div[2]/ul/li[1]/div/div/div[1]")
	private WebElement nuritionvalue;


	/* X-path for Unit of Measurement */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[1]/div/div/div/input")
	private WebElement unitofmeasue;
	
	/* X-path for unit of measurement dropdown */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[1]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement dropdown;
	
	/* X-path for price */
	@FindBy(xpath = "//input[@name='price']")
	private WebElement price;
	
	/* X-path for currency */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[2]/div[2]/span/div/div/div[1]/div/input")
	private WebElement currency;
	
	/* X-path for currency value */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[2]/div[2]/span/div/div/div[2]/ul/li[1]/div/div/div/div/span")
	private WebElement currencyvalue;
	
	/* X-path for Add type packing*/
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[1]/input")
	private WebElement typepacking;
	
	/* X-path for Length*/
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[3]/input")
	private WebElement length;
	//*[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]
	
	/* X-path for breath */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[4]/input")
	private WebElement breath;

	/* X-path for height */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[5]/input")
	private WebElement height;

	/* X-path for checkbox1 */
	@FindBy(xpath = "//*[@id='defaultProcessCheckbox']")
	private WebElement checkbox1;
	
	/* X-path for register product*/
	@FindBy(xpath = "//*[@id='add-product-register-btn']")
	private WebElement registerproduct;
	
	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[2]/div[3]/div/div/div/div/input")
	private WebElement gln1;
	
	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[3]/div[3]/div/div/div/div/input")
	private WebElement gln2;
	
	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[4]/div[3]/div/div/div/div/input")
	private WebElement gln3;

	/* X-path for autosearch*/
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[2]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch;
	
	/* X-path for autosearch*/
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[3]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch1;
	/* X-path for autosearch*/
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[4]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch2;
	
	public void products() throws InterruptedException
	 {
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(4000);
		actionutil.scrollDowntoelement(products);
		Thread.sleep(2000);
		 actionutil.clickOnElement(products, "Products is clicked");
		 Thread.sleep(5000);
		// actionutil.clickOnElement(existingproduct, "existingproduct is clicked");
		 //Thread.sleep(2000);
		 actionutil.clickOnElement(addnew, "Add new is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(productcategory, "Click on productcategory");
		 actionutil.clickOnElement(productbasedfood, "productbasedfood is clicked");
		 actionutil.clickOnElement(productname, "product name is selected");
		 actionutil.typeText(productname,proname, "enter the product");
		 actionutil.clickOnElement(productid, "Click on productid");
		 actionutil.clickOnElement(checkbox, "Click on checkbox");
		 actionutil.clickOnElement(autogenerate, "Click on autogenerate");
		 actionutil.clickOnElement(productdesc, "Click on productdesc");
		 actionutil.typeText(productdesc, "test", "Enetered the product desc");
		 actionutil.clickOnElement(upload, "Click on upload");
		 		 Thread.sleep(2000);
		 		 
		         StringSelection ss = new StringSelection(imageaddress1);
		         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		         try {
		             Robot robot = new Robot();

		             // Pressing Enter key to focus on Window 
		             robot.keyPress(KeyEvent.VK_ENTER);
		             robot.keyRelease(KeyEvent.VK_ENTER);

		             // Pressing CTRL+V keys to paste the copied file path
		             robot.keyPress(KeyEvent.VK_CONTROL);
		             robot.keyPress(KeyEvent.VK_V);
		             
		             robot.keyRelease(KeyEvent.VK_V);
		             robot.keyRelease(KeyEvent.VK_CONTROL);

		             // Pressing Enter key to upload the file 
		             robot.keyPress(KeyEvent.VK_ENTER);
		             robot.keyRelease(KeyEvent.VK_ENTER);

		         } catch (Exception e) {
		            e.printStackTrace();
		         }
		// upload.sendKeys(imageaddress);
		Thread.sleep(2000);
		 //actionutil.typeText(gln,"9999978912345", "enter the GLN");
		// actionutil.typeText(gln,randomNumber12, "enter the GLN");
		 
		 
		// actionutil.typeText(autogenerate,"Bangalore Palace, Palace Cross Road, Vasanth Nagar, Bengaluru, Karnataka, India", "enter the  address");
	   	 
		 
		 
		// actionutil.typeText(city, "Bengaluru", "Enetered the city");
		 
		// actionutil.typeText(zipcode, "560052", "Enetred the Zip");
		 //actionutil.scrollDowntoelement(addbutton);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ingredientname);
		actionutil.scrollDown();
		//actionutil.scrollDowntoelement(ingredientname);
		//actionutil.scrollToElement1(ingredientname, "scroll to ingredientname");
		//actionutil.scrollToElement(ingredientname, "Scroll to ingredientname");
		 actionutil.clickOnElement(ingredientname, "Click on ingrediant name");
		 actionutil.typeText(ingredientname, "wheat", "ingredient name is entered");
		 Thread.sleep(1000);	
		 actionutil.scrollDown();
		 Thread.sleep(2000);
		 actionutil.clickOnElement(nuritionfact, "Click on ingrediant name");
		 actionutil.typeText(nuritionfact, "fact", "nutri name is entered");
		 actionutil.clickOnElement(nutritionqty, "Click on ingrediant QTY");
		 actionutil.typeText(nutritionqty, "1", "nutri qty is entered");
		 actionutil.clickOnElement(nuritiondrop, "Click on ingrediant drop");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(nuritionvalue, "Click on ingrediant value");
		 Thread.sleep(2000);
		 actionutil.scrollDown();
		 Thread.sleep(2000);
		 actionutil.scrollDown();
		 
		 actionutil.clickOnElement(unitofmeasue, "Click on ingrediant name");
		 actionutil.clickOnElement(dropdown, "Click on ingrediant name");
		 actionutil.clickOnElement(price, "Click on ingrediant name");
		 actionutil.typeText(price, "1", "price is entered");
		 actionutil.clickOnElement(currency, "Click on currency");
		 actionutil.scrollDown();
		 actionutil.clickOnElement(currencyvalue, "Click on currency value");
		 actionutil.clickOnElement(typepacking, "Click on typepacking value");
		 actionutil.typeText(typepacking, "1", "typepacking is entered");
		 actionutil.clickOnElement(length, "Click on length value");
		 actionutil.typeText(length, "1", "length is entered");
		 actionutil.clickOnElement(breath, "Click on breath value");
		 actionutil.typeText(breath, "1", "breath is entered");
		 actionutil.clickOnElement(height, "Click on height value");
		 actionutil.typeText(height, "1", "height is entered");
		 Thread.sleep(2000);
		 actionutil.scrollDown();
		 Thread.sleep(2000);
		 actionutil.scrollDown();
		 actionutil.clickOnElement(checkbox1, "Click on checkbox1");
		 actionutil.scrollDown();
		 Thread.sleep(2000);
		 actionutil.scrollDowntoelement(gln3);
		 //actionutil.scrollDown();
		 actionutil.clickOnElement(gln1, "Click on gln1");
		 actionutil.typeText(gln1, "0956265002424", "gln1 is entered");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(autosearch, "Click on autosearch");
		 Thread.sleep(2000);	
		 actionutil.clickOnElement(gln2, "Click on gln2");
		 actionutil.typeText(gln2, "0956265002424", "gln2 is entered");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(autosearch1, "Click on autosearch");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(gln3, "Click on gln3");
		 actionutil.typeText(gln3, "0956265002424", "gln3 is entered");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(autosearch2, "Click on autosearch");
		 Thread.sleep(2000);
		 actionutil.scrollDowntoelement(registerproduct);
		 Thread.sleep(2000);
		 actionutil.clickOnElement(registerproduct, "Click on registerproduct");
		 

	 }
	}
