package com.s3.TestCasesPhase2.Users;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.s3.businessLogicPhase2.LoginPhase2;
import com.s3.businessLogicPhase2.UserProfilePhase2;
import com.s3.testCases.TCUsers;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class Test_UsersEditUser {
	String filepath = Constant.REPORTS_UI_NEWUSERPOPUP;	String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	String statusSheet = Constant.RESULT_SHEET_USERS;
	ExtentReports extent = ExtentReports.get(TCUsers.class);
	static public int ResultCol;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Main() throws Exception {
		String runMode= LoginPhase2.Runable(2, 2, 9, 3, Constant.RUNMODEUSER);
		if(runMode.equals("N"))	{
		ExcelUtils.wrtExcelData(9, Constant.RESULT_COL+ ResultCol, statusExcel, statusSheet, "Not Executed");
		ResultCol++;
		throw new Exception("RunMode off");
		}
		System.out.println("Edit user information verification");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Edit user information, TC_User_09 ");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("User Test", "S3 User test");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);

	}

	@Test(dataProvider = "EditUser")
	public void EditUserVerification(String username, String password, String rememberme,String searchText, String newfirstName, 
			String newlastName,String newUsertype, String newPartner, String newClient,String newRoles,String newEmailfrequency) throws Exception {
	
		String Result;
		try {
			Thread.sleep(1000);
			String logintype = LoginPhase2.login_step(username, password, rememberme);
			UserProfilePhase2.clkUsers();
			Result = UserProfilePhase2.editUser(searchText,newfirstName,newlastName,newUsertype,newPartner,newClient,newRoles,newEmailfrequency);
			ExcelUtils.wrtExcelData(9, Constant.RESULT_COL + ResultCol, statusExcel, statusSheet, Result);
			ResultCol++;
			Assert.assertEquals(Result, "Pass");
			System.out.println(searchText +" User information update sucessfully");
			//String deleteuser=UserProfilePhase2.deleteuser(email,logintype);
		} catch (Exception e) {
			Log.info("User informatio not updated successfully");
			ExcelUtils.wrtExcelData(9, Constant.RESULT_COL + ResultCol, statusExcel, statusSheet, "Fail");
			ResultCol++;
			ExcelUtils.wrtExcelData(9, Constant.RESONE_COL, statusExcel, statusSheet,e.getMessage());
			Assert.assertTrue(false);
			
		}
	}

	@DataProvider(name = "EditUser")
	public Object[][] dataProviderMethod() throws Exception {
		@SuppressWarnings("unused")
		String strQuery = "Select * from " + Constant.EDITUSER;
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
