package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClasses.CreateDriver;

public class LoginPage {
	
	
	/*
	 * private WebElement unTextBox; private WebElement pwTextBox; private
	 * WebElement loginButton; 
	 
	 * public LoginPage(WebDriver driver) 
	 * {
	 * unTextBox=driver.findElement(By.id("username"));
	 * pwTextBox=driver.findElement(By.name("pwd"));
	 * loginButton=driver.findElement(By.id("loginButton")); 
	 * } 
	 
	 * public void
	 * login(String un, String pw) 
	 * { unTextBox.sendKeys(un); pwTextBox.sendKeys(pw);
	 * loginButton.click(); 
	 * }
	 */
	
	@FindBy(tagName = "mylist") 
	private List<WebElement> links;
	
	@FindBy(id="log")
	private WebElement unTextBox;
	@CacheLookup
	
	@FindBy(id="pwd")
	private WebElement pwTextBox;
	
	@FindBy(xpath="//input[@id='login']")
	private WebElement loginbtn;
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public HomePage login(String UN, String PW) {
		
		unTextBox.sendKeys("");
		pwTextBox.sendKeys("");
		loginbtn.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	

}
