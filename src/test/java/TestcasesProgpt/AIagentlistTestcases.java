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
		dashboardpage.aiagentsidetab();
	}
	
	@AfterMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void quitbrowser() throws IOException, InterruptedException 
	{
		driver.close();
	}
	
	@Test(priority =1, groups = { "Sanity", "Regression"})
	public void VerifyAgentsList () 
	{	
        Assert.assertTrue(agentlist().size() > 0, "❌ Test Failed: No agents found.");
		log.info("✅ Test Passed: Agent list is displayed with " + agentlist().size() + " agents.");
	}
	
	@Test(priority =2, groups = {"Sanity", "Regression"})
	public void verifyOrgOwnerLabelPresence() 
	{
		Assert.assertTrue(orgownerlabel().isDisplayed(), "Org Owner label is not visible.");
        Assert.assertEquals(orgownerlabel().getText().trim(), "Org Owner");
        log.info(" ✅ Org Owner label is not visible.");
	}
	
	@Test(priority =3, groups = { "Sanity", "Regression"})
    public void verifysearchagentfunctionality() throws InterruptedException 
	{
		agentlistname() ;
	}
	
	@Test(priority =4, groups = { "Sanity", "Regression"})
	public void knowledgebaseredirect() 
	{  
		searchagent().sendKeys ("recr" ) ;
		knowledgebase().click();
		Assert.assertEquals(agentdetailspage.knowledgebasetext(), "Knowledge base");
		log.info("User Successfully redirect to " + agentdetailspage.knowledgebasetext( ));
	}
	
	@Test(priority =5, groups = {  "Sanity", "Regression"})
	public void deployredirect() 
	{  
		searchagent().sendKeys ("recr" ) ;
		agentdeploy().click();
		Assert.assertEquals(agentdetailspage.sharelinktext() , "Share Link");
		log.info("User Successfully redirect to = "+ agentdetailspage.sharelinktext());
	}
	
	@Test(priority =6, groups = { "Sanity", "Regression"})
	public void settingredirect() 
	{  
		searchagent().sendKeys ("recr" ) ;
		Agentsetting().click();
		Assert.assertEquals(agentdetailspage.agentdetailstext() , "Agent Details");
		log.info("User Successfully redirect to = "+ agentdetailspage.agentdetailstext());
	}
	
	@Test(priority =7, groups = { "Sanity", "Regression"})
	public void conversationredirect () 
	{  
		searchagent().sendKeys ("recr" ) ;
		newcoversation().click();;
		Assert.assertEquals(agentdetailspage.conversationscreentext(), "Hey! How can I assist you today?");
		log.info("User Successfully redirect to = "+  agentdetailspage.conversationscreentext());
	}
//	
//	@Test(priority =8, groups = { "Sanity", "Regression"})
//	public void deleteagentconfirmation() 
//	{  
//		
//		searchagent().sendKeys ("chat123" ) ;
//		deleteagent( );		
//		String deletetext = deleteconfirmationtext ( );
//		Assert.assertEquals(deletetext, "Agent and related data deleted successfully.");
//		log.info("------------------deleteagentconfirmation Testcase Pass");
//
//	}
	
}
