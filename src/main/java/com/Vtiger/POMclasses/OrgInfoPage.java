package com.Vtiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericUtil.WebDriverUtil;

public class OrgInfoPage //Rule 1
{
	WebDriver driver;

	@FindBy(xpath="//img[@title='Create Organization...']")  //Rule 2
	private WebElement createorgimg;   //Rule 3

	@FindBy(name="search_text")  //Rule 2
	private WebElement orgnameTxtFld;   //Rule 3

	@FindBy(id="bas_searchfield")  //Rule 2
	private WebElement searchfororgDD;   //Rule 3

	@FindBy(name="submit")  //Rule 2
	private WebElement searchNowbtn;   //Rule 3

	//Rule 4
	public WebElement getCreateorgimg() {
		return createorgimg;
	}

	public WebElement getOrgnameTxtFld() {
		return orgnameTxtFld;
	}

	public WebElement getSearchfororgDD() {
		return searchfororgDD;
	}

	public WebElement getSearchNowbtn() {
		return searchNowbtn;
	}
	
	//Rule 5
	public OrgInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	public void seacrchForOrg(String orgnamesearchfor,String text)
	{
		HomePage hp=new HomePage(driver);
        hp.getOrglink().click();
		orgnameTxtFld.sendKeys(orgnamesearchfor);
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectValueFromDD(text, searchfororgDD);
		searchNowbtn.click();
	}

}
