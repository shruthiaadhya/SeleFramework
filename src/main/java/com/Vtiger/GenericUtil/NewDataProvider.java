package com.Vtiger.GenericUtil;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewDataProvider 
{
	
	@Test(dataProvider="getValue")
	public void print(String value1,String value2)
	{
		System.out.println(value1+" "+value2);
	}
	
	@DataProvider()
	public Object[][] getValue()
	{
		Object arr[][]=new Object[4][2];
		arr[0][0]="TYSS";
		arr[0][1]="testyantra";
		arr[1][0]="Hyd";
		arr[1][1]="Nzb";
		arr[2][0]="mango";
		arr[2][1]="apple";
		arr[3][0]="indian";
		arr[3][1]="western";
		return arr;
	}

}
