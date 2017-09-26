package com.s3.testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.s3.businessLogic.Login;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class TCLogin {
	String filepath = Constant.REPORTS_FILE_PATH_LOGIN;
	ExtentReports extent = ExtentReports.get(TCLogin.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Main() throws Exception {
		System.out.println("TCLogin started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("ATCLogin001");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("Login test", "S3 login test");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test
	public void LoginTest() throws Exception, InvalidFormatException, IOException {
		try {
			String excelFile = Constant.EXCEL_FILE_NAME;
			String excelSheetName = Constant.LOGIN_SHEET;
			// This is to get the total number of rows in excel file which will
			// get from ExcelUtils.java file
			int totalNumberOfRows = ExcelUtils.getLastRowNum(excelFile, excelSheetName);
			// This loop is for perform the login action for multiple number of
			// users available in excel sheet
			for (int row = 1; row <= totalNumberOfRows; row++) {
				Log.info("User: " + row);
				int col = 0;
				// Call the loginValidation methods from login action class
				Login.TestLoginValidation();
				extent.log(LogStatus.INFO, "Login Validation", "Login validation action performed succesfully");
				// Call the login steps method from login action class
				Login.login_steps(row, col, excelFile, excelSheetName);
				extent.log(LogStatus.INFO, "Login steps", "Login action performed succesfully");
				Login.TestDatavalidation();
				extent.log(LogStatus.INFO, "Login test data validation",
						"Login Test Data validation performed succesfully");
				extent.log(LogStatus.PASS, "Logout test", "Logout performed succesfully");
				String statusExcel = Constant.STATUS_EXCEL_FILE;
				String statusSheet = Constant.STATUS_SHEET;
				ExcelUtils.wrtExcelData(2, 3, statusExcel, statusSheet, "Pass");
				ExcelUtils.wrtExcelData(2, 6, statusExcel, statusSheet, "");
				// call the test data validation method from login action class

			}
		} catch (Exception e) {
			e.getStackTrace();
			String statusExcel = Constant.STATUS_EXCEL_FILE;
			String statusSheet = Constant.STATUS_SHEET;
			try {
				ExcelUtils.wrtExcelData(2, 3, statusExcel, statusSheet, "Fail");
				ExcelUtils.wrtExcelData(2, 6, statusExcel, statusSheet, e.getMessage());
				//Assert.assertTrue(false);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			extent.log(LogStatus.FAIL, "Login", "Login Fail Details");
			Utils.getScreenShot(Constant.OUTPUT_DIR + "LoginFailScreenShot.PNG");
			extent.attachScreenshot(Constant.OUTPUT_DIR + "LoginFailScreenShot.PNG");
		}
	}

	// This is to quit the driver and close the window
	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("TCLogin");
		Utils.browserClose();
		Utils.browserQuit();

	}
}
