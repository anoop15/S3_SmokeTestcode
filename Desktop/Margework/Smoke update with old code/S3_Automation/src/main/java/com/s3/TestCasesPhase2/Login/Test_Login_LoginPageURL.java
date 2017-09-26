package com.s3.TestCasesPhase2.Login;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.s3.businessLogicPhase2.LoginPhase2;
import com.s3.testCases.TCLogin;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class Test_Login_LoginPageURL {
	String filepath = Constant.REPORTS_FILE_PATH_LOGIN;
	ExtentReports extent = ExtentReports.get(TCLogin.class);
	static public int ResultCol;
	static String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	static String statusSheet = Constant.RESULT_SHEET_LOGIN;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Setup() throws Exception {
	//	System.out.println(Constant.RUNMODEXLS);
		String runMode= LoginPhase2.Runable(1, 2, 1, 3, Constant.RUNMODELOGIN);
			if(runMode.equals("N"))	{
			ExcelUtils.wrtExcelData(1, Constant.RESULT_COL +ResultCol, statusExcel, statusSheet, "Not Executed");
			ResultCol++;
			throw new Exception("RunMode off");
		}
		System.out.println("Login Page URL Verification started");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCLogin_04");
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

	@Test(dataProvider="UrlData")
	public static void LoginpageURLVerification(String ExpectedUrl) throws Exception {
		
		try {
			String URLResult = LoginPhase2.TestURL(ExpectedUrl);
			System.out.println("TestURL is :- " + URLResult + ExpectedUrl);
			ExcelUtils.wrtExcelData(1, Constant.RESULT_COL + ResultCol, statusExcel, statusSheet, URLResult);
			ResultCol++;
			Assert.assertEquals(URLResult, "Pass");
		} catch (Exception e) {
			Log.info("test case fail");
			ExcelUtils.wrtExcelData(1, Constant.RESULT_COL+ ResultCol, statusExcel, statusSheet, "Fail");
			ResultCol++;
			ExcelUtils.wrtExcelData(1, Constant.RESONE_COL, statusExcel, statusSheet,e.getMessage());
			}
	}


	  @DataProvider(name = "UrlData")
		public Object[][] dataProviderMethod() throws Exception {
			@SuppressWarnings("unused")
			String strQuery= "Select * from "+Constant.URL_SHEET;
	//** This reads Excel by POI  **//
			//	Object[][] excelData = ExcelUtils.getTableArray(Constant.LOGIN_TEST_DATA,Constant.VALIDLOGIN_SHEET);
	//** This reads Excel file by Fillo 	**//		
			Object[][] excelData =ExcelUtils.ConnenctToFillo(Constant.LOGIN_TEST_DATA,strQuery);
			return excelData;
		}

	
	
	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("LoginPageURL");
		Utils.browserClose();
		Utils.browserQuit();

	}
}
