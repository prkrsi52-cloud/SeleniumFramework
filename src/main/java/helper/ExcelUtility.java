package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static XSSFWorkbook wb = null;

	public static Object[][] getData(String sheetName) {

		File src = new File(System.getProperty("user.dir") + "/TestData/SampleExcelData.xlsx");

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(src);

		} catch (FileNotFoundException e) {

			System.out.println("File Not Found " + e.getMessage());
		}
		
		try {
			wb = new XSSFWorkbook(fis);

		} catch (IOException e) {

			System.out.println("WorkBook not Found " + e.getMessage());
		}

		XSSFSheet sh1 = wb.getSheet(sheetName);

		int row = wb.getSheet(sheetName).getPhysicalNumberOfRows();

		int column = wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {

				arr[i][j] = ExcelUtility.getCellData(sheetName, i, j);

			}

		}
		return arr;

	}

	public static String getCellData(String sheetName, int row, int column) {

		XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(column);

		CellType celltype = cell.getCellType();

		String data = "";

		if (celltype == CellType.STRING) {

			data = cell.getStringCellValue();

		} else if (celltype == CellType.BOOLEAN) {

			data = String.valueOf(cell.getBooleanCellValue());

		} else if (celltype == CellType.NUMERIC) {

			data = String.valueOf(cell.getNumericCellValue());

		} else if (celltype == CellType.BLANK) {
			data = "";
		}

		return data;

	}

}
