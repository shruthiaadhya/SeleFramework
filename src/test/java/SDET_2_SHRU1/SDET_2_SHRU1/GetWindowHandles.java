package SDET_2_SHRU1.SDET_2_SHRU1;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandles {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		
		driver.manage().window().maximize();
		
		Set<String> whids = driver.getWindowHandles();
		String pwtitle = driver.getTitle();
		int wsize = driver.getWindowHandles().size();
		System.out.println(wsize);
		
		for(String wh:whids)
		{
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println(title);
			driver.quit();
		}
		
		for(String wh:whids)
		{
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase(pwtitle))
			{
				driver.close();
				
				//validating
				System.out.println("after closing");
				System.out.println(driver.getWindowHandles().size());
			}
			
		}
		
		for(String wh:whids)
		{
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println(title);
			if(!title.equalsIgnoreCase(pwtitle))
			{
				driver.close();
			}
		}
		
		for(String wh:whids)
		{
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase("Ellie MAE"))
			{
				driver.close();
			}
		}
		
		for(String wh:whids)
		{
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase("Cognizant"))
			{
				driver.close();
			}
		}
		
		for(String wh:whids)
		{
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase("Tech Mahindra"))
			{
				driver.close();
			}
		}
	}

}
