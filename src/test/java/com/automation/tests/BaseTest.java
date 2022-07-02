package com.automation.tests;

import java.time.Duration;

import org.openqa.selenium.OutputType;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private static ExtentReports reports;
	public static ExtentTest test;
	private ExtentSparkReporter reporter;
	
	public WebDriver driver;
	private String browserName;
	private String url;

	public WebDriver openApplication(){

		switch (browserName){
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;	
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
	}


	@BeforeSuite(alwaysRun = true)
	public void reportSetUp(){
		reports = new ExtentReports();
		reporter = new ExtentSparkReporter("extentReports/report.html");
		reports.attachReporter(reporter);
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void reportsFlush(){
		reports.flush();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUpTestReport(ITestResult result){
		driver = openApplication();	
		test = reports.createTest(result.getMethod().getMethodName());
	}
	
	@Parameters({"URL","BROWSERNAME"})
	@BeforeTest(alwaysRun = true)
	public void setUpEnv(String url, String browserName){
		this.url=url;
		this.browserName=browserName;
	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication(ITestResult result){
		
		if(result.isSuccess()){
			test.pass("Test Passed");
		}else{
			TakesScreenshot tss = (TakesScreenshot) driver;
			//File screenshotPath = tss.getScreenshotAs(OutputType.FILE);
			String screenShotInBase64 = tss.getScreenshotAs(OutputType.BASE64);
			test.fail("Test failed due to : "+ result.getThrowable().getMessage() , MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotInBase64).build());
		}
		driver.close();
	}

}
