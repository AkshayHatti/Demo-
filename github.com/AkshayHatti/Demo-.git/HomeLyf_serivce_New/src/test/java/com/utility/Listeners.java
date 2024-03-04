package com.utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Listeners extends BaseClass implements ITestListener{
	
	ExtentReports extent = ExtentReporterNG.getExtentReport();
	
	ThreadLocal<ExtentTest>extenttest = new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		ObjectRepo.test = extent.createTest(result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
		extenttest.set(ObjectRepo.test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		ObjectRepo.test.log(Status.PASS, "TestCase Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		ObjectRepo.test.log(Status.FAIL, "TestCase Fail");
		String src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		ObjectRepo.test.addScreenCaptureFromBase64String(src);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ObjectRepo.test.log(Status.SKIP, "TestCase Skip");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

}
