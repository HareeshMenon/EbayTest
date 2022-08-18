package eBayTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\HP\\Programs\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		//Cookies
		Thread.sleep(3000);
		driver.findElement(By.id("gdpr-banner-accept")).click();
		
		//Session cookie deletion and logout of secure login
		driver.manage().deleteAllCookies();
		
		driver.close();

	}

}
