package com.Vtiger.GenericUtil;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer
{
	
	int counter=0;
	int retrylimit=3;

	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter<retrylimit)
		{
			counter++;
			return true;
		}
		return false;
	}
	

}
