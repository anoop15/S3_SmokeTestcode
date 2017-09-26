package com.s3.TestCasesPhase2.Login;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.s3.businessLogicPhase2.LoginPhase2;
import com.s3.testCases.TCLogin;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class Test_Login_ForgotPasswordDismiss {
	String filepath = Constant.REPORTS_FILE_PATH_LOGIN;
	ExtentReports extent = ExtentReports.get(TCLogin.class);
	String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	String statusSheet = Constant.RESULT_SHEET_LOGIN;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Setup() throws Exception {
		String runMode= LoginPhase2.Runable(1, 2, 14, 3, Constant.RUNMODELOGIN);
		if(runMode.equals("N"))	{
		ExcelUtils.wrtExcelData(14, Constant.RESULT_COL, statusExcel, statusSheet, "Not Executed");
		throw new Exception("RunMode off");
		}
		System.out.println("Validte the Forgot Password functionality");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCLogin_14");
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
	public void LoginErrorMessage() throws FileNotFoundException {
		
		try {
			String Result = LoginPhase2.ForgotPassword_cancel();
			System.out.println("Forgot password cancel functionality is - " + Result);
			ExcelUtils.wrtExcelData(14, Constant.RESULT_COL, statusExcel, statusSheet, Result);
			Assert.assertEquals(Result, "Pass");
		} catch (Exception e) {
			Log.info("Forgot password cancel functionaltiy fail");
			System.out.println("Test cases Fail");
			ExcelUtils.wrtExcelData(14, Constant.RESULT_COL, statusExcel, statusSheet, "FAIL");
			ExcelUtils.wrtExcelData(14, Constant.RESONE_COL, statusExcel, statusSheet,e.getMessage());
			Assert.assertEquals("Fail", "NA");
		}

	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("LoginPageVerification");
		Utils.browserClose();
		Utils.browserQuit();

	}
}
