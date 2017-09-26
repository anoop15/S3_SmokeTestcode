package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.AddAppModule;
import com.s3.businessLogic.IsMultiCampus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCAddAppModule {
	public static int mRow;
	public static int mCol;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.ADD_APPMODULE_SHEET;
	String filepath = Constant.REPORTS_APPMODULE_FILE;
	ExtentReports extent = ExtentReports.get(TCAddAppModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void LogConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCAdd_AppModule");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("AddAppModule", "S3 TCAddAppModule Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test()
	public void AddAppModule() throws Exception {

		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			// Utils.getScreenShot(Constant.OUTPUT_DIR+"LoginAppModuleScreenShot.PNG");
			// extent.attachScreenshot(Constant.OUTPUT_DIR+"LoginAppModuleScreenShot.PNG");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.appName(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "openMyAppApplicaion Operation Performed");
			// Utils.getScreenShot(Constant.OUTPUT_DIR+"openMyAppApplicaionScreenShot.PNG");
			// extent.attachScreenshot(Constant.OUTPUT_DIR+"openMyAppApplicaionScreenShot.PNG");
			AddAppModule.addAppModuleLogic(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.isAdded(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "addAppModuleLogic Operation Performed");
			// Utils.getScreenShot(Constant.OUTPUT_DIR+"addAppModuleLogicScreenShot.PNG");
			// extent.attachScreenshot(Constant.OUTPUT_DIR+"addAppModuleLogicScreenShot.PNG");
			AddAppModule.PlistVerification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Logout Operation Performed");
			// Utils.getScreenShot(Constant.OUTPUT_DIR+"LogoutAppModuleScreenShot.PNG");
			// extent.attachScreenshot(Constant.OUTPUT_DIR+"LogoutAppModuleScreenShot.PNG");
			ExcelUtils.wrtExcelData(1, 26, excelFile, excelSheetName, "Pass");
			extent.log(LogStatus.PASS, "AddAppModule test", "Test Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(26, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(26, 4, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				System.out.println("This is the exception" + e.getMessage());
				ExcelUtils.wrtExcelData(1, 26, excelFile, excelSheetName, "Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "AppModuleFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "AppModuleFailScreenShot.PNG");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(26, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(26, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "App Module test", "Test Fail");
		}
	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();

	}

}
