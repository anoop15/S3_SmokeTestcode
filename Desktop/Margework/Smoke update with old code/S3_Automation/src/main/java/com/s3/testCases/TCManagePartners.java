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
import com.s3.businessLogic.ManagePartners;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCManagePartners {
	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.PARTNER_Sheet;
	String filepath = Constant.REPORTS_MANAGEPARTNER_FILE;
	ExtentReports extent = ExtentReports.get(TCManagePartners.class);
	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void LogConfi() throws Exception {
		System.out.println("TCManagePartners started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCManagePartners");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
		extent.startTest("Manage Partner", "Manage Partner Test Started");
		extent.log(LogStatus.INFO, "Open Web Browser Operation Performed");
	}

	@Test()
	public void Partner() throws Exception {
		try {
			int row = 1;
			int col = 0;
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			ManagePartners.ClkAdmin();
			extent.log(LogStatus.INFO, "Admin Tab Click Operation Performed");
			ManagePartners.ClkManagePartners();
			extent.log(LogStatus.INFO, "Manage Partner Tab Click Operation Performed");
			ManagePartners.CreatePartners(mRow, mCol, excelFile, excelSheetName);
			Log.info("New Partner has created");
			extent.log(LogStatus.INFO, "Create New Partner Operation Performed");
			ManagePartners.EditPartner(mRow, mCol, excelFile, excelSheetName);
			Log.info("a Partner has Edited");
			extent.log(LogStatus.INFO, "Edit New Partner Operation Performed");
			ManagePartners.DeletePartners(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Delete New Partner Operation Performed");
			Log.info("a Partner has deleted");
			extent.log(LogStatus.INFO, "Logout Operation Performed");
			Log.info("Logout has been Performed");
			extent.endTest();
			extent.log(LogStatus.PASS, "Logout test", "Logout performed succesfully");
			ExcelUtils.wrtExcelData(1, 7, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(3, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(3, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 7, excelFile, excelSheetName, "Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "ManagePartnersFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "ManagePartnersFailScreenShot.PNG");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(3, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(3, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "Manage Partner test", "Test Fail");
		}

	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();
	}

}
