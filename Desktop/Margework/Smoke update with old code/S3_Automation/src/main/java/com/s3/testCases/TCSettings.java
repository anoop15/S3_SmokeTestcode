package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.businessLogic.Settings;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCSettings {

	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String filepath = Constant.REPORTS_SETTINGS_FILE;
	String statusExcel = Constant.STATUS_EXCEL_FILE;
	String statusSheet = Constant.STATUS_SHEET;
	ExtentReports extent = ExtentReports.get(TCSettings.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void loginConfiguration() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Settings Tab");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
		extent.startTest("Settings Tab", "Settings Tab Test Started");
		extent.log(LogStatus.INFO, "Open Web Browser Operation Performed");

	}

	@Test()
	public void settingsData() throws Exception {
		String excelSheetName = Constant.SETTINGS_SHEET;
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			Settings.appSettingsLogic(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Settings Operation Performed");
			Login.logout();
			ExcelUtils.wrtExcelData(96, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(96, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 37, excelFile, excelSheetName, "Fail");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(96, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(96, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "Settings Tab test", "Test Fail");
		}
	}
}
