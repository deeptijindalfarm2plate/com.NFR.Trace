package com.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demo.baseutil.Basetest;
import com.demo.fileutils.FileVariables;

/**
 * Description: Implements the creation of the Extent report with specified name
 * after loading the Extent config file from specified location. * @author
 * Deepti Jindal
 */
public class Extent {

	private ExtentReports extent;
	FileVariables fileVariables = new FileVariables();

	/**
	 * Description: Creates of HTML report in specified path
	 */

	public ExtentReports getExtent(String filepath) {

		if (extent == null) {
			try {
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter(filepath + " _Report.html"));
				return extent;
			} catch (Exception e) {
				Basetest.logger.error("Exception while creating report html file.");

			}
		}
		return extent;
	}

	/**
	 * Description :Loads the Extent-config file specified from the location
	 *
	 * @author Deepti Jindal
	 * @param filePath
	 */
	private static ExtentHtmlReporter getHtmlReporter(String filePath) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "./config/extent-config2.xml");
		return htmlReporter;
	}

}
