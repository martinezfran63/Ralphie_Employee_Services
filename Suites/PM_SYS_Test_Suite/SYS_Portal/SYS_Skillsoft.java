package Suites.PM_SYS_Test_Suite.SYS_Portal;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import Custom.PrintScreen;


public class SYS_Skillsoft {
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
    public void SYS_Skillsoft(String portal_sys, String suid_1, String spwd_1, String browser, String environment) throws IOException {
    	String fail = "\nTest Failed"; 
    	String script = "SYS_Skillsoft";
    	System.out.println("\nTest Name: SYS_Skillsoft\n" + "Broswer: " + browser +"\n"+ "Enviroment: " + 
    	    	 environment + "\nURL: " + portal_sys + "\nUsername: " + suid_1 + "\nPasword: " + spwd_1);
    	 wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    	 
    	 
    	 // Launch URL
    	 try
         {
    		 System.out.println("1/6 Launch URL");
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
    		  System.out.println("2/6 Enter UserID and Password");
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
        	  System.out.println("3/6 Click Submit");
        	  wd.findElement(By.name("Submit")).click();
          }
          	catch (Throwable e)
  			{
          		System.out.println("Unable to click Submit"+ fail);
          		PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
          		org.testng.Assert.fail("Unable to click Submit");
  			}


          //Click Training
          try
          {
        	  System.out.println("4/6 Click Training");
        	  try { Thread.sleep(12000l); } catch (Exception e) { throw new RuntimeException(e); }
        	  wd.findElement(By.linkText("Training")).click();
          }
       		catch (Throwable e)
       		{
       			System.out.println("Unable to click Training"+ fail);
       			PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
       			org.testng.Assert.fail("Unable to click Training");
       		}
          
          
          //Click SkillSoft Resources
          try
          {
        	  System.out.println("5/6 Click SkillSoft Resources");
        	  try { Thread.sleep(10000l); } catch (Exception e) { throw new RuntimeException(e); }
        	  wd.findElement(By.linkText("SkillSoft Resources")).click();

          }
        	catch (Throwable e)
        	{
        		System.out.println("Unable to start Skillsoft"+ fail);
        		PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
        		org.testng.Assert.fail("Unable to click SkillSoft Resources");
        	}

         	
         //code to switch frames
      	 Actions action = new Actions(wd);
      	 //switch to the first frame
      	 wd.switchTo().frame(2);

          
       // Assert Text Present
       try
       {

      	 try { Thread.sleep(12000l); } catch (Exception e) { throw new RuntimeException(e); }
      	 String TexttoVerify= "Resources - SkillSoft";
      	 System.out.println("6/6 Verify text '"+ TexttoVerify + "' is present");
      	 Assert.assertTrue(wd.findElement(By.cssSelector(".page-title")).getText().contains(TexttoVerify));
      	 System.out.println("The text is present");
       }
       	catch (Throwable e)
       	{
       		System.out.println("The text is not present" + fail);
       		PrintScreen capture = new PrintScreen(wd,  browser, environment, script);
       		org.testng.Assert.fail("The text is not present");
       	}
           
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
