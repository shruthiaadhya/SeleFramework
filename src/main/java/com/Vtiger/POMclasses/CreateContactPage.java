package com.Vtiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericUtil.ExcelUtil;
import com.Vtiger.GenericUtil.WebDriverUtil;

public class CreateContactPage //Rule 1
{
	WebDriver driver;
	
	@FindBy(name="salutationtype") //Rule2
	private WebElement selectDD;   //Rule3
	
	@FindBy(name="firstname") //Rule2
	private WebElement firstname;   //Rule3
	
	@FindBy(name="lastname") //Rule2
	private WebElement lastname;   //Rule3
	
	@FindBy(xpath="//img[@title='Select']") //Rule2
	private WebElement plusImgOrgName;   //Rule3
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") //Rule2
	private WebElement saveBtn;   //Rule3

	public WebElement getSelectDD() {
		return selectDD;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPlusImgOrgName() {
		return plusImgOrgName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public CreateContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createContact(String lname)
	{
		HomePage hp=new HomePage(driver);
		hp.getContactslink().click();
		ContactsinfoPage cp=new ContactsinfoPage(driver);
		cp.getCreatecontactimg().click();
		lastname.sendKeys(lname);
		saveBtn.click();
	}
	public void createContactWithOrgt(String DD1Txt,String fname, String lname) throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getContactslink().click();
		ContactsinfoPage cp=new ContactsinfoPage(driver);
		cp.getCreatecontactimg().click();
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectValueFromDD(DD1Txt, selectDD);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		String pw = driver.getWindowHandle();
		plusImgOrgName.click();
		ContactOrgNameNewPage connp=new ContactOrgNameNewPage(driver);
		String Org = ExcelUtil.objOfExcelUtil().readExcelData("Sheet1", 13, 0);
		String txt=ExcelUtil.objOfExcelUtil().readExcelData("Sheet3", 2, 0);
		connp.selectOrgName(Org, txt);
		driver.switchTo().window(pw);
		saveBtn.click();
		
	}
	

}
