package myPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ImportFromExcel {
	
	
	@Test
	public void excelTest() throws BiffException, IOException{
	
		String FilePath = "src/ExcelTest.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		
		Sheet sh = wb.getSheet(0); // this is to get the access to Sheet1. 
		for (int i = 0; i<8; i++){
			for (int j = 0; j < 3; j++){
				String CellGetContent = sh.getCell(j,i).getContents();
				System.out.print(CellGetContent + "  ");
				if (j == 2){
					System.out.println();
				}
			}
		}
		
		
	}
	
	

}
