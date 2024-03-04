package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;

	public ConfigDataProvider() throws Exception  {
		
		File src = new File(System.getProperty("user.dir")+"\\ConfigData\\config.properties");
		FileInputStream file = new FileInputStream(src);
		
		pro = new Properties();
		pro.load(file);
	}
	
	public String getBrowser() {
	  return pro.getProperty("Browser");
	}
	
	public String getUrl() {
		return pro.getProperty("Url");
	}
}
