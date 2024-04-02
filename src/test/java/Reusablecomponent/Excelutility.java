package Reusablecomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excelutility {
	 
	 
	    public String[][] getData1() {
	        // Provide the path to your Excel file
	        String filePath = System.getProperty("user.dir")+"\\testdata\\Userdetails.xlsx";

	        try (FileInputStream fileInputStream = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
	            Sheet sheet = workbook.getSheetAt(0);
	            int rowCount = sheet.getPhysicalNumberOfRows();
	            int colCount = sheet.getRow(0).getLastCellNum();
	            String[][] data = new String[rowCount - 1][colCount];

	            // Skip the header row
	            for (int i = 1; i < rowCount; i++) {
	                Row row = sheet.getRow(i);
	                for (int j = 0; j <colCount; j++) {
	                    Cell cell = row.getCell(j);
	                    data[i - 1][j] = cell.getStringCellValue();
	                }
	            }
	            return data;
	        } catch (IOException e) {
	            e.printStackTrace(); // Handle exceptions
	            return null;
	        }
	    
}
	     public void write_dataToExcel(String name, String email, String password) throws EncryptedDocumentException, InvalidFormatException {
	    	 try  {
	    		 String filePath = System.getProperty("user.dir")+"\\testdata\\Userdetails.xlsx";
	    		 File f= new File(filePath);
	    		 FileInputStream fis= new FileInputStream(f);
	             // Create a new sheet
//	             Sheet sheet = workbook.createSheet("Userdetails");
                  Workbook wk= WorkbookFactory.create(fis);
                 Sheet sheet= wk.getSheet("Userdetails");
	             // Write data into the sheet
	             Row headerRow = sheet.createRow(1);
	             headerRow.createCell(0).setCellValue(name);
	             headerRow.createCell(1).setCellValue(email);
	             headerRow.createCell(2).setCellValue(password);
	             
	             // Write the workbook content to a file
	             try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
	                 wk.write(fileOutputStream);
	             }
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }
}