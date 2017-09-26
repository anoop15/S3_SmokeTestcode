package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.MyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCDeleteMyApplication {
	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.DELETE_MYAPPLICATION_SHEET;
	String filepath = Constant.REPORTS_DELETEMYAPPLICATION_FILE;
	ExtentReports extent = ExtentReports.get(TCDeleteMyApplication.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void LogConfi() throws Exception {
		System.out.println("TCDeleteMyApplication started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCDeleteMyAppliction");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
		extent.startTest("MyApplications", "DeleteMyApplications Test Started");
		extent.log(LogStatus.INFO, "Open Web Browser Operation Performed");
	}

	@Test()
	public void DeleteMyApplication() throws FileNotFoundException {
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			MyApplication.SearchApp(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Serch App Operation Performed");
			MyApplication.DeleteApp(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Delete/Cancel Operation Performed");
			extent.log(LogStatus.PASS, "TCDeleteMyAppliction test", "Test Pass");
			ExcelUtils.wrtExcelData(1, 5, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(105, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(105, 6, statusExcel, statusSheet,"");
		} catch (Exception e) {
			ExcelUtils.wrtExcelData(1, 5, excelFile, excelSheetName, "Fail");
			Utils.getScreenShot(Constant.OUTPUT_DIR + "DeleteMyApplicationFail.PNG");
			extent.attachScreenshot(Constant.OUTPUT_DIR + "DeleteMyApplicationFail.PNG");
			extent.log(LogStatus.PASS, "TCDeleteMyAppliction test", "Test Fail");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(105, 3, statusExcel, statusSheet, "Fail");
			ExcelUtils.wrtExcelData(105, 6, statusExcel, statusSheet, e.getMessage());
			extent.log(LogStatus.FAIL, "TCDeleteMyAppliction test", "Test Fail");
			Assert.assertTrue(false);
		}
	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();
	}

}
