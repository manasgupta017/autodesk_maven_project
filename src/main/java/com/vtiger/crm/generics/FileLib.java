package com.vtiger.crm.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Darth_Yoda
 *
 */
public class FileLib {

	String filePath = "./testdata/testdata.xlsx";

	/**
	 * used to read data from Excel
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @throw EncrytedDocument Exception
	 */

	public String getExcelData(String SheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		String value = null;
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.getRow(rowNum);
		Cell cl = rw.getCell(cellNum);
		switch (cl.getCellType()) {
		case STRING:
			// STRING is Global Constant in CellType<Enum>(return type of
			// getCellType())
			value = cl.getStringCellValue();
			break;
		case BOOLEAN:
			value = Boolean.toString(cl.getBooleanCellValue());
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cl)) {
				Date dateValue = cl.getDateCellValue();
				String format = "YYYY-MM-dd";
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				value = sdf.format(dateValue);
			} else {
				long longValue = (long) cl.getNumericCellValue();
				value = Long.toString(longValue);
			}
			break;

		default:

			break;
		}
		wb.close();// closing the excel sheet because it get crashed if it is
					// open more times
		return value;
	}

	public void setExcelData(String SheetName, int rowNum, int cellNum, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.getRow(rowNum);
		Cell cel = rw.createCell(cellNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();

	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowIndex = sh.getLastRowNum();
		return rowIndex;
	}

	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream("");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
