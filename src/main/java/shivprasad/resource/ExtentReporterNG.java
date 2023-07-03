package shivprasad.resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	
	public static ExtentReports getReportObject()
	{
	String path= System.getProperty("user.dir")+"\\reports\\result.html";
	ExtentSparkReporter reporter =new ExtentSparkReporter(path);
	reporter.config().setReportName("Automation Result");
	reporter.config().setDocumentTitle("Testing Result");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("TesterName", "Shivprasad Deshmukh");
	return extent;
	}
}
