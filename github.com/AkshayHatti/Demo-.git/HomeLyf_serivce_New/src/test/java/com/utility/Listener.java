package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Listeners(com.utility.Listener.class)


public class Listener implements ITestListener{

	private ExtentSparkReporter htmlReporter;
	private ExtentReports reports;
	private ExtentTest test;

	public void ConfigReport()
	{
		htmlReporter=new ExtentSparkReporter("Extent Listener Report.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add system information/environment info to reports
		reports.setSystemInfo("Machine", "TestPC");
		reports.setSystemInfo("Operating system", "Windows 11");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Host", "QA");

		//Configuration to change the look and fill
		htmlReporter.config().setDocumentTitle("Extent listener report");
		htmlReporter.config().setReportName("HomeLyf service App report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("This is a test scenario: onTestStart"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("This is a test scenario: onTestSuccess"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of passed test case: "+result.getName(), ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("This is a test scenario: onTestFailure"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case: "+result.getName(), ExtentColor.RED));

		// To take a screenshot
		String methodName = result.getName();
		String screenshotName = "screenshot_" + methodName + ".png";

		System.out.println("Taking a screenshot for: " + methodName);

		String src = BaseClass.ts.getScreenshotAs(OutputType.BASE64);
		//File target = new File(".\\Screenshot\\" + screenshotName);
		test.addScreenCaptureFromBase64String(src);
		
//		try {
//			FileUtils.copyToFile(src, target);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("This is a test scenario: onTestSkipped"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of skipped test case: "+result.getName(), ExtentColor.YELLOW));

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("This is a test scenario: onTestFailedButWithinSuccessPercentage"+result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		System.out.println("This is a test scenario: onTestFailedWithTimeout"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ConfigReport();
		System.out.println("This is a test scenario: onStart"+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("This is a test scenario: onFinish"+context.getName());
		reports.flush();
	}

}

