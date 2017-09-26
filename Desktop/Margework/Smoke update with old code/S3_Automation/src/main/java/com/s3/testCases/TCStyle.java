package com.s3.testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.businessLogic.StyleTab;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCStyle {
	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String filepath = Constant.REPORTS_STYLE_FILE;
	ExtentReports extent = ExtentReports.get(TCStyle.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void LogConfi() throws Exception {
		System.out.println("TCStyle started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("StyleTab");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("Login test", "S3 login test");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.startTest("Style Tab", "Style Tab Test Started");
	}

	@Test()
	public void style() throws Exception {

		String excelSheetName = Constant.STYLE_SHEET;
		int row = 1;
		int col = 0;
		try {
			extent.log(LogStatus.INFO, "Open Web Browser Operation Performed");
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "openMyAppApplicaion Operation Performed");
			StyleTab.selectNavigationLayout(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "selectNavigationLayout Operation Performed");
			StyleTab.Advance(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Advance Operation Performed");
			StyleTab.VerificationStyle();
			StyleTab.pListStyleVarification();
			extent.log(LogStatus.INFO, "pListStyleVarification Operation Performed");
			ExcelUtils.wrtExcelData(1, 71, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(92, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(92, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			extent.log(LogStatus.FAIL, "Style Tab Test", "Test Fail");
			Utils.getScreenShot(Constant.OUTPUT_DIR + "FailStyleScreenShot.PNG");
			extent.attachScreenshot(Constant.OUTPUT_DIR + "FailStyleScreenShot.PNG");
			ExcelUtils.wrtExcelData(1, 71, excelFile, excelSheetName, "Fail");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(92, 3, statusExcel, statusSheet, "Fail");
			ExcelUtils.wrtExcelData(92, 6, statusExcel, statusSheet, e.getMessage());
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
