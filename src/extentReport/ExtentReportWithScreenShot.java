package extentReport;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentReportWithScreenShot
{
	public WebDriver driver;
	public ExtentHtmlReporter htmlextent=null;
	public ExtentReports report=null;
	public ExtentTest log=null;

	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		htmlextent=new ExtentHtmlReporter("./reports/extentreport.html");
		report=new ExtentReports();
	}
	@BeforeMethod
	public void beforemethod()
	{
		report.attachReporter(htmlextent);
	}

	@Test
	public void testcase2()
	{
		log=report.createTest("testcase2");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		try
		{
			log.log(Status.INFO, "Google Page opened"+log.addScreenCaptureFromPath(captureScreen()));
			log.log(Status.PASS, "Passed test 2"+log.addScreenCaptureFromPath(captureScreen()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterTest
	public void aftertest()
	{
		driver.quit();
		report.flush();
	}
	
	public String captureScreen() throws IOException
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		//String dest="C:/Users/Family/eclipse-workspace/ExtentReport/screenshots/"+"google.png";
		String dest="C:/Users/Family/eclipse-workspace/ExtentReport/screenshots/"+getcurrentdateandtime()+".png";
		File target=new File(dest);
		FileUtils.copyFile(src,target);
		return dest;
	}

	public String getcurrentdateandtime()
	{
		String str=null;
		try
		{
			DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date=new Date();
			str=dateFormat.format(date);
			str=str.replace(" ","").replaceAll("/","").replaceAll(":","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}
}
