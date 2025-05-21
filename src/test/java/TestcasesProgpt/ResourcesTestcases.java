package TestcasesProgpt;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectProgpt.DashboardPage;
import PageObjectProgpt.LoginPage;
import PageObjectProgpt.ResourcesPage;

public class ResourcesTestcases extends ResourcesPage {
	
	     private LoginPage loginpage;
	   	private DashboardPage dashboardPage;

	@Parameters({ "browser" })
	@BeforeMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void beforetestrun(String browserName) throws IOException, InterruptedException 
	{
		launchbrowser(browserName);
		webURL(progptStaging);
		loginpage = new LoginPage();
		dashboardPage = new DashboardPage();
		loginpage.loginuser("rakib@yopmail.com", "Rakib@*1#");
		Thread.sleep(2000);
	    log.info("login Successfully");
		dashboardPage.resourcessidetab();


	}
	
	@AfterMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void Aftertestrun() 
	{
		driver.quit();
	}

//  Resource page visibility 
 	@Test(priority=1, groups = { "Sanity", "Regression"})
	 public void verifyresourcesectionvisible ( )  
	 {
        Assert.assertTrue(blogsredirection().isDisplayed(), "❌ 'Resources' heading is not visible on dashboard.");
        Assert.assertTrue(supportredirection().isDisplayed(), "❌ 'supportredirection' heading is not visible on dashboard.");
        Assert.assertTrue(usermanualredirection().isDisplayed(), "❌ 'usermanualredirection' heading is not visible on dashboard.");
        Assert.assertTrue(tutorialsredirection().isDisplayed(), "❌ 'tutorialsredirection' heading is not visible on dashboard.");
        Assert.assertTrue(trustsecurityredirection().isDisplayed(), "❌ 'trustsecurityredirection' heading is not visible on dashboard.");
        Assert.assertTrue(pricingplanredirection().isDisplayed(), "❌ 'pricingplanredirection' heading is not visible on dashboard.");
	    log.info("Successfully verify  Resource page section     " +  driver.getCurrentUrl());
	 }
	
//	Resources Page Link redirection 
	@Test(priority=2, groups = {  "Sanity", "Regression"})
	 public void verifyblogspageredirection( )  
	 {
		blogsredirection().click();
		switchwindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("blog"));
	    log.info("Successfully Redirect  Blogs page section     " +  driver.getCurrentUrl());
	 }
	
	@Test(priority=3, groups = {  "Sanity", "Regression"})
	 public void verifysupportpageredirection( )  
	 {
		supportredirection().click();
       Assert.assertTrue(driver.getCurrentUrl().contains("contact-us"));
	    log.info("Successfully Redirect  Support page section     " +  driver.getCurrentUrl());
	 }
	
	@Test(priority=4, groups = {  "Sanity", "Regression"})
	 public void verifyusermanualsectionvisible( )  
	 {
		usermanualredirection().click();
		switchwindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("docs.progpt"));
	    log.info("Successfully Redirect  User manual page section     " +  driver.getCurrentUrl());
	 }
	 
	 @Test(priority=5, groups = { "Sanity", "Regression"})
	 public void verifytutorialssectionvisible( )  
	 {
		tutorialsredirection().click();
		switchwindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("tutorials"));
	    log.info("Successfully Redirect  Tutorials page section     " +  driver.getCurrentUrl());
	 }
	 
	 @Test(priority=6, groups = {  "Sanity", "Regression"})
	 public void verifytrustsecuritysectionvisible( )  
	 {
		trustsecurityredirection().click();
		switchwindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("trust-security"));
	    log.info("Successfully Redirect  Trust-security page section     " +  driver.getCurrentUrl());
	 }
	 
	 @Test(priority=7, groups = {  "Sanity", "Regression"})
	 public void verifypricingplansectionvisible( )  
	 {
		pricingplanredirection().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("billing-plans"));
	    log.info("Successfully Redirect  Pricing plan page section     " +  driver.getCurrentUrl());
	 }
	 
	 @Test(priority=8, groups = { "Sanity", "Regression"})
	 public void verifyFAQSectionIsVisible()  
	 {
	     Assert.assertTrue(faqItemscount().size() == 5, "❌ FAQ items are not visible");
	     log.info(faqItemscount().size() + "    ✅ FAQ section and questions are successfully verified.");
	 }

	 @Test(priority=9, groups = {"Sanity", "Regression"})
	  public void verifyFAQExpandCollapse() throws InterruptedException
	 {
		 questionexpandandcollapse ( );
		 log.info("✅ FAQ expand/collapse functionality verified successfully.");
	 }

	
	 

}
