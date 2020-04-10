package com.credible.utility;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties; 

public class Configuration {
	
	private static Properties prop;
	
	public static String getPropertyClient(String property) {
		prop = new Properties();
		String address = System.getProperty("user.dir") + "\\properties\\credible.properties";
		try {
			FileInputStream fis = new FileInputStream(address);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(property); 
	}
}
