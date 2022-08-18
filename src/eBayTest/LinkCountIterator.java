package eBayTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCountIterator 
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\HP\\Programs\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Cookies
		Thread.sleep(15000);
		driver.findElement(By.id("gdpr-banner-accept")).click();

		//1. Count the no.of links present in the page - find the tag 'a'
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println("No:of Links present: "+count);
		
		//2. No.of links present on footer - limiting webdriver scope
		WebElement footerDriver = driver.findElement(By.id("glbfooter"));
		int footerLinks = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Footer Links: "+footerLinks);
		
		//3. Categories
		WebElement categoriesBar = driver.findElement(By.cssSelector(".hl-cat-nav__container"));
		int itemsRow = categoriesBar.findElements(By.tagName("a")).size();
		System.out.println("Number of categories present: "+itemsRow);
		
		//4. No.of links present on 1st footer column
		WebElement columnFooter = driver.findElement(By.xpath("//body[1]/div[7]/footer[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/ul[1]"));
		int footerFirstLinks = columnFooter.findElements(By.tagName("a")).size();
		System.out.println("Footer Links: "+footerFirstLinks);
		
		//5. Click on each link in the column and check if the links are opening - dynamic selection
		for(int i=0;i<footerFirstLinks;i++)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnFooter.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
		}
				
		Set<String> items = driver.getWindowHandles();
		Iterator<String> it = items.iterator();
				
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
