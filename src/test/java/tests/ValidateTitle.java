package tests;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Base;

public class ValidateTitle extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	public WebDriver driver;

	@BeforeTest
	public void open() throws IOException
	{
		driver=init();
		ArrayList<String> d=data("Amazon","Products","URL");
		driver.get(d.get(1));
		log.info("Opened the URL1");

	}
	
	@Test
	public void validateTitleTest()
	{
		
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		log.info("Validating the Title");

	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
