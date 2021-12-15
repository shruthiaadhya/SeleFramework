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

public class TC001_CreateOrganizationTest extends BaseClass
{
	
       
    @Test(groups="SmokeTest", retryAnalyzer = com.Vtiger.GenericUtil.RetryAnalyzer.class)
	public void createOrganization() throws Throwable
	{

		HomePage hp=new HomePage(driver);
        hp.getOrglink().click();
		
        //Random org name
		String Orgname = JavaUtil.objJavaUtil().generateFirstName()+JavaUtil.objJavaUtil().generateRandomNumber();

		//creating organization
		
		CreateOrgPage cop=new CreateOrgPage(driver);
		cop.createOrg(Orgname);

		Thread.sleep(3000);

		//Validating
		OrgInfoPage orgp= new OrgInfoPage(driver);
		orgp.seacrchForOrg(Orgname,ExcelUtil.objOfExcelUtil().readExcelData("Sheet3", 2, 0));
		
		
		WebElement val = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+Orgname+"']"));
		Assert.assertEquals(val.getText(), Orgname);
		System.out.println("TestCase1 Method1 Passed");
	}
    
    @Test (groups="RegressionTest",retryAnalyzer = com.Vtiger.GenericUtil.RetryAnalyzer.class)
    public void createOrgWithContact() throws Throwable
    {

		HomePage hp=new HomePage(driver);
        hp.getOrglink().click();
        
        String Orgname = JavaUtil.objJavaUtil().generateFirstName()+JavaUtil.objJavaUtil().generateRandomNumber();
        CreateOrgPage cop=new CreateOrgPage(driver);
        cop.createOrgWithContact(Orgname, JavaUtil.objJavaUtil().generatePhoneNo());
        
        Thread.sleep(3000);
        OrgInfoPage orgp= new OrgInfoPage(driver);
		orgp.seacrchForOrg(Orgname,ExcelUtil.objOfExcelUtil().readExcelData("Sheet3", 2, 0));
		
		
        WebElement val = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+Orgname+"']"));
        Assert.assertEquals(val.getText(), Orgname);
		System.out.println("TestCase1 Method2 Passed");
    
    
        
        
    }

}
