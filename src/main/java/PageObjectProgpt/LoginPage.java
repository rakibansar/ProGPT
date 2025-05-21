package PageObjectProgpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilityProgpt.BaseProgpt;

public class LoginPage extends BaseProgpt{
	

	private String usernameOrEmailLocator = "//input[@name='email']";
	private String passwordLocator = "//input[@name='password']";
	private String signinbuttonLocator = "//button[@type='submit']";
	private String eyetogglelocator = "//button[@aria-label='toggle password visibility']";

	private String createanaccountLocator = "//div/a[contains(text(),'Create an account')]";
	private String forgotpasswordLocator = "//div/a[contains(text(),'Forgot Password')]";
	private String verifyemailLocator = "//div/a[contains(text(),'Verify Email')]";

	
	
	public  void loginuser ( String username , String password) throws InterruptedException 
	{
		waitelement(usernameOrEmailLocator); 
		WebElement Enterusernameoremail = driver.findElement(By.xpath(usernameOrEmailLocator));
		Enterusernameoremail.sendKeys(username);
		
		waitelement(passwordLocator); 
		WebElement Enterpassword = driver.findElement(By.xpath(passwordLocator));
		Enterpassword.sendKeys(password);
		
		waitelement(signinbuttonLocator); 
		WebElement Signinbutton = driver.findElement(By.xpath(signinbuttonLocator));
		Signinbutton.click();
		Thread.sleep(2000);

	}
	
	public  void createanaccount () 
	{
		waitelement(createanaccountLocator); 
		WebElement CreateanAccount = driver.findElement(By.xpath(createanaccountLocator));
		CreateanAccount.click();
	}
	
	public  void forgotpassword () 
	{
		waitelement(forgotpasswordLocator); 
		WebElement Forgotpassword = driver.findElement(By.xpath(forgotpasswordLocator));
		Forgotpassword.click();
	}
	
	public  void verifyemail () 
	{
		waitelement(verifyemailLocator); 
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemailLocator));
		Verifyemail.click();
	}
	
	public  void togglepasswordvisibility () 
	{
		waitelement(passwordLocator); 
		WebElement Enterpassword = driver.findElement(By.xpath(passwordLocator));
		Enterpassword.sendKeys("qwerty");
		
		
		String initialType = Enterpassword.getAttribute("type");
	    Assert.assertEquals(initialType, "password", "Password field should initially be hidden.");
	    
		waitelement(eyetogglelocator); 
		WebElement Eyetoggle = driver.findElement(By.xpath(eyetogglelocator));
		Eyetoggle.click();
		
		String visibleType = Enterpassword.getAttribute("type");
	    Assert.assertEquals(visibleType, "text", "Password should be visible after toggle.");
	    
	}
	
	
	

}
