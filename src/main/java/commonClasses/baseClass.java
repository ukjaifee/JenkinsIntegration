package commonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class baseClass {

	
	
	public static  WebDriver driver=null;
	

	
	// @BeforeMethod 
     @Parameters({"browser"}) 
	public static WebDriver Open_Browser(@Optional("FireFox")String browser){
		  
	       if(browser.equalsIgnoreCase("Firefox")){
	       driver=new FirefoxDriver();
	       }
	       else if(browser.equalsIgnoreCase("Chrome"))
	       {
	    	   DesiredCapabilities cap=DesiredCapabilities.chrome();
	           cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	           System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	    	   driver=new ChromeDriver(cap);
	       }
	       else if(browser.equalsIgnoreCase("IE")){
	          System.setProperty("webdriver.ie.driver", "");
	    	  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	    	  caps.setCapability("ignoreZoomSetting", true);
	    	  caps.setCapability("nativeEvents",false);
	    	  driver = new InternetExplorerDriver(caps);
	    	 
	    	   }
	     driver.get("https://www.google.com/");  
	     driver.manage().window().maximize();
	     return driver;
 }
	
}
