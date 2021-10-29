package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base extends ExcelData {

	public	WebDriver driver;
	

	public WebDriver init() throws IOException
	{
		
		String browserPath=System.getProperty("user.dir")+"//src//main//java//resources//chromedriver.exe";
	//	ExcelData ed= new ExcelData();
		ArrayList<String> list=	data("Amazon","Products","Browser");
		
		if (list.get(1).equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", browserPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public String screenShot(String failedMethodName,WebDriver driver) throws IOException
	{
		String screenShotPath= System.getProperty("user.dir")+"//reports//"+failedMethodName+".jpg";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File fs=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs,new File(screenShotPath));
		return screenShotPath;
		
	}
}
