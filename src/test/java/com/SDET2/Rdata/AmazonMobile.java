package com.SDET2.Rdata;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Vtiger.GenericUtil.FileUtil;
import com.Vtiger.GenericUtil.WebDriverUtil;

public class AmazonMobile {
	
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
					
					//amazon url
					driver.get("https://www.amazon.in/");
					
					//maximize and wait 
					WebDriverUtil util=new WebDriverUtil(driver);
					util.windowMaximize(driver);
					util.pageLoadTimeout();

					//search box
					WebElement eleadd = driver.findElement(By.id("twotabsearchtextbox"));
					eleadd.sendKeys("Mobiles under 15000");
					eleadd.sendKeys(Keys.ENTER);
					
					//first checkbox
					Thread.sleep(2000);
					driver.findElement(By.xpath("//ul[@aria-labelledby=\"p_89-title\"]/descendant::span[text()=\"Redmi\"]")).click();
					
					//first mobile price
					Thread.sleep(2000);
					String price = driver.findElement(By.xpath("//span[@cel_widget_id=\"MAIN-SEARCH_RESULTS-0\"]//span[@class=\"a-price-whole\"]")).getText();
					String[] str=price.split(",");
					String s=str[0]+str[1];
					int a=Integer.parseInt(s);
					System.out.println(a);
					if(s.equals("15000"))
					{
					   System.out.println("Less than 15000");
					}
					else
					{
						System.out.println("not less than 15000");
					}
					
					//close browser
					driver.close();

	}

}
