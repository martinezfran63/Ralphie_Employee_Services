package Suites.PM_SYS_Test_Suite.SYS_Portal;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import Custom.PrintScreen;


public class SYS_SSO_FIN {
	 WebDriver wd;
    
	 // Configure for multi-browser drivers
	 //value passed into @parameters states the browser being used for testing
	 @Parameters("browser")
	 @BeforeMethod
	 public void beforeTest(String browser) {
		      //to switch betweent the various browsers to test in based on "browser" value passed from xml doc
	           if (browser.equalsIgnoreCase("firefox")) {
	        	      //creates an instance of the firefox driver to do testing on the browser
	                  wd = new FirefoxDriver();
	           } else if (browser.equalsIgnoreCase("chrome")) {
	                  // Set Path to find the browser driver
	                  System.setProperty("webdriver.chrome.driver",
	                		  "C:/Selenium/chrome/chromedriver.exe");
	                 //creates an instance of the chrome driver to do testing on the browser
	                  wd = new ChromeDriver();
	           } else if (browser.equalsIgnoreCase("Internet Explorer")) {
		        	// Set Path to find the browser driver
	                  System.setProperty("webdriver.ie.driver", "C:/Selenium/IE/IEDriverServer.exe");
	                //creates an instance of the ie driver to do testing on the browser
	                  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	                  caps.setCapability("ignoreZoomSetting", true);
	                  caps.setCapability("nativeEvents",false);
		               // this line of code is to resolve protected mode issue 
	                  caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	                  caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

	                  wd = new InternetExplorerDriver(caps);
	           } else {
	                  throw new IllegalArgumentException("The Browser Type is Undefined");
	           }
	           
	           
	    }
    
    @Test
    //value passed into @paramters states the url, username, userpassword, & the browser being used for testing
    @Parameters({ "portal_sys", "suid_1", "spwd_1", "browser", "environment" })
    public void SYS_SSO_FIN(String portal_sys, String suid_1, String spwd_1, String browser, String environment) throws IOException {
    	String fail = "\nTest Failed";
    	String script = "SYS_SSO_FIN";
    	System.out.println("\nTest Name: SYS_SSO_FIN\n" + "Broswer: " + browser +"\n"+ "Enviroment: " + 
    	 environment + "\nURL: " + portal_sys + "\nUsername: " + suid_1 + "\nPasword: " + spwd_1);
    	 wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    	 
    	 
    	 // Launch URL
         try
         {
        	 System.out.println("1/7 Launch URL");
        	 wd.manage().window().maximize();
        	 wd.get(portal_sys);
         }
         catch (Throwable e)
         {
        	 System.out.println("Unable to launch URL"+ fail);
        	 PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
        	 org.testng.Assert.fail("Unable to launch url");
         }
        
    	
	 	 // Enter UserID and Password
         try
         {
        	 System.out.println("2/7 Enter UserID and Password");
        	 wd.findElement(By.id("userid")).click();
        	 wd.findElement(By.id("userid")).clear();
        	 wd.findElement(By.id("userid")).sendKeys(suid_1);
        	 wd.findElement(By.id("pwd")).click();
        	 wd.findElement(By.id("pwd")).clear();
        	 wd.findElement(By.id("pwd")).sendKeys(spwd_1);
         }
         	catch (Throwable e)
 			{
         		System.out.println("Unable to Enter UserID and Password"+ fail);
         		PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
         		org.testng.Assert.fail("Unable to Enter UserID and Password");
 			}
        
         
         // Click Submit
         try
         {
        	 System.out.println("3/7 Click Submit");
        	 wd.findElement(By.name("Submit")).click();
         }
         	catch (Throwable e)
 			{
         		System.out.println("Unable to click Submit"+ fail);
         		PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
         		org.testng.Assert.fail("Unable to click Submit");
 			}

         
        
         
         //Click Business Applications
         try
         {
        	 System.out.println("5/7 Click Business Applications");
        	 try { Thread.sleep(14000l); } catch (Exception e) { throw new RuntimeException(e); }
        	 wd.findElement(By.linkText("Business Applications")).click();
     	}
     		catch (Throwable e)
     		{
     			System.out.println("Unable to click Business Applications"+ fail);
     			PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
     			org.testng.Assert.fail("Unable to click Business Applications");
     		}
        
         //Click Finance Link
         try
         {
        	 System.out.println("6/7 Click Finance Link");
        	 try { Thread.sleep(10000l); } catch (Exception e) { throw new RuntimeException(e); }
        	 wd.findElement(By.linkText("Finance")).click();
         }
         	catch (Throwable e)
         	{
         		System.out.println("Unable to click Finace Link"+ fail);
         		PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
         		org.testng.Assert.fail("Unable to click Finance Link");
         	}
        
        
        
        try { Thread.sleep(5000l); } catch (Exception e) { throw new RuntimeException(e); }
        //code to switch to popup window
        String subWindowHandler = null;
        Set<String> handles = wd.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while ( iterator.hasNext()){
        subWindowHandler = iterator. next();
        }
        wd.switchTo().window( subWindowHandler); // switch to popup window
        
        
        // Verify Text Present
        try
        {
        	String TexttoVerify= "Finance System";
        	System.out.println("7/7 Verify text '"+ TexttoVerify + "' is present");
        	try { Thread.sleep(6000l); } catch (Exception e) { throw new RuntimeException(e); }
        	Assert.assertTrue(wd.findElement(By.tagName("html")).getText().contains(TexttoVerify));
        	System.out.println("The text is present");
        }
        	catch (Throwable e)
        	{
        		System.out.println("The text is not present" + fail);
        		PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
        		org.testng.Assert.fail("The text is not present");
        	}

        
        try { Thread.sleep(2000l); } catch (Exception e) { throw new RuntimeException(e); }
        System.out.println(script + ": Test Passed");

    }
    
    //following code will close the browser
    @AfterMethod
    public void afterTest() {
           try {
 
                  wd.quit();
           } catch (Exception e) {
                  wd = null;
           }
    }
    
}

