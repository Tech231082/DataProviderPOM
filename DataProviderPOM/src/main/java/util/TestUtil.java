package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public static String TEST_DATA_SHEET_PATH="C:\\JUnit\\eclipse-workspace\\DataProviderPOM\\src\\main\\java\\testData\\data.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetname) {
		FileInputStream file=null;
		try {
			file=new FileInputStream(TEST_DATA_SHEET_PATH);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet=(Sheet) book.getSheet(sheetname);
		
		Object[][] data=(Object[][]) new Object[sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum();i++) {
			for(int j=0;j<((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum();j++) {
				
				data[i][j]=((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
		
	}

}
