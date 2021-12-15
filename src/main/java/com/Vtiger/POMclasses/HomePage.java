package com.Vtiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericUtil.WebDriverUtil;

public class HomePage //Rule 1
{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Organizations']") //Rule 2
	private WebElement orglink;    //Rule 3
	
	@FindBy(xpath="//a[text()='Contacts']") //Rule 2
	private WebElement contactslink;    //Rule 3
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") //Rule 2
	private WebElement logoutimg;    //Rule 3
	
	@FindBy(xpath="//a[text()='Sign Out']") //Rule 2
	private WebElement signoutlink;    //Rule 3

	//Rule 4
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getLogoutimg() {
		return logoutimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	//Rule 5
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule 6
	public void logoutFromApp() throws InterruptedException
	{
		WebDriverUtil util=new WebDriverUtil(driver);
		util.moveToElement(logoutimg);
		Thread.sleep(3000);
		signoutlink.click();
	}
	
	
	
	
	

}
