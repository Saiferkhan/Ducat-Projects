package testng_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	
	public static Object [][] getexceldata(String filepath, String sheetName) throws IOException{
		
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int rowCount=sheet.getPhysicalNumberOfRows()-1;
		int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object [][]data = new Object[rowCount][cellcount];
		
		for(int i=0;i<rowCount;i++) {
			
			Row row=sheet.getRow(i+1);
			for(int j=0;j<cellcount;j++) {
				
				Cell cell=row.getCell(j);
				
				data[i][j]=cell.toString();
				
			}
		}
		//System.out.println("Loop is end by saifer khan");
		workbook.close();
		fis.close();
		return data;
				
	}
	@DataProvider(name="exceldata")
	public Object[][] exceldataproiver() throws IOException{
		
		String filepath="C:\\Users\\user\\eclipse-workspace\\SeleniumMavemproject1\\src\\test\\resources\\Sheets\\testdata.xlsx";
		String sheetName="Sheet1";
		
		Object[][] data =getexceldata(filepath,sheetName);
		System.out.println(Arrays.deepToString(data));
		
		String username=data[0][0].toString();
		String password=data[0][1].toString();
		
		System.out.println("Username:"+username);
		System.out.println("Password:"+password);
		
		return getexceldata(filepath,sheetName);
	}

}
