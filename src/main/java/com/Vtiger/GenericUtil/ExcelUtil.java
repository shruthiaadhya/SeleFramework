package com.Vtiger.GenericUtil;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil implements IAutoConstants{
	
	/**
	 * @author Admin
	 * Description: Singleton concept
	 */
	private ExcelUtil()
	{
		
	}
	
	/**
	 * @author Admin
	 * Description:creating ExcelUtil object
	 * 
	 * @return
	 */
	public static ExcelUtil objOfExcelUtil()
	{
		ExcelUtil el=new ExcelUtil();
		return el;
	}
	
	/**
	 * @author Admin
	 * Description:reading data from excel sheet
	 * 
	 * @param sname
	 * @param rnum
	 * @param cnum
	 * @return
	 * @throws Throwable
	 */
	public String readExcelData(String sname,int rnum, int cnum) throws Throwable 
	{
        
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sname).getRow(rnum).getCell(cnum).getStringCellValue();
        return value;
      	
	}
	
	public int getLastRow(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IAutoConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetname).getLastRowNum();
		
	}
	
	public String selectValueFromDD(String sheetname,int cnum, String DDvalue) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IAutoConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		
		int lastrow= getLastRow(sheetname);
		String value="null";
		
		for(int i=0;i<lastrow;i++)
		{
			value=sh.getRow(i).getCell(cnum).getStringCellValue();
			if(value.equalsIgnoreCase(DDvalue))
			{
				break;
			}
		}
		return value;
	}

}
