package com.credible.utility;

import static org.testng.AssertJUnit.assertTrue;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.credible.testCases.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Methods extends TestBase implements ITestListener{
	public static ExtentReports report;
	public static ExtentTest test;
	public static String targetString;
	public static int diff = 0;		
	
	public static void getScreenshot(WebDriver driver,String testName) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("yyyyMMMddhhmmssa").format(new Date());
		targetString = System.getProperty("user.dir") + "\\Screenshots\\" + date + testName + ".png";
		File target = new File(targetString);
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void waitExplicit(int second) {	 	
		try {
			Thread.sleep(1000*second);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
	}
	
	public static void ExplicitWaitClickable(WebElement locator,int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void ExplicitWaitToBeSelected(By locator,int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),seconds);
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}	
	
	public static void startExtentReports() {
		String date = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ssa").format(new Date());
		String reportTarget = System.getProperty("user.dir") + "\\ExtentReportResult\\" + date + ".html";
		report = new ExtentReports(reportTarget);
	}

	public static void endAndCreateReport() {
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		super.log.info("Test is Starting");
		test = report.startTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		super.log.info("Test is Passed");
		report.endTest(test);
		test.log(LogStatus.PASS, "Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		getScreenshot(super.driver, result.getName());
		String testName = result.getName();
		super.log.info("Test is Failed," + "Test name is " + testName);
		report.endTest(test);
		test.log(LogStatus.FAIL, "Test failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		super.log.info("Test is Skipped");
		report.endTest(test);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	public static void verifyElementDisplayed(WebElement element) {
		try {
			Assert.assertTrue(element.isDisplayed());	
			} 
		catch (NoSuchElementException e) {
			System.out.println("Verification fail");
		}
	}
	
	public static void WaitForWebElement(WebElement element) {
		try {
			Assert.assertTrue(element.isDisplayed());	
			} 
		catch (NoSuchElementException e) {
			System.out.println("Verification fail");
		}
	}
	
	public static void verifyPageDisplayed(String url) {
		try {
			Assert.assertEquals(driver.getCurrentUrl(), url);
			} 
		catch (Exception e) {
			System.out.println("Page Display Fail");
		}
	}
	
	public static WebElement waitElement(int time, By locator) 
	{
		WebDriverWait wait = new WebDriverWait(driver,time); 
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void scrollToElement(WebElement element) {
		
		Point coordinates = element.getLocation();  		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		System.out.println("window.pageYOffset: " + value);  
		Methods.diff = value.intValue();  	 
	}
	
	public static int scrollToElementReturnDistance(WebElement element) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		Point coordinates = element.getLocation();		
		return coordinates.getY(); 
	}
	
	public static void clickByRobot(WebElement element, Boolean clickBeforeMove, Boolean clickAfterMove)
	{  
		Point coordinates = element.getLocation(); 
		Robot robot;
		try { 			
			
			robot = new Robot();
			if(clickBeforeMove)
				robotClick(robot);  		
				System.out.println("Methods.diff: " + Methods.diff); 
				robot.mouseMove(coordinates.getX() + 10,(coordinates.getY()+130) - Methods.diff);     	
			if(clickAfterMove)
				robotClick(robot);   			
		} catch (AWTException e) {
			e.printStackTrace();
		}  
		
	}
	
	public static void robotClick(Robot robot)
	{
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);   
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	
	public static void robotScroll(int distance)
	{
		java.awt.Point currentMousePosition = MouseInfo.getPointerInfo().getLocation();			
		Robot robot; 
		try {
			robot = new Robot();
			robot.mouseWheel(distance);   
			currentMousePosition = MouseInfo.getPointerInfo().getLocation();		
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int[] clickByRobotReturnPosition(By locator, int xGoTo , int yGoTO) 
	{
		 
		try {
			Point coordinates = driver.findElement(locator).getLocation(); 
			Robot robot;
			robot = new Robot();  
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			} 		
			int x = coordinates.getX() + xGoTo;
			int y = coordinates.getY() - yGoTO;  
			int[] ar = {x,y};
			return ar; 
		} catch (AWTException e) {			 
			e.printStackTrace();
		}  		
		return null;
		  
	}
	
	public static void moveCursorToPosition(int x, int y, int xGoTo, int yGoTo)
	{ 
		try { 			 
			Robot robot;			
			robot = new Robot();  			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}  
			robot.mouseMove(x + xGoTo,y + yGoTo);     			
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);   
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {			
			e.printStackTrace();
		} 
	}

	public static void MouseGoDownAndClick(int distanceX, int distanceY, Boolean click) {
		
		java.awt.Point curMousePos = MouseInfo.getPointerInfo().getLocation();
		Methods.moveCursorToPosition((int)curMousePos.getX(), (int)curMousePos.getY(), distanceX, distanceY);
		if(click)
		{
			Robot robot; 
			try {
				robot = new Robot();
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);   
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			} catch (AWTException e) {				
				e.printStackTrace();
			} 
		}
	}
}
