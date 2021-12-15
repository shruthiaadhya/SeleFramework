package com.Vtiger.GenericUtil;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Vtiger.POMclasses.HomePage;
import com.Vtiger.POMclasses.LoginPage;

public class BaseClass {

	public  WebDriver driver;
	public static WebDriver sdriver;
	public LoginPage lp;
	@BeforeSuite (groups={"SmokeTest","RegressionTest"})
	public void connectToDB()
	{
		System.out.println("connect to database");
	}
	
	//@Parameters("Browser")
	@BeforeClass (groups={"SmokeTest","RegressionTest"})
	public void launchBrowser_URL() throws IOException
	{
		// Launch browser
                 FileUtil prop = FileUtil.objOfFileUtil();
				String browser = prop.readDataFromPropFile("browser");
				if(browser.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("safari"))
				{
					driver=new SafariDriver();
				}
				else
				{
					driver=new ChromeDriver();
				}

				//get url
				driver.get(prop.readDataFromPropFile("url"));

				//maximize and wait 
				WebDriverUtil util=new WebDriverUtil(driver);
				util.windowMaximize(driver);
				util.pageLoadTimeout();
				
				lp=new LoginPage(driver);
				sdriver=driver;
				
	}
	
	
	
	@BeforeMethod (groups={"SmokeTest","RegressionTest"})
	public void loginToApp() throws IOException
	{
		//Login
				
				lp.loginToApp();
	}
	
	
	@AfterMethod (groups={"SmokeTest","RegressionTest"})
	public void logoutFromApp() throws InterruptedException
	{
        Thread.sleep(3000);
		//Sign out
		HomePage hp=new HomePage(driver);
		hp.logoutFromApp();
	}
	
	@AfterClass (groups={"SmokeTest","RegressionTest"})
	public void tearDown() throws InterruptedException
	{
		//Closing broswer
				Thread.sleep(3000);
				driver.close();
	}
	
	@AfterSuite (groups={"SmokeTest","RegressionTest"})
	public void disconnectFromDB()
	{
		System.out.println("disconnect from database");
	}
	
	public static void takeScreenShot(String name) throws Throwable 
	{
		TakesScreenshot ts = (TakesScreenshot) sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dst= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest= new File(dst);
		FileUtils.copyFile(src, finaldest);
	}
}
