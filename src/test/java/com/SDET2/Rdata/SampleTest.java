package com.SDET2.Rdata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void cmdLineParameter()
	{
	    WebDriver driver = null;
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		System.out.println(browser);
		System.out.println(url);
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get(url);
	}

}
