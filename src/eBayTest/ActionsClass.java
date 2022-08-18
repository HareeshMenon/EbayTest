package eBayTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\HP\\Programs\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		//Cookies
		Thread.sleep(3000);
		driver.findElement(By.id("gdpr-banner-accept")).click();
		
		Actions act = new Actions(driver);
		WebElement bellIcon = driver.findElement(By.id("gh-Alerts-i"));
		WebElement cartIcon = driver.findElement(By.cssSelector("a[aria-label='Your shopping cart']"));
		
		// Notifications 
		act.moveToElement(bellIcon).build().perform();
		
		Thread.sleep(1500);
		//Shopping Cart
		act.moveToElement(cartIcon).build().perform();
		Thread.sleep(1500);
		System.out.println(driver.findElement(By.cssSelector(".gh-minicart-header__title")).getText());
		
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("headphones",Keys.ENTER);
		
		//check box for color
		//driver.findElement(By.xpath("//h3[normalize-space()='Color']")).click();
		Thread.sleep(1500);
		System.out.println(driver.findElement(By.cssSelector("input[aria-label='Red']")).isSelected());
		driver.findElement(By.cssSelector("input[aria-label='Red']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[aria-label='Red']")).isSelected());

		//No of Items in Results
		int results = driver.findElements(By.cssSelector(".s-item__title")).size();
		System.out.println("No.of results are "+results);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\HP\\SearchResults.png"));
		
		
		//Select all options with noise canceling options
		List<WebElement> listResults = driver.findElements(By.cssSelector(".s-item__title"));
		for(WebElement first:listResults)
		{
			if(first.getText().contains("Noise Canceling"))
			{
				first.click();
			}
		}
	
		Thread.sleep(1500);

	
	}
}
