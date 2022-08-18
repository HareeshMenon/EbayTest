package eBayTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchAndActions 
{

//	@SuppressWarnings("deprecation")
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
		
		//Search Bar
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		searchBox.sendKeys("painti");
		Thread.sleep(2500);	
		searchBox.sendKeys(Keys.DOWN, Keys.ENTER);
		
		WebElement staticDropDown = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select dropDown = new Select(staticDropDown);
		
		dropDown.selectByVisibleText("Antiques");
		driver.findElement(By.cssSelector("#gh-btn")).click();
		

	}

}
