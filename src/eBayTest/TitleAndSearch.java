package eBayTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TitleAndSearch 
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\HP\\Programs\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Cookies
		Thread.sleep(3000);
		driver.findElement(By.id("gdpr-banner-accept")).click();
		
		// Title validation
		String title = driver.getTitle();
		String titleExpected = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		
		Assert.assertEquals(title, titleExpected);
		
		//Search Bar
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Gandhi Biography");
		driver.findElement(By.cssSelector("#gh-btn")).click();
		
		
		
		

	}

}
