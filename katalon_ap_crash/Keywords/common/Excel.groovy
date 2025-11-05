package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
/*import MobileBuiltInKeywords as Mobile
 import WSBuiltInKeywords as WS
 import WebUiBuiltInKeywords as WebUI*/

import java.util.List
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.xpath.axes.UnionPathIterator.iterOwner
//import org.junit.After

import java.lang.String

public class Excel {

	def static String ReadFromExcel(String filePath, String sheetName, int iRowNumber, String columnName){

		int columnNumber = getColumnNumber(filePath, sheetName, columnName)
		return ReadFromExcel(filePath, sheetName, iRowNumber, columnNumber)
	}

	def static void WirteToExcel(String filePath, String sheetName, int iRowNumber, String columnName, String text){

		int columnNumber = getColumnNumber(filePath, sheetName, columnName)

		WirteToExcel(filePath, sheetName, iRowNumber, columnNumber, text)
	}

	def static List GetValuesFromExcel(String filePath, String sheetName, String columnName){
		int columnNumber = getColumnNumber(filePath, sheetName, columnName)

		return GetValuesFromExcel(filePath, sheetName, columnNumber)
	}

	def static int getColumnNumber(String filePath, String sheetName, String columnName){

		FileInputStream file = new FileInputStream (new File(filePath))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheet(sheetName)
		int cnt = sheet.getRow(0).getLastCellNum()
		println cnt
		int i = 0;

		'Read data from excel'
		for (i = 0; i < cnt; i ++) {
			String text = sheet.getRow(0).getCell(i).getStringCellValue()
			println text
			if(text == columnName) break
		}
		file.close()

		return i
	}

	def static void WirteToExcel(String filePath, String sheetName, int iRowNumber, int columnNumber, String text){

		FileInputStream file = new FileInputStream (new File(filePath))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheet(sheetName)

		CellStyle wrapStyle = workbook.createCellStyle();
		wrapStyle.setWrapText(true);

		'Write data to excel'
		if(sheet.getRow(iRowNumber) == null)
			sheet.createRow(iRowNumber)
		Cell cell = sheet.getRow(iRowNumber).createCell(columnNumber)
		cell.setCellStyle(wrapStyle)
		cell.setCellValue(text)

		//sheet.getRow(iRowNumber).createCell(columnNumber).setCellValue(text)
		//sheet.createRow(iRowNumber).createCell(columnNumber).setCellValue(text)

		file.close()

		FileOutputStream outFile =new FileOutputStream(new File(filePath))
		workbook.write(outFile)
		outFile.close()
	}

	def static String ReadFromExcel(String filePath, String sheetName, int iRowNumber, int columnNumber){

		FileInputStream file = new FileInputStream (new File(filePath))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheet(sheetName)

		'Read data from excel'
		String text = sheet.getRow(iRowNumber).getCell(columnNumber).getStringCellValue()
		println text
		file.close()

		return text
	}

	def static List GetValuesFromExcel(String filePath, String sheetName, int columnNumber){
		List lst = new ArrayList<String>()

		FileInputStream file = new FileInputStream (new File(filePath))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheet(sheetName)
		int cnt = sheet.getLastRowNum()

		'Read data from excel'
		for(int i=1;i<=cnt;i++){
			if(sheet.getRow(i).getCell(columnNumber) != null){
				String text = sheet.getRow(i).getCell(columnNumber).getStringCellValue()
				println text
				lst.add(text)
			}
		}

		file.close()

		return lst
	}

	def static RemoveValuesFromExcel(String filePath, String sheetName, int beginRow){
		//List lst = new ArrayList<String>()

		FileInputStream file = new FileInputStream (new File(filePath))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheet(sheetName)
		int cnt = sheet.getLastRowNum()

		'Remove data from excel'
		for(int i=beginRow;i<=cnt;i++){
			sheet.removeRow(sheet.getRow(i))
		}

		file.close()

		FileOutputStream outFile =new FileOutputStream(new File(filePath))
		workbook.write(outFile)
		outFile.close()
	}

	@Keyword
	def void writeToExcel(String filePath, String sheetName, int rowIndex, int columnIndex, String value){

		FileInputStream file = new FileInputStream(new File(filePath))

		XSSFWorkbook workbook = new XSSFWorkbook(file)

		XSSFSheet sheet = workbook.getSheet(sheetName)

		//Object excel = ExcelFactory.getExcelDataWithDefaultSheet(filePath, 'Sheet1', true)

		sheet.getRow(rowIndex).createCell(columnIndex).setCellValue(value)

		file.close()

		FileOutputStream outFile = new FileOutputStream(new File(filePath))

		workbook.write(outFile)

		outFile.close()
	}
}
