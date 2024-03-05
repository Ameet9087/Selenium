package BasicDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		//step-1.create object of fileInputStream class in fileinputstream constructor
		FileInputStream file=new FileInputStream("src\\test\\resources\\excel.xlsx");
		
		//step-2.WorkbookFactory class from apache poi and call create (InputStream)
		Workbook wbf = WorkbookFactory.create(file);
		
		//steep-3.call getsheet(String name) and enter sheet name
		Sheet sheetName = wbf.getSheet("FTC");
		
		//step-4.call getrow(int rownumber) and enter row number
		Row row = sheetName.getRow(2);
		
		//step-5.call getcell(int cell) and enter cell number
		Cell column = row.getCell(1);
		
		//step-6.call getStringCellValue()
		String value = column.getStringCellValue();
		
		System.out.println(value);
	}

}
