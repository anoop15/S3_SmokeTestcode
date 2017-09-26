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

public class TCCreatePartners {
	public static int mRow = 1;
	public static int mCol = 3;

	String excelFile = Constant.EXCEL_FILE_NAME;
	String excelSheetName = Constant.PARTNER_Sheet;
	String filepath = Constant.REPORTS_CREATEPARTNER_FILE;
	ExtentReports extent = ExtentReports.get(TCCreatePartners.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void LogConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("ATCCreatePartner003");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("CreatePartner", "S3 CreatePartner Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test()
	public void CreatePartner() throws Exception {
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed: <span class='label info'>info</span>");
			ManagePartners.ClkAdmin();
			extent.log(LogStatus.INFO, "Admin Tab Click Operation Performed: <span class='label info'>success</span>");
			ManagePartners.ClkManagePartners();
			extent.log(LogStatus.INFO,"Manage Partner Tab Click Operation Performed: <span class='label info'>success</span>");
			ManagePartners.CreatePartners(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Create Partner Operation Performed: <span class='label info'>success</span>");
			Log.info("New Partner has created");
			ExcelUtils.wrtExcelData(1, 7, excelFile, excelSheetName, "Pass");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(3, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(3, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			ExcelUtils.wrtExcelData(1, 7, excelFile, excelSheetName, "Fail");
			e.getMessage();
			extent.log(LogStatus.FAIL, "Manage Partner test", "Test Fail");
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(3, 3, statusExcel, statusSheet, "Fail");
			ExcelUtils.wrtExcelData(3, 6, statusExcel, statusSheet, e.getMessage());
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
