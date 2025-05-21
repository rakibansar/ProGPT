package PageObjectProgpt;



import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilityProgpt.BaseProgpt;

public class CreateNewAIAgentPage extends BaseProgpt {

//	Agent Details page (createAl agent)
	private String agentnamelocator = "(//div/input)[1]";
	private String modeltypedropdownlocator = "//div[@data-testid=\"model_type-select\"]";
	private String selectchatversionlocator = "//div/label/span[2]";
	private String allradiobuttonlocator = "//*[@role='radiogroup']/label";
	private String nextbuttonlocator = "//span[contains(text(),'Next')]";
	
//	Knowledge Base  page (createAl agent)
	
	private String knowledgebaseheadingtextlocator = "//span[contains(text(),'Knowledge Base')]";
	private String resourceradiolocator = "//h6[contains(text(),'Resource')]";
	private String dbconnectionradiolocator = "//h6[contains(text(),'Database Connection')]";
	private String bydefaultselectedradiolocator = "(//label/span)[1]";

	private String clickfileslocator = "//span[contains(text(),'Files')]";
	private String clicktouploadlocator = "input[type='file'][data-testid='file_support']";
	private String clickURLlocator = "(//div/span[contains(text(),'URL')])[1]";
	private String enterweburllocator = "//input[@name=\"web_url\"]";
	private String savebuttonlocator = "//button[contains(text(),'Save')]";
	private String previousbuttonlocator = "//span[contains(text(),'Previous')]";

	private String duplicatealertlocator = "//div[@role=\"alert\"]";


	
	
// Agent Details
	
	public  WebElement enteragentname ( ) 
	{
		waitelement(agentnamelocator); 
		WebElement Agentname = driver.findElement(By.xpath(agentnamelocator));
		
		return Agentname;
	}
	
	public  WebElement modeltypedropdown ( ) 
	{
		waitelement(modeltypedropdownlocator); 
		WebElement Modeltypedropdown = driver.findElement(By.xpath(modeltypedropdownlocator));
		return Modeltypedropdown;
	}
	
	public  void allradiobutton ( ) throws InterruptedException 
	{
              String[] expectedModels = 
             {
            	"OpenAI GPT-4.o Preview",
                "OpenAI GPT-4.o Mini",
                "OpenAI GPT-o.1 Preview" ,
                "OpenAI GPT-o.1 Mini",
                "Azure OpenAI GPT-4.o Preview",
                "Azure OpenAI GPT-4.o Mini",
                "Titan Text G1 - Express",
                "Claude 3 Sonnet",    
                "Claude 3.5 Haiku",
                "Claude 3.5 Sonnet",
                "Claude 3 Opus"        
             };
    
        for (String model : expectedModels) 
        {
			waitelement("//*[contains(text(),'" + model + "')]");
			WebElement modelElement = driver.findElement(By.xpath("//*[contains(text(),'" + model + "')]"));
			Assert.assertTrue(modelElement.isDisplayed(), model + " radio button is not visible.");
			Assert.assertTrue(modelElement.isEnabled(), model + " radio button is not clickable.");
			log.info(model + " radio button is visible and clickable.");
        }  
	}
	
	
	public void UserCanSelectModelRadioButton() 
	{
		waitelement(allradiobuttonlocator); 
	    List<WebElement> radios = driver.findElements(By.xpath(allradiobuttonlocator));
	    for (WebElement radio : radios) 
	    {
	    	radio.click();
			Assert.assertTrue(radio.getText().contains("Selected"), " radio button is not clickable.");
			System.out.println(radio.getText());
	    }
	    
	}
	
	public  void selectradiochatversion ( ) 
	{
		waitelement(selectchatversionlocator); 
		WebElement Selectchatversion = driver.findElement(By.xpath(selectchatversionlocator));
		Selectchatversion.click();
	}
	
	public   WebElement   nextbutton  ( ) 
	{
		waitelement(nextbuttonlocator); 
		WebElement Nextbutton = driver.findElement(By.xpath(nextbuttonlocator));
		return Nextbutton;	
	}
	
//Knowledge Base 
	
	
	public  WebElement knowledgebaseheadingtext ( ) 
	{
		waitelement(knowledgebaseheadingtextlocator); 
		WebElement Knowledgebaseheadingtext = driver.findElement(By.xpath(knowledgebaseheadingtextlocator));
		return Knowledgebaseheadingtext;
	}
	
	public  WebElement clickfiles ( ) 
	{
		waitelement(clickfileslocator); 
		WebElement Clickfiles = driver.findElement(By.xpath(clickfileslocator));
		return Clickfiles;
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
	
	
	
// Knowledge Base Locator 
	
	public  WebElement resourceradio ( ) 
	{
		waitelement(resourceradiolocator); 
		WebElement Resourceradio = driver.findElement(By.xpath(resourceradiolocator));
		return Resourceradio;
	}

	public  WebElement dbconnectionRadio ( ) 
	{
		waitelement(dbconnectionradiolocator); 
		WebElement DBConnectionRadio = driver.findElement(By.xpath(dbconnectionradiolocator));	
		return DBConnectionRadio;
	}
	
	public  WebElement bydefaultselectedradio ( ) 
	{
		waitelement(bydefaultselectedradiolocator); 
		WebElement Bydefaultselectedradio = driver.findElement(By.xpath(bydefaultselectedradiolocator));	
		return Bydefaultselectedradio;
	}
		
	public  void resourcetypes ( )   
	{
		List<String> expectedResources = Arrays.asList("Files", "URL", "Confluence", "Site Map", "Amazon S3");

	      for (String resource : expectedResources) 
	      {
	          // Adjust the locator to fit your actual UI (e.g., use xpath or class name if necessary)
	          WebElement element = driver.findElement(By.xpath("//*[text()='" + resource + "']"));
	 	      Assert.assertTrue(element.isDisplayed(), resource + " option is not visible");
	 	      log.info(resource + " option is  visible");
	      }
	}
	  
	public  WebElement previousbutton ( ) 
	{
		waitelement(previousbuttonlocator); 
		WebElement Previousbutton = driver.findElement(By.xpath(previousbuttonlocator));	
		return Previousbutton;
	}
	
	public  WebElement savebutton ( ) 
	{
		waitelement(savebuttonlocator); 
		WebElement Savebutton = driver.findElement(By.xpath(savebuttonlocator));
		return Savebutton;
	}
	
	public  void compareduplicateagent ( )   
	{
		waitelement(duplicatealertlocator); 
		WebElement Duplicatealert = driver.findElement(By.xpath(duplicatealertlocator));
		String duplicateerror = Duplicatealert.getText();
		String expectedduplicateerror = "Agent name already exists. Please try another name";
		if(duplicateerror.equals(expectedduplicateerror))
		{	
			Assert.assertTrue(duplicateerror.contains
				(expectedduplicateerror),"duplicae Agent doesn't exits");	
		    log.info(" Unable to create duplicate , Agent name already exists. Please try another name ");
			DashboardPage dashboardpage = new DashboardPage();
			dashboardpage.aiagentsidetab();
			AIAgentslistPage aiagentspage = new AIAgentslistPage();
			aiagentspage.searchagent(). sendKeys("chat123");
			aiagentspage.deleteagent ( );
		    log.info(" chat123 deleted Successfully ");
		    dashboardpage.createnewAIagentsidetab();
		    enteragentname().sendKeys("Chat123");;
		    nextbutton().click();
		    savebutton().click();
		   }
		else {
			
		}
		
	}
		
}