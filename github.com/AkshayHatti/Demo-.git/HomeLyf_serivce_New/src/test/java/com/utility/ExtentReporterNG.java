package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	public static ExtentReports extent;
	public  static ExtentReports getExtentReport() {
		
		String path = "E:\\Desktop\\HomeLyf_Service\\HomeLyf_serivce_New\\TestReports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("TestExecution Report");
		reporter.config().setReportName("Automation Report");
		reporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("System","DELL");
		extent.setSystemInfo("QA","Satyashri");
		extent.setSystemInfo("Environment","Stage");
		extent.setSystemInfo("Browser","Chrome");
		extent.setSystemInfo("OS","Windows10");
		return extent;
	}

}
