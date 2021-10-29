package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	By hello=By.xpath("//a[@data-nav-ref='nav_ya_signin']");
	By signIn=By.linkText("Sign in");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement hello()
	{
		return driver.findElement(hello);
	}
	
	public WebElement signIn()
	{
		return driver.findElement(signIn);
	}
}
