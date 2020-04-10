package com.credible.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
 

import io.github.bonigarcia.wdm.WebDriverManager; 

public class Driver {
private static WebDriver driver;
	
	
	public static WebDriver getDriver() { 
		if (driver == null) { 
			switch (Configuration.getPropertyClient("browser")) {
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
			case "ie":
				if(System.getProperty("os.name").toLowerCase().contains("mac")) {
					throw new WebDriverException("InternetExplorer is not supported in your MAC OS");
				}
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "safari":
				if(System.getProperty("os.name").toLowerCase().contains("windows")) {
					throw new WebDriverException("Safari is not supported in your Windows");
				}
				break;	
			}
		}
		
		return driver;	
	}
	
	public static void closeDriver() {
		if(driver != null) {
			
			driver.quit();
			driver = null;
		}
	}
}
