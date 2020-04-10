# credible

Client: Credible 
Page: Student Loan Apply
Java: My framework is written using Java language
 Maven : My framework created as a Maven Project, Maven is used to manage dependencies and also run our tests as Maven goals from termonal
 Selenium Web Driver: a library which is used to browser, it interacts with the browser.
 TestNG: used to group tests using xml files, do sort and hard assertions, create test methods, run in certain order.
Extent: My framework generates detailed HTML reports with easy to read and understand to non-techinacal team members. My reports have details test steps and screenshots for any failures that may occurIDE: I use Eclipse in my current framework. During testing, the log4j plugin works, with the help of which the test steps are recorded to a file.

Design:
Page Object model: my framework used page object model according to which I created a separate class for the pages of my application.
PageFactory design: a design which makes it easy to access the page object class.
Singleton Driver: My frameworks uses a singleton pattern to share the webdriver instance between different classes
TestBase: My framework has a testbase class which my tests extent. testbase class has the common steps for all my tests.
property  file: used to store the important test data
utilities: have reusable utilities which can be used across different classes of my framework

Testing Framework - guidelines and rules used for creating and designing test cases
1. Set up Environment; install JDK,Maven, Eclipse IDE
2. Create Maven Project
 -  ArtifactID - name of my Project
 -  GroupID - identifies my project uniquely across all projects
 
 3. Add Dependencies from Maven Repository
  - Selenium-Java
  - TestNG
  - Log4j
  - webdrivermanager
  - extentreports
-  screenshots
  
  4. Framework Structure(packages)
   - pageFactory
⦁	     StudentLoanEducationPageFactory
⦁	     StudentLoanFinancialPageFactory
⦁	     StudentLoanProfilePageFactory
   - testCases
⦁	    StudentLoanEducation
⦁	     StudentLoanFinancial
⦁	    StudentLoanProfile
⦁	    TestBase
  - utility
⦁	Configuration
⦁	     Driver
⦁	    -Methods(all helper methods)
    
    
