package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.Info;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCInfo {

	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String filepath = Constant.REPORTS_SETTINGS_FILE;
	ExtentReports extent = ExtentReports.get(TCInfo.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void loginConfiguration() throws Exception {
		System.out.println("TCInfo startrd");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Info Tab");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
		extent.startTest("Info Tab", "Info Tab Test Started");
		extent.log(LogStatus.INFO, "Open Web Browser Operation Performed");
	}

	@Test()
	public void Info() {
		String excelSheetName = Constant.INFO_SHEET;
		int row = 1;
		int col = 0;

		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "OpenMyApplication Operation Performed");
			Info.infoTab(mRow, mCol, excelFile, excelSheetName);
			Info.pListverification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "infoTab Operation Performed");
			ExcelUtils.wrtExcelData(1, 25, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(100, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(100, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 25, excelFile, excelSheetName, "Fail");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(100, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(100, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "open my applications test test", "Test Fail");
		}
	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();
	}
}
