package com.SDET2.Rdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readkey {

	public static void main(String[] args) throws IOException
	{
		String dirpath = System.getProperty("user.dir");
		String propfilepath = dirpath+"/propfile.properties";
		FileInputStream fis=new FileInputStream(propfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		String val = prop.getProperty("browser");
		System.out.println(val);

	}

}
