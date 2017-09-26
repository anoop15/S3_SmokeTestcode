package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.AddPreDefinedWebModule;
import com.s3.businessLogic.IsMultiCampus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCAddBillPayModule {

	public static int mRow;
	public static int mCol;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.ADD_BILLPAYMODULE_SHEET;
	String filepath = Constant.REPORTS_BILLPAYMODULEFILE;
	ExtentReports extent = ExtentReports.get(TCAddBillPayModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void logConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCAddBillPayModule");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("TCAddBillPayModule", "S3 TCAddBillPayModule Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test()
	public void addPreDefinedWebModule() throws Exception {

		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.appName(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "openMyAppApplicaion Operation Performed");
			AddPreDefinedWebModule.addPredefinedWebModuleLogic(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.isAdded(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "addPredefinedWebModuleLogic Operation Performed");
			AddPreDefinedWebModule.pListVerification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "pListVerification Operation Performed");
			Utils.getScreenShot(Constant.OUTPUT_DIR + "LogoutPreDefinedWebScreenShot.PNG");
			extent.attachScreenshot(Constant.OUTPUT_DIR + "LogoutPreDefinedWebScreenShot.PNG");
			extent.log(LogStatus.PASS, "TCAddBillPayModule", "Test Pass");
			ExcelUtils.wrtExcelData(1, 23, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(111, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(111, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 23, excelFile, excelSheetName, "Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "PreDefinedModuleFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "PreDefinedModuleFailScreenShot.PNG");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(111, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(111, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "TCAddBillPayModule", "Test Fail");
		}
	}

	@AfterMethod()
	public void close() {
		Login.logout();
		extent.log(LogStatus.INFO, "Logout Operation Performed");
		Utils.browserClose();
		Utils.browserQuit();
	}
}
