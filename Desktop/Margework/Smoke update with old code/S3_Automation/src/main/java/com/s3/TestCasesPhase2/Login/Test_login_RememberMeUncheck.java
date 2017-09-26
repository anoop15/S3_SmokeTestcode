package com.s3.TestCasesPhase2.Login;

import java.io.File;
import java.io.FileNotFoundException;

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

public class Test_login_RememberMeUncheck {
	String filepath = Constant.REPORTS_FILE_PATH_LOGIN;
	String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	String statusSheet = Constant.RESULT_SHEET_LOGIN;
	ExtentReports extent = ExtentReports.get(TCLogin.class);
	static public int DataRow_R;
	static public int DataRow_U;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Setup() throws Exception {
		String runMode= LoginPhase2.Runable(1, 2, 8, 3, Constant.RUNMODELOGIN);
		if(runMode.equals("N"))	{
		ExcelUtils.wrtExcelData(8, Constant.RESULT_COL+ DataRow_R, statusExcel, statusSheet, "Not Executed");
		DataRow_R++;
		throw new Exception("RunMode off");
		}
		System.out.println("Remember Me Functionality");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TCLogin_08");
		extent.init(filepath, true);
		extent.startTest("Login test", "S3 login test");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}
	
	
	@Test(dataProvider="RememberMe")
	public void TestRememberme(String username,String password,String rememberMe) throws FileNotFoundException{
	try{
			Thread.sleep(1000);
			String Result = LoginPhase2.RememberMeUnchecked(username, password, rememberMe);
			System.out.println("Remember me unchecked functionality :- " + Result);
			ExcelUtils.wrtExcelData(8, Constant.RESULT_COL+DataRow_U, statusExcel, statusSheet, Result);
			DataRow_U++;
			Assert.assertEquals(Result, "Pass");
		}catch(Exception e)
		{
			Log.info("Login page verification fail");
			ExcelUtils.wrtExcelData(8, Constant.RESULT_COL +DataRow_U,statusExcel, statusSheet, "FAIL");
			DataRow_U++;
			ExcelUtils.wrtExcelData(8, Constant.RESONE_COL, statusExcel, statusSheet,e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	
	
	

	@DataProvider(name = "RememberMe")
		public Object[][] dataProviderMethod() throws Exception {
			@SuppressWarnings("unused")
			String strQuery= "Select * from "+ Constant.REMEMBERMEUNCHECK;
	//** This reads Excel by POI  **//
			//	Object[][] excelData = ExcelUtils.getTableArray(Constant.LOGIN_TEST_DATA,Constant.VALIDLOGIN_SHEET);
	//** This reads Excel file by Fillo 	**//		
			Object[][] excelData =ExcelUtils.ConnenctToFillo(Constant.LOGIN_TEST_DATA,strQuery);
			return excelData;
		}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("Remembert me Verification");
		LoginPhase2.browserClose();
		LoginPhase2.browserQuit();
		File directory = new File(LoginPhase2.SRC_FOLDER);
		if(directory.exists())
		LoginPhase2.deleteSavedCookies(LoginPhase2.SRC_FOLDER);
		
		}
}

	

