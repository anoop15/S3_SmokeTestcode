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

public class Test_Login_LoginPageElementVerification {
	String filepath = Constant.REPORTS_FILE_PATH_LOGIN;
	ExtentReports extent = ExtentReports.get(TCLogin.class);
	static String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	static String statusSheet = Constant.RESULT_SHEET_LOGIN;
	static public int ResultCol;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Setup() throws Exception {
		String runMode= LoginPhase2.Runable(1, 2, 2, 3, Constant.RUNMODELOGIN);
		if(runMode.equals("N"))	{
		ExcelUtils.wrtExcelData(2, Constant.RESULT_COL+ ResultCol, statusExcel, statusSheet, "Not Executed");
		ResultCol++;
		throw new Exception("RunMode off");
	}
		System.out.println("Login Page Verification started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCLogin_02");
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
	public void LoginPageVerification() throws FileNotFoundException{
		
	try{
		Thread.sleep(1000);
		String Result = LoginPhase2.LoginElements();
		ExcelUtils.wrtExcelData(2, Constant.RESULT_COL , statusExcel, statusSheet, Result);
		Assert.assertEquals(Result, "Pass");
	}catch(Exception e){
	Log.info("Login page verification fail");
	ExcelUtils.wrtExcelData(2, Constant.RESULT_COL+ResultCol, statusExcel, statusSheet, "FAIL");
	ExcelUtils.wrtExcelData(2, Constant.RESONE_COL+ResultCol, statusExcel, statusSheet,e.getMessage());
	
	}
		
	}
	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("LoginPageVerification");
		Utils.browserClose();
		Utils.browserQuit();

	}
	
}
