package tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

public class JDBCTest extends Base{
	
	public WebDriver driver;
	public static Logger log= org.apache.logging.log4j.LogManager.getLogger(JDBCTest.class.getName());
	
	@BeforeTest
	public void opening() throws IOException, SQLException
	{
		driver=init();
		driver.get(jdbc().getString("url"));
		log.info("open url with jdbc");
		
	}

	@Test
	public void open() throws SQLException, InterruptedException
	{
		LandingPage ln= new LandingPage(driver);
		ln.signIn().click();
		Thread.sleep(2000);
		LoginPage lp= new LoginPage(driver);
		lp.emailBox().sendKeys(jdbc().getString("username"));
		log.info("inserted username using JDBC");
		Thread.sleep(2000);
		lp.continueButton().click();
		Thread.sleep(2000);
		lp.passwordBox().sendKeys(jdbc().getString("password"));
		log.info("inserted password using JDBC");
		Thread.sleep(2000);
		lp.signIn().click();
		Thread.sleep(2000);
				
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
