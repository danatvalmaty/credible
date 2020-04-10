package com.credible.pageFactory;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.credible.utility.Configuration;
import com.credible.utility.Driver;
import com.credible.utility.Methods;

public class StudentLoanProfilePageFactory {
	
	@FindBy(xpath = "((//fieldset[contains(@data-step,'profile')]/div)[1]//input)[3]")    
	private WebElement inputLastname;
	@FindBy(xpath = "((//fieldset[contains(@data-step,'profile')]/div)[1]//input)[1]")    
	private WebElement inputFirstname;
	@FindBy(xpath = "(//fieldset[contains(@data-step,'profile')]/div)[2]/div/div/span/input")      
	private WebElement inputDateOfBirth;
	@FindBy(xpath = "(//fieldset[contains(@data-step,'profile')]/div)[3]/div/div/span/input")      
	private WebElement inputPrimaryPhoneNumber;
	@FindBy(xpath = "((//fieldset[contains(@data-step,'profile')]/div)[4]//input)[1]")      
	private WebElement inputPermanentAddress;
	@FindBy(xpath = "(//div[@data-fields='email'])[2]/div//input")      
	private WebElement inputEmailAddress;
	@FindBy(xpath = "((//div[@data-fields='password'])[2]/div//input)[1]")       
	private WebElement inputPassword;
	
	public StudentLoanProfilePageFactory() { 
		PageFactory.initElements(Driver.getDriver(), this); 
		Methods.waitExplicit(2);
	}	
	public Boolean setFirstnameLastnameSuffix() {
		Boolean testPass = false; 
		Methods.clickByRobot(inputFirstname, false, true);  
		inputFirstname.sendKeys(Configuration.getPropertyClient("firstname"));    
		Methods.clickByRobot(inputLastname, false, true);  
		inputLastname.sendKeys(Configuration.getPropertyClient("lastname")); 
		testPass = true;     
		return testPass; 
	}
	
	public Boolean setDateOfBirth() { 
		Boolean testPass = false; 
		Methods.clickByRobot(inputDateOfBirth, false, true);  
		inputDateOfBirth.sendKeys(Configuration.getPropertyClient("dateOfBirth"));    
		testPass = true;    
		return testPass; 
	}	
	public Boolean setPrimaryPhoneNumber() { 
		Boolean testPass = false; 
		Methods.clickByRobot(inputPrimaryPhoneNumber, false, true);  
		inputPrimaryPhoneNumber.sendKeys(Configuration.getPropertyClient("phoneNumber"));     
		testPass = true;    
		return testPass; 
	}	
	public Boolean setPermanentAddress() { 
		Boolean testPass = false; 
		Methods.clickByRobot(inputPermanentAddress, false, true);  
		inputPermanentAddress.sendKeys("123"); 
		Methods.MouseGoDownAndClick(0,100,true);  
		testPass = true;    
		return testPass; 
	}	
	public Boolean setEmailAddress() {   
		Boolean testPass = false; 
		Methods.scrollToElement(inputEmailAddress);  
		Methods.clickByRobot(inputEmailAddress, false, true);  
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today); 
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());   
		inputEmailAddress.sendKeys("Guldana"+(cal.get(Calendar.MONTH)+1)+cal.get(Calendar.DAY_OF_MONTH)+timestamp.getTime()+"@credible.com");   
		testPass = true;    
		return testPass; 
	}	
	public Boolean setPassword() { 
		Boolean testPass = false; 
		Methods.clickByRobot(inputPassword, false, true);  
		inputPassword.sendKeys(Configuration.getPropertyClient("password"));       
		testPass = true;    
		return testPass; 
	}	
}
