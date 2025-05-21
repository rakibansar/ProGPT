package PageObjectProgpt;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilityProgpt.BaseProgpt;


public class AIAgentslistPage extends BaseProgpt {
	  // Search Agent
		private String searchagentlocator = "//input[@name=\"search_data\"]";
		private String agentlistlocator = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 css-1ym32mv']";
		private String emptyagentlistlocator = "//span[contains(text(),'No agent found')]";

	 // ORG label
		private String orgownerlabelocator = "(//h4[contains(text(),'org owner')])[1]";
		
	 // Link Redirection 
		private String newcoversationlocator = "//div[contains(text(),'New Conversation')]";
		private String knowledgebaselocator = "//a[@aria-label='Knowledge base']";
		private String agentdeploylocator = "//div/a[@aria-label='Deploy']";
		private String agentsettinglocator = "//div/a[@aria-label=\"Setting\"]";

	 // Delete Agent
		private String deleteagentlocator = "//div[@data-testid=\"Delete\"]";
		private String deleteagentconfirmationlocator = "//button[contains(text(),'Delete')]";
		private String deleteconfirmationpopuplocator = "//div[@class=\"SnackbarItem-message\"]";

	
	
//  Search Agent 
	public  WebElement searchagent ( ) 
	{
		waitelement(searchagentlocator); 
		WebElement Searchagent = driver.findElement(By.xpath(searchagentlocator));
		return Searchagent;
	}
	
// Agent Search list and if no Agent Found 
	public List<WebElement> agentlist() 
	{	
		int i= 0;
		try 
	    {
	 	    WebElement emptyagentlist = driver.findElement(By.xpath(emptyagentlistlocator));
	     	if (emptyagentlist.isDisplayed())  
	     	 {   
	   	        i=1;
	   	        log.info("No Agent found");
	    	 } 		
	    }     catch (Exception e) {}
     	if (i==0)
			  waitelement(agentlistlocator);
	  	      List<WebElement> agentlistlisting = driver.findElements(By.xpath(agentlistlocator));  		  
	  	      return agentlistlisting ;
	}

// Agent List By Search 
	public void agentlistname() throws InterruptedException 
	{
	    String[] searchTerms = {"recrawl", "filepdf","efgrhmdtsetwf"};
	    for (String term : searchTerms) 
	    {
	    	searchagent().sendKeys(Keys.CONTROL + "a");
	    	searchagent().sendKeys(Keys.DELETE);
	    	searchagent().sendKeys(term);
	        Thread.sleep(1000);       
	        List<WebElement> agents = agentlist(); 
	        	 
			 for (WebElement agent : agents) 
			 {
				String name = agent.getText().toLowerCase().trim();
	        	Assert.assertTrue(name.contains(term.toLowerCase()),
	        	      "Agent '" + name + "' does not match search term '" + term + "'"); 
	        	log.info("Agent Found: " );
	         }
		 }	    
	}

// Org label
	public WebElement orgownerlabel() 
	{
		waitelement(orgownerlabelocator);
		WebElement orgOwnerLabel = driver.findElement(By.xpath(orgownerlabelocator));
	    return  orgOwnerLabel ; 
	}
	
	
// Link redirection 
	public  WebElement newcoversation ( ) 
	{
		waitelement(newcoversationlocator); 
		WebElement Newcoversation = driver.findElement(By.xpath(newcoversationlocator));
		return Newcoversation;
	}
	
	public  WebElement knowledgebase ( ) 
	{
		waitelement(knowledgebaselocator); 
		WebElement Knowledgebase = driver.findElement(By.xpath(knowledgebaselocator));
		return Knowledgebase;
	}
	
	public  WebElement agentdeploy ( ) 
	{
		waitelement(agentdeploylocator); 
		WebElement Agentdeploy = driver.findElement(By.xpath(agentdeploylocator));
		return Agentdeploy;
	}
	
	public  WebElement Agentsetting ( ) 
	{
		waitelement(agentsettinglocator); 
		WebElement Agentsetting = driver.findElement(By.xpath(agentsettinglocator));
		return Agentsetting;
	}
	
//	Delete Agent 
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
	
	
	
}