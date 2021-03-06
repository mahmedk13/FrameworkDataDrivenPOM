package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase  {
	
	
	
	
	public static  WebDriver driver=null;

	
	
	public static void init() {
		
		
		
		if(Constants.BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Constants.BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}else {
			System.out.println("browser is not defined");
		}
		
		driver.get(Constants.URL);
		driver.manage().window().maximize();

		
	}
	
	
	public static void click(WebElement element, String elementName) {
		element.click();
		ExtentListeners.test.pass("Clicking on element "+elementName);
		
	}
	
	public static void type(WebElement element, String value, String elementName) {
		element.sendKeys(value);
		ExtentListeners.test.pass("Typing in field "+elementName);

		
	}
	
	
	public static void closeBrowser() {
		driver.quit();
	}
	
}
	
	