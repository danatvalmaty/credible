package com.credible.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.credible.utility.Driver;
import com.credible.utility.Methods; 

public class StudentLoanEducationPageFactory {  	

	@FindBy(xpath = "//div[text()=\"Student\"]//..//button[contains(text(),'Get My Loan Rates')]")
	private WebElement btnStudentLoan;

	@FindBy(xpath = "//button[contains(text(),'I am the student')]")
	private WebElement btnIamStudent;

	@FindBy(xpath = "((//*[@class=\"row add-cosigner-section\"]//div[@class='radios radios-vertical radios-horizontal'])[1]//input)[2]")
	public WebElement btnNoOne;

	@FindBy(xpath = "((//*[@class=\"row add-cosigner-section\"]//div[@class='radios radios-vertical radios-horizontal'])[2]//input)[2]") 
	private WebElement btnNoTwo;	

	@FindBy(xpath = "//div[@data-fields='education.degree_type']//a") 
	private WebElement selectDegreeType;	

	@FindBy(xpath = "(//span[contains(text(),'Bachelors')])[1]") 
	private WebElement optionBacelors;	
	
	@FindBy(xpath = "((//fieldset[@data-step='education']/div[@class='row'])[1]//input)[1]") 
	private WebElement inputSchool; 	

	@FindBy(xpath = "((//fieldset[@data-step='education']/div[@class='row'])//div[@class='select2-container bootstrap-dropdown'])[2]") 
	private WebElement currentYearOfStudySelect;	

	@FindBy(xpath = "(((//ul[@class='select2-results']))[9]//span)[5]")  
	private WebElement webElementMenuOptionCurrentYearOfStudy;
//
	@FindBy(xpath = "//div[@data-fields='education.degree_type']//a") 
	private WebElement webElementDegreeType;
//	
	@FindBy(xpath = "((//ul[@class='select2-results'])[9]//span)[4]")
	private WebElement webElementDegreeTypeBachelors;	

	@FindBy(xpath = "(//fieldset[@data-step='education']/div[@class='row'])[6]//input") 
	private WebElement expectedGraduationCompletionDate; 
	
	@FindBy(xpath = "(//fieldset[@data-step='education']/div[@class='row'])[7]//a")  
	private WebElement inputAcademicPeriodOfLoan;  
	
	@FindBy(xpath = "//div[contains(text(),'Fall 2020')]")  
	private WebElement optionFall2020;
	
	@FindBy(xpath = "(//fieldset[@data-step='education']/div[@class='row'])[8]//input")   
	private WebElement inputRequestedLoanAmount;
	
	@FindBy(xpath = "(//button[@class='cta cta-primary' and contains(text(),'Continue')])[1]") 
	private WebElement btnContinue;
	
	public StudentLoanEducationPageFactory() { 
		PageFactory.initElements(Driver.getDriver(), this);
		Methods.waitExplicit(2);
	}
	
	public void clickBtnStudentLoan() { 
		btnStudentLoan.click();
	}
	public void clickBtnIamStudent() {
		btnIamStudent.click();
	}
	public Boolean clickRadioBtnNoOne() {		
		if (btnNoOne.isSelected()) {			
		} else {
			JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
			js.executeScript("arguments[0].click();", btnNoOne);
			if(btnNoOne.isSelected()) 
				return true; 
		}
		
		return false;
	}	
	public Boolean clickRadioBtnNoTwo() {		
		if (btnNoTwo.isSelected()) {			
		} else {
			JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
			js.executeScript("arguments[0].click();", btnNoTwo);
			if(btnNoTwo.isSelected())  
				return true; 
		}		
		return false;
	}	
	public void setDataSchool(String school)
	{		
		WebElement schoolWebElement = Methods.waitElement(20, By.xpath("((//fieldset[@data-step='education']/div[@class='row'])[1]//input)[2]"));
		schoolWebElement.sendKeys(school);   		
		Methods.clickByRobot(schoolWebElement, false, false); 
		Methods.MouseGoDownAndClick(0,100,true);  
	}	
	public Boolean clickSelectDegreeType() 
	{  
		Boolean testPass = false; 
		Methods.clickByRobot(webElementDegreeType, true, true);    
		testPass = true;  
		return testPass;
		
	} 	
	public Boolean clickMenuOptionBachelors() 
	{
		Boolean testPass = false;
		Methods.clickByRobot(webElementDegreeTypeBachelors, false, true);    
		testPass = true;  
		return testPass; 
	}	
	public Boolean clickCurrentYearOfStudySelect() 
	{ 
		Boolean testPass = false;   
		Methods.scrollToElement(currentYearOfStudySelect);   
		Methods.clickByRobot(currentYearOfStudySelect, false, true);  
		testPass = true;   
		return testPass; 
	}	
	public Boolean clickMenuOptionCurrentYearOfStudy() { 
		Boolean testPass = false;
		Methods.clickByRobot(webElementMenuOptionCurrentYearOfStudy, false, true);    
		testPass = true;  
		return testPass; 
	}	
	public Boolean clickGraduationCompletionDate() 
	{ 
		Boolean testPass = false;
		Methods.clickByRobot(expectedGraduationCompletionDate, false, true);  
		expectedGraduationCompletionDate.sendKeys("092020"); 
		testPass = true;    
		return testPass; 
	}
	public Boolean setAcademicPeriodOfLoan() { 
		Boolean testPass = false;
		Methods.clickByRobot(inputAcademicPeriodOfLoan, false, true);   
		Methods.clickByRobot(optionFall2020, false, true);      
		testPass = true;    
		return testPass; 
	}	
	public Boolean setRequestedLoanAmount() 
	{ 
		Boolean testPass = false; 	
		Methods.clickByRobot(inputRequestedLoanAmount, false, true);  
		inputRequestedLoanAmount.sendKeys("20000");  
		testPass = true;    
		return testPass; 
	}	
	public Boolean clickContinue() 
	{		 
		Boolean testPass = false; 
		Methods.clickByRobot(btnContinue, false, true);   
		testPass = true;    
		return testPass;  
	}  	
}
