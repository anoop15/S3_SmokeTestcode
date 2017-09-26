package com.s3.testCases;

import java.io.FileNotFoundException;

//import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.AddDashboardModule;
import com.s3.businessLogic.IsMultiCampus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCAddDashboardModule {

	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String filepath = Constant.REPORTS_DASHBOARDMODULE_FILE;
	ExtentReports extent = ExtentReports.get(TCAddDashboardModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void logConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCAddDashboardModule");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("Dashboard Module", "S3 TCAddDashboardModule Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test()
	public void addDashboardModule() throws Exception {
		String excelSheetName = Constant.ADD_DASHBOARDMODULE_SHEET;
		int row = 1;
		int col = 0;

		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.appName(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "openMyAppApplicaion Operation Performed");
			AddDashboardModule.dashboardModuleLogic(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.isAdded(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Add Dashboard Data Operation Performed");
			AddDashboardModule.PlistVerification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Dashboard Plist Verification Operation Performed");
			ExcelUtils.wrtExcelData(1, 12, excelFile, excelSheetName, "Pass");
			extent.log(LogStatus.PASS, "Dashboard Module test", "Test Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(158, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(158, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				extent.log(LogStatus.FAIL, "Dashboard Module test", "Test Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "DashboardModuleFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "DashboardModuleFailScreenShot.PNG");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(158, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(158, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
		}
	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();

	}
}
