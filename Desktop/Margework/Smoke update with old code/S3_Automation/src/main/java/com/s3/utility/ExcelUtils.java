package com.s3.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtils {
	public static Sheet sh;
	private static Workbook wb;
	private static Cell cell;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static String getCellData(int RowNum, int ColNum,
			String excelfilename, String SheetName) throws Exception {
		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(excelfilename);
			wb = WorkbookFactory.create(ExcelFile);
			// Access the required test data sheet
			Sheet sh = wb.getSheet(SheetName);
			// get the cell value
			cell = sh.getRow(RowNum).getCell(ColNum);
			String CellData = cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static int getLastRowNum(String excelfilename, String SheetName)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(excelfilename);
		wb = WorkbookFactory.create(ExcelFile);
		// Access the required test data sheet
		Sheet sh = wb.getSheet(SheetName);
		return sh.getLastRowNum();
	}

	public static void wrtExcelData(int RowNum, int ColNum,
			String excelfilename, String SheetName, String Data)
			throws FileNotFoundException {
		// CODE TO WRITE RESULT IN EXL
		FileInputStream fis;
		try {
			fis = new FileInputStream(excelfilename);
			wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			Row rw = sh.getRow(RowNum);
			Cell cel = rw.createCell(ColNum);
			// cel.setCellType(cel.CELL_TYPE_STRING);
			cel.setCellValue(Data);
			FileOutputStream fos = new FileOutputStream(excelfilename);
			wb.write(fos);
			fos.close();
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//// this is for data provider
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
		 
		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);
			   // Access the required test data sheet
			   ExcelWBook = new XSSFWorkbook(ExcelFile);
			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
			   Sheet datatypeSheet = ExcelWBook.getSheet(SheetName);
			   int startRow = 1;
			   int startCol = 0;
			   int ci,cj;
			   int totalRows = ExcelWSheet.getLastRowNum();
			  // int totalRows = getLastRowNum(FilePath, SheetName);
			//  System.out.println("Total rows :-"+ totalRows);
			   // you can write a function as well to get Column count
			   int totalCols = getLastColNum(datatypeSheet);
			   tabArray=new String[totalRows][totalCols];
			  System.out.println(totalRows);
			  System.out.println(totalCols);
			   ci=0;
			   for (int i=startRow;i<=totalRows;i++, ci++) 
			   {           	   
				  cj=0;
				   for (int j=startCol;j<totalCols;j++, cj++){
					   tabArray[ci][cj]=getCellData(i,j);
					   System.out.println(tabArray[ci][cj]);  
						}
					}
				}
			catch (FileNotFoundException e){
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
				}
			catch (IOException e){
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
				}
			return(tabArray);

			}
	
	
	private static int getLastColNum(Sheet datatypeSheet) {
		// TODO Auto-generated method stub
		Iterator<Row> iterator = datatypeSheet.iterator();
		int maxCol = 0;
		while (iterator.hasNext()) {

			Row currentRow = iterator.next();
			int numberOfCols = currentRow.getLastCellNum();
//			System.out.println("Cols in this Row are " + numberOfCols);
			if (numberOfCols > maxCol)
				maxCol = numberOfCols;
		}
		return maxCol;
	}
	
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			if  (dataType == 3) {
				return "";
			}else{
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
			}
		}
	
	
	//Read Excel by Fillo 
	
	public static String[][] ConnenctToFillo(String filePath, String strQuery) throws FilloException {
		  Fillo fillo = new Fillo();
		  Connection connection = fillo.getConnection(filePath);
		  Recordset recordset = connection.executeQuery(strQuery);
		  final String[][] excelData = new String[recordset.getCount()][recordset.getFieldNames().size()];

		  int row = 0;
		  while (recordset.next()) {
		   int col = 0;
		   for (int i = 0; i < recordset.getFieldNames().size(); i++) {
		    excelData[row][col] = recordset.getField(i).value();
		    col++;
		   }
		   row++;
		  }

		  recordset.close();
		  connection.close();
		  return excelData;
		 }

}
