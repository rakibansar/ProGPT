package PageObjectProgpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import UtilityProgpt.BaseProgpt;

public class LoginPage extends BaseProgpt{
	

	private String usernameOrEmailLocator = "//input[@name='email']";
	private String passwordLocator = "//input[@name='password']";
	private String signinbuttonLocator = "//button[@type='submit']";
	
	private String forgotpasswordLocator = "a[href='/forget-password']";

	
	
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
		Thread.sleep(20000);

	}
	
	public  void forgotpassword () 
	{
		waitelement(forgotpasswordLocator); 
		WebElement Forgotpassword = driver.findElement(By.xpath(forgotpasswordLocator));
		Forgotpassword.click();
	}
	
	

}
