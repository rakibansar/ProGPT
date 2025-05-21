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
		loginpage.loginuser("rakib@yopmail.com", "Rakib@*1#");
		Thread.sleep(2000);
	    log.info("login Successfully");

	}
	
	@AfterMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void Aftertestrun() 
	{
		driver.close();
	}
	
	
//Dash Board page UI	
	
	@Test(priority=1, groups = { "Sanity", "Regression"})
	 public void testDashboardLoadsCorrectly( )  
		{
		dashboardheading();
	    log.info("Successfully navigated to Dashboard     " +  driver.getCurrentUrl());
		}

	@Test(priority=2, groups = {"Sanity", "Regression"})
	 public void dashboardbackgroundcolorcheck( ) 
		{
		String colorcode = getbackgroundcolor();
	    log.info("Backgroud color is        " +  colorcode);

		}
	
//Dash Board page URL Redirection 
	
	@Test(priority=3, groups = {"Sanity", "Regression"})
	 public void testdashboardcreateaiagentlinkredirection( ) 	 
		{
		dashboardcreateaiagentclick ( );
		Assert.assertTrue(driver.getCurrentUrl().contains("progpt.biz/new-agent"));
	    log.info("Successfully navigated to create Ai agent     " +  driver.getCurrentUrl());
		}
	
	@Test(priority=4, groups = { "Sanity", "Regression"})
	 public void testdashboardusermanuallinkredirection( ) throws InterruptedException 	 
		{
		dashboardusermanuaclick ( );
		switchwindow();
		String usermanualurl =driver.getCurrentUrl();
		Assert.assertTrue(usermanualurl.contains("docs.progpt.biz"));
	    log.info("Successfully navigated to docs.progpt.biz      " +  usermanualurl);
		}
	
	@Test(priority=5, groups = { "Sanity", "Regression"})
	 public void testdashboardreachoutsupportlinkredirection( ) throws InterruptedException 
	 
		{
		dashboarreachoutsupport ( );
		Assert.assertTrue(driver.getCurrentUrl().contains("contact-us"));
	    log.info("Successfully navigated to Contact-us      " +  driver.getCurrentUrl());

		}
	
//	Dashboard Side tab link  redirection 
	
	@Test(priority=6, groups = { "Sanity", "Regression"})
	 public void testsidetabnewAIagentredirection( ) throws InterruptedException 
	 
		{
		createnewAIagentsidetab ( );
		Assert.assertTrue(driver.getCurrentUrl().contains("new-agent"), "Navigation to create AI agent page failed or wrong page.");
	    log.info("Successfully navigated to Create AI agent      " +  driver.getCurrentUrl());
		}
	
	@Test(priority=7, groups = { "Sanity", "Regression"})
	 public void testsidetabaiagentredirection( ) throws InterruptedException 
	 
	    {
		aiagentsidetab ( );
		Assert.assertTrue(driver.getCurrentUrl().contains("agents"), "Navigation to  AI agent page failed or wrong page.");
	    log.info("Successfully navigated to Agents      " +  driver.getCurrentUrl());

		}
	
	@Test(priority=8, groups = { "Sanity", "Regression"})
	 public void testsidetabcontactusredirection( ) throws InterruptedException 
	 
	    {
		contactussidetab ( );
		Assert.assertTrue(driver.getCurrentUrl().contains("contact-us"), "Navigation to  Contact-us page failed or wrong page.");
	    log.info("Successfully navigated to Contact us      " +  driver.getCurrentUrl());
		}
	
	@Test(priority=9, groups = {"create", "Sanity", "Regression"})
	 public void testsidetabresourcesredirection( ) throws InterruptedException 
	 
	    {
		resourcessidetab ( );
		Assert.assertTrue(driver.getCurrentUrl().contains("resources"), "Navigation to  Resources page failed or wrong page.");
	    log.info("Successfully navigated to Resources          " +  driver.getCurrentUrl());

		}
	
	@Test(priority=10, groups = { "Sanity", "Regression"})
	 public void testsidetabusermanualredirection( ) throws InterruptedException 
	 
	    {
		usermanualsidetab ( );
		switchwindow();
		String usermanualurl =driver.getCurrentUrl();
		Assert.assertTrue(usermanualurl.contains("docs.progpt.biz"));
	    log.info("Successfully navigated to docs.progpt.biz          " +  usermanualurl);
		}
	
	
//	My profile dropdown
	@Test(priority=11, groups = {"Sanity", "Regression"})
	 public void Testprofiledropdown( ) throws InterruptedException 
	 
	    {
		profiledropdown ( );
		Assert.assertTrue(myprofiletext ( ).contains("My Profile"));
	    log.info("Successfully open My profile dropdown           " );
		}

//	Dashboard My profile Dropdown test cases 

	@Test(priority=12, groups = { "Sanity", "Regression"})
	 public void switchorgnizationredirection  ( ) throws InterruptedException 
	 
		{
		switchorgnizationclick();
		Assert.assertTrue(driver.getCurrentUrl().contains("organization-settings"), "Navigation to  organization-settings page failed or wrong page.");
	    log.info("Successfully navigated to organization-settings          " +  driver.getCurrentUrl());
		}
	
	@Test(priority=13, groups = { "Sanity", "Regression"})
	 public void myprofileredirection  ( ) throws InterruptedException  
	 
		{
		profileclick();
		Assert.assertTrue(driver.getCurrentUrl().contains("profile"), "Navigation to  Profile page failed or wrong page.");
	    log.info("Successfully navigated to Profile          " +  driver.getCurrentUrl());
		}
	
	@Test(priority=14, groups = { "Sanity", "Regression"})
	 public void orgnizationredirection  ( ) throws InterruptedException  
	 
		{
		orgnizationclick();
		Assert.assertTrue(driver.getCurrentUrl().contains("organization-settings"), "Navigation to  organization-settings page failed or wrong page.");
	    log.info("Successfully navigated to organization-settings          " +  driver.getCurrentUrl());
		}
	
	@Test(priority=15, groups = { "Sanity", "Regression"})
	 public void contactusredirection  ( ) throws InterruptedException  
	 
		{
		contactusclick();
		Assert.assertTrue(driver.getCurrentUrl().contains("contact-us"), "Navigation to  contact-us page failed or wrong page.");
	    log.info("Successfully navigated to contact-us          " +  driver.getCurrentUrl());
		}
	
	@Test(priority=16, groups = { "Sanity", "Regression"})
	 public void logoutuserpopupconfirmation  ( ) throws InterruptedException  
	 
		{
		String confirmationtext = logoutclick();
		Assert.assertTrue(confirmationtext.contains("Are you sure you want to logout?"), "Navigation to  logout confirmation popup   failed or wrong page.");
	    log.info("Successfully navigated to logout confirmation popup          " +  confirmationtext);
		}
	
	@Test(priority=17, groups = { "Sanity", "Regression"})
	 public void confirmlogout  ( ) throws InterruptedException  
	 
		{
		logoutclick();
		logoutconfirm();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Navigation to  login page  failed or wrong page.");
	    log.info("Successfully navigated to Login page         " +  driver.getCurrentUrl());
		}
	
	@Test(priority=18, groups = { "Sanity", "Regression"})
	 public void cancellogout  ( ) throws InterruptedException  
	 
		{
		logoutclick();
		logoutcancel();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Navigation to  dashboard page  failed or wrong page.");
	    log.info("Successfully navigated to Dashboard page         " +  driver.getCurrentUrl());
		}
	
	
	
	
	
}
