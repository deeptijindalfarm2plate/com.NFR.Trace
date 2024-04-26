package com.demo.fileutils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description : Implements creation of file variables required to perform
 * various file operations.
 * 
 * @author: Deepti Jindal
 *
 */
public class FileVariables {
	private String extentDir;
	private static String screenshotpath;
	private String sStartTime;
	private String extentReportFolderPath;
	private Date date;
	private SimpleDateFormat sdf;
	private String sDate;
	private String hash;

	/**
	 * Description:Gets the screenshot path
	 * 
	 * @author:Deepti Jindal
	 * @param screenShotPath
	 */
	public static String getScreenShotPath() {
		return screenshotpath;
	}

	/**
	 * Description:Sets the screenshot path
	 * 
	 * @author:Deepti Jindal
	 * @param screenShotPath
	 */
	public void setScreenShotPath(String screenShotPath) {
		FileVariables.screenshotpath = screenShotPath;
	}

	/**
	 * Description:Gets start time
	 * 
	 * @author:Deepti Jindal
	 * @return sStartTime
	 */

	public String getsStartTime() {
		return sStartTime;
	}

	/**
	 * Description:Sets the start time
	 * 
	 * @author:Deepti Jindal
	 * @param sStartTime
	 */
	public void setsStartTime(String sStartTime) {
		this.sStartTime = sStartTime;
	}

	/**
	 * Description:Gets Extent report folder path
	 * 
	 * @author:Deepti Jindal
	 * @return extentReportFolderPath
	 */
	public String getExtentReportFolderPath() {
		return extentReportFolderPath;
	}

	/**
	 * Description:Sets the Extent report folder path
	 * 
	 * @author:Deepti Jindal
	 * @param extentReportFolderPath
	 */
	public void setExtentReportFolderPath(String extentReportFolderPath) {
		this.extentReportFolderPath = extentReportFolderPath;
	}

	/**
	 * Description:Gets Date
	 * 
	 * @author:Deepti Jindal
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Description:Sets the date
	 * 
	 * @author:Deepti Jindal
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Description:Gets simple date format
	 * 
	 * @author:Deepti Jindal
	 * @return sdf
	 */
	public SimpleDateFormat getSdf() {
		return sdf;
	}

	/**
	 * Description:Sets the simple date format
	 * 
	 * @author:Deepti Jindal
	 * @param sdf
	 */
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	/**
	 * Description:Gets Date
	 * 
	 * @author:Deepti Jindal
	 * @return sDate
	 */
	public String getsDate() {
		return sDate;
	}

	/**
	 * Description:Sets the date
	 * 
	 * @author:Deepti Jindal
	 * @param sDate
	 */
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	/**
	 * Description:Gets Hash
	 * 
	 * @author:Deepti Jindal
	 * @return hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * Description Sets the hash
	 * 
	 * @author:Deepti Jindal
	 * @param hash
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * Description:Gets extent directory
	 * 
	 * @author:Deepti Jindal
	 * @return extentDir
	 */
	public String getExtentDir() {
		return extentDir;
	}

	/**
	 * Description:Sets extent dir
	 * 
	 * @author:Deepti Jindal
	 * @param extentDir
	 */
	public void setExtentDir(String extentDir) {
		this.extentDir = extentDir;
	}
}
