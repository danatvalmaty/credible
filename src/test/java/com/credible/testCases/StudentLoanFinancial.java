package com.credible.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.credible.utility.Methods;

public class StudentLoanFinancial extends TestBase{ 
	
	@Test(priority = 14)   
	public static void setEmploymentIncome() 
	{
		Boolean testPass = false; 		
		Methods.diff = 0;  
		testPass = studentLoanPageFinancial.setEmploymentIncome(); 	 	
		Assert.assertTrue(testPass, "setEmploymentIncome not pass"); 
	}
	@Test(priority = 15)   
	public static void setOtherIndividualIncome() 
	{
		Boolean testPass = false; 			
		testPass = studentLoanPageFinancial.setOtherIndividualIncome(); 	 	
		Assert.assertTrue(testPass, "setOtherIndividualIncome not pass");   
	}  	
	@Test(priority = 16)   
	public static void setIncomeFromOtherHouseholdMembers() 
	{
		Boolean testPass = false; 			
		testPass = studentLoanPageFinancial.setIncomeFromOtherHouseholdMembers(); 	 	
		Assert.assertTrue(testPass, "setIncomeFromOtherHouseholdMembers not pass"); 
	}  	 
	@Test(priority = 17)   
	public static void setMonthlyHousingPayment() 
	{ 
		Boolean testPass = false; 			
		testPass = studentLoanPageFinancial.setMonthlyHousingPayment(); 	 	
		Assert.assertTrue(testPass, "setMonthlyHousingPayment not pass"); 
	}  
	@Test(priority = 18)   
	public static void clickContinue()   
	{ 
		Boolean testPass = false; 	
		testPass = studentLoanPageFinancial.clickContinue(); 		
		Assert.assertTrue(testPass, "clickContinue not pass");   
	}
	
}
