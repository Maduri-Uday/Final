package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By emailBox=By.name("email");
	By continueButton=By.id("continue");
	By passwordBox=By.id("ap_password");
	By signIn=By.id("signInSubmit");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement emailBox()
	{
		return driver.findElement(emailBox);
	}
	
	public WebElement continueButton()
	{
		return driver.findElement(continueButton);
	}
	
	public WebElement passwordBox()
	{
		return driver.findElement(passwordBox);
	}
	
	public WebElement signIn()
	{
		return driver.findElement(signIn);
	}


}
