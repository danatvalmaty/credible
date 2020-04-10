package com.credible.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.credible.utility.Methods;

public class StudentLoanProfile extends TestBase{ 
	
	@Test(priority = 19)   
	public static void setFirstnameLastnameSuffix()   
	{ 
		Boolean testPass = false; 		
		Methods.diff = 0;  
		testPass = studentLoanPageProfile.setFirstnameLastnameSuffix(); 	 	
		Assert.assertTrue(testPass, "setFirstnameLastnameSuffix not pass"); 
	} 
	@Test(priority = 20)   
	public static void setDateOfBirth()   
	{  
		Boolean testPass = false; 		 
		Methods.diff = 0;  
		testPass = studentLoanPageProfile.setDateOfBirth(); 	 	
		Assert.assertTrue(testPass, "setDateOfBirth not pass"); 
	} 
	@Test(priority = 21)   
	public static void setPrimaryPhoneNumber()   
	{  
		Boolean testPass = false; 		
		Methods.diff = 0;  
		testPass = studentLoanPageProfile.setPrimaryPhoneNumber(); 	  	
		Assert.assertTrue(testPass, "setPrimaryPhoneNumber not pass"); 
	} 
	@Test(priority = 22)   
	public static void setPermanentAddress()   
	{  
		Boolean testPass = false; 		
		Methods.diff = 0;  
		testPass = studentLoanPageProfile.setPermanentAddress(); 	  	 
		Assert.assertTrue(testPass, "setPermanentAddress not pass"); 
	} 
	@Test(priority = 23)   
	public static void setEmailAddress()    
	{  
		Boolean testPass = false; 		
		Methods.diff = 0;  
		testPass = studentLoanPageProfile.setEmailAddress(); 	  	 
		Assert.assertTrue(testPass, "setEmailAddress not pass"); 
	} 
	@Test(priority = 24)   
	public static void setPassword()    
	{  
		Boolean testPass = false; 		 
		Methods.diff = 0;  
		testPass = studentLoanPageProfile.setPassword(); 	   	 
		Assert.assertTrue(testPass, "setPassword not pass");  
	} 
}
