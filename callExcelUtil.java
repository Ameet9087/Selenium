package BasicDDT;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import CommonUtil.ExcelUtil;
import CommonUtil.ProperrtyFileUtil;

public class callExcelUtil {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		ExcelUtil e=new ExcelUtil();
		String val = e.getDataFromExcel("FTC", 0, 0);
		System.out.println(val);
		
		ProperrtyFileUtil pf=new ProperrtyFileUtil();
		String key = pf.getDataFromPropertyFile("url");
		System.out.println(key);
	}

}
