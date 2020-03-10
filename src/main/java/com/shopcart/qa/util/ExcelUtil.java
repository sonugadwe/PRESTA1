package com.shopcart.qa.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static Object[][] getDataFromExcel(String sheetName, String sheet_Path) throws Exception {
		FileInputStream fis = new FileInputStream(sheet_Path);
		// Workbook workbook = WorkbookFactory.create(stream);
		// Sheet s = workbook.getSheet(sheetName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet s = workbook.getSheet(sheetName);

		/*
		 * int rowCount = s.getLastRowNum(); System.out.println("row:" +rowCount); int
		 * cellCount = s.getRow(0).getLastCellNum();
		 */
		Object[][] data = new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];

		for (int i = 0; i < s.getLastRowNum(); i++) {
			for (int j = 0; j < s.getRow(0).getLastCellNum(); j++) {
				//Cell cell = s.getRow(i + 1).getCell(j);
				// System.out.println(data[i][j]);
				/*switch (cell.getCellType()) {
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;

				default:
				}*/
				
				data[i][j]= s.getRow(i+1).getCell(j).toString();
			}
			System.out.println("");
		}

		return data;
	}

}
