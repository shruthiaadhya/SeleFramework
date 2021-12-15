package com.Vtiger.GenericUtil;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	WebDriver driver;
	public WebDriverUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * @author Admin
	 * Description:maximising window
	 * 
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * @author Admin
	 * Description:implicitly wait time
	 * 
	 */
	public void pageLoadTimeout()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	/**
	 * @author Admin
	 * Description: Selecting value from dropdowns using value or index or text
	 * 
	 * @param element
	 * @param value
	 */
	public void selectValueFromDD(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void selectValueFromDD(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectValueFromDD( String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	/**
	 * @author Admin
	 * Description:Mouse over actions using movetoelement or movebyoffset
	 * 
	 * @param element
	 */
	public void moveToElement(WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	public void clickByOffset(int xoffset, int yoffset)
	{
		Actions a=new Actions(driver);
		a.moveByOffset(xoffset, yoffset);
	}
	
	public void rightClick(WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element);
	}
	
	/**
	 * @author Admin
	 * Description:scrolling down methods
	 * 
	 * @param element
	 */
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	
	public void scrollbyPosition(int X, int Y)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+X+","+Y+")");
	}
	
	/**
	 * @author Admin
	 * Description:Handling popups by alert 
	 * 
	 */
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
    
	public void sendkeysAlert(String keys)
	{
		driver.switchTo().alert().sendKeys(keys);
	}
	
	public void gettextAlert()
	{
		driver.switchTo().alert().getText();
	}
	
	/**
	 * @author Admin
	 * Description:handling frame by index or text or webelement
	 * 
	 * @param index
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame( String text)
	{
		driver.switchTo().frame(text);
	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * @author Admin
	 * Description:handling multiple windows
	 * 
	 * @param expectedtitle
	 */
	public void switchToWindow(String expectedtitle)
	{
		Set<String> winids = driver.getWindowHandles();
		for(String id:winids)
		{
			String actualtitle = driver.switchTo().window(id).getTitle();
			System.out.println(actualtitle);
			if(actualtitle.contains(expectedtitle))
			{
				break;
			}
		}
	}
	
	
	
	
	
}
