package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dummy {

	static HashMap<String, HashMap> outerMap = new HashMap<String, HashMap>();

	public static void main(String[] args) throws Exception {
		/*
		 * WebDriver drive = null;
		 * 
		 * String s = "Suraj";
		 * 
		 * char[] s1 = s.toCharArray();
		 * 
		 * for (char c : s1) {
		 * 
		 * System.out.println(c + "****"); } System.out.println(s1.length); int
		 * i = s1.length - 1; for (; i >= 0; i--) { System.out.println(s1[i] +
		 * "******------*******"); }
		 */
		System.out.println("********MAP***********");

		// D:\\Test.xlsx
		// C:\\Users\\28891\\Desktop\\UPM_report\\TestData_Configuration.xlsx
		HashMap<Integer, HashMap> m1 = loadData("D:\\Test.xlsx");

		System.out.println("************read from hashmap***********");

		System.out.println(m1);

		System.out.println("********");

		System.out.println(readData("Sheet 0", 5, 0));
		/*
		 * Set keys = m1.keySet(); for(Object key: keys) { HashMap rowval =
		 * m1.get(key); System.out.println(key); System.out.println(rowval); }
		 */
	}

	public static HashMap loadData(String path) throws Exception {
		try {
			
			FileInputStream fis = new FileInputStream(new File(path));
			// Create an excel workbook from the file system
			XSSFWorkbook workBook = new XSSFWorkbook(fis);

			int sheetSize = workBook.getNumberOfSheets();

			int sheetNum;
			for (sheetNum = 0; sheetNum < sheetSize; sheetNum++) {
				XSSFSheet sheet = workBook.getSheetAt(sheetNum);
				int lastRow = sheet.getLastRowNum();
				HashMap<Integer, List<String>> innerMap = new HashMap<Integer, List<String>>();
				for (int currentRowCnt = 0; currentRowCnt <= lastRow; currentRowCnt++) {

					Row row = sheet.getRow(currentRowCnt);

					// Empty rows are returned as null
					if (row == null) {
						continue;
					}
					int lastColumn = 0;
					ArrayList<String> data = new ArrayList<String>();
					if (row.getCell(0) != null) {
						lastColumn = row.getLastCellNum();

						for (int currentCellCnt = 0; currentCellCnt < lastColumn; currentCellCnt++) {
							// Undefined cells are returned as null
							Cell cell = row.getCell(currentCellCnt);
							if (cell == null) {
								continue;
							}
							if (cell.getCellType() == 0) {
								data.add(Double.toString((cell.getNumericCellValue())));
							} else {
								cell.getCellType();
								data.add(cell.getStringCellValue());
							}
							// System.out.println(cell);
						}
					} else {
						break;
					}
					innerMap.put(currentRowCnt, data);
				}
				outerMap.put("Sheet " + sheetNum, innerMap);

			}

			fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return outerMap;

	}

	public static String readData(String SheetNo, int rowNum, int columnNo) {

		HashMap<Integer, List> innerMap = new HashMap<Integer, List>();
		String Data = null;
		Set<String> Keys = outerMap.keySet();

		for (String sheet : Keys) {
			if (sheet.equals(SheetNo)) {
				innerMap = outerMap.get(sheet);
				List<String> allData = innerMap.get(rowNum);
				int row = 0;
				for (String cellValue : allData) {
					if (row == columnNo) {
						Data = cellValue;
						// System.out.println(Data);
					}
					row++;
				}

			}

		}
		return Data;

	}

}
