package com.credible.testCases;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentLoanEducation extends TestBase {
	@Test(priority = 1)
	public static void clickStudentLoan() {  
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today); 
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());   
		System.out.println("Guldana"+(cal.get(Calendar.MONTH)+1)+cal.get(Calendar.DAY_OF_MONTH)+timestamp.getTime()); 
		
		Boolean testPass = false;	
		studentLoanPage.clickBtnStudentLoan();
		testPass = true;
		Assert.assertTrue(testPass, "clickStudentLoan not pass");
	}

	@Test(priority = 2)
	public static void clickBtnIamStudent() { 
		Boolean testPass = false;
		studentLoanPage.clickBtnIamStudent();
		testPass = true;
		Assert.assertTrue(testPass, "clickBtnIamStudent not pass");

	}

	@Test(priority = 3) 
	public static void clickRadioBtnNoOne() {
		Boolean testPass = false;
		testPass = studentLoanPage.clickRadioBtnNoOne();		
		Assert.assertTrue(testPass, "clickRadioBtnNo not pass");
	}
	
	@Test(priority = 4) 
	public static void clickRadioBtnNoTwo() {
		Boolean testPass = false;	
		testPass = studentLoanPage.clickRadioBtnNoTwo();		
		Assert.assertTrue(testPass, "clickRadioBtnNo not pass"); 
	}
	
	@Test(priority = 5) 
	public static void inputDataSchool() {
		Boolean testPass = false;	
		studentLoanPage.setDataSchool("Sch");
		testPass = true;
		Assert.assertTrue(testPass, "School not pass");  
	}
	
	@Test(priority = 6)   
	public static void clickSelectDegreeType() {
		Boolean testPass = false;	
		testPass = studentLoanPage.clickSelectDegreeType();  		
		
		Assert.assertTrue(testPass, "clickSelectDegreeType not pass");   
	}
	
	@Test(priority = 7)   
	public static void clickSelectDegreeTypeBachelor() { 
		Boolean testPass = false;		
		testPass = studentLoanPage.clickMenuOptionBachelors(); 		
		Assert.assertTrue(testPass, "clickMenuOptionBachelors not pass");  
	}
	
	
	@Test(priority = 8)   
	public static void clickCurrentYearOfStudySelect() { 
		Boolean testPass = false;	 
		testPass = studentLoanPage.clickCurrentYearOfStudySelect(); 		
		Assert.assertTrue(testPass, "clickCurrentYearOfStudySelect not pass"); 
	}
	
	@Test(priority = 9)   
	public static void clickSelectCurrentYearOfStudy() { 
		Boolean testPass = false;		
		testPass = studentLoanPage.clickMenuOptionCurrentYearOfStudy(); 		
		Assert.assertTrue(testPass, "clickMenuOptionBachelors not pass");  
	}
	
	@Test(priority = 10)   
	public static void clickExpectedGraduationCompletionDate() { 
		Boolean testPass = false;	
		testPass = studentLoanPage.clickGraduationCompletionDate(); 		
		Assert.assertTrue(testPass, "clickExpectedGraduationCompletionDate not pass"); 
	}
	
	@Test(priority = 11)   
	public static void setAcademicPeriodOfLoan() { 
		Boolean testPass = false;	
		testPass = studentLoanPage.setAcademicPeriodOfLoan(); 		
		Assert.assertTrue(testPass, "setAcademicPeriodOfLoan not pass"); 
	}
	
	@Test(priority = 12) 
	public static void setRequestedLoanAmount()	{  
		Boolean testPass = false;	
		testPass = studentLoanPage.setRequestedLoanAmount(); 		
		Assert.assertTrue(testPass, "setRequestedLoanAmount not pass"); 
	}
	
	@Test(priority = 13)   
	public static void clickContinue() 
	{
		Boolean testPass = false; 	
		testPass = studentLoanPage.clickContinue(); 		
		Assert.assertTrue(testPass, "clickContinue not pass");  
	}


}
