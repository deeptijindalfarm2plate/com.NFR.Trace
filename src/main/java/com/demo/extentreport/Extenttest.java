package com.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demo.baseutil.Basetest;

/**
 * Description : Creates the HTML report based on the name specified.
 * 
 * @author Deepti Jindal
 *
 */
public class Extenttest {
	private static ExtentTest extenttest;
	private static ExtentReports extentreports;

	/**
	 * Description : Creates the HTML report based on the name specified
	 * 
	 * @author Deepti Jindal
	 * @param name
	 */
	public static ExtentTest createTest(String name) {

		extenttest = extentreports.createTest(name);
		return extenttest;
	}

	public static ExtentReports getExtent() {
		return extentreports;
	}

	/**
	 * Description : Initializes report specified in the file path
	 * 
	 * @author Deepti Jindal
	 * @param filepath
	 */
	public void initReport(String filepath) {
		extentreports = new Extent().getExtent(filepath);
		Basetest.logger.info("Report Initiated");
	}

}
