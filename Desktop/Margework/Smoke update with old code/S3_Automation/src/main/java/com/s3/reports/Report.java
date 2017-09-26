package com.s3.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.testng.annotations.Test;

import com.s3.Sendmail.SendReport;
import com.s3.utility.Constant;
import com.s3.utility.Utils;
import com.s3.utility.Xls_Reader;

public class Report {
    public static String result_FolderName=null;
       
      
    @Test    
    public void CreateSendReports() throws IOException {
          	// read suite.xls
        System.out.println("executing");
        Date d = new Date();
        String date=d.toString().replaceAll(" ", "_");
        date=date.replaceAll(":", "_");
        date=date.replaceAll("\\+", "_");
        System.out.println(date);
        result_FolderName="Reports"+"_"+date;
        System.out.println(result_FolderName);
        String reportsDirPath=System.getProperty("user.dir")+"\\Reports";
        new File(result_FolderName).mkdirs();

        String URL=Constant.URL;
        String Browser=Constant.BROWSER_NAME;
        String OS =Utils.getOS(); 
        Xls_Reader suiteXLS = new Xls_Reader(System.getProperty("user.dir")+"//TestData//SuiteRunmode.xlsx");

        String indexHtmlPath=result_FolderName+"/index.html";
        new File(indexHtmlPath).createNewFile();
        try{

            FileWriter fstream = new FileWriter(indexHtmlPath);
            BufferedWriter out = new BufferedWriter(fstream);
           out.write("<html><HEAD> <TITLE>Automation Test Results</TITLE></HEAD><body><h4 align=center><FONT COLOR=660066 FACE=AriaL SIZE=6><b><u> Automation Test Results</u></b></h4><table  border=1 cellspacing=1 cellpadding=1 ><tr><h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5> <u>Test Details :</u></h4><td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run Date</b></td><td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>");
            out.write(d.toString());
            out.write("</b></td></tr><tr><td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run URL</b></td><td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>");
            out.write(URL);
            out.write("</b></td></tr><tr><td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Browser</b></td><td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>");
            out.write(Browser);
            out.write("</b></td></tr><tr><td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>OS</b></td><td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>");
            out.write(OS);
            out.write("</b></td></tr></table><h4> <FONT COLOR=660000 FACE= Arial  SIZE=4.5> <u>Report :</u></h4><table  border=1 cellspacing=1 cellpadding=1 width=100%><tr><td width=20% align= center  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>SUITE NAME</b></td><td width=40% align= center  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>DESCRIPTION</b></td><td width=10% align= center  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>RUNMODE</b></td></tr>");
        //    out.write("</b></td></tr></table><h4> <FONT COLOR=660000 FACE= Arial  SIZE=4.5> <u>Report :</u></h4><table  border=1 cellspacing=1 cellpadding=1 width=100%><tr><td width=20% align= center  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>SUITE NAME</b></td><td width=40% align= center  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>DESCRIPTION</b></td></tr>");

            //out.write("<tr><td width=20% align= center><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>TC04</b></td><td width=40% align= center><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>TC04</b></td><td width=10% align=center  bgcolor=yellow><FONT COLOR=153E7E FACE=Arial SIZE=2><b>Skip</b></td></tr>");
            int totalTestSuites=suiteXLS.getRowCount(Constant.TEST_SUITE_SHEET);
            String currentTestSuite=null;
            Xls_Reader current_suite_xls=null;
            String suite_result="";
            for(int currentSuiteID =2;currentSuiteID<= totalTestSuites;currentSuiteID++){
                suite_result="";
                currentTestSuite=null;
                current_suite_xls=null;
                currentTestSuite = suiteXLS.getCellData(Constant.TEST_SUITE_SHEET, Constant.SUITE_ID,currentSuiteID);
                current_suite_xls=new Xls_Reader(System.getProperty("user.dir")+"//Reports//S3Test_Results.xlsx");

                String currentTestName=null;
                String currentTestRunmode=null;
                String currentTestDescription=null;
                // create index file for this suite
                String suiteIndexFile=result_FolderName+"/"+currentTestSuite+".html";
                new File(suiteIndexFile).createNewFile();
             
                int rows= current_suite_xls.getRowCount(currentTestSuite);
                int cols = current_suite_xls.getColumnCount(currentTestSuite);

                FileWriter fstream_test_steps= new FileWriter(suiteIndexFile);
                BufferedWriter out_test_steps= new BufferedWriter(fstream_test_steps);
                out_test_steps.write("<html><HEAD> <TITLE>"+currentTestSuite+" Test Results</TITLE></HEAD><body><h4 align=center><FONT COLOR=660066 FACE=AriaL SIZE=6><b><u> "+currentTestSuite+" Detailed Test Results</u></b></h4><table width=100% border=1 cellspacing=1 cellpadding=1 >");
                out_test_steps.write("<tr>");
                for(int colNum=0;colNum<cols;colNum++){
                    out_test_steps.write("<td align= center bgcolor=#153E7E><FONT COLOR=#ffffff FACE= Arial  SIZE=2><b>");
                    out_test_steps.write(current_suite_xls.getCellData(currentTestSuite, colNum, 1));
                }
                out_test_steps.write("</b></tr>");
                
                
                //fill data
                boolean result_col=false;
                for(int rowNum=2;rowNum<=rows;rowNum++){
                    out_test_steps.write("<tr>");
                    for(int colNum=0;colNum<cols;colNum++){
                    	  String data=current_suite_xls.getCellData(currentTestSuite, colNum, rowNum);
                          result_col=current_suite_xls.getCellData(currentTestSuite, colNum, 1).startsWith(Constant.RESULT);
                          if(data.isEmpty()){
                              if(result_col)
                                  data="SKIP";
                              else
                                  data=" ";
                          }
                          if((data.startsWith("Pass") || data.startsWith("PASS")) && result_col)
                              out_test_steps.write("<td align=center bgcolor=#A7FF31><FONT COLOR=#000000 FACE= Arial  SIZE=1>");
                          else if((data.startsWith("Fail") || data.startsWith("FAIL")) && result_col){
                              out_test_steps.write("<td align=center bgcolor=red><FONT COLOR=#000000 FACE= Arial  SIZE=1>");
                              if(suite_result.equals(""))
                                  suite_result="FAIL";
                          }
                          else if((data.startsWith("Skip") || data.startsWith("SKIP")) && result_col)
                              out_test_steps.write("<td align=center bgcolor=yellow><FONT COLOR=#000000 FACE= Arial  SIZE=1>");
                          else
                              out_test_steps.write("<td align= left bgcolor=#ffffff><FONT COLOR=#000000 FACE= Arial  SIZE=1>");
                          out_test_steps.write(data);

                      }
                      out_test_steps.write("</tr>");
                  }


                out_test_steps.write("</tr>");
                out_test_steps.write("</table>");
                out_test_steps.close();
                out.write("<tr><td width=20% align= center><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>");
                out.write("<a href="+currentTestSuite.replace(" ", "%20")+".html>"+currentTestSuite+"</a>");
                out.write("</b></td><td width=40% align= center><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>");
                out.write(suiteXLS.getCellData(Constant.TEST_SUITE_SHEET, Constant.DESCRIPTION,currentSuiteID));
               out.write("</b></td><td width=10% align=center  bgcolor=");
              if(suiteXLS.getCellData("Test Suite", 2, currentSuiteID).equalsIgnoreCase("Y"))
            	  out.write("white><FONT COLOR=153E7E FACE=Arial SIZE=2><b>YES</b></td></tr>");
              if(suiteXLS.getCellData("Test Suite", 2, currentSuiteID).equalsIgnoreCase("N"))
            	  out.write("white><FONT COLOR=153E7E FACE=Arial SIZE=2><b>NO</b></td></tr>");
              else
            	  if(suiteXLS.getCellData("Test Suite", 2, currentSuiteID).equalsIgnoreCase(""))
                	  out.write("white><FONT COLOR=153E7E FACE=Arial SIZE=2><b></b></td></tr>");  
               //out.println(suiteXLS.getCellData(Constant.TEST_SUITE_SHEET, Constant.RUNMODE,currentSuiteID));
//                if(suiteXLS.getCellData(Constant.TEST_SUITE_SHEET, Constant.RUNMODE,currentSuiteID).equalsIgnoreCase(Constant.RUNMODE_YES))
//                    if(suite_result.equals("FAIL"))
//                        out.write("red><FONT COLOR=153E7E FACE=Arial SIZE=2><b>FAIL</b></td></tr>");
//                    else
//                        out.write("green><FONT COLOR=153E7E FACE=Arial SIZE=2><b>PASS</b></td></tr>");
//                else
//                    out.write("yellow><FONT COLOR=153E7E FACE=Arial SIZE=2><b>SKIP</b></td></tr>");
                //	out.write("</td></tr>");
            }
            //Close the output stream
            out.write("</table>");
            out.close();
      //This is for creating zip file 
           ZipDirectory.makezip(result_FolderName);
      //This is for sending reports via mail  
       SendReport.ReportSend(result_FolderName);
        }catch(Exception e){
		System.err.println("Error: " + e.getMessage());
        e.printStackTrace();
		}
	}
}
