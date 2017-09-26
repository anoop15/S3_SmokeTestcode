package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.AddPeopleSoftEnrollment;
import com.s3.businessLogic.IsMultiCampus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCAddPeopleSoftModule {

	public static int mRow;
	public static int mCol;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.ADD_PEOPLESOFT_SHEET;
	String filepath = Constant.REPORTS_PEOPLESOFTMODULE_FILE;
	ExtentReports extent = ExtentReports.get(TCAddPeopleSoftModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void logConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCAddPeopleSoftModule");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("AddPeopleSoftModule", "S3 AddPeopleSoftModule Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test()
	public void addNewPeopleSoftModule() throws Exception {
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.appName(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "openMyAppApplicaion Operation Performed");
			AddPeopleSoftEnrollment.addPeopleSoft(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.isAdded(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "addPeopleSoft Operation Performed");
			AddPeopleSoftEnrollment.plistVerification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "plistVerification Operation Performed");
			extent.log(LogStatus.PASS, "TCAddPeopleSoftModule", "Test Pass");
			ExcelUtils.wrtExcelData(1, 26, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(82, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(82, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 26, excelFile, excelSheetName, "Fail");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(82, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(82, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException fnf) {
				fnf.getStackTrace();
				System.out.println("Please close the Excel File Before Run");
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "TCAddPeopleSoftModule", "Test Fail");
		}

	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();
	}
}
