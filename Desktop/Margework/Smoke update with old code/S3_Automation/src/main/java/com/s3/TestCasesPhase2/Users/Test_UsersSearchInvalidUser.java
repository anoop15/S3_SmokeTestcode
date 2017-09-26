package com.s3.TestCasesPhase2.Users;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.s3.businessLogicPhase2.BaseLogic;
import com.s3.businessLogicPhase2.LoginPhase2;
import com.s3.businessLogicPhase2.UserProfilePhase2;
import com.s3.testCases.TCUsers;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class Test_UsersSearchInvalidUser {
	String filepath = Constant.REPORTS_UI_NEWUSERPOPUP;
	String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	String statusSheet = Constant.RESULT_SHEET_USERS;
	ExtentReports extent = ExtentReports.get(TCUsers.class);
	static public int ResultCol;
	UserProfilePhase2 userprofilephase2 = new UserProfilePhase2();
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Setup() throws Exception {
		String runMode= BaseLogic.Runable(2, 2, 12, 3, Constant.RUNMODEUSER);
		if(runMode.equals("N"))	{
		ExcelUtils.wrtExcelData(12, Constant.RESULT_COL+ ResultCol, statusExcel, statusSheet, "Not Executed");
		ResultCol++;
		throw new Exception("RunMode off");
		}
	
		System.out.println("Search Invalid user verification");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Search user, TC_User_12 ");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("Search Invlid User Test", "S3 User test");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);

	}

	@Test(dataProvider = "SearchInvaliduser")
	public void SearchUserVerification(String username, String password, String rememberme,String searchText ) throws Exception {
		
		String Result="Fail";
		try {
			Thread.sleep(1000);
			String logintype = LoginPhase2.login_step(username, password, rememberme);
			UserProfilePhase2.clkUsers();
			Result=UserProfilePhase2.InvalidsearchUser(searchText);
			ExcelUtils.wrtExcelData(12, Constant.RESULT_COL + ResultCol, statusExcel, statusSheet, Result);
			ResultCol++;
			Assert.assertEquals(Result, "Pass");
			System.out.println(searchText +" User Not found and correct message display");
		} catch (Exception e) {
			Log.info("Required message not display on invalid search user");
			ExcelUtils.wrtExcelData(12, Constant.RESULT_COL + ResultCol, statusExcel, statusSheet, "Fail");
			ResultCol++;
			ExcelUtils.wrtExcelData(12, Constant.RESONE_COL, statusExcel, statusSheet,e.getMessage());
			Assert.assertEquals(Result, "Pass");
			System.out.println("---------"+e.getMessage());
		}
	}

	@DataProvider(name = "SearchInvaliduser")
	public Object[][] dataProviderMethod() throws Exception {
		@SuppressWarnings("unused")
		String strQuery = "Select * from " + Constant.SEARCHINVALIDUSER;
		// ** This reads Excel by POI **//
		// Object[][] excelData =
	// ExcelUtils.getTableArray(Constant.LOGIN_TEST_DATA,Constant.VALIDLOGIN_SHEET);
		// ** This reads Excel file by Fillo **//
		Object[][] excelData = ExcelUtils.ConnenctToFillo(Constant.USERS_TEST_DATA, strQuery);
		return excelData;
	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("LoginPageVerification");
		Utils.browserClose();
		Utils.browserQuit();

	}


}
