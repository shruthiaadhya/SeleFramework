package com.SDET2.Rdata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Vtiger.GenericUtil.FileUtil;
import com.Vtiger.GenericUtil.WebDriverUtil;
import com.Vtiger.POMclasses.LoginPage;

public class VtigerHomePageDD {
 
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
	
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


			//Login
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp();
			
			//driver.findElement(By.xpath("//select[@id=\"qccombo\"]/descendant::option[@value=\"Contacts\"]")).click();
			List<WebElement> alleles = driver.findElements(By.xpath("//select[@id=\"qccombo\"]/option"));
			System.out.println(alleles.size());
			
			for(int i=0;i<alleles.size();i++)
			{
				WebElement oneele = alleles.get(i);
				String text = oneele.getText();
				if(text.equalsIgnoreCase("New Contact"))
				{                                                                 
					oneele.click();
				}
			}
		
}
}
