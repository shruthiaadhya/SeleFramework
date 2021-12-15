package com.Vtiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericUtil.WebDriverUtil;

public class ContactOrgNameNewPage //Rule 1
{
	WebDriver driver;
	
	@FindBy(id="search_txt") //Rule2
	private WebElement searchTxtFld;   //Rule3
	
	public WebElement getSearchTxtFld() {
		return searchTxtFld;
	}

	@FindBy(name="search_field") //Rule2
	private WebElement selectOrgNameDD;   //Rule3
	
	@FindBy(name="search") //Rule2
	private WebElement searchBtn;   //Rule3
	
	@FindBy(xpath="//a[text()=\"Test002\"]") //Rule2
	private WebElement selectTxt;   //Rule3

	//Rule 4
	public WebElement getSelectOrgNameDD() {
		return selectOrgNameDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectTxt() {
		return selectTxt;
	}
	
	public ContactOrgNameNewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	public void selectOrgName(String orgname,String text ) 
	{
		
		WebDriverUtil util=new WebDriverUtil(driver);
		util.switchToWindow("Accounts&action");
		searchTxtFld.sendKeys(orgname);
		util.selectValueFromDD(text, selectOrgNameDD);
		searchBtn.click();
		selectTxt.click();
	}
	
	
	
}
