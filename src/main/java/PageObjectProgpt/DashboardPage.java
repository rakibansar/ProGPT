package PageObjectProgpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilityProgpt.BaseProgpt;

public class DashboardPage extends BaseProgpt{
	

	private String backgroundcolorlocator = "//div/a[@target=\"_blank\"]" ;
	private String dashboardaiagentlocator = "//span/a[contains(text(),\"Create Your AI Agent\")]" ;
	private String dashboardusermanuallocator = "//a[contains(text(),'User Manual')]" ;
	private String dashboarreachoutsupportlocator = "//a[contains(text(),'Reach out to Support')]" ;
	private String dashboardchatbotlocator = "//*[@class=\"progpt_bot\"]" ;
	private String dashboardchatbotheadinglocator = "//span[contains(text(),'Ask me anything!')]" ;

	

	private String newAlagentLocator = "//div/a[contains(text(),'New AI Agent')]" ;
	private String dashboardLocator = "a[href=\"/dashboard\"']";
	private String aiagentsLocator = "//span[contains(text(),'AI Agents')]";
	private String usermanualLocator = "//span[contains(text(),'User Manual')]";

	private String openprofileLocator = "//button[@aria-label=\"open profile\"]";
	private String profileLocator = "//span[contains(text(),'Profile')]";
	private String orgnizationLocator = "//span[contains(text(),'Organizations')]";
	private String contactusLocator = "//span[contains(text(),'Contact Us')]";
	private String logoutLocator = "//span[contains(text(),'Logout')]";

	
	public  String getbackgroundcolor ( ) 
	{
		waitelement(backgroundcolorlocator); 
		WebElement Backgroundcolor = driver.findElement(By.xpath(backgroundcolorlocator));
		Backgroundcolor.getAttribute("color");
		String  colorcode = (Backgroundcolor.getAttribute("style"));
		Assert.assertTrue(colorcode.contains("rgb(255, 255, 255)"));

		return colorcode;
	}
	
	public  void dashboardaiagentclick ( ) 
	{
		waitelement(dashboardaiagentlocator); 
		WebElement Dashboardaiagent = driver.findElement(By.xpath(dashboardaiagentlocator));
		Dashboardaiagent.click();
		
	}
	
	public  void dashboardusermanuaclick ( ) 
	{
		waitelement(dashboardusermanuallocator); 
		WebElement Dashboardusermanual = driver.findElement(By.xpath(dashboardusermanuallocator));
		Dashboardusermanual.click();
		
	}

	public  void dashboarreachoutsupport ( ) 
	{
		waitelement(dashboarreachoutsupportlocator); 
		WebElement Dashboarreachoutsupport = driver.findElement(By.xpath(dashboarreachoutsupportlocator));
		Dashboarreachoutsupport.click();
	}
	
	public  void dashboardchatbot ( ) 
	{
		waitelement(dashboardchatbotlocator); 
		WebElement Dashboardchatbot = driver.findElement(By.xpath(dashboardchatbotlocator));
		Dashboardchatbot.click();
		
	}
	
	public  String dashboardchatbotheadingtext ( ) 
	{
		waitelement(dashboardchatbotheadinglocator); 
		WebElement Dashboardchatbotheadingtext = driver.findElement(By.xpath(dashboardchatbotheadinglocator));
		String chatbotheadingtext =  Dashboardchatbotheadingtext.getText();
		return chatbotheadingtext;
	}
// Side Tab 
	
	public  void createnewAIagent ( ) 
	{
		waitelement(newAlagentLocator); 
		WebElement NewAlagenttab = driver.findElement(By.xpath(newAlagentLocator));
		NewAlagenttab.click();
	}
	
	
	public  void dashboardtab () 
	{
		waitelement(dashboardLocator); 
		WebElement Dashboardtab = driver.findElement(By.xpath(dashboardLocator));
		Dashboardtab.click();
	}
	

	public  void aiagenttab () 
	{
		waitelement(aiagentsLocator); 
		WebElement AIagenttab = driver.findElement(By.xpath(aiagentsLocator));
		AIagenttab.click();
	}
	
	public  void usermanualtab ( ) 
	{
		waitelement(usermanualLocator); 
		WebElement Usermanualtab = driver.findElement(By.xpath(usermanualLocator));
		Usermanualtab.click();
	}
	
	public  void openprofileicon ( ) 
	{
		waitelement(openprofileLocator); 
		WebElement Openprofileicon = driver.findElement(By.xpath(openprofileLocator));
		Openprofileicon.click();
	}

// Profile click 
	
	public  void profileclick ( ) 
	{
		openprofileicon();
		waitelement(profileLocator); 
		WebElement Profileclick = driver.findElement(By.xpath(profileLocator));
		Profileclick.click();
	}
	
	public  void orgnizationclick ( ) 
	{
		openprofileicon();
		waitelement(orgnizationLocator); 
		WebElement Orgnizationclick = driver.findElement(By.xpath(orgnizationLocator));
		Orgnizationclick.click();
	}
	
	public  void contactusclick ( ) 
	{
		openprofileicon();
		waitelement(contactusLocator); 
		WebElement Contactusclick = driver.findElement(By.xpath(contactusLocator));
		Contactusclick.click();
	}
	
	public  void logoutclick ( ) 
	{
		openprofileicon();
		waitelement(logoutLocator); 
		WebElement Logoutclick = driver.findElement(By.xpath(logoutLocator));
		Logoutclick.click();
	}
	
	
}