package com.s3.testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.ManageClients;
import com.s3.businessLogic.Login;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCManageClients {
	public static int mRow;
	public static int mCol;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.CLIENT_SHEET;
	String filepath = Constant.REPORTS_CLIENT_FILE;
	ExtentReports extent = ExtentReports.get(TCManageClients.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void LogConfi() throws Exception {
		System.out.println("TCManageclient started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCCreateClient");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("CreateClient", "S3 CreateClient Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);

	}

	@Test()
	public void Client() throws Exception {

		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			ManageClients.ClkAdmin();
			extent.log(LogStatus.INFO, "ClkAdmin Operation Performed");
			ManageClients.CreateClient(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "CreateClient Operation Performed");
			ManageClients.VerifyClient(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "VerifyClient Operation Performed");
			ManageClients.EditClient(mRow, mCol, excelFile, excelSheetName);
			extent.attachScreenshot(Constant.OUTPUT_DIR + "ClientEditScreenShot.PNG");
			ManageClients.deleteClient(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Logout Operation Performed");
			ExcelUtils.wrtExcelData(1, 10, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(7, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(7, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			ExcelUtils.wrtExcelData(1, 10, excelFile, excelSheetName, "Fail");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(7, 3, statusExcel, statusSheet, "Fail");
			ExcelUtils.wrtExcelData(7, 6, statusExcel, statusSheet, e.getMessage());
			Utils.getScreenShot(Constant.OUTPUT_DIR + "ClientFailScreenShot.PNG");
			extent.attachScreenshot(Constant.OUTPUT_DIR + "ClientFailScreenShot.PNG");
			extent.log(LogStatus.FAIL, "Client test", "Test Fail");
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
