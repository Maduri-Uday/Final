package tests;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	public static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Test.class.getName());

	@BeforeTest
	public void open() throws IOException
	{
		driver=init();
		ArrayList<String> d=data("Amazon","Products","URL");
		driver.get(d.get(1));
		log.info("Opened the URL");

	}
	
	@Test
	public void validateLoginTest() throws InterruptedException, IOException
	{
		
		
		LandingPage ln=new LandingPage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(ln.hello()).build().perform();
		log.info("Howereing the mouse to Signin");
		Thread.sleep(2000);
		ln.signIn().click();
		log.info("clicked on Signin");
		Thread.sleep(2000);
		ArrayList<String>data=	data("Amazon","Products","Credintials");
		LoginPage lp=new LoginPage(driver);
		lp.emailBox().sendKeys(data.get(1));
		log.info("entered Username");
		Thread.sleep(2000);
		lp.continueButton().click();
		Thread.sleep(2000);
		lp.passwordBox().sendKeys(data.get(2));
		log.info("entered password");
		Thread.sleep(2000);
		lp.signIn().click();
		Assert.assertEquals(driver.getTitle(),"abc");
	}
	
	@AfterTest
	public void close() {
		driver.close();
		log.info("Closing the browser");
	}
}
