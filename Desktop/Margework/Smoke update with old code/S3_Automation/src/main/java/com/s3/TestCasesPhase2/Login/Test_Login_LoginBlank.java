package com.s3.TestCasesPhase2.Login;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.s3.businessLogicPhase2.LoginPhase2;
import com.s3.testCases.TCLogin;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class Test_Login_LoginBlank {
	String filepath = Constant.REPORTS_FILE_PATH_LOGIN;
	ExtentReports extent = ExtentReports.get(TCLogin.class);
	static public int ResultCol;
	String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	String statusSheet = Constant.RESULT_SHEET_LOGIN;
	
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Setup() throws Exception {
		String runMode= LoginPhase2.Runable(1, 2, 3, 3, Constant.RUNMODELOGIN);
		if(runMode.equals("N"))	{
		ExcelUtils.wrtExcelData(3, Constant.RESULT_COL+ ResultCol, statusExcel, statusSheet, "Not Executed");
		ResultCol++;
		throw new Exception("RunMode off");
		}
		System.out.println("Login Error Message verification on BlankLogin");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCLogin_03");
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
	
	
	@Test(dataProvider="BlankLogin")
	public void LoginErrorMessage(String UserName,String Password, String ExpectedError) throws FileNotFoundException{
	try{
		Thread.sleep(1000);
		String ErrorMessage = LoginPhase2.LoginErrorMessage(UserName,Password,ExpectedError);
		System.out.println("Login Error message with blank fields is :- " + ErrorMessage);
		ExcelUtils.wrtExcelData(3, Constant.RESULT_COL +ResultCol, statusExcel, statusSheet, ErrorMessage);
		ResultCol++;
		Assert.assertEquals(ErrorMessage, "Pass");

	}catch(Exception e){
	Log.info("Login page verification fail");
	ExcelUtils.wrtExcelData(3, Constant.RESULT_COL +ResultCol, statusExcel, statusSheet, "FAIL");
	ResultCol++;
	ExcelUtils.wrtExcelData(3, Constant.RESONE_COL, statusExcel, statusSheet,e.getMessage());
	}
		
	}
	
	
	
	 @DataProvider(name = "BlankLogin")
		public Object[][] dataProviderMethod() throws Exception {
			@SuppressWarnings("unused")
			String strQuery= "Select * from "+ Constant.BLANKLOGIN;
	//** This reads Excel by POI  **//
			//	Object[][] excelData = ExcelUtils.getTableArray(Constant.LOGIN_TEST_DATA,Constant.VALIDLOGIN_SHEET);
	//** This reads Excel file by Fillo 	**//		
			Object[][] excelData =ExcelUtils.ConnenctToFillo(Constant.LOGIN_TEST_DATA,strQuery);
			return excelData;
		}
	 
	 
	@AfterMethod
	public void afterMethod() {
		
		Log.endTestCase("LoginPageVerification");
		Utils.browserClose();
		Utils.browserQuit();

	}
	
	
}
