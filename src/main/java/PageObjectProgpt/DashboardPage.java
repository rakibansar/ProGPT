package PageObjectProgpt;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilityProgpt.BaseProgpt;

public class DashboardPage extends BaseProgpt{
	
// Dashboard page Link 
 	private String dashboardcreateaiagentlocator = "//span/a[contains(text(),\"Create Your AI Agent\")]" ;
	private String dashboardusermanuallocator = "//a[contains(text(),'User Manual')]" ;
	private String dashboarreachoutsupportlocator = "//a[contains(text(),'Reach out to Support')]" ;

// Dashoardpage chat bot
	private String dashboardchatbotlocator = "//*[@class=\"progpt_bot\"]" ;

// UI
	private String dashboardheadinglocator  = "//p[contains(text(),'How to Get Started with')]" ;
	private String backgroundcolorlocator = "//div/a[@target=\"_blank\"]" ;

// Dashboard page Sidetab  	
	private String newAlagentLocator = "//div/a[contains(text(),'New AI Agent')]" ;
	private String dashboardLocator = "//span[contains(text(),'Dashboard')]";
	private String aiagentsLocator = "//span[contains(text(),'AI Agents')]";
	private String sidetabcontactusLocator = "//span[contains(text(),'Contact Us')]";
	private String resourcesLocator = "//span[contains(text(),'Resources')]";
	private String usermanualLocator = "//span[contains(text(),'User Manual')]";

// Dashboard page profile icon   	
	private String openprofileLocator = "//button[@aria-label=\"open profile\"]";
	private String myprofiletextlocator = "//span[contains(text(),'My Profile')]";

	//a[@aria-label='Switch Organization']
	private String switchorgnizationlocator = "//a[@aria-label='Switch Organization']";
	private String profileLocator = "//span[contains(text(),'Profile')]";
	private String orgnizationLocator = "//span[contains(text(),'Organizations')]";
	private String contactusLocator = "//span[contains(text(),'Contact Us')]";
	private String logoutLocator = "//span[contains(text(),'Logout')]";
	private String logoutconfirmationLocator = "//button[contains(text(),'Yes')]";
	private String logoutcancelLocator = "//button[contains(text(),'No')]";
	private String logoutpopupextLocator = "//span[contains(text(),'Are you sure you want to logout?')]";

	
	

	 
//Dashboard Page UI	
	public  void dashboardheading ( ) 
	{
		waitelement(dashboardheadinglocator); 
		WebElement Dashboardheading = driver.findElement(By.xpath(dashboardheadinglocator));
		assertTrue(Dashboardheading.isDisplayed(), "Dashboard header not visible");	
	}
	public  String getbackgroundcolor ( ) 
	{
		waitelement(backgroundcolorlocator); 
		WebElement Backgroundcolor = driver.findElement(By.xpath(backgroundcolorlocator));
		Backgroundcolor.getAttribute("color");
		String  colorcode = (Backgroundcolor.getAttribute("style"));
		Assert.assertTrue(colorcode.contains("rgb(255, 255, 255)"));
		return colorcode;
	}
	
//Dashboard Page link	
	
	public  void dashboardcreateaiagentclick ( ) 
	{
		waitelement(dashboardcreateaiagentlocator); 
		WebElement Dashboardcreateaiagent = driver.findElement(By.xpath(dashboardcreateaiagentlocator));
		Dashboardcreateaiagent.click();		
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
	
//  Dashboard Chat bot
	public  void dashboardchatbot ( ) throws InterruptedException 
	{
		waitelement(dashboardchatbotlocator); 		
		WebElement Dashboardchatbot = driver.findElement(By.xpath(dashboardchatbotlocator));
		Dashboardchatbot.click();	
	}
	
	
	
// Dashboard Side Tab 
	public  void createnewAIagentsidetab ( ) 
	{
		waitelement(newAlagentLocator); 
		WebElement NewAlagenttab = driver.findElement(By.xpath(newAlagentLocator));
		NewAlagenttab.click();
	}
	
	
	public  void dashboardsidetab () 
	{
		waitelement(dashboardLocator); 
		WebElement Dashboardtab = driver.findElement(By.xpath(dashboardLocator));
		Dashboardtab.click();
	}
	
	public  void aiagentsidetab () 
	{
		waitelement(aiagentsLocator); 
		WebElement AIagenttab = driver.findElement(By.xpath(aiagentsLocator));
		AIagenttab.click();
	}
	
	public  void contactussidetab ( ) 
	{
		waitelement(sidetabcontactusLocator); 
		WebElement sidetabContactus = driver.findElement(By.xpath(sidetabcontactusLocator));
		sidetabContactus.click();
	}
	
	public  void resourcessidetab ( ) 
	{
		waitelement(resourcesLocator); 
		WebElement resourcessidetab = driver.findElement(By.xpath(resourcesLocator));
		resourcessidetab.click();
	}
	
	public  void usermanualsidetab ( ) 
	{
		waitelement(usermanualLocator); 
		WebElement Usermanualtab = driver.findElement(By.xpath(usermanualLocator));
		Usermanualtab.click();
	}
	
//	profile icon
	public  void profiledropdown ( ) 
	{
		waitelement(openprofileLocator); 
		WebElement Openprofileicon = driver.findElement(By.xpath(openprofileLocator));
		Openprofileicon.click();
	}
	
	public  String myprofiletext ( ) 
	{
		waitelement(myprofiletextlocator); 
		WebElement Myprofiletext = driver.findElement(By.xpath(myprofiletextlocator));
		String text = Myprofiletext.getText();
		return text;
	}

// Profile dropdown	
	public  void switchorgnizationclick ( ) 
	{
		profiledropdown();
		waitelement(switchorgnizationlocator); 
		WebElement Switchorgnization = driver.findElement(By.xpath(switchorgnizationlocator));
		Switchorgnization.click();
	}
	
	public  void profileclick ( ) 
	{
		profiledropdown();
		waitelement(profileLocator); 
		WebElement Profileclick = driver.findElement(By.xpath(profileLocator));
		Profileclick.click();
	}
	
	public  void orgnizationclick ( ) 
	{
		profiledropdown();
		waitelement(orgnizationLocator); 
		WebElement Orgnizationclick = driver.findElement(By.xpath(orgnizationLocator));
		Orgnizationclick.click();
	}
	
	public  void contactusclick ( ) 
	{
		profiledropdown();
		waitelement(contactusLocator); 
		WebElement Contactusclick = driver.findElement(By.xpath(contactusLocator));
		Contactusclick.click();
	}
	
	public  String logoutclick ( ) 
	{
		profiledropdown();
		waitelement(logoutLocator); 
		WebElement Logoutclick = driver.findElement(By.xpath(logoutLocator));
		Logoutclick.click();
		log.info("done");
		waitelement(logoutpopupextLocator); 
		WebElement confirmtext = driver.findElement(By.xpath(logoutpopupextLocator));
		String confirmation  = confirmtext.getText();
		return confirmation;
	}
	
	public  void logoutconfirm ( ) 
	{
		waitelement(logoutconfirmationLocator); 
		WebElement Logoutconfirmation = driver.findElement(By.xpath(logoutconfirmationLocator));
		Logoutconfirmation.click();
		
	}
	
	public  void logoutcancel ( ) 
	{
		waitelement(logoutcancelLocator); 
		WebElement Logoutcancel = driver.findElement(By.xpath(logoutcancelLocator));
		Logoutcancel.click();
	}
}