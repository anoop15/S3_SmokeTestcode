package com.s3.testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.Users;
import com.s3.businessLogic.Login;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCUsers {

	public static int mRow;
	public static int mCol;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.USER_SHEET;
	String filepath = Constant.REPORTS_USER_FILE;
	ExtentReports extent = ExtentReports.get(TCUsers.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void logConfi() throws Exception {
		System.out.println("TCUser started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCCreateAdminUser");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("CreateAdminUser", "S3 CreateAdminUser Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);

	}

	@Test()
	public void admin() throws Exception {
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			Users.clkUsers();
			extent.log(LogStatus.INFO, "Click User Operation Performed");
			Users.createNewUser(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "createNewUser Operation Performed");
			Users.veriCreatedUser(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Verify createdNewUser Operation Performed");
			Users.editUser(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Edit user Operation Performed");
			Users.deleteUser(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "delete User Operation Performed");
			ExcelUtils.wrtExcelData(1, 19, excelFile, excelSheetName, "Pass");
			extent.log(LogStatus.PASS, " AdminUser test", "Test Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(11, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(11, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			ExcelUtils.wrtExcelData(1, 19, excelFile, excelSheetName, "Fail");
			Utils.getScreenShot(Constant.OUTPUT_DIR + "AdminUserFailScreenShot.PNG");
			extent.attachScreenshot(Constant.OUTPUT_DIR + "AdminUserFailScreenShot.PNG");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(11, 3, statusExcel, statusSheet, "Fail");
			ExcelUtils.wrtExcelData(11, 6, statusExcel, statusSheet, e.getMessage());
			extent.log(LogStatus.FAIL, " AdminUser test", "Test Fail");
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