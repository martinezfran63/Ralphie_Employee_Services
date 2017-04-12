package Custom;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException; 
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;


public class PrintScreen {

	public PrintScreen()
	{
		
		
	   }
	
	
	
	
	
	public PrintScreen(WebDriver wd, String browser, String environment, String  script) throws IOException{
		
		// take the screenshot at the end of every test
		File scrFile2 = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	    // now save the screenshot to a file some place
		FileUtils. copyFile(scrFile2, new File("C:/Users/Francisco Martinez/Documents/Selenium_Webdriver_Screenshots/" + script + "_" + browser 
				+"_" + environment + ".png" ));
		
		
	   }


}