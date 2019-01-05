package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport
{
	static	ExtentHtmlReporter report=new ExtentHtmlReporter("./reports/report.html");
	static	ExtentReports exten=new ExtentReports();
	static	ExtentTest test;
	
	@Test
	public void extentPass()
	{
//		ExtentHtmlReporter report=new ExtentHtmlReporter("./reports/report.html");
//		ExtentReports exten=new ExtentReports();
		exten.attachReporter(report);
		test=exten.createTest("extentPass");
		test.log(Status.INFO,"extent report is working fine");
		test.log(Status.PASS,"test is passed");
		exten.flush();
	}
	
	@Test
	public void extentFail()
	{
//		ExtentHtmlReporter report=new ExtentHtmlReporter("./reports/report2.html");
//		ExtentReports exten=new ExtentReports();
		exten.attachReporter(report);
		test=exten.createTest("extentFail");
//		Assert.fail();
		test.log(Status.INFO,"extent report is working fine");
		test.log(Status.FAIL,"test is failed");
		exten.flush();
	}
	
	@Test(enabled=true)
	//@Ignore
	public void extentSkip()
	{
		exten.attachReporter(report);
		test=exten.createTest("extentSkip");
		test.log(Status.INFO,"extent report is working fine");
		test.log(Status.SKIP,"test is skipped");
		exten.flush();
	}
	
	@Test
	public void extentWarning()
	{
		exten.attachReporter(report);
		test=exten.createTest("extentWarning");
		test.log(Status.INFO,"extent report is working fine");
		test.log(Status.WARNING,"test is warned");
		exten.flush();
	}
}
