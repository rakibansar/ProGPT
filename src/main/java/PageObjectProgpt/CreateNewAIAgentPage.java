package PageObjectProgpt;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UtilityProgpt.BaseProgpt;

public class CreateNewAIAgentPage extends BaseProgpt {

	private String agentnamelocator = "(//div/input)[1]";
	private String selectchatversionlocator = "//div/label/span[2]";
	private String nextbuttonlocator = "//span[contains(text(),'Next')]";
	
	private String clickfileslocator = "//span[contains(text(),'Files')]";
	private String clicktouploadlocator = "input[type='file'][data-testid='file_support']";
	
	private String clickURLlocator = "(//div/span[contains(text(),'URL')])[1]";
	private String enterweburllocator = "//input[@name=\"web_url\"]";
	private String savebuttonlocator = "//button[contains(text(),'Save')]";
	
	private String duplicatealertlocator = "//div[@role=\"alert\"]";


	
	
// Agent Details
	
	public  void enteragentname ( ) 
	{
		waitelement(agentnamelocator); 
		WebElement Agentname = driver.findElement(By.xpath(agentnamelocator));
		Agentname.sendKeys("chat123");
	}
	
	public  void selectchatversion ( ) 
	{
		waitelement(selectchatversionlocator); 
		WebElement Selectchatversion = driver.findElement(By.xpath(selectchatversionlocator));
		Selectchatversion.click();
	}
	
	public  void nextbutton ( ) 
	{
		waitelement(nextbuttonlocator); 
		WebElement Nextbutton = driver.findElement(By.xpath(nextbuttonlocator));
		Nextbutton.click();
	}
	
//Knowledge Base 
	
	public  void clickfiles ( ) 
	{
		waitelement(clickfileslocator); 
		WebElement Clickfiles = driver.findElement(By.xpath(clickfileslocator));
		Clickfiles.click();
	}
	
	public  void clicktoupload ( ) 
	{
		waitelement(clicktouploadlocator); 
		WebElement Clicktoupload = driver.findElement(By.cssSelector(clicktouploadlocator));
		String filePath = "C:\\Users\\Rakib\\eclipse-workspace\\Progpttest\\TestData\\Screenshot_9.png";
		Clicktoupload.sendKeys(filePath);
	}
	
	
	public  void clickurl ( ) 
	{
		waitelement(clickURLlocator); 
		WebElement clickURL = driver.findElement(By.xpath(clickURLlocator));
		clickURL.click();
	}
	
	public  void enterweburl ( ) 
	{
		waitelement(enterweburllocator); 
		WebElement Enterweburl = driver.findElement(By.xpath(enterweburllocator));
		Enterweburl.sendKeys("https://progpt.biz/sitemap.xml");
	}
	
	public  void savebutton ( ) 
	{
		waitelement(savebuttonlocator); 
		WebElement Savebutton = driver.findElement(By.xpath(savebuttonlocator));
		Savebutton.click();
	}
	
	public  void compareduplicateagent ( ) 
	{
		waitelement(duplicatealertlocator); 
		WebElement Duplicatealert = driver.findElement(By.xpath(duplicatealertlocator));
		String duplicateerror = Duplicatealert.getText();
		String expectedduplicateerror = "Agent name already exists. Please try another name";
		if(duplicateerror.equals(expectedduplicateerror))
		{
			DashboardPage dashboardpage = new DashboardPage();
			dashboardpage.aiagenttab();
			AIAgentslistPage aiagentspage = new AIAgentslistPage();
			aiagentspage.searchagent ("chat123") ;
			aiagentspage.deleteagent ( );
			dashboardpage = new DashboardPage();
		    dashboardpage.createnewAIagent();
		    enteragentname();
		    selectchatversion();
		    nextbutton();
		    clickurl();
		    enterweburl();
		    savebutton();
		}
		else {
			
		}
		
	}
	
	//*[contains(text(),'Agent name already exists. Please try another name')]
	
}