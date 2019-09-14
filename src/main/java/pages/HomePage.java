package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public DashBoard m1() {
		System.out.print("Umesh");
		return PageFactory.initElements(driver, DashBoard.class);
	}

}
