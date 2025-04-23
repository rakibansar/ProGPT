package TestcasesProgpt;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectProgpt.CreateNewAIAgentPage;
import PageObjectProgpt.DashboardPage;
import PageObjectProgpt.LoginPage;

public class CreateNewAIagentTestcases extends CreateNewAIAgentPage{
	
		private LoginPage loginpage;
		private DashboardPage dashboardpage;
		
		@Parameters({ "browser" })
		@BeforeMethod(groups = { "create","Smoke","Sanity", "Regression"})
		public void beforetestrun(String browserName) throws IOException, InterruptedException 
		{
			launchbrowser(browserName);
			webURL(progptStaging);
			loginpage = new LoginPage();
		        loginpage.loginuser("rakib@yopmail.com", "Rakib@*1#");
			Thread.sleep(3000);
		}
		
		@AfterMethod(groups = { "create","Smoke","Sanity", "Regression"})
		public void Aftertestrun() 
		{
			driver.close();
		}
		
		
		@Test(groups = {"Smoke","Sanity", "Regression"})
		public void createAIagent() throws IOException, InterruptedException 
		{   
			log.info("createAIagent testcase Start---------------------");
			dashboardpage = new DashboardPage();
		    dashboardpage.createnewAIagent();
		    enteragentname();
		    selectchatversion();
		    nextbutton();
		    clickurl();
		    enterweburl();
		    savebutton();
		    compareduplicateagent();
			log.info("------------------loginuserTestcase Pass");

			Thread.sleep(3000);
		}

	}
