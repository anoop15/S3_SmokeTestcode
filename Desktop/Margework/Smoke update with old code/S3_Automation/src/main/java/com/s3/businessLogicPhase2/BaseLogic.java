package com.s3.businessLogicPhase2;

import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;

public class BaseLogic {
	public static String Runable(int SuiteRowNum,int SuiteColNum,int TestcasesRowNum,int TestcaseColNum,String TestcasesSheetName) throws Exception
	{
		try{
		String RunModeSuite= ExcelUtils.getCellData(SuiteRowNum,SuiteColNum ,Constant.RUNMODEXLS,Constant.RUNMODESUITESHEET);
		String RunModeTestCase=ExcelUtils.getCellData(TestcasesRowNum,TestcaseColNum,Constant.RUNMODEXLS, TestcasesSheetName);
		System.out.println("Login RunMode :-"+RunModeSuite);
		System.out.println("URL Test case:- "+RunModeTestCase);
		if(RunModeSuite.equalsIgnoreCase("") || RunModeTestCase.equalsIgnoreCase(""))
			throw new Exception("Unable to read SuiteRunmode XLSX file or data is not available in XLSX file ");
		else
		if(RunModeSuite.equalsIgnoreCase("N") || RunModeTestCase.equalsIgnoreCase("N") )
		return "N";
		else
		return "Y";
		}catch(Exception e)
		{
			throw new Exception("Unable to read SuiteRunmode XLSX file");
		}
	}
}
