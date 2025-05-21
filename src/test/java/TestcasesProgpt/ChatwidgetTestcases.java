package TestcasesProgpt;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectProgpt.ChatwidgetPage;
import PageObjectProgpt.DashboardPage;
import PageObjectProgpt.LoginPage;

public class ChatwidgetTestcases extends ChatwidgetPage {
	
	private LoginPage loginpage;
	private DashboardPage dashboardPage;

	@Parameters({ "browser" })
	@BeforeClass(groups = { "create","Smoke","Sanity", "Regression"})
	public void beforetestrun(String browserName) throws IOException, InterruptedException 
	{
		launchbrowser(browserName);
		webURL(progptStaging);
		loginpage = new LoginPage();
		dashboardPage = new DashboardPage();
		loginpage.loginuser("rakib@yopmail.com", "Rakib@*1#");
		Thread.sleep(2000);
	    log.info("login Successfully");
	}


	@AfterClass(groups = { "create","Smoke","Sanity", "Regression"})
	public void Aftertestrun() 
	{
		driver.close();
	}
	
	
	@Test(priority=1, groups = { "create","Sanity", "Regression"})
	 public void Verifydashboardchatbotandheading ( ) throws InterruptedException 
		{
		dashboardPage.dashboardchatbot();
		Assert.assertEquals(chatheadingtextvisible(), "Ask me anything!");
	    log.info(chatheadingtextvisible());
		}

	@Test(priority=2, groups = { "Sanity", "Regression"})
	 public void verifyintialbotmessage ( ) throws InterruptedException 
		{
		movetochatbotframe();
		Assert.assertTrue(intialmessage().contains("How can I assist you today?"));
	    log.info(intialmessage());
		}
	
	@Test(priority=3, groups = { "Sanity", "Regression"})
	 public void verifysendiconenable  ( ) throws InterruptedException 
		{
		  movetochatbotframe();
		  sendmessageiconclick();
		   log.info("Send icon is Disabled");
		}

	@Test(priority=4, groups = { "Sanity", "Regression"})
	 public void verifysendmesagehiresponse  ( ) throws InterruptedException 
		{
		  movetochatbotframe();
		  Sendmessage("hii");
		  sendmessageiconclick();
		  Assert.assertTrue(hiiresponse().contains("How can I assist you today?"));
		  log.info(hiiresponse());
		}
	

	@Test(priority=5, groups = { "Sanity", "Regression"})
	 public void dropdownanddropupchatwidget  ( ) throws InterruptedException 
		{
		  movetochatbotframe();
		  Sendmessage("hii");
		  sendmessageiconclick();
		  driver.switchTo().defaultContent();
		  chatdropdowniconclick();
		  Thread.sleep(2000);
		  dashboardPage.dashboardchatbot();
		  movetochatbotframe();
		  Assert.assertTrue(hiiresponse().contains("How can I assist you today?"));
		  log.info(hiiresponse() + "Old chat Appear after dropdown and dropup");
		}
	
	@Test(priority=6, groups = { "create","Sanity", "Regression"})
	 public void verifyrandomtextreply  ( ) throws InterruptedException 
		{
		Thread.sleep(2000);
		  movetochatbotframe();		
		  Sendmessage("jsdbfadvas");
		  sendmessageiconclick();
		  Assert.assertTrue(randomtextresponse().contains("There is no information related to"));
		  log.info(randomtextresponse() );
		}

	@Test(priority=7, groups = { "Sanity", "Regression"})
	 public void Verifybrandingtag  ( ) throws InterruptedException 
		{
		  Assert.assertTrue(brandingtext().contains("ProGPT"));
		  log.info( "Powered By  " + brandingtext() );
		}



	

}
