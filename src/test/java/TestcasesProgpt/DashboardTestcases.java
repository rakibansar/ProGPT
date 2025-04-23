package TestcasesProgpt;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectProgpt.DashboardPage;
import PageObjectProgpt.LoginPage;


public class DashboardTestcases extends DashboardPage {
	
	private LoginPage loginpage;

	
	@Parameters({ "browser" })
	@BeforeMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void beforetestrun(String browserName) throws IOException, InterruptedException 
	{
		launchbrowser(browserName);
		webURL(progptStaging);
		loginpage = new LoginPage();
		loginpage.loginuser("rakib@yopmail.com", "Rakib@123");
		Thread.sleep(3000);
	}
	
	@AfterMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void Aftertestrun() 
	{
		driver.close();
	}
	
//Dash Board UI And URL Redirection 
	@Test(groups = { "Sanity", "Regression"})
	 public void dashboardbackgroundcolorcheck( ) 
	 
		{
		getbackgroundcolor();
		}
	
	@Test(groups = {"Sanity", "Regression"})
	 public void dashboardcheckaiagentredirection( ) 
	 
		{
		dashboardaiagentclick ( );
		log.info("Actual Result = "+  driver.getCurrentUrl() + " Expected Result = progpt.biz/new-agent");
		Assert.assertTrue(driver.getCurrentUrl().contains("progpt.biz/new-agent"));

		}
	
	@Test(groups = { "Sanity", "Regression"})
	 public void dashboardusermanularedirection( ) throws InterruptedException 
	 
		{
		dashboardusermanuaclick ( );
		switchwindow();
		String usermanualurl =driver.getCurrentUrl();
		log.info("Actual Result = "+  usermanualurl + " Expected Result = docs.progpt.biz");
		Assert.assertTrue(usermanualurl.contains("docs.progpt.biz"));
		
		}
	
	@Test(groups = { "Sanity", "Regression"})
	 public void dashboardreachoutsupportredirection( ) throws InterruptedException 
	 
		{
		dashboarreachoutsupport ( );
		log.info("Actual Result = "+  driver.getCurrentUrl() + " Expected Result = progpt.biz/profile/contact-us");
		Assert.assertTrue(driver.getCurrentUrl().contains("progpt.biz/profile/contact-us"));
		}
	
	@Test(groups = { "create","Sanity", "Regression"})
	 public void dashboardchatbotopen ( ) throws InterruptedException 
	 
		{
		dashboardchatbot();
		Assert.assertEquals(dashboardchatbotheadingtext(), "Ask me anything!");
		}
	
	    
}