package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData extends Jdbc{


	public ArrayList<String> data(String sheetName,String columnName,String desiredRow) throws IOException
	{
		ArrayList<String> aList= new ArrayList<String>();
		String excelPath=System.getProperty("user.dir")+"//src//main//java//resources//TestData.xlsx";
		FileInputStream fs = new FileInputStream(excelPath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		int sheets=	workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				Iterator<Cell> cells=firstRow.cellIterator();
				int k=0;
				int column=0;
				while (cells.hasNext()) {
					Cell cell=cells.next();
					if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
						column=k;
					}
					k++;
					}
				while (rows.hasNext()) {
					Row row=rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(desiredRow)) {
						Iterator<Cell> cv=row.cellIterator();
						while (cv.hasNext()) {
							Cell cd=cv.next();
								CellType type=cd.getCellType();
							if (type==CellType.NUMERIC) {
							
								aList.add(NumberToTextConverter.toText(cd.getNumericCellValue()));
							}
							else {
								aList.add(cd.getStringCellValue());
							}
						}
					}
					
				}
				
			}
	
		}
		return aList;
	}
}
