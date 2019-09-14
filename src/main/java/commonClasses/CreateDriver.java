package commonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {
	
	private static WebDriver driver;
	
	public CreateDriver() {}

	public static WebDriver getDriver() {
		if(driver==null) {
			driver=new FirefoxDriver();
		}
		
		return driver;
	}
	
	public static WebDriver getDriver(String browserName) {
		if (driver == null) {
			driver = new FirefoxDriver();
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();

		}
		return driver;
	}
	
	
	

}
