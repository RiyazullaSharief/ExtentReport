package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport1
{
	@Test
	public void extent()
	{
		ExtentHtmlReporter report=new ExtentHtmlReporter("./reports/pass.html");
		ExtentReports exten=new ExtentReports();
		exten.attachReporter(report);
		ExtentTest test=exten.createTest("extent");
		test.log(Status.INFO,"Extent report is working fine");
		test.log(Status.PASS,"Test is passed");
		exten.flush();
	}
	
	@Test
	public void devops()
	{
		ExtentHtmlReporter report=new ExtentHtmlReporter("./reports/fail.html");
		ExtentReports exten=new ExtentReports();
		exten.attachReporter(report);
		ExtentTest test=exten.createTest("devops");
		test.log(Status.INFO,"Extent report is working fine");
		test.log(Status.FAIL,"Test is failed");
		exten.flush();
	}
	
	@Test
	public void testing()
	{
		ExtentHtmlReporter report=new ExtentHtmlReporter("./reports/skip.html");
		ExtentReports exten=new ExtentReports();
		exten.attachReporter(report);
		ExtentTest test=exten.createTest("testing");
		test.log(Status.INFO,"Extent report is working fine");
		test.log(Status.SKIP,"Test is skipped");
		exten.flush();
	}
}
