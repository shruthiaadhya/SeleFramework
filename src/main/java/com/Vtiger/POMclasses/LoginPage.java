package com.Vtiger.POMclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericUtil.FileUtil;

public class LoginPage //Rule1
{
	WebDriver driver;
	
	@FindBy(name="user_name")  //Rule 2
	private WebElement username; //Rule 3

	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	//Rule 4
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
	
	//Rule 5
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule 6
	public void loginToApp() throws IOException
	{
		username.sendKeys(FileUtil.objOfFileUtil().readDataFromPropFile("username"));
		password.sendKeys(FileUtil.objOfFileUtil().readDataFromPropFile("password"));
		loginbtn.click();
	}
	
	//login credentials from user
	public void loginToApp(String newusername, String newpassword)
	{
		username.sendKeys(newusername);
		password.sendKeys(newpassword);
		loginbtn.click();
	}
	
	

}
