package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtility {

	static XSSFWorkbook excelwbk;
	static XSSFSheet excelSheet;
	static XSSFRow excelrow;
	static XSSFCell excelcell;
	
	public static void main(String args[]) throws IOException {
		
		File file=new File("D:\\UmeshData\\Book2.xlsx");
		FileInputStream fis=new FileInputStream(file);
		excelwbk=new XSSFWorkbook(fis);
		excelSheet=excelwbk.getSheet("Sheet4");
		
		int RowCount=excelSheet.getLastRowNum() + 1;
		
		int ColCount= excelSheet.getRow(0).getLastCellNum();
		Object[][] array=new Object[RowCount][ColCount];
		for(int i=1; i<RowCount; i++) {
			excelrow=excelSheet.getRow(i);
			for(int j=0; j<ColCount; j++) {
				excelcell=excelrow.getCell(j);
				array[i][j]=excelcell;
				System.out.println(array);
			}
		}
		
		
	}
	
	
}
