package Mmt_TrainDriverSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverTrain {
 public static WebDriver driver;
 public static ChromeOptions options;
 public static EdgeOptions option1;
 
 public static WebDriver chromeDriver() throws InterruptedException
  {
	 WebDriverManager.chromedriver().setup();
	 options=new ChromeOptions();
	 options.addArguments("--start-maximized");
	 options.addArguments("disable-notifications");
	 options.addArguments("disable-popup-blocking");
	 
	 driver=new ChromeDriver(options);
	 driver.get("https://www.makemytrip.com/");
	 Thread.sleep(3000);
	 
     try {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'notification-frame-')]")));
		WebElement close_popup = driver.findElement(By.cssSelector("a.close"));
		close_popup.click();
		driver.switchTo().defaultContent();
		} catch(Exception e) {
			e.printStackTrace();}
		return driver;
	
  }
 public static WebDriver edgeDriver() throws InterruptedException
  {
	 WebDriverManager.edgedriver().setup();
	 option1=new EdgeOptions();
	 option1.addArguments("--start-maximized");
	 option1.addArguments("disable-notifications");
	 option1.addArguments("disable-popup-blocking");
	 
	 driver=new EdgeDriver(option1);
	 driver.get("https://www.makemytrip.com/");
	 Thread.sleep(3000);
     try {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'notif')]")));
		WebElement close_popup = driver.findElement(By.cssSelector("a.close"));
		close_popup.click();
		driver.switchTo().defaultContent();
		} catch(Exception e) {
			e.printStackTrace();}
	 return driver;
  }
 
}
