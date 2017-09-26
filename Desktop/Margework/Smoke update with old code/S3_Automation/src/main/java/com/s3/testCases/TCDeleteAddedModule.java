package com.s3.testCases;

import java.io.FileNotFoundException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.DeleteAddedModules;
import com.s3.businessLogic.Login;
import com.s3.businessLogic.OpenMyApplication;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCDeleteAddedModule {

	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String filepath = Constant.REPORTS_DELETE_MODULE_FILE;
	ExtentReports extent = ExtentReports.get(TCDeleteAddedModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void logConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCDeleteAddedModule");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("TCDeleteAddedModule", "S3 TCDeleteAddedModule Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test()
	public void deleteModule() throws Exception {

		String excelSheetName = Constant.DELETE_ADDEDMODULE_SHEET;
		int row = 1;
		int col = 0;

		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			DeleteAddedModules.deleteModule(mRow, mCol, excelFile, excelSheetName);
			ExcelUtils.wrtExcelData(1, 6, excelFile, excelSheetName, "Pass");
			extent.log(LogStatus.PASS, "", "Test Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(156, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(156, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				extent.log(LogStatus.FAIL, "TCDeleteAddedModule", "Test Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "DeleteModuleFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "DeleteModuleFailScreenShot.PNG");
				ExcelUtils.wrtExcelData(1, 6, excelFile, excelSheetName, "Fail");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(156, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(156, 6, statusExcel, statusSheet, e.getMessage());
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
