package alphatroniksExtract;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	private XSSFSheet spreadsheet;
	private XSSFWorkbook workbook;
	//Create row object
	private XSSFRow row;
	String[] headers = {"instrumentName","instrumentSubtitle", "description","mrp","sellingPrice","type","photoFile","JSON"};
	public ExcelSheet() throws Exception {
		// TODO Auto-generated constructor stub
		
		//Create Blank workbook
		  workbook = new XSSFWorkbook();
	      //Create a blank spreadsheet
	      spreadsheet = workbook.createSheet("Electronic Devices and Modules");
	         
	}
	
	
	public void writeRow(int rowIndex) {
	      row = spreadsheet.createRow(rowIndex);
	}
	
	public void writeCell(int columnIndex, Object value) {
		Cell cell = row.createCell(columnIndex);
        cell.setCellValue(String.valueOf(value));
	}
	
	public void writeHeaders() {
		//Create row object
	      XSSFRow row;
	      row = spreadsheet.createRow(0);
	      int cellid = 0;
	         for (String obj : headers)
	         {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      
	      
	}
	
	public void createFile(String fileName ) throws Exception {
		//Create file system using specific name
	      FileOutputStream out = new FileOutputStream(
	      new File(fileName));
	    //write operation workbook using file out object 
	      workbook.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
	}

}
