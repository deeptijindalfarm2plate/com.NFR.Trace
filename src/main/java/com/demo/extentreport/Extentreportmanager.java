package com.demo.extentreport;

import com.aventstack.extentreports.ExtentTest;

/**
 * Description Implements creation of the node,or parent block in the extent
 * report
 * 
 * @author Deepti Jindal
 *
 */
public class Extentreportmanager {

	private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();

	/**
	 * Description : Fetches the object of Extent reports for the test methods.
	 * 
	 * @author Deepti Jindal
	 * @return ExtentTest
	 */
	public static ExtentTest getExtentReportForTestMethods() {
		return extenttest.get();
	}

	/**
	 * Description :Sets the Extent Test for the test methods.
	 * 
	 * @author Deepti Jindal
	 * @param ExtentTest
	 */
	public static void setExtentReportsForTestMethods(ExtentTest extent) {
		extenttest.set(extent);
	}

	public static ThreadLocal<ExtentTest> extentmethod = new ThreadLocal<>();

	/**
	 * Description : Fetches the object of Extent Test for precondition
	 * 
	 * @author Deepti Jindal
	 * @return ExtentTest
	 */
	public static ExtentTest getExtentReportForClassMethods() {
		return extentmethod.get();
	}

	/**
	 * Description :Sets the Extent Test for the class method
	 * 
	 * @author Deepti Jindal
	 * @param ExtentTest
	 */
	public static void setExtentReportsForClassMethods(ExtentTest extent) {
		extentmethod.set(extent);
	}

	private static ThreadLocal<ExtentTest> extentprecondition = new ThreadLocal<>();

	/**
	 * Description : Fetches the object of Extent Test for precondition
	 * 
	 * @author Deepti Jindal
	 * @return ExtentTest
	 */
	public static ExtentTest getExtentReportForPrecondition() {
		return extentprecondition.get();
	}

	/**
	 * Description :Sets the Extent Test with the precondition
	 * 
	 * @author Deepti Jinda
	 * @param ExtentTest
	 */
	public static void setExtentReportsForPrecondition(ExtentTest extent) {
		extentprecondition.set(extent);
	}

	private static ThreadLocal<ExtentTest> parentreport = new ThreadLocal<>();

	/**
	 * Description :Sets the Extent Test for Parent node in report.
	 * 
	 * @author Deepti Jindal
	 * @param ExtentTest
	 */
	public static void setParentReport(ExtentTest extentTest) {
		parentreport.set(extentTest);
	}

	/**
	 * Description : Fetches the object of Extent Test for parent node in Report.
	 * 
	 * @author Deepti Jindal
	 * @return ExtentTest
	 */
	public static ExtentTest getParentReport() {
		return parentreport.get();
	}

	private static ThreadLocal<ExtentTest> testreport = new ThreadLocal<>();

	/**
	 * Description : Fetches the object of Extent Test for Test Report.
	 * 
	 * @author Deepti Jindal
	 * @return ExtentTest
	 */
	public static ExtentTest getTestReport() {
		return testreport.get();
	}

	/**
	 * Description :Sets the Extent Test for Report.
	 * 
	 * @author Deepti Jindal
	 * @param ExtentTest
	 */
	public static void setTestReport(ExtentTest extent) {
		testreport.set(extent);
	}

	private static ThreadLocal<ExtentTest> extentreport = new ThreadLocal<>();

	/**
	 * Description :Sets the Extent Test for Report.
	 * 
	 * @author Deepti Jindal
	 * @param ExtentTest
	 */
	public static void setReport(ExtentTest extentTest) {
		extentreport.set(extentTest);
	}

	/**
	 * Description : Fetches the object of Extent Test for Report.
	 * 
	 * @author Deepti Jindal
	 * @return ExtentTest
	 */
	public static ExtentTest getReport() {
		return extentreport.get();
	}

}
