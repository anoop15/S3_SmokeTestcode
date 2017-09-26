package com.s3.TestCasesPhase2.Admin;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.s3.businessLogicPhase2.AdminPhase2;
import com.s3.businessLogicPhase2.BaseLogic;
import com.s3.businessLogicPhase2.LoginPhase2;
import com.s3.testCases.TCLogin;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class Test_AdminManagePartnerCreateNewPartner {
	String filepath = Constant.REPORTS_FILE_PATH_LOGIN;
	String statusExcel = Constant.RESULT_EXCEL_FILE_PHASE2;
	String statusSheet = Constant.RESULT_SHEET_ADMIN;
	ExtentReports extent = ExtentReports.get(TCLogin.class);
	static public int ResultCol;

	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Setup() throws Exception {
		//int SuiteRowNum,int SuiteColNum,int TestcasesRowNum,int TestcaseColNum,String TestcasesSheetName
		String runMode= BaseLogic.Runable(3, 2, 8, 3, Constant.RUNMODEADMIN);
		if(runMode.equals("N"))	{
		ExcelUtils.wrtExcelData(8, Constant.RESULT_COL+ ResultCol, statusExcel, statusSheet, "Not Executed");
		ResultCol++;
		throw new Exception("RunMode off");
		}
		System.out.println("Verify functionality of create new partner");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TC_Admin_08");
		Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
		extent.init(filepath, true);
		extent.startTest("Admin test", "S3 login test");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("S3 Automation Testing");
		extent.config().reportHeadline("S3 Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("S3 Automation");
		extent.config().useExtentFooter(false);
	}

	@Test(dataProvider = "ManagePartnerPageInput")
	public void ManagePartnerCreateNewPartner(String Username, String Password, String NewPartnerName) throws FileNotFoundException {
		String Result ="Fail";
		try {
			Thread.sleep(1000);
			LoginPhase2.Login(Username, Password);
			Thread.sleep(2000);
			Result = AdminPhase2.ManagePartner_CreateNewPartner(NewPartnerName);
			AdminPhase2.DeletePartner(NewPartnerName);
			System.out.println("New Partner create test case  " + Result);
			ExcelUtils.wrtExcelData(8, Constant.RESULT_COL+ ResultCol, statusExcel, statusSheet, Result);
			ResultCol++;
			Assert.assertEquals(Result, "Pass");
		} catch (Exception e) {
			System.out.println("Test cases Fail");
			ExcelUtils.wrtExcelData(8, Constant.RESULT_COL + ResultCol, statusExcel, statusSheet, "Fail");
			ResultCol++;
			ExcelUtils.wrtExcelData(8, Constant.RESONE_COL, statusExcel, statusSheet,e.getMessage());
			Assert.assertEquals(Result, "Pass");
			
		}

	}

	@DataProvider(name = "ManagePartnerPageInput")
	public Object[][] dataProviderMethod() throws Exception {
		@SuppressWarnings("unused")
		String strQuery = "Select * from " + Constant.MANPARTNERCREATENEWPARTNER;
		// ** This reads Excel by POI **//
		// Object[][] excelData =
		// ExcelUtils.getTableArray(Constant.LOGIN_TEST_DATA,Constant.VALIDLOGIN_SHEET);
		// ** This reads Excel file by Fillo **//
		Object[][] excelData = ExcelUtils.ConnenctToFillo(Constant.ADMIN_TEST_DATA, strQuery);
		return excelData;
	}

	@AfterMethod
	public void afterMethod() {
		Utils.browserClose();
		Utils.browserQuit();

	}

}
