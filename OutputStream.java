package BasicDDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class OutputStream {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream file= new FileInputStream("src\\\\test\\\\resources\\\\excel.xlsx");
		Workbook wbf = WorkbookFactory.create(file);
		Sheet sheetName = wbf.getSheet("FTC");
		Row row = sheetName.createRow(3);
		Cell column = row.createCell(0);
		column.setCellValue("city");
		
		
		FileOutputStream opFile=new FileOutputStream("src\\\\test\\\\resources\\\\excel.xlsx");
		wbf.write(opFile);
	}

}
