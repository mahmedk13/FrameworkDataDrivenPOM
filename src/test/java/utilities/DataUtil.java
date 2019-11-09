package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataUtil {
	
	
	@DataProvider
	public Object[][] getData(Method m) throws IOException{
		System.out.println("name of the method in data provider is "+m.getName());
		
		File f = new File("./src/test/resources/excelfiles/testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(m.getName());
		int totalRowNum = sh.getPhysicalNumberOfRows();
		System.out.println("total row numbers are "+sh.getPhysicalNumberOfRows());
		int cellNum = sh.getRow(0).getLastCellNum();
		System.out.println("total cols are "+cellNum);
		
		Object[][] data = new Object[totalRowNum-1][cellNum];
		
		for(int i=1; i<totalRowNum; i++) {
			for(int j=0; j<cellNum; j++) {
				data[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		
		
		return data;
		
	}
	

}
