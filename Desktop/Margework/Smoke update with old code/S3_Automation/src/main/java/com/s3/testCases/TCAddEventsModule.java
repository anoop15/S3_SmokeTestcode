package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.AddEventsModule;
import com.s3.businessLogic.IsMultiCampus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCAddEventsModule {
	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.ADD_EVENTSMODULE_SHEET;
	String filepath = Constant.REPORTS_EVENTSMODULE_FILE;
	ExtentReports extent = ExtentReports.get(TCAddEventsModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void logConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("News/Video/Sport Module");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("Events Module", "S3 Events Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.log(LogStatus.INFO, "Open Web Browser Operation Performed");
		extent.config().useExtentFooter(false);

	}

	@Test()
	public void AddEventModule() throws Exception {
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.appName(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "openMyAppApplicaion Operation Performed");
			AddEventsModule.addEventsNoduleLogic(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.isAdded(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "addEventsNoduleLogic Operation Performed");
			AddEventsModule.plistVerification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "plistVerification Operation Performed");
			ExcelUtils.wrtExcelData(1, 23, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(57, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(57, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 23, excelFile, excelSheetName, "Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "BurserModuleFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "BurserModuleFailScreenShot.PNG");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(57, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(57, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "AddEventModule test", "Test Fail");
		}

	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();
	}
}
