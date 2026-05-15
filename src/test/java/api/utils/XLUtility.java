package api.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtility {

	public FileInputStream fis;
	public FileOutputStream fos;
	public Workbook book;
	public Sheet sh;
	public Row row;
	public Cell cel;
	
	String path;
	
	public XLUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		book=WorkbookFactory.create(fis);
		sh=book.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		return rowcount;
	}
	
	public int getCellCount(String sheetname,int rownum) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		book=WorkbookFactory.create(fis);
		sh=book.getSheet(sheetname);
		row=sh.getRow(rownum);
		int cellcount=row.getLastCellNum();
		return cellcount;
	}
	
	public String getCellData(String sheetname, int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		book=WorkbookFactory.create(fis);
		sh=book.getSheet(sheetname);
		row=sh.getRow(rownum);
		cel=row.getCell(cellnum);
		DataFormatter format=new DataFormatter();
		String data=format.formatCellValue(cel);
		return data;
	}
	
		
}
