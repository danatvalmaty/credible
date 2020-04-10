package com.credible.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.credible.utility.Driver;
import com.credible.utility.Methods;

public class StudentLoanFinancialPageFactory { 
	
	@FindBy(xpath = "(//fieldset[contains(@data-step,'financial')]/div)[1]/div/div/span/input")    
	private WebElement inputEmploymentIncome;  
	
	@FindBy(xpath = "(//fieldset[contains(@data-step,'financial')]/div)[2]/div/div/div/span/input")    
	private WebElement inputOtherIndividualIncome; 	
	
	@FindBy(xpath = "(//fieldset[contains(@data-step,'financial')]/div)[4]/div/div/div/span/input")    
	private WebElement inputIncomeFromOtherHouseholdMembers; 
	
	@FindBy(xpath = "((//fieldset[contains(@data-step,'financial')]/div)[6]/div/div/span)[2]/input")    
	private WebElement inputMonthlyHousingPayment;  
	
	@FindBy(xpath = "(//button[@class='cta cta-primary' and contains(text(),'Continue')])[2]") 
	private WebElement btnContinue;
	
	public StudentLoanFinancialPageFactory() { 
		PageFactory.initElements(Driver.getDriver(), this); 
		Methods.waitExplicit(2);
	}
	public Boolean setEmploymentIncome() {  		
		Boolean testPass = false; 	
		Methods.clickByRobot(inputEmploymentIncome, false, true);  
		inputEmploymentIncome.sendKeys("80000");      
		testPass = true;    
		return testPass; 
	}	
	public Boolean setOtherIndividualIncome() {  		
		Boolean testPass = false; 	
		Methods.clickByRobot(inputOtherIndividualIncome, false, true);  
		inputOtherIndividualIncome.sendKeys("1000");      
		testPass = true;    
		return testPass; 
	}	
	public Boolean setIncomeFromOtherHouseholdMembers() {  		
		Boolean testPass = false; 	
		Methods.clickByRobot(inputIncomeFromOtherHouseholdMembers, false, true);  
		inputIncomeFromOtherHouseholdMembers.sendKeys("20000");      
		testPass = true;    
		return testPass; 
	}
	public Boolean setMonthlyHousingPayment() {   		
		Boolean testPass = false; 
		Methods.clickByRobot(inputMonthlyHousingPayment, false, true);  
		inputMonthlyHousingPayment.sendKeys("1000");      
		testPass = true;    
		return testPass; 
	} 
	public Boolean clickContinue() 
	{		 
		Boolean testPass = false; 
		Methods.scrollToElement(btnContinue);   
		Methods.clickByRobot(btnContinue, false, true);   
		testPass = true;    
		return testPass;  
	}  	
	
}
