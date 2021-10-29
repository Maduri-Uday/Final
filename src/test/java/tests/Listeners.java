package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.Base;

public class Listeners extends Base implements ITestListener {
	ExtentReports rep=utilities.ExtentReports.extentReport();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> local= new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
	test=rep.createTest(result.getMethod().getMethodName());
	local.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		local.get().log(Status.PASS,"Passed");
	}

	public void onTestFailure(ITestResult result) {
		local.get().fail("Test Failed");
		local.get().fail(result.getThrowable());
		WebDriver driver = null;
		String failedMethodName=result.getMethod().getMethodName();
		try {
			driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			
			local.get().addScreenCaptureFromPath(screenShot(failedMethodName, driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		rep.flush();

	}

}
