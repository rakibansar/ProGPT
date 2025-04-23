package TestcasesProgpt;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectProgpt.AIAgentslistPage;
import PageObjectProgpt.AgentDetailsPage;
import PageObjectProgpt.DashboardPage;
import PageObjectProgpt.LoginPage;

public class AIagentlistTestcases extends AIAgentslistPage {

	private AgentDetailsPage agentdetailspage  = new AgentDetailsPage();
	private	DashboardPage dashboardpage = new DashboardPage();

	
	
	@Parameters({ "browser" })
	@BeforeMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void beforetestrun(String browserName) throws IOException, InterruptedException 
	{
		launchbrowser(browserName);
		webURL(progptStaging);
		LoginPage loginpage = new LoginPage();
		loginpage.loginuser("rakib@yopmail.com", "Rakib@*1#");
		Thread.sleep(3000);
		dashboardpage.aiagenttab();
	}
	
	@AfterMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void quitbrowser() throws IOException, InterruptedException 
	{
		driver.close();
	}
	
	@Test(priority =1, groups = { "Sanity", "Regression"})
	public void knowledgebaseredirect() 
	{  
		log.info("knowledgebaseredirect testcase Start---------------------");
		searchagent ("chat123" ) ;
		knowledgebase();
		String pagetext = agentdetailspage.knowledgebasetext();
		log.info("Actual Result = " + pagetext+ " Expected Result = Knowledge base");
		Assert.assertEquals(pagetext, "Knowledge base");
		log.info("------------------knowledgebaseredirect Testcase Pass");

	}
	
	@Test(priority =2, groups = { "Sanity", "Regression"})
	public void deployredirect() 
	{  
		log.info("deployredirect testcase Start---------------------");
		searchagent ("chat123" ) ;
		agentdeploy();
		String pagetext = agentdetailspage.sharelinktext();
		log.info("Actual Result = "+ pagetext+ " Expected Result = Share Link");
		Assert.assertEquals(pagetext, "Share Link");
		log.info("------------------deployredirect Testcase Pass");
	}
	
	@Test(priority =3, groups = { "Sanity", "Regression"})
	public void settingredirect() 
	{  
		log.info("settingredirect testcase Start---------------------");
		searchagent ("chat123" ) ;
		Agentsetting();
		String pagetext = agentdetailspage.agentdetailstext();
		log.info("Actual Result = "+ pagetext+ " Expected Result = Agent Details");
		Assert.assertEquals(pagetext, "Agent Details");
		log.info("------------------settingredirect Testcase Pass");
	}
	
	@Test(priority =4, groups = { "Sanity", "Regression"})
	public void conversationredirect () 
	{  
		log.info("settingredirect testcase Start---------------------");
		searchagent ("chat123" ) ;
		newcoversation();
		String pagetext = agentdetailspage.conversationscreentext();
		log.info("Actual Result = "+ pagetext+ " Expected Result = Hey! How can I assist you today?");
		Assert.assertEquals(pagetext, "Hey! How can I assist you today?");
		log.info("------------------conversationredirect Testcase Pass");

	}
	
	@Test(priority =5, groups = { "Sanity", "Regression"})
	public void deleteagentconfirmation() 
	{  
		
		log.info("deleteagentconfirmation testcase Start---------------------");
		searchagent ("chat123" ) ;
		deleteagent( );		
		String deletetext = deleteconfirmationtext ( );
		log.info("Actual Result = "+  deletetext + " Expected Result = Agent and related data deleted successfully.");
		Assert.assertEquals(deletetext, "Agent and related data deleted successfully.");
		log.info("------------------deleteagentconfirmation Testcase Pass");

	}
	
}
