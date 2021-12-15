package com.Vtiger.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.GenericUtil.BaseClass;
import com.Vtiger.GenericUtil.ExcelUtil;
import com.Vtiger.GenericUtil.JavaUtil;
import com.Vtiger.POMclasses.ContactsinfoPage;
import com.Vtiger.POMclasses.CreateContactPage;

public class TC003_CreateContactWithOrganizationTest extends BaseClass
{
	
	@Test(groups="SmokeTest",retryAnalyzer = com.Vtiger.GenericUtil.RetryAnalyzer.class)
	public void createContactSmoke() throws Throwable
	{
		String lname=JavaUtil.objJavaUtil().generateLastName();
		ExcelUtil exd = ExcelUtil.objOfExcelUtil();
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(lname);
		ContactsinfoPage cp=new ContactsinfoPage(driver);
		cp.searchForContact(lname, exd.readExcelData("Sheet3", 8, 0));
		
		WebElement valt = driver.findElement(By.xpath("//a[@title='Contacts' and text()='"+lname+"']"));
		Assert.assertEquals(valt.getText(), lname);
		System.out.println("TestCase3 Method1 Passed");
		
	}
	
	@Test (groups="RegressionTest",retryAnalyzer = com.Vtiger.GenericUtil.RetryAnalyzer.class)
	public void createContactWithOrg() throws Throwable
	{
		//Generating random names
		String fname=JavaUtil.objJavaUtil().generateFirstName();
		String lname=JavaUtil.objJavaUtil().generateLastName();
		ExcelUtil exd = ExcelUtil.objOfExcelUtil();
		
		//creating contact with organization
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContactWithOrgt(exd.readExcelData("Sheet3", 2, 1), fname, lname);
		
		//validating created contact
		ContactsinfoPage cp=new ContactsinfoPage(driver);
		cp.searchForContact(fname, exd.readExcelData("Sheet3", 7, 0));
		
		WebElement valt = driver.findElement(By.xpath("//a[text()='"+fname+"']"));
		Assert.assertEquals(valt.getText(), fname);
		System.out.println("TestCase3 Method2 Passed");
		
	}
	
	
	

}
