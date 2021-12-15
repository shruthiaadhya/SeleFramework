package com.Vtiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericUtil.WebDriverUtil;

public class CreateOrgPage
{
   WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement orgNameTxtFld;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="rating")
	private WebElement ratingDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(id="phone")
	private WebElement phoneTxtFld;
	
	

	public WebElement getPhoneTxtFld() {
		return phoneTxtFld;
	}

	public WebElement getOrgNameTxtFld() {
		return orgNameTxtFld;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getRatingDD() {
		return ratingDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}
	
	public CreateOrgPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createOrg(String orgname)
	{
		
        OrgInfoPage orgp= new OrgInfoPage(driver);
        orgp.getCreateorgimg().click();
		orgNameTxtFld.sendKeys(orgname);
		saveBtn.click();
	}
	
	public void createOrgWithContact(String orgname,String phone)
	{
		 OrgInfoPage orgp= new OrgInfoPage(driver);
	        orgp.getCreateorgimg().click();
			orgNameTxtFld.sendKeys(orgname);
			phoneTxtFld.sendKeys(phone);
			saveBtn.click();
	}
	
	public void createOrgBySelectingDDS(String orgname, String itext, String rtext, String ttext) throws Throwable
	{
		
        OrgInfoPage orgp= new OrgInfoPage(driver);
        orgp.getCreateorgimg().click();
		orgNameTxtFld.sendKeys(orgname);
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectValueFromDD(itext, industryDD);
		util.selectValueFromDD(rtext, ratingDD);
		util.selectValueFromDD(ttext, typeDD);
		saveBtn.click();
	}
	
}

