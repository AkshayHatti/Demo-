package com.utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
public AppiumDriverLocalService service;

//public static ConfigDataProvider config;

	public  static AndroidDriver driver;
	public static TakesScreenshot ts;
	
	@BeforeClass
	
	public void setup () throws MalformedURLException {
		
		service = new AppiumServiceBuilder ().withAppiumJS(new File("C:\\Users\\AKSHAY\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
			
			service.start();
		
				
     		UiAutomator2Options options = new UiAutomator2Options ();
			
			options.setDeviceName("Pixel");
			
			options.setApp("E:\\software testing and automation\\latest eclipse\\Homelyf_services_1.0\\src\\test\\resources\\apk'\\app-release.apk");
			
		     driver= new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		
		     String sessionId =driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     
		     
		DesiredCapabilities desiredCap =new DesiredCapabilities();
		
		desiredCap.setCapability("platformName", "Android");
		
		//desiredCap.setCapability("platformVersion", "(9.0");
		
		desiredCap.setCapability("deviceName", "any device name");
		desiredCap.setCapability("automationName", "UiAutomator2");
		
		//desiredCap.setCapability("appActivity", "");
		
		desiredCap.setCapability("avd", "Pixel");
		desiredCap.setCapability("app", "/Users");
	}
		@BeforeMethod
		public void takeScreenshot()
		{
			System.out.println("Starting the screenshot method!");
			ts= (TakesScreenshot) driver;
		}
		
	
	}
	
	

