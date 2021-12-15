package com.Vtiger.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.GenericUtil.BaseClass;
import com.Vtiger.GenericUtil.ExcelUtil;
import com.Vtiger.GenericUtil.JavaUtil;
import com.Vtiger.POMclasses.CreateOrgPage;
import com.Vtiger.POMclasses.HomePage;
import com.Vtiger.POMclasses.OrgInfoPage;

public class TC002_CreateOrganizationWithDropdownTest extends BaseClass
{
	@Test (groups="RegressionTest",retryAnalyzer = com.Vtiger.GenericUtil.RetryAnalyzer.class)
	public void createOrgWithDD() throws Throwable
	{
		HomePage hp=new HomePage(driver);
        hp.getOrglink().click();
        
		//random organization
		String Orgname = JavaUtil.objJavaUtil().generateFirstName()+JavaUtil.objJavaUtil().generateRandomNumber();
		ExcelUtil exd = ExcelUtil.objOfExcelUtil();
		
		//creating org with dropdowns
		CreateOrgPage cop=new CreateOrgPage(driver);
		cop.createOrgBySelectingDDS(Orgname, exd.readExcelData("Sheet2", 6, 0),exd.readExcelData("Sheet2", 2, 1), 
				exd.readExcelData("Sheet2", 3, 2));
		Thread.sleep(3000);
		
		//validating created organization
		OrgInfoPage orgp= new OrgInfoPage(driver);
		orgp.seacrchForOrg(Orgname,ExcelUtil.objOfExcelUtil().readExcelData("Sheet3", 2, 0));

		WebElement val = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+Orgname+"']"));
		Assert.assertEquals(val.getText(), Orgname);
		System.out.println("TestCase2  Passed");


	}

}
