package com.credible.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.credible.pageFactory.StudentLoanEducationPageFactory;
import com.credible.pageFactory.StudentLoanFinancialPageFactory;
import com.credible.pageFactory.StudentLoanProfilePageFactory;
import com.credible.utility.Configuration;
import com.credible.utility.Driver;
import com.credible.utility.Methods;
import com.relevantcodes.extentreports.ExtentTest;



public class TestBase { 
	
	protected static WebDriver driver;
	protected static Logger log;
	static String url;
	static StudentLoanEducationPageFactory studentLoanPage = new StudentLoanEducationPageFactory(); 
	static StudentLoanFinancialPageFactory studentLoanPageFinancial = new StudentLoanFinancialPageFactory();  
	static StudentLoanProfilePageFactory studentLoanPageProfile = new StudentLoanProfilePageFactory();    
	
	@BeforeTest
	public static void BeforeTest() { 
		log = (Logger) LogManager.getLogger(); 
		url = Configuration.getPropertyClient("urlMainPage"); 
		Methods.startExtentReports(); 		
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
		driver.get(url);
	}
	@BeforeMethod
	public static void BeforeTestMethod() {
		
		switchToFrame("webklipper-publisher-widget-container-survey-frame"); 
		              
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}  		
	}
	
	@AfterMethod
	public static void AfterTestMethod() {  

	}
	
	@AfterTest
	public static void AfterTest() {		
		Methods.endAndCreateReport();
	}
	
	public static void switchToFrame(String frame) {
		try {
			driver.switchTo().frame(frame);			
			Boolean isPresent = driver.findElements(By.xpath("(//div[@class='wrapper']/div/div)[1]")).size() > 0;
			if(isPresent) 
			{ 
				System.out.println("found element, try close");  
				WebElement close = driver.findElement(By.xpath("(//div[@class='wrapper']/div/div)[1]"));
				Methods.clickByRobot(close, false, true); 
				driver.switchTo().defaultContent();				
			}
			else {
				System.out.println("not found element"); 
			} 
		} catch (NoSuchFrameException e) {
			System.out.println("frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("frame with id " + frame
					+ e.getStackTrace());
		}
	}
}
