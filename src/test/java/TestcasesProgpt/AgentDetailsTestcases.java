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



public class AgentDetailsTestcases extends AgentDetailsPage {
	
	private	DashboardPage dashboardpage = new DashboardPage();
	private	AIAgentslistPage aiAgentslistpage = new AIAgentslistPage();

	@Parameters({ "browser" })
	@BeforeMethod(groups = {"create","Smoke","Sanity", "Regression"})
	public void beforetestrun(String browserName) throws IOException, InterruptedException 
	{
		launchbrowser(browserName);
		webURL(progptStaging);
		LoginPage loginpage = new LoginPage();
		loginpage.loginuser("rakib@yopmail.com", "Rakib@*1#");
		Thread.sleep(3000);
		dashboardpage.aiagentsidetab();
		aiAgentslistpage.searchagent().sendKeys ("e") ;
		aiAgentslistpage.agentdeploy() ;
	}
	
	@AfterMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void quitbrowser() throws IOException, InterruptedException 
	{
		driver.close();
	}
	
	@Test(priority =1, groups = {"Sanity", "Regression"})
	public void Sharelinkchatresponse() throws InterruptedException 
	{  
		log.info("Sharelinkchatresponse testcase Start---------------------");
		sharelink() ;
		driver.get(Sharelinkgeturl());
		sharelinksendmessage();
		Thread.sleep(3000);
        Assert.assertTrue(messageresponse().contains("How can I assist you today?"));
        log.info("Actual Result = "+  messageresponse()+ " Expected Result = How can I assist you today?");
		log.info("------------------Sharelinkchatresponse Testcase Pass");
      
	}

}
