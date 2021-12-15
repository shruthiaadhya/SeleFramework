package com.Vtiger.GenericUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil implements IAutoConstants {
	
	/**
	 * @author Admin
	 * Description: Singleton concept
	 */
	private FileUtil()
	{
		
	}
	
	/**
	 * @author Admin
	 * Description:creating fileutil object
	 * 
	 * @return
	 */
	public static FileUtil objOfFileUtil()
	{
		FileUtil file=new FileUtil();
		return file;
	}
	
	/**
	 * @author Admin
	 * Description:reading data from property file
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropFile(String key) throws IOException
	{
		
		FileInputStream fis=new FileInputStream(Propfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public String readDataFromPropFile(String key,String path) throws IOException
	{
		
		FileInputStream fis=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
