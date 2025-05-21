package TestcasesProgpt;


import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectProgpt.CreateNewAIAgentPage;
import PageObjectProgpt.DashboardPage;
import PageObjectProgpt.LoginPage;

public class CreateNewAIagentTestcases extends CreateNewAIAgentPage {
	
	private	DashboardPage dashboardpage = new DashboardPage();

	@Parameters({ "browser" })
	@BeforeClass(groups = {"create","Smoke","Sanity", "Regression"})
	public void beforetestrun(String browserName) throws IOException, InterruptedException 
	{
		launchbrowser(browserName);
		webURL(progptStaging);
		LoginPage loginpage = new LoginPage();
		loginpage.loginuser("rakib@yopmail.com", "Rakib@*1#");
		Thread.sleep(2000);
//		Redirect to create AI agent 
		dashboardpage.createnewAIagentsidetab();
	}
	
	@AfterClass(groups = { "create","Smoke","Sanity", "Regression"})
	public void quitbrowser() throws IOException, InterruptedException 
	{
		driver.close();
	}


//  Agent Details page Test cases 
	@Test(priority = 1, groups = {"Sanity", "Regression"})
	public void verifyAgentNameFieldIsVisible() 
	{ 
	    Assert.assertTrue(enteragentname().isDisplayed(), 
	    		"Agent Name input field is not visible.");
	    log.info("Agent Name input field is visible.");
	}
		
	@Test(priority = 2, groups = { "Sanity", "Regression"})
	public void verifyAgentNameInputFunctionality() 
	{
	    String testName = "Chat123";
	    enteragentname().sendKeys(testName);
	    Assert.assertEquals(enteragentname().getAttribute("value"), testName, 
	    		"Agent Name input field value mismatch.");
	    log.info("Agent Name input field accepts and displays text correctly.");
	}
		
	@Test(priority = 3, groups = {"Sanity", "Regression"})
	public void verifyModelTypeDropdownIsVisible() 
	{
	    Assert.assertTrue(modeltypedropdown ( ).isDisplayed(), "Model Type dropdown is not visible.");
	    log.info("Model Type dropdown is visible.");
	}	
	
	@Test(priority = 4, groups = { "Sanity", "Regression"})
	public void verifyModelRadioButtonsVisible() throws InterruptedException 
	{
		allradiobutton();
		log.info("All radio buttons are  visible.");

	}
	
	@Test(priority = 5, groups = { "Sanity", "Regression"})
	public void verifyUserCanSelectModelRadioButton() 
	{
		UserCanSelectModelRadioButton();
		log.info("All radio buttons are  clickable.");
	}
	
	@Test(priority = 6, groups = {"Sanity", "Regression" })
	public void verifyNextButtonIsvalidationenableanddisable() throws InterruptedException 
	{	 
		enteragentname().sendKeys("Chat123");
		Assert.assertTrue(nextbutton().getAttribute("class").contains("1vaj1ps"),
				"'Next' button is Disabled  while agent field have text.");
		log.info("Next button is Enabled while Agent field have text");

		enteragentname().sendKeys(Keys.CONTROL + "a"); // Select all (CTRL+A)
		enteragentname().sendKeys(Keys.DELETE);
		enteragentname().sendKeys("qq");
		Assert.assertFalse(nextbutton().getAttribute("class").contains("1vaj1ps"),
				"'Next' button is Disabled  while agent field have text.");
		log.info("Next button is Disabled while Agent field is Blank");
    } 
	
//	verify user redirect to Kowledge base after clicking on next button 
	@Test(priority = 7, groups = {"Sanity", "Regression" })
	public void verifyFormNavigationToNextStep() 
	{
		enteragentname().sendKeys(Keys.CONTROL + "a"); // Select all (CTRL+A)
		enteragentname().sendKeys(Keys.DELETE);
		enteragentname().sendKeys("Chat123");
		selectradiochatversion();
		nextbutton().click();
		Assert.assertTrue(knowledgebaseheadingtext().getText().contains
				("Knowledge Base"),"User won't be able to redirect on Knowlwdgebase page");
		log.info("Agent details saved successfully");
	}
	
			
		@Test(priority = 8, groups = {"Sanity", "Regression" })
		public void testRadioButtontabsVisibility() {
			Assert.assertTrue(resourceradio().isDisplayed(), "Resource radio button is not visible.");
			Assert.assertTrue(dbconnectionRadio().isDisplayed(), "Database Connection radio button is not visible.");
			log.info(resourceradio().getText(),
					dbconnectionRadio().getText() + "Knowledge Bade Resource and Database Connectionare visible");
		}

		@Test(priority = 9, groups = {"Sanity", "Regression" })
		public void verifyResourceRadioSelectedByDefault() {
			Assert.assertTrue(bydefaultselectedradio().getAttribute("class").contains("checked"),
					"'Resource' radio button is not selected by default.");
		}

		@Test(priority = 10, groups = {"Sanity", "Regression" })
		public void verifyResourceTypesAreVisible() 
		{
			resourcetypes();
		}
		
		@Test(priority = 11, groups = {"Sanity", "Regression" })
		 public void verifyPreviousAndSaveButtonsVisible() 
		{
	        Assert.assertTrue(previousbutton().isDisplayed(), "'Previous' button is not visible.");
	        Assert.assertTrue(savebutton().isDisplayed(), "'Save' button is not visible.");
	        log.info("Previousbutton and Savebuttonis are  visible.");
	    }
		
		@Test(priority = 12, groups = {"Sanity", "Regression" })
		 public void verifysavebuttonfunctionality() throws InterruptedException 
		{
			savebutton().click();
			compareduplicateagent();
			Thread.sleep(1000);
	        Assert.assertTrue(driver.getCurrentUrl().contains("agents"), "Unable to save new Agent .");
	        log.info("New Agent Saved Successfully. ");
	    }
		
//  Create Save Agent, New AI Agent,  Delete Existing AI Agent and Check Duplicate 
			
		@Test(priority = 13, groups = { "Smoke", "Sanity", "Regression" })
			public void createAIagentDeleteagentandduplicateagent () throws InterruptedException  
			{
				for (int i = 1; i <= 2; i++) 
				{
					dashboardpage.dashboardsidetab();
					dashboardpage.createnewAIagentsidetab();
					enteragentname().sendKeys("Chat123");
					nextbutton().click();
					savebutton().click();
					compareduplicateagent();
					log.info("Chat123" + " Agent created successfully");
					Thread.sleep(1000);
		        }
			}

	}
