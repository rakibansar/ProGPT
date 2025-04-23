package PageObjectProgpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UtilityProgpt.BaseProgpt;


public class AIAgentslistPage extends BaseProgpt {
	
    // Search Agent
	private String searchagentlocator = "//input[@name=\"search_data\"]";
	
	// Delete Agent
	private String deleteagentlocator = "//div[@data-testid=\"Delete\"]";
	private String deleteagentconfirmationlocator = "//button[contains(text(),'Delete')]";
	private String deleteconfirmationpopuplocator = "//div[@class=\"SnackbarItem-message\"]";

	private String knowledgebaselocator = "//a[@aria-label=\"Knowledge base\"]";
	private String agentdeploylocator = "//div/a[@aria-label=\"Deploy\"]";
	private String agentsettinglocator = "//div/a[@aria-label=\"Setting\"]";
	private String newcoversationlocator = "//div[contains(text(),'New Conversation')]";
	
	
	
	public  void searchagent (String text ) 
	{
		waitelement(searchagentlocator); 
		WebElement Searchagent = driver.findElement(By.xpath(searchagentlocator));
		Searchagent.sendKeys(text);
	}
	

	public  void knowledgebase ( ) 
	{
		waitelement(knowledgebaselocator); 
		WebElement Knowledgebase = driver.findElement(By.xpath(knowledgebaselocator));
		Knowledgebase.click();
	}
	
	public  void agentdeploy ( ) 
	{
		waitelement(agentdeploylocator); 
		WebElement Agentdeploy = driver.findElement(By.xpath(agentdeploylocator));
		Agentdeploy.click();
	}
	
	public  void Agentsetting ( ) 
	{
		waitelement(agentsettinglocator); 
		WebElement Agentsetting = driver.findElement(By.xpath(agentsettinglocator));
		Agentsetting.click();
	}
	
	public  void deleteagent ( ) 
	{
		waitelement(deleteagentlocator); 
		WebElement Deleteagent = driver.findElement(By.xpath(deleteagentlocator));
		Deleteagent.click();
		waitelement(deleteagentconfirmationlocator); 
		WebElement Deleteagentconfirmation = driver.findElement(By.xpath(deleteagentconfirmationlocator));
		Deleteagentconfirmation.click();
	}
	
	public  String  deleteconfirmationtext ( ) 
	{
		waitelement(deleteconfirmationpopuplocator); 
		WebElement Deleteconfirmationpopup = driver.findElement(By.xpath(deleteconfirmationpopuplocator));
		String deletetext = Deleteconfirmationpopup.getText();
		return deletetext;
	}
	
	public  void newcoversation ( ) 
	{
		waitelement(newcoversationlocator); 
		WebElement Newcoversation = driver.findElement(By.xpath(newcoversationlocator));
		Newcoversation.click();
	}
	
}