package CommonUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

		public String getDataFromExcel(String SheetName,int RowNum,int ColumnNum) throws EncryptedDocumentException, IOException {
			FileInputStream file= new FileInputStream("src\\test\\resources\\data.xlsx");
			Workbook wbf = WorkbookFactory.create(file);
			Sheet sheetName = wbf.getSheet(SheetName);
			Row row = sheetName.getRow(RowNum);
			Cell column = row.getCell(ColumnNum);
			String value = column.getStringCellValue();
			return value;
		}
	

}

