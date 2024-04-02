package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestSetup {
	 public static WebDriver driver;
	 public static JavascriptExecutor js;
	 public static TakesScreenshot ts;
	 public static Properties ps;
	 public  static ExtentSparkReporter htmlreporter;
	 public static ExtentReports extent;
	 public  static ExtentTest test;
	 public static  ThreadLocal<WebDriver> threadLocalVariable = new ThreadLocal<>();
@BeforeSuite
public void open_suite() {
	Date d= new Date();
	String reportName="localRun"+(d.getDate() < 10 ? "0" + d.getDate() : d.getDate()) + " " + 
            (d.getMonth() + 1 < 10 ? "0" + (d.getMonth() + 1) : (d.getMonth() + 1)) + "_" + 
            (1900 + d.getYear()) + "_" + 
            (d.getHours() < 10 ? "0" + d.getHours() : d.getHours()) + "_" + 
            (d.getSeconds() < 10 ? "0" + d.getSeconds() : d.getSeconds());
	         String folderName=d.getYear()+"_"+d.getMonth()+" "+d.getDay();
	     File f= new File(System.getProperty("user.dir")+"/reports/"+folderName);  
	     f.mkdir();
        htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+folderName+"/"+reportName+".html");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setReportName("Automation test results");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
}
@BeforeMethod
public void open_browser(Method method) throws IOException {
	test=extent.createTest(method.getName());
	ExtentFactory.getInstance().setExtent(test);
	driver=open_browser(getProperties("browser"));
}
@AfterMethod
public void teardown(ITestResult results) {
	if(results.getStatus()==ITestResult.FAILURE) {
		String methodName=results.getMethod().getMethodName();
		String excepionMessage=Arrays.toString(results.getThrowable().getStackTrace());
		String logtext="<b> + Testcase-failed</b>"+results.getMethod()+"<details>message:"+results.getThrowable().getMessage()+"</details></b>";
		Markup m=MarkupHelper.createLabel(logtext, ExtentColor.RED);
		ExtentFactory.getInstance().getExtent().fail(m);
	}else if(results.getStatus()==ITestResult.SUCCESS) {
		String methodName=results.getMethod().getMethodName();
		String logtext="<b> + Testcase-Passed</b>";
		Markup m=MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		ExtentFactory.getInstance().getExtent().pass(m);                  
	}else if(results.getStatus()==ITestResult.SKIP) {
		String methodName=results.getMethod().getMethodName();
		String logtext="<b> + Testcase-skipped</b>";
		Markup m=MarkupHelper.createLabel(logtext, ExtentColor.GREY);
		ExtentFactory.getInstance().getExtent().skip(m);
	}
	if(DriverFactory.getInstance().getDriver()!=null) {
		DriverFactory.getInstance().closeBrowser();
	}
	extent.flush();
	
}
@AfterSuite
public void close_suite() {
	
}
public WebDriver open_browser(String browser) {
	switch(browser){
	case "chrome":
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
	driver=new ChromeDriver();
    DriverFactory.getInstance().setDriver(driver);
	break;
	case "firefox":
		System.setProperty("webdriver.firefox.driver","C://chromedriver.exe");
		driver = new FirefoxDriver();
		break;
	case "edge":
		System.setProperty("webdriver.edge.driver","C://chromedriver.exe");
		driver = new EdgeDriver();
		break;
	
	}
	return DriverFactory.getInstance().getDriver();
}

 public String getProperties(String key) throws IOException {
	  FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
	  ps= new Properties();
	  ps.load(fis);
	  String s=ps.getProperty(key);
	   return s;
	 
 }

}
