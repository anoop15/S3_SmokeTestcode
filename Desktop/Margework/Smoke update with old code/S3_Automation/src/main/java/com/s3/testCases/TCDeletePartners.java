package com.s3.testCases;

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

public class TCDeletePartners {
	public static int mRow;
	public static int mCol;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.PARTNER_Sheet;
	String filepath = Constant.REPORTS_DELETEPARTNER_FILE;
	ExtentReports extent = ExtentReports.get(TCDeletePartners.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void LogConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("ATCDeletePartners005");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("DeletePartner", "S3 DeletePartner Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);

	}

	@Test()
	public void DeletePartner() throws Exception {
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			ManagePartners.ClkAdmin();
			ManagePartners.ClkManagePartners();
			ManagePartners.DeletePartners(mRow, mCol, excelFile, excelSheetName);
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(3, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(3, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			ExcelUtils.wrtExcelData(1, 7, excelFile, excelSheetName, "Fail");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(3, 3, statusExcel, statusSheet, "Fail");
			ExcelUtils.wrtExcelData(3, 6, statusExcel, statusSheet, e.getMessage());
			extent.log(LogStatus.FAIL, "Delete Manage Partner test", "Test Fail");
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