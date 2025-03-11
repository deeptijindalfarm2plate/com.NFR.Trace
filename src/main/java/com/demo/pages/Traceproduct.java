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
import org.openqa.selenium.support.ui.Select;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Traceproduct {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	int randomNumber1 = new Random().nextInt(13);
	String randomNumber12 = actionutil.generateRandomNumber(13);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String proname = "wheat" + randomNumber1 + randomNumber + randomNumber12;
	String userDir = System.getProperty("user.dir");
	String imageaddress1 = userDir + "\\src\\test\\resources\\data\\img.jpg";
	String filePath = userDir + "\\src\\test\\resources\\data\\NewProduct.txt";
	String imageaddress = "C:\\Users\\Deepti Jindal\\eclipse-workspace\\com.NFR.Trace\\src\\test\\resources\\data\\img.jpg";

	public Traceproduct(WebDriver driver, long eto, WebActionUtil actionutil) {
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

	/* X-path for Add New product */
	@FindBy(xpath = "//h5[@id='ADD_NEW_PRODUCT']")
	private WebElement addnew;

	/* X-path for Product category */
	@FindBy(xpath = "//*[@id='add_product_productCategory']")
	private WebElement productcategory;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]

	/* X-path for product based food */
	@FindBy(xpath = "//*[@id='add_product_productCategory_0']")
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

	/* X-path for product existing */
	@FindBy(xpath = "	//*[@id='EXISTING_PRODUCTS']")
	private WebElement productexists;

	/* X-path for upload */
	@FindBy(xpath = "//button[@id='add_product_fileUpload']")
	private WebElement upload;

	// span[text()='Upload Photo/Video']
	// button[@class='FileUpload_uploadButton__9mScn undefined']

	/* X-path for Ingredient name */
	@FindBy(xpath = "//input[@id ='add_product_ingredients_input_0']")
	private WebElement ingredientname;

	/* X-path for Ingredient add */
	@FindBy(xpath = "//button[@id='add_product_ingredients_add_button']")
	private WebElement ingredientadd;

	/* X-path for Consumption */
	@FindBy(xpath = "//textarea[@id='add_product_guidelines_input']")
	private WebElement consumption;

	/* X-path for UOM */
	@FindBy(xpath = "//*[@id='add_product_nutrition_uom_0']")
	private WebElement uom;

	/* X-path for Nutrition quanity */
	@FindBy(xpath = "//input[@id='add_product_nutrition_quantity_input_0']")
	private WebElement nutritionqty;

	/* X-path for Nutrition fact */
	@FindBy(xpath = "//input[@id='add_product_nutrition_name_input_0']")
	private WebElement nuritionfact;

	/* X-path for Nutrition drop */
	@FindBy(xpath = "//*[@id='add_product_nutrition_uom_0']")
	private WebElement nuritiondrop;

	/* X-path for Nutrition value */
	@FindBy(xpath = "//*[@id='add_product_nutrition_uom_0_0']")
	private WebElement nuritionvalue;

	/* X-path for Unit of Measurement */
	@FindBy(xpath = "(//*[@id='add_product_productUOM'])[1]")
	private WebElement unitofmeasue;

	/* X-path for unit of measurement dropdow */
	@FindBy(xpath = "//*[@id='add_product_productUOM_0']")
	private WebElement dropdown;

	/* X-path for price */
	@FindBy(xpath = "//input[@name='price']")
	private WebElement price;

	/* X-path for currency */
	@FindBy(xpath = "//*[@id='currency']")
	private WebElement currency;

	/* X-path for currency value */
	@FindBy(xpath = "//span[contains(text(),'USA ($)')]")
	private WebElement currencyvalue;

	/* X-path for Add type packing */
	@FindBy(xpath = "//*[@id='PackagingInputTable_inputs_quantity_0']")
	private WebElement typepacking;

	/* X-path for Length */
	@FindBy(xpath = "//*[@id='PackagingInputTable_inputs_length_0']")
	private WebElement length;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]

	/* X-path for breath */
	@FindBy(xpath = "//*[@id='PackagingInputTable_inputs_breadth_0']")
	private WebElement breath;

	/* X-path for height */
	@FindBy(xpath = "//*[@id='PackagingInputTable_inputs_height_0']")
	private WebElement height;

	/* X-path for checkbox1 */
	@FindBy(xpath = "//*[@id='defaultProcessCheckbox']")
	private WebElement checkbox1;

	/* X-path for register product */
	@FindBy(xpath = "//*[@id='add-product-register-btn']")
	private WebElement registerproduct;

	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_0']")
	private WebElement gln1;

	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_1']")
	private WebElement gln2;

	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_2']")
	private WebElement gln3;
	
	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_3']")
	private WebElement gln4;
	

	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_4']")
	private WebElement gln5;

	/* X-path for autosearch */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_0_0']")
	private WebElement autosearch;
	
	/* X-path for autosearch */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_3_0']")
	private WebElement autosearch4;
	
	/* X-path for autosearch */
	@FindBy(xpath = "//*[@id='DefaultProcessTable_inputs_gln_4_0']")
	private WebElement autosearch5;

	/* X-path for autosearch */
	@FindBy(xpath = " //*[@id='DefaultProcessTable_inputs']/div[1]/div/div[3]/div[3]/div/div/div[2]/ul/li[1]")
	private WebElement autosearch1;

	/* X-path for autosearch */
	@FindBy(xpath = "  //*[@id='DefaultProcessTable_inputs']/div[1]/div/div[4]/div[3]/div/div/div[2]/ul/li[1]")
	private WebElement autosearch2;

	/* X-path for prodcut id */
	@FindBy(xpath = "//tr[1]/th[2]")
	private WebElement productidsaved;
	
	/* X-path for prodcut id */
	@FindBy(xpath = "//input[@type='search']")
	private WebElement existingproductidfield;
	
	/* X-path for prodcut id */
	@FindBy(xpath = "//div[@id='productSearch_0']")
	private WebElement productidedit;
	
	//div[@id='productSearch_0']ivate WebElement productidedit;

	/* X-path for table */
	@FindBy(xpath = "//*[@id='myId']/div[1]")
	private WebElement table;

	/* X-path for save button */
	@FindBy(xpath = "//*[@id='add-product-reconfirmation-modal-save-btn']")
	private WebElement save;
	
	/* X-path for delete button */
	@FindBy(xpath = "(//*[@id='Group_12476'])[4]")
	private WebElement delship;
	
	/* X-path for save button */
	@FindBy(xpath = "(//*[contains(text(), 'Yes')])[1]")
	private WebElement delshipconfirm;
	
	
	
	

	public void productsadd() throws InterruptedException, IOException {
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(4000);
		actionutil.scrollDowntoelement(products);
		Thread.sleep(2000);
		actionutil.clickOnElement(products, "Products is clicked");
		Thread.sleep(5000);
		// actionutil.clickOnElement(existingproduct, "existingproduct is clicked");
		// Thread.sleep(2000);
		actionutil.clickOnElement(addnew, "Add new is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(productcategory, "Click on productcategory");
		actionutil.clickOnElement(productbasedfood, "productbasedfood is clicked");
		actionutil.clickOnElement(productname, "product name is selected");
		actionutil.typeText(productname, proname, "enter the product");
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
		// actionutil.typeText(gln,"9999978912345", "enter the GLN");
		// actionutil.typeText(gln,randomNumber12, "enter the GLN");

		// actionutil.typeText(autogenerate,"Bangalore Palace, Palace Cross Road,
		// Vasanth Nagar, Bengaluru, Karnataka, India", "enter the address");

		// actionutil.typeText(city, "Bengaluru", "Enetered the city");

		// actionutil.typeText(zipcode, "560052", "Enetred the Zip");
		// actionutil.scrollDowntoelement(addbutton);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", ingredientname);
		// actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.scrollDowntoelement(upload);
		// actionutil.scrollDowntoelement(ingredientname);
		// actionutil.scrollToElement1(ingredientname, "scroll to ingredientname");
		// actionutil.scrollToElement(ingredientname, "Scroll to ingredientname");
		actionutil.clickOnElement(ingredientname, "Click on ingrediant name");
		actionutil.typeText(ingredientname, "wheat", "ingredient name is entered");
		Thread.sleep(1000);
		// actionutil.scrollDowntoelement(nuritionfact);
		Thread.sleep(2000);
		actionutil.clickOnElement(nuritionfact, "Click on ingrediant name");
		actionutil.typeText(nuritionfact, "fact", "nutri name is entered");
		actionutil.clickOnElement(nutritionqty, "Click on ingrediant QTY");
		actionutil.typeText(nutritionqty, "1", "nutri qty is entered");
		actionutil.clickOnElement(nuritiondrop, "Click on ingrediant drop");
		Thread.sleep(2000);
		actionutil.clickOnElement(nuritionvalue, "Click on ingrediant value");
		Thread.sleep(2000);
		actionutil.scrollDowntoelement(nuritionfact);
		Thread.sleep(2000);
		actionutil.scrollDown();

		actionutil.clickOnElement(unitofmeasue, "Click on Uinitofmeasure name");
		actionutil.clickOnElement(dropdown, "Click on Uinitofmeasure name");
		actionutil.clickOnElement(price, "Click on Uinitofmeasure name");
		actionutil.typeText(price, "1", "price is entered");
		actionutil.clickOnElement(currency, "Click on currency");
		// actionutil.scrollDowntoelement(currencyvalue);
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
		/** For Defect id: 19693
		
		actionutil.clickOnElement(checkbox1, "Click on checkbox1");
		// actionutil.scrollDown();
		Thread.sleep(5000);
		actionutil.scrollDowntoelement(height);
		// actionutil.scrollDown();
		actionutil.clickOnElement(gln1, "Click on gln1");
		actionutil.typeText(gln1, "warehouse", "gln1 is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(autosearch, "Click on autosearch");
		Thread.sleep(2000);
		actionutil.clickOnElement(gln2, "Click on gln2");
		actionutil.typeText(gln2, "warehouse", "gln2 is entered");
		Thread.sleep(3000);
		actionutil.clickOnElement(autosearch1, "Click on autosearch");
		Thread.sleep(2000);
		actionutil.clickOnElement(gln3, "Click on gln3");
		actionutil.typeText(gln3, "warehouse", "gln3 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(table, "scrolldown to table:");
		Thread.sleep(2000);
		actionutil.clickOnElement(autosearch2, "Click on autosearch");
	//	Thread.sleep(2000);
	//	actionutil.clickOnElement(gln4, "Click on gln4");
	//	actionutil.typeText(gln4, "warehouse", "gln4 is entered");
		//Thread.sleep(4000);
		//actionutil.clickOnElement(autosearch4, "Click on autosearch");
		Thread.sleep(5000);
		actionutil.clickOnElement(gln5, "Click on gln5");
		actionutil.typeText(gln5, "warehouse", "gln5 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(table, "scrolldown to table:");
		Thread.sleep(2000);
		actionutil.clickOnElement(autosearch5, "Click on autosearch");
		Thread.sleep(5000);
		actionutil.clickOnElement(delship, "click on del of ship");
		actionutil.clickOnElement(delshipconfirm, "click on confirm of ship");
		Thread.sleep(4000);
		
		**/
		actionutil.scrollDowntoelement(registerproduct);
		Thread.sleep(2000);
		actionutil.clickOnElement(registerproduct, "Click on registerproduct");
		Thread.sleep(12000);
		//extra lines frpm 386 to 397//
		actionutil.scrollDowntoelement(products);
		Thread.sleep(2000);
		actionutil.clickOnElement(products, "Products is clicked");
		Thread.sleep(25000);
		
		
		//driver.navigate().refresh();
	//	actionutil.clickOnElement(existingproductidfield, "product exist is clicked");
		//Thread.sleep(5000);
		//actionutil.clickOnElement(productidedit, "product exist is clicked");
		//Thread.sleep(5000);
	
		String saved = productidsaved.getText();
		String savedinfile = " product id:   " + saved;
		System.out.println(" Print the value of saved" + "  " + saved);

		// String filePath = "/path/to/your/file.txt";

		// Initialize FileWriter in append mode
		FileWriter writer = new FileWriter(filePath, true);
		writer.write(savedinfile + "\n"); // Write the first value
		writer.write(saved + "\n"); // Write the first value
		writer.close();
		System.out.println("Product is registered successfull");
		
	}

	public void productsaddmanu() throws InterruptedException, IOException {
		Thread.sleep(8000);
		// actionutil.clickOnElement(trace, "click on trace");
		// Thread.sleep(4000);
		actionutil.scrollDowntoelement(products);
		Thread.sleep(2000);
		actionutil.clickOnElement(products, "Products is clicked");
		Thread.sleep(5000);
		// actionutil.clickOnElement(existingproduct, "existingproduct is clicked");
		// Thread.sleep(2000);
		actionutil.clickOnElement(addnew, "Add new is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(productcategory, "Click on productcategory");
		actionutil.clickOnElement(productbasedfood, "productbasedfood is clicked");
		actionutil.clickOnElement(productname, "product name is selected");
		actionutil.typeText(productname, proname, "enter the product");
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
		
		Thread.sleep(2000);
				Thread.sleep(2000);
		actionutil.scrollDowntoelement(upload);
			actionutil.clickOnElement(ingredientname, "Click on ingrediant name");
		actionutil.typeText(ingredientname, "wheat", "ingredient name is entered");
		Thread.sleep(1000);
				Thread.sleep(2000);
		actionutil.clickOnElement(nuritionfact, "Click on ingrediant name");
		actionutil.typeText(nuritionfact, "fact", "nutri name is entered");
		actionutil.clickOnElement(nutritionqty, "Click on ingrediant QTY");
		actionutil.typeText(nutritionqty, "1", "nutri qty is entered");
		actionutil.clickOnElement(nuritiondrop, "Click on ingrediant drop");
		Thread.sleep(2000);
		actionutil.clickOnElement(nuritionvalue, "Click on ingrediant value");
		Thread.sleep(2000);
		actionutil.scrollDowntoelement(nuritionfact);
		Thread.sleep(2000);
		actionutil.scrollDown();

		actionutil.clickOnElement(unitofmeasue, "Click on ingrediant name");
		actionutil.clickOnElement(dropdown, "Click on ingrediant name");
		actionutil.clickOnElement(price, "Click on ingrediant name");
		actionutil.typeText(price, "1", "price is entered");
		actionutil.clickOnElement(currency, "Click on currency");
		// actionutil.scrollDowntoelement(currencyvalue);
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
		// Thread.sleep(2000);
		// actionutil.scrollDown();
		// actionutil.scrollDowntoelement(checkbox1);
		actionutil.clickOnElement(checkbox1, "Click on checkbox1");
		// actionutil.scrollDown();
		Thread.sleep(5000);
		actionutil.scrollDowntoelement(height);
		// actionutil.scrollDown();
		actionutil.clickOnElement(gln1, "Click on gln1");
		actionutil.typeText(gln1, "test", "gln1 is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(autosearch, "Click on autosearch");
		Thread.sleep(2000);
		actionutil.clickOnElement(gln2, "Click on gln2");
		actionutil.typeText(gln2, "test", "gln2 is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(autosearch1, "Click on autosearch");
		Thread.sleep(5000);
		actionutil.clickOnElement(gln3, "Click on gln3");
		actionutil.typeText(gln3, "test", "gln3 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(table, "scrolldown to table:");
		Thread.sleep(2000);
		actionutil.clickOnElement(autosearch2, "Click on autosearch");
		Thread.sleep(2000);
		Thread.sleep(5000);
		actionutil.clickOnElement(gln4, "Click on gln3");
		actionutil.typeText(gln4, "test", "gln4 is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(autosearch, "Click on autosearch");
		Thread.sleep(2000);
		
		actionutil.clickOnElement(gln5, "Click on gln3");
		actionutil.typeText(gln5, "test", "gln5 is entered");
		Thread.sleep(2000);
		actionutil.scrollToElement(table, "scrolldown to table:");
		Thread.sleep(2000);
		actionutil.clickOnElement(autosearch2, "Click on autosearch");
		Thread.sleep(2000);
		
		actionutil.scrollDowntoelement(registerproduct);
		Thread.sleep(2000);
		actionutil.clickOnElement(registerproduct, "Click on registerproduct");
		Thread.sleep(10000);
		// actionutil.clickOnElement(productexists, "product exist is clicked");
		Thread.sleep(10000);
		driver.navigate().refresh();
		String saved = productidsaved.getText();
		String savedinfile = " product id:   " + saved;
		System.out.println(" Print the value of saved" + "  " + saved);

		// String filePath = "/path/to/your/file.txt";

		// Initialize FileWriter in append mode
		FileWriter writer = new FileWriter(filePath, true);
		writer.write(savedinfile + "\n"); // Write the first value
		writer.write(saved + "\n"); // Write the first value
		writer.close();

	}

	public void productedit() throws InterruptedException {
		Thread.sleep(2000);
		actionutil.clickOnElement(productidedit, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.scrollToElement(productdesc, "Product description is clicked");
		actionutil.typeText(productdesc, "TestTest", "prodcut description is edited");
		Thread.sleep(2000);
		actionutil.scrollDownToBottom();
		Thread.sleep(2000);
		actionutil.scrollDowntoelement(save);
		Thread.sleep(2000);
		actionutil.clickOnElement(save, "Saved is clicked");

	}

}
