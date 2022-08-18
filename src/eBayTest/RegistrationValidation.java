package eBayTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegistrationValidation 
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\HP\\Programs\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Cookies
		Thread.sleep(3000);
		driver.findElement(By.id("gdpr-banner-accept")).click();
		
		//Registration
		driver.findElement(By.linkText("register")).click();
		
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Hareesh");
		WebElement lastName = driver.findElement(By.id("lastname"));
		WebElement mailField = driver.findElement(By.cssSelector("#Email"));
		WebElement passField = driver.findElement(By.cssSelector("#password"));
		WebElement submitBtn = driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT"));

		
		mailField.sendKeys("testmail.com");
		passField.sendKeys("Testuser01");
		
		String errorMessage = driver.findElement(By.xpath("//span[@id='Email_err']")).getText();
		
		System.out.println("Error message is "+errorMessage);
		
		Thread.sleep(1500);
		mailField.clear();
		mailField.sendKeys("testmail@mail.com");
		passField.clear();
		passField.sendKeys("Testuser101");
		
		try
		{
			Assert.assertEquals(true, submitBtn.isEnabled());
		}
		catch(AssertionError e)
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("D:\\HP\\ButtonStatus1.png"));
		}
		System.out.println("Submit button is enabled: "+submitBtn.isEnabled());
		
		Thread.sleep(1500);
		lastName.sendKeys("Menon");
		
		try
		{
			Assert.assertEquals(false, submitBtn.isEnabled());
		}
		catch(AssertionError e)
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("D:\\HP\\ButtonStatus2.png"));
		}
		System.out.println("Submit button is enabled: "+submitBtn.isEnabled());

	}

}
