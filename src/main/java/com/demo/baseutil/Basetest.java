package com.demo.baseutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.*;
import java.util.*; 
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.server.ResourceService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.demo.extentreport.Extentreportmanager;
import com.demo.extentreport.Extenttest;
import com.demo.fileutils.FileOperation;
import com.demo.util.WebActionUtil;

/***********************************************************************
 * Description : Implements Application Precondition and Postcondition.
 *
 * @author : Deepti Jindal
 * @BeforeSuite: Creates all the folder structure for Extent Reports
 * @BeforeClass : sets extent report.
 * @BeforeTest :Launches the browser according to the browser name specified.
 * @AfterSuite: Kills the driver (example chromedriver.exe) according to browser
 *              specified.
 */
public class Basetest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Logger logger = LogManager.getLogger();
	public static final String usrdir = "user.dir";
	public static final String CONFIGPATH = System.getProperty(usrdir) + "./config/config.properties";
	public static final int ITO = 10;
	public static final int ETO = 30;
	public static final String EXCELPATH = System.getProperty(usrdir) + "./src/main/resources/data/Data.xlsx";
	public static final String MESSAGESPATH = System.getProperty(usrdir)
			+ "./src/main/resources/data/messages.properties";
	public Initializepages pages;

	static {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Description :Creates folder structure for Extent reports. * @author:Deepti Jindal
	 */

	@BeforeSuite(alwaysRun = true)
	public synchronized void createFolder() {
		try {
			logger.info("Folder creation for Extent");
			FileOperation fileOperation = new FileOperation();
			fileOperation.CreateFiles();
		} catch (Exception e) {
			logger.error("Exception while report inititation");
		}

	}

	/**
	 * Description: sets extent report
	 *
	 * @author:Deepti Jindal
	 *
	 */

	@BeforeClass(alwaysRun = true)
	public void setExtentReport() {
		try {
			ExtentTest parentExtentTest = Extenttest.createTest(getClass().getSimpleName());
			Extentreportmanager.setParentReport(parentExtentTest);
		} catch (Exception e) {
			WebActionUtil.error("Unable to create the node for class");
		}
	}

	/**
	 * Description: launches browser and creates node for extent report.
	 *
	 * @author:Deepti Jindal
	 * @param:browserName
	 * @param: methodName
	 */
	@Parameters("browserName")
	@BeforeTest
	public void launchBrowser(String browserName) {
		try {
			driver = Createdriver.getInstance().setDriver(browserName);
			WebActionUtil actionutil = new WebActionUtil(driver, ETO);
			pages = new Initializepages(driver, ETO, actionutil);
			driver.get(prop.getProperty("APP_URL"));
			driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} catch (Exception e) {
			WebActionUtil.fail("Failed to launch the Browser");
			WebActionUtil.error("Failed to launch the Browser");
		}

	}

	@BeforeMethod
	public void test(Method methodName) {

		String description = methodName.getAnnotation(Test.class).description();
		ExtentTest testReport = Extentreportmanager.getParentReport().createNode(methodName.getName(), description);
		Extentreportmanager.setTestReport(testReport);
		logger = LogManager.getLogger(getClass().getName());

	}

	/**
	 * Description: Kills drivers.
	 * 
	 * @author:Deepti Jindal
	 * @param:browserName
	 */
	@Parameters("browserName")
	@AfterSuite
	public synchronized void killTask(String browserName) {
		try {
			if (driver != null) {
             driver.close();
			driver.quit();

			} else {
				WebActionUtil.error("Failed to close the Browser");
			}
		} catch (Exception e) {
			WebActionUtil.error("Failed to close the Browser");
		}
			}
}
