package com.demo.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.grid.web.ErrorHandler;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demo.baseutil.Basetest;
import com.demo.extentreport.Extentreportmanager;
import com.paulhammant.ngwebdriver.NgWebDriver;

/**
 * Description: All the action utilities added in this class e.g
 * clickonelement,WaitforElement etc
 *
 * @author : Deepti Jindal
 */

public class WebActionUtil extends Basetest {
	public static WebDriver driver;
	WebDriverWait wait;
	public long ETO;
	public JavascriptExecutor jsExecutor;
	public Actions action;
	public String mainID;
	public static TakesScreenshot screenshot;
	public static Integer EXPLICIT_WAIT_120_SEC = 120;
	public static StringBuffer VERIFICATION_ERRORS = new StringBuffer();
	public static Random rand = new Random();
	public static String value;
	public static ExtentHtmlReporter htmlReporter;

	public WebActionUtil(WebDriver driver, long ETO) {
		this.driver = driver;
		this.ETO = ETO;
		wait = new WebDriverWait(driver, ETO);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		screenshot = (TakesScreenshot) driver;
	}

	/**
	 * Description Method to find random value 
	 *
	 * @author deep
	 * @param return value
	 */
	public void findvalue(List<WebElement> l1, WebElement we1, String elementName){
		
		
		
		
		for (WebElement li : l1) {			
			
			li = l1.get(rand.nextInt(l1.size()));
			li.click();
			return;
		}
		
		info("Enter the value into " + elementName);
		
		
	}
	
	public static boolean find_CAT(List<WebElement> l1 ) throws InterruptedException, IOException {
		
		if(!l1.isEmpty()) {
		
		for (WebElement li : l1) {			
			
					li = l1.get(rand.nextInt(l1.size()));
					WebElement cat =li.findElement(By.tagName("a"));
					value =cat.getAttribute("href");
		}
		}
		else {
			return false;
		}
		boolean Responce = Responce(value);
		if(Responce == false) {
			return false;
		}
		return true;
		
	}
	
	public static boolean Responce(String testcaseurl) throws IOException {
		// TODO Auto-generated method stub
			HttpURLConnection huc = null;
             huc = (HttpURLConnection)(new URL(testcaseurl).openConnection());
             
             huc.setRequestMethod("HEAD");
             
             huc.connect();
             
             int respCode = huc.getResponseCode();
             
             if(respCode == 200){
                driver.get(testcaseurl);
                return true;  
             }
             else {
            	 return false;
             }
	}
	
	/**
	 * Description Method to provide info in the extent report
	 *
	 * @author Deepti Jindal
	 * @param message
	 */
	public void extentinfo(String message) {
		Extentreportmanager.getTestReport().info(message);
	}

	/**
	 *
	 * Description Method for the info updation in extent Report Report
	 *
	 * @author Deepti Jindal
	 * @param message
	 */

	public void pass(String message) {
		Extentreportmanager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	/**
	 *
	 * Description Method for the error/errorure updation in extent Report
	 *
	 * @author Deepti Jindal
	 * @param message
	 */

	public static void fail(String message) {
		Reporter.log(message);
		Extentreportmanager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 *
	 * Description Method for the error/errorure updation in extent Report
	 *
	 * @author Deepti Jindal
	 * @param message
	 * @param color
	 */

	public static void validationinfo(String message, String color) {
		if (color.equalsIgnoreCase("blue"))
			Extentreportmanager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
		else if (color.equalsIgnoreCase("green"))
			Extentreportmanager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
		else if (color.equalsIgnoreCase("red"))
			Extentreportmanager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 * Description Method to provide info in the log,extent reports,testNg reports
	 *
	 * @author Deepti Jindal
	 * @param message
	 */
	public static void info(String message) {
		Basetest.logger.info(message);
	}

	/**
	 * Description Method for the Warning updation in extent Report,Log file,TestNG
	 * Report
	 *
	 * @author Deepti Jindal
	 * @param message
	 */
	public void warn(String message) {
		Basetest.logger.warn(message);
		Reporter.log(message);
	}

	/**
	 *
	 * Description Method for the error updation in Console and logs
	 *
	 * @author Deepti Jindal
	 * @param message
	 */
	public static void error(String message) {
		Basetest.logger.error(message);
		Reporter.log(message);
	}

	/**
	 *
	 * Description Method for fetching of get Current Date Time
	 *
	 * @author Deepti Jindal
	 *
	 */
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 *
	 * Description Method for fetching Current Date
	 *
	 * @author Deepti Jindal
	 *
	 */
	public static String getCurrentDate() {
		DateFormat customFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * Description :Checks whether an element is visible
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 *
	 */
	public synchronized boolean isElementVisible(WebElement element, String elemantName) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			info(elemantName + " is visible");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 *
	 * Description Check whether the Element is displayed with expected conditions
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public synchronized boolean isElementClickable(WebElement element, String elementName) {

		info("Validate " + elementName + " is clickable");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			error(elementName + " is not clickable");
			return false;
		}
	}

	/**
	 *
	 * Description Method to delete the directory
	 *
	 * @author Deepti Jindal
	 * @param pathToDeleteFolder
	 */
	public static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 *
	 * Description Method to delete folder directory
	 *
	 * @author Deepti Jindal
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}
		}
		folderToDelete.delete();
	}

	/**
	 * Description Capture the screenshot of the complete screen
	 *
	 * @author Deepti Jindal
	 * @param path
	 * @return destinationPath
	 */
	public static String getScreenShot(String path) {
		File src = (screenshot.getScreenshotAs(OutputType.FILE));
		String destinationPath = path + getCurrentDateTime() + ".png";
		File destination = new File(destinationPath);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destinationPath;
	}

	/**
	 * Description To Enter the Text to the Text filed
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public synchronized void typeText(WebElement element, String value, String elementName) {
		try {
			info("Enter the value into " + elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(value);
			info(value + " typed into " + elementName);
			extentinfo(value + " typed into " + elementName);
		} catch (AssertionError error) {
			error(" Unable to type " + value + " into " + elementName);
			Assert.fail("Unable to type " + elementName);
		} catch (Exception e) {
			error(" Unable to type " + value + "into " + elementName);
			Assert.fail("Unable to type " + elementName);
		}
	}

	/**
	 * Description Clear the Text
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public void clearText(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			info("Clear the text present in" + elementName);
		} catch (Exception e) {
			error("Unable to clear the text in " + elementName);
		}
	}

	/**
	 * Description To Select the value by the Visible Text
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param value
	 */
	public synchronized void selectByText(WebElement element, String value) {
		try {
			info("Select the value " + value);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select selecvalue = new Select(element);
			selecvalue.selectByVisibleText(value);
			info(value + " is selected");
			extentinfo(value + " is selected");
		} catch (Exception e) {
			error(" Unable to select the value : " + value);
			fail(" Unable to select the value : " + value);
			Assert.fail("Unable to select the value : " + value);
		}
	}

	/**
	 * Description Scroll to the Element
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public void scrollToElement(WebElement element, String elementName) {
		info("Scroll till the " + elementName);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			info("Scroll till the " + elementName + " completed");
		} catch (Exception e) {
			error("Scroll till the " + elementName + " failed");
		}
	}
	
	
	public void scrollToElement1(WebElement element, String elementName) {
	    info("Scroll till the " + elementName);
	    try {
	        new WebDriverWait(driver, 20)
	                .until(ExpectedConditions.elementToBeClickable(element));
	        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	        info("Scroll till the " + elementName + " completed");
	    } catch (Exception e) {
	        error("Scroll till the " + elementName + " failed");
	    }
	}


	/**
	 * Description Scroll up
	 *
	 * @author Deepti Jindal
	 */
	public synchronized void scrollUp() {
		try {
			jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight , 0)");
			info("Scroll up");
		} catch (Exception e) {
			error("Scroll up failed");
		}
	}
	
	/**
	 * Description Scroll down
	 *
	 * @author Deepti Jindal
	 */
	
	public synchronized void scrollDowntoelement(WebElement element) {
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			info("Scroll down");
		} catch (Exception e) {
			error("Scroll down failed");
		}
	}
	public synchronized void scrollDown() {
		try {
			jsExecutor.executeScript("window.scrollBy(0,100)");
			info("Scroll down");
		} catch (Exception e) {
			error("Scroll down failed");
		}
	}
	public synchronized void scrollDown1() {
		try {
			jsExecutor.executeScript("window.scrollBy(0,80)");
			info("Scroll down");
		} catch (Exception e) {
			error("Scroll down failed");
		}
	}
	
	public static void scrollDownToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // This will scroll the page to the bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


	/**
	 * Description Method scroll till particular element using javascript
	 *
	 * @author Deepti Jindal
	 * @param yaxis
	 * @param elementName
	 */
	public synchronized void scrollTillUsingJs(int yaxis, String elementName) {
		try {
			jsExecutor.executeScript("window.scrollBy(0," + yaxis + ")");
			info("Scrolled Till" + elementName);

		} catch (WebDriverException we) {
			error("Unable to scroll till element:" + elementName);
		}
	}

	/**
	 * Description To create the duration of the Test Run
	 *
	 * @author Deepti Jindal
	 * @param millis
	 */
	public static String formatDuration(final long millis) {
		long seconds = (millis / 1000) % 60;
		long minutes = (millis / (1000 * 60)) % 60;
		long hours = millis / (1000 * 60 * 60);

		StringBuilder b = new StringBuilder();
		b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) : String.valueOf(hours));
		b.append(":");
		b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) : String.valueOf(minutes));
		b.append(":");
		b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) : String.valueOf(seconds));
		return b.toString();
	}

	/**
	 * Description Wait for the angular page to load
	 *
	 * @author Deepti Jindal
	 */
	public synchronized void waitForAngularPageToLoad() {
		try {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return Boolean.valueOf(((JavascriptExecutor) driver)
							.executeScript("return (window.angular !== undefined) "
									+ "&& (angular.element(document).injector() !== undefined) "
									+ "&& (angular.element(document).injector().get('$http').pendingRequests.length === 0)")
							.toString());
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(pageLoadCondition);
		} catch (Exception e) {
			error("Unable to load the page correctly");
		}
	}

	/**
	 * Description : Wait for the angular page load
	 *
	 * @author Deepti Jindal
	 *
	 */
	public synchronized void waitForAngularPageload() {
		// JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		NgWebDriver ngDriver = new NgWebDriver(jsExecutor);
		ngDriver.waitForAngularRequestsToFinish();
	}

	/**
	 *
	 * Description Wait for the Element is displayed with expected conditions
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public void waitForElement(WebElement element, String elementName) {
		try {
			info("Wait for " + elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) != null);

		} catch (Exception e) {
			error(elementName + " is not visible");
		}
	}

	/**
	 * Description Wait for the load by checking ready state using
	 * JavascriptExecutor
	 *
	 * @author Deepti Jindal
	 * @param timeInSecs
	 */
	public synchronized void waitForPageLoadJS(int timeInSecs) {
		new WebDriverWait(driver, timeInSecs).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	/**
	 *
	 * Description : Wait for given time
	 *
	 * @author Deepti Jindal B
	 * @param millis
	 */
	public synchronized static void poll(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * Description Check whether the Element is displayed with expected conditions
	 *
	 * @author Deepti Jindal B
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementDisplayed(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
		}
	}

	/**
	 *
	 * Description : Validate the value entered in an element
	 *
	 * @author Deepti Jindal B
	 * @param expectedValue
	 * @param actualvalue
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateEnteredValue(String expectedValue, String actualvalue, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		try {
			Assert.assertEquals(expectedValue, actualvalue);
			info("Valid value is entered in " + elementName);
			info(validationPassMessage);
			validationinfo(validationPassMessage, color);
			extentinfo(validationPassMessage);
		} catch (Exception e) {
			error("Valid value is not entered in " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
		}
	}

	/**
	 *
	 * Description : Verify the attribute value of an element
	 *
	 * @author Deepti Jindal B
	 * @param element
	 * @param attribute
	 * @param valuetobecompared
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateAttribute(WebElement element, String attribute, String valuetobecompared,
			String elementName, String validationPassMessage, String validationFailMessage, String color) {
		String actualvalue = element.getAttribute(attribute);
		try {
			wait.until(ExpectedConditions.attributeContains(element, attribute, valuetobecompared));
			Assert.assertEquals(element.getAttribute(attribute), valuetobecompared);
			info("Expected attribute value : " + valuetobecompared + " is matching with the actual attribute value : "
					+ actualvalue + " of " + elementName);
			info(validationPassMessage);
			validationinfo(validationPassMessage, color);
		} catch (Exception e) {
			error("Expected attribute value : " + valuetobecompared
					+ " is not matching with the actual attribute value : " + actualvalue + " of " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
		}
	}

//	/**
//	 * Description :Retrieves text of the web element
//	 *
//	 * @author Shreya u
//	 * @param element
//	 * @param attribute
//	 * @param elementName
//	 * @param validationPassMessage
//	 * @param validationFailMessage
//	 * @param color
//	 */
//	public synchronized void validateAttributeIsEmpty(WebElement element, String attribute, String elementName,
//			String validationPassMessage, String validationFailMessage, String color) {
//		String actualvalue = element.getAttribute(attribute);
//		try {
//			if (actualvalue.isEmpty()) {
//				info(validationPassMessage);
//				validationinfo(validationPassMessage, color);
//				// extentinfo(validationPassMessage);
//			} else {
//				error(validationFailMessage);
//				fail(validationFailMessage);
//			}
//		} catch (Exception e) {
//			error(validationFailMessage);
//			fail(validationFailMessage);
//		}
//	}

	/**
	 *
	 * Description Check whether the Element is Enabled
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementEnabled(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isEnabled());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
		}
	}

//	/**
//	 *
//	 * Description : Validate the download format
//	 *
//	 * @author Deepti Jindal B
//	 * @param downloadedDocumentName
//	 * @param validationPassMessage
//	 * @param validationFailMessage
//	 * @param color
//	 */
//	public synchronized void validateDownload(String downloadedDocumentName, String validationPassMessage,
//			String validationFailMessage, String color) {
//		String userDir = System.getProperty("user.home");
//
//		File file = new File(userDir + "/Downloads/" + downloadedDocumentName);
//
//		if (file.exists()) {
//			info("Downloaded document name is " + downloadedDocumentName);
//			info(validationPassMessage);
//			validationinfo(validationPassMessage, color);
//		} else {
//			error(validationFailMessage);
//			fail(validationFailMessage);
//			Assert.fail("Unable to validate downloaded document");
//		}
//
//	}

	/**
	 * Description :Retrieves text of the webelement
	 *
	 * @author Shreya u
	 * @param element
	 * @param elementName
	 */
	public synchronized String getText(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			info(elementName + " is visible");
			String text = element.getText();
			info("Retrieved the text of the element " + elementName);
			return text;
		} catch (Exception e) {
			error("Failed to retrieve the text of the element " + elementName);
			return null;
		}
	}

//	/**
//	 * Description :Compares text of the webelement
//	 *
//	 * @author Deepti Jindal
//	 * @param actual
//	 * @param expected
//	 * @param color
//	 *
//	 */
//	public synchronized void comparetText(String actual, String expected, String color) {
//		try {
//			Assert.assertEquals(actual, expected);
//			info(actual + " is matching with " + expected);
//			validationinfo(actual + " is matching with " + expected, color);
//
//		} catch (Exception e) {
//			error(actual + " is not matching with " + expected);
//			fail(actual + " is not matching with " + expected);
//		}
//	}

//	/**
//	 * Description :Retrieves text of the Web element
//	 *
//	 * @author Shreya u
//	 * @param element
//	 * @param elementName
//	 * @return enteredValue
//	 */
//	public synchronized String getTextUsingJS(WebElement element, String elementName) {
//		String enteredValue = null;
//		try {
//			// poll(5000);
//			wait.until(ExpectedConditions.visibilityOf(element));
//			info(elementName + " is visible");
//			enteredValue = (String) (jsExecutor.executeScript("return arguments[0].value", element));
//			info("The value entered in " + elementName + " is " + enteredValue);
//		} catch (Exception e) {
//			error("Failed to retrieve the entered value from " + elementName);
//		}
//		return enteredValue;
//	}

//	/**
//	 *
//	 * Description : Retrieves the value entered in an element
//	 *
//	 * @author Deepti Jindal B
//	 * @param elementId
//	 * @param elementName
//	 * @return enteredValue
//	 */
//	public synchronized String getTextUsingElementId(String elementId, String elementName) {
//		String enteredValue = null;
//		try {
//			poll(1000);
//			String script = "return document.getElementById('" + elementId + "').value";
//			enteredValue = (String) (jsExecutor.executeScript(script));
//			info("The value entered in " + elementName + " is " + enteredValue);
//		} catch (Exception e) {
//			error("Failed to retrieve the entered value from " + elementName);
//		}
//		return enteredValue;
//	}

//	/**
//	 * Description : Get file Name
//	 *
//	 * @author Vivek Dogra
//	 * @param fileFormat
//	 * @return fileName
//	 */
//	public synchronized String getSampleFileName(String fileFormat) {
//		String fileName = "Sample" + fileFormat.toUpperCase() + "." + fileFormat;
//		return fileName;
//
//	}

//	/**
//	 * Description Method to delete excel file from downloads
//	 *
//	 * @author Deepti Jindal
//	 * @param downloadspath
//	 */
//	public synchronized void deleteXlFilesFromDownloads(String downloadspath) {
//		// Delete all files from this directory
//		String targetDirectory = downloadspath;
//		File dir = new File(targetDirectory);
//
//		// Filter out all log files
//		String[] xlFiles = dir.list((d, s) -> {
//			boolean fileName = s.startsWith("Claim") && s.endsWith(".xlsx") ? true : false;
//			return fileName;
//		});
//		if (xlFiles.length >= 50) {
//			for (String xlFile : xlFiles) {
//				String tempXLFile = new StringBuffer(targetDirectory).append(File.separator).append(xlFile).toString();
//				File fileDelete = new File(tempXLFile);
//				boolean isdeleted = fileDelete.delete();
//				// System.out.println("file : " + tempXLFile + " is deleted : " + isdeleted);
//			}
//		}
//	}

	/**
	 * Description Method refresh browser using java script
	 *
	 * @author Deepti Jindal
	 *
	 */
	public synchronized void refreshUsingJs() {
		try {
			jsExecutor.executeScript("history.go[0];");
			info("Refreshed browser");
		} catch (WebDriverException we) {
			error("Unable to refresh browser:");
		}

	}

	/**
	 * Description Method return page text using java script
	 *
	 * @author Deepti Jindal
	 * @return innerText
	 */
	public synchronized String getInnerTextUsingJs() {
		try {
			String innerText = jsExecutor.executeScript("return document.documentElement.innerText;").toString();
			return innerText;
		} catch (Exception we) {
			error("Unable to get the inner text of the page");
		}
		return null;

	}

	/**
	 *
	 * Description Method clicks on web element
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 * @throws InterruptedException 
	 */
	public synchronized void clickOnElement(WebElement element, String elementName) throws InterruptedException {

		if (isElementClickable(element, elementName)) {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Thread.sleep(2000);
			info("Clicked on : " + elementName);
			extentinfo("Clicked on : " + elementName);
		} else {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)) == null);
		}
	}

	/**
	 * Description Click on the Element using JavaScript
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public void clickOnElementUsingJS(WebElement element, String elementName) {
		try {
			if (isElementClickable(element, elementName)) {
				jsExecutor.executeScript("arguments[0].click();", element);
				info("Clicked on : " + elementName);
				extentinfo("Clicked on : " + elementName);
			}
		} catch (NoSuchElementException e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) == null);
		}
	}

	/**
	 * Description Click on element using action class
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 *
	 */
	public synchronized void actionClick(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.click(element).build().perform();
			info("Clicked on : " + elementName);
			extentinfo("Clicked on : " + elementName);
		} catch (Exception e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.fail("Unable to click on " + elementName);
		}

	}

	/**
	 * Description: Verifying the Web element is present or not
	 * 
	 * @param element
	 * @return
	 */
	public boolean verifyWebElementPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_120_SEC);
		wait.pollingEvery(Duration.ofSeconds(1));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (NoSuchElementException | NoSuchFrameException | NoSuchWindowException e) {
			driver.navigate().refresh();
			VERIFICATION_ERRORS.append(
					"Element: " + element + " is not present on page \n -Caugth exception: " + e.getMessage() + "\n\n");
			return false;
		}
	}

	/**
	 * Description Click on the check box
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public void clickCheckBox(WebElement element, String elementname) {
		wait.until(ExpectedConditions.visibilityOf(element));
		if (element.isSelected()) {
			info(elementname + " selected by default");
			extentinfo(elementname + " selected by default");
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			info(elementname + " is selected");
			extentinfo(elementname + " is selected");
		}
	}

	/**
	 * Description Click on the check box
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public void clickCheckBoxUsingJS(WebElement element, String elementname) {
		wait.until(ExpectedConditions.visibilityOf(element));
		if (element.isSelected()) {
			info(elementname + " selected by default");
			extentinfo(elementname + " selected by default");
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			jsExecutor.executeScript("arguments[0].click();", element);
			info(elementname + " is selected");
			extentinfo(elementname + " is selected");
		}
	}

	/**
	 * Description: Verifying element is displaying
	 *
	 * @author Deepti Jindal
	 * @param element
	 */
	public boolean isElementDisplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException
				| org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public void waitForElementToBeGone(WebElement element, int timeout) {
		if (isElementDisplayed(element)) {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
		}
	}

	/**
	 * Description Double Click On Element
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 */
	public void doubleClickOnElement(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.doubleClick(element).perform();
			info("Double clicked on : " + elementName);
			extentinfo("Double clicked on : " + elementName);
		} catch (Exception e) {
			error("Unable to double click on " + elementName);
			fail("Unable to double click on " + elementName);
			Assert.fail("Unable to double click on " + elementName);
		}
	}

	/**
	 * Description Mouse over on an element
	 *
	 * @author Deepti Jindal
	 * @param element
	 * @param elementName
	 *
	 */
	public synchronized void actionMouseOver(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			action.moveToElement(element).build().perform();
			info("Able to mouse over on " + elementName);
			extentinfo("Able to mouse over on " + elementName);
		} catch (Exception e) {
			error("Unable to mouse over on " + elementName);
			fail("Unable to mouse over on " + elementName);
			Assert.fail("Unable to mouse over on " + elementName);
		}

	}

	/**
	 * Description :Method to switch to Child Window/Tab
	 *
	 * @author Deepti Jindal
	 */
	public synchronized void switchWindow() {
		mainID = driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			if (!id.equals(mainID)) {
				driver.switchTo().window(id);
			}
		}
	}

	/**
	 * Description :Method to switch to Main Window/Tab
	 *
	 * @author Deepti Jindal
	 */
	public synchronized void switchToMainWindow() {
		driver.switchTo().window(mainID);
	}
	
	/** To read the data from excel file*/
	 @DataProvider(name = "getLoginData")
	    public Object[][] getLoginData() throws IOException {
       
       String userDir = System.getProperty("user.dir");
       String filePath = userDir + "\\eclipse-workspace\\com.NFR.Trace\\src\\test\\resources\\data\\data.xlsx";
       String sheetName = "Sheet1";

       FileInputStream fileInputStream = new FileInputStream(filePath);
       XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
       XSSFSheet sheet = workbook.getSheet(sheetName);

       int rowCount = sheet.getPhysicalNumberOfRows();
       List<Object[]> data = new ArrayList<>();

       for (int i = 1; i < rowCount; i++) {
           XSSFRow row = sheet.getRow(i);
           Cell emailCell = row.getCell(1);
           Cell passwordCell = row.getCell(2);

           String email = emailCell.getStringCellValue();
           String password = passwordCell.getStringCellValue();

           data.add(new Object[]{email, password});
       }

       workbook.close();
       fileInputStream.close();

       return data.toArray(new Object[0][0]);
   }
/** Function to create random name
 *  Author : Deepti Jindal
 */
	 
	 public static String generateRandomAlphanumeric(int length) {
	        // Define the characters to use in the random string
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	        // Create a StringBuilder to store the random string
	        StringBuilder randomString = new StringBuilder(length);

	        // Create a Random object
	        Random random = new Random();

	        // Generate random alphanumeric string
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            randomString.append(characters.charAt(index));
	        }

	        return randomString.toString();
	    }

/** To open a new tab
 * Author: Deepti Jindal
 */
	 
	 public static void openNewTab() {
	        // Use Actions class to send key combinations for opening a new tab
	        Actions actions = new Actions(driver);
	        WebElement body = driver.findElement(By.tagName("body"));

	        // Press and hold the Control key, press T, then release both keys (Ctrl + T)
	        actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();

	        // Wait for a while to ensure the new tab is opened
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	  
	 }
	 
	 
	 public static void switchToNewTab(String originalHandle) {
	        Set<String> handles = driver.getWindowHandles();
	        for (String handle : handles) {
	            if (!handle.equals(originalHandle)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }
	    }

	    // Method to switch back to the original tab
	    public static void switchToOriginalTab(String originalHandle) {
	        driver.switchTo().window(originalHandle);
	    }
	
	 
	    public static String generateRandomNumber(int length) {
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
	            // Generate a random digit between 0 and 9
	            int digit = random.nextInt(10);
	            sb.append(digit);
	        }
	        return sb.toString();
	    }
	 
	 
}
