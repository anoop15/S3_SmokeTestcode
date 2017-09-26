package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.AddNewsVideosSportsModule;
import com.s3.businessLogic.IsMultiCampus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCAddNewsModule {

	public static int mRow;
	public static int mCol;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.Add_NEWSMODULE_SHEET;
	// This is to get the file names from Constant.java file
	// This is to get the total number of rows in excel file which will get from
	// ExcelUtils.java file
	String filepath = Constant.REPORTS_NEWSMODULE_FILE;
	ExtentReports extent = ExtentReports.get(TCAddNewsModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void logConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("News Module");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("News Module", "S3 News Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.log(LogStatus.INFO, "Open Web Browser Operation Performed");
		extent.config().useExtentFooter(false);

	}

	@Test()
	public void addNewsVideoSportsModule() throws Exception {
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.appName(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Open My Application Operation Performed");
			AddNewsVideosSportsModule.addNewsVideosSportsLogic(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.isAdded(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Add Data in module Operation Performed");
			AddNewsVideosSportsModule.plistVerification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "PList Verification Performed");
			ExcelUtils.wrtExcelData(1, 27, excelFile, excelSheetName, "Pass");
			extent.log(LogStatus.PASS, "News test", "Test Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(77, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(77, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 27, excelFile, excelSheetName, "Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "addNewsVideosSportsFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "addNewsVideosSportsFailScreenShot.PNG");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(77, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(77, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException fnf) {
				fnf.getStackTrace();
				System.out.println("Please close the Excel File Before Run");
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "News test", "Test Fail");
		}
	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();
	}
}