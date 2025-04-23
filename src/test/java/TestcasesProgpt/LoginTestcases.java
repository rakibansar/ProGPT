package TestcasesProgpt;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectProgpt.LoginPage;
import UtilityProgpt.DataproviderProgpt;

public class LoginTestcases extends LoginPage {
	
	 @Parameters({"browser"})	
	 @BeforeMethod(groups = { "create","Smoke","Sanity", "Regression"})
	public void beforetestrun(String browserName) throws IOException, InterruptedException
	{
		launchbrowser( browserName);
		webURL( progptStaging);
	}
	
	@Test( dataProviderClass = DataproviderProgpt.class,   dataProvider = "Usernameandpassword", groups = {  "Regression"})
	public void loginuser(String username , String password, String title) throws InterruptedException
	{
		loginuser( username ,  password);
		log.info("username = " + username +  " Password = " + password);
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), title);
		log.info("Actual Result = " + driver.getTitle() + "Expected Result = "  + title);
		driver.close();
	}
	
}