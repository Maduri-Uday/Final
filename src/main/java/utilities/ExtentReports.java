package utilities;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {
	
	static com.aventstack.extentreports.ExtentReports report;
	
	public static com.aventstack.extentreports.ExtentReports extentReport()
	{
		String reportPath=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("Amazon");
		report = new com.aventstack.extentreports.ExtentReports();
		report.attachReporter(reporter);
		
		return report;
	}

}
