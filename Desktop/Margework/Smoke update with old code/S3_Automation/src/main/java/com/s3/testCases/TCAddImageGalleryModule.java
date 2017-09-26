package com.s3.testCases;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.s3.businessLogic.AddImageGalleryModule;
import com.s3.businessLogic.IsMultiCampus;
import com.s3.businessLogic.OpenMyApplication;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.Login;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCAddImageGalleryModule {

	public static int mRow;
	public static int mCol;
	String excelFile = Constant.EXCEL_FILE_NAME;
	String filepath = Constant.REPORTS_IMAGEGALLERYMODULE_FILE;
	ExtentReports extent = ExtentReports.get(TCAddImageGalleryModule.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod()
	public void loginConfi() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCAddImageGallery");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("Admissions Module", "S3 Add Images Gallery Module Test Started");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test
	public void AddImageGalleryModule() throws Exception {
		String excelSheetName = Constant.ADD_IMAGEGALLERYMODULE_SHEET;
		int row = 1;
		int col = 0;
		try {
			Login.login_steps(row, col, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Login Operation Performed");
			OpenMyApplication.openMyAppApplicaion(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.appName(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "openMyAppApplicaion Operation Performed");
			AddImageGalleryModule.AddImagesGalleryModuleLogic(mRow, mCol, excelFile, excelSheetName);
			IsMultiCampus.isAdded(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "AddImagesGalleryModuleLogic Operation Performed");
			AddImageGalleryModule.PlistVerification(mRow, mCol, excelFile, excelSheetName);
			extent.log(LogStatus.INFO, "Logout Operation Performed");
			extent.log(LogStatus.PASS, "TCAddImageGallery test", "Test Pass");
			ExcelUtils.wrtExcelData(1, 16, excelFile, excelSheetName, "Pass");
			AddImageGalleryModule.xmlParser(mRow, mCol, excelFile, excelSheetName);
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			ExcelUtils.wrtExcelData(62, 3, statusExcel, statusSheet, "Pass");
			ExcelUtils.wrtExcelData(62, 6, statusExcel, statusSheet, "");
		} catch (Exception e) {
			try {
				ExcelUtils.wrtExcelData(1, 16, excelFile, excelSheetName, "Fail");
				Utils.getScreenShot(Constant.OUTPUT_DIR + "ImageGalleryModuleFailScreenShot.PNG");
				extent.attachScreenshot(Constant.OUTPUT_DIR + "ImageGalleryModuleFailScreenShot.PNG");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(62, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(62, 6, statusExcel, statusSheet, e.getMessage());
				Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
			extent.log(LogStatus.FAIL, "TCAddImageGallery test", "Test Fail");
		}
	}

	@AfterMethod()
	public void close() {
		Login.logout();
		Utils.browserClose();
		Utils.browserQuit();
	}

}
