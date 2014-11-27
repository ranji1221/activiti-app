package org.ranji.document;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelUtil {
		
	private HSSFWorkbook wb;
	
	private ExcelUtil(){
		wb = new HSSFWorkbook();
	}
	
	private ExcelUtil(InputStream is){
		POIFSFileSystem fs = null;
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ExcelUtil getInstance(){
		return new ExcelUtil();
	}
	public static ExcelUtil getInstance(InputStream is){
		return new ExcelUtil(is);
	}
	/**
	 * 获取EXCEL中的Sheet脚本数
	 * @return
	 */
	public int getSheetCount(){
		return wb.getNumberOfSheets();
	}
	
	public static void main(String[] args) {
		ExcelUtil excelUtil = 
				ExcelUtil.getInstance(ExcelUtil.class.getClassLoader().getResourceAsStream("test.xls"));
		System.out.println(excelUtil.getSheetCount());
	}
}
