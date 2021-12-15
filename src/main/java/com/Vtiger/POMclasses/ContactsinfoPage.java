package com.Vtiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericUtil.WebDriverUtil;

public class ContactsinfoPage //Rule 1
{
    WebDriver driver;
    
    @FindBy(xpath="//img[@title='Create Contact...']")  //Rule 2
	private WebElement createcontactimg;   //Rule 3

	@FindBy(className="txtBox")  //Rule 2
	private WebElement searchForTxtFld;   //Rule 3

	@FindBy(id="bas_searchfield")  //Rule 2
	private WebElement searchforContactDD;   //Rule 3

	@FindBy(name="submit")  //Rule 2
	private WebElement searchNowbtn;   //Rule 3

	//Rule 4
	public WebElement getCreatecontactimg() {
		return createcontactimg;
	}

	public WebElement getSearchForTxtFld() {
		return searchForTxtFld;
	}

	public WebElement getSearchforContactDD() {
		return searchforContactDD;
	}

	public WebElement getSearchNowbtn() {
		return searchNowbtn;
	}
	
	//Rule 5
	public ContactsinfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	//Rule 6
	public void searchForContact(String Fname, String text)
	{
		HomePage hp=new HomePage(driver);
		hp.getContactslink().click();
		searchForTxtFld.sendKeys(Fname);
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectValueFromDD(text, searchforContactDD);
		searchNowbtn.click();
	}
	
}
