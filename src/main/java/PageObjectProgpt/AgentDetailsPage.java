package PageObjectProgpt;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UtilityProgpt.BaseProgpt;


public class AgentDetailsPage extends BaseProgpt {

	private String agentdetailstextlocator = "//span[contains(text(),'Agent Details')]";
	private String knowledgebasetextlocator = "//div[@class=\"MuiBox-root css-hasfov\"]";
	private String conversationscreentextlocator = "//h6[@class=\"MuiTypography-root MuiTypography-h6 css-m50ydm\"]";

	private String sharelinklocator = "//button[contains(text(),'Share Link')]";
	private String sharelinkurllocator = "//input[@name='link']";
	private String enablelinklocator = "//span[@class=\"MuiSwitch-track css-114i81k\"]";
	private String sharelinksendmessagelocator = "//textarea[@placeholder=\"Send a message\"]";
	private String sharelinksendlocator = "//div/img[@alt=\"send\"]";
	private String messageresponselocator = "(//div/p)[2]";

	
	private String embedonwebsitelocator = "//button[contains(text(),'Embed on Website')]";
	private String integratewithplateformlocator = "//button[contains(text(),'Integrate With Platforms')]";

//  Get text for Ai agentlist  assertion Knowledge base And Deploy Setting agentdetails And Conversation .
	public String knowledgebasetext() {
		waitelement(knowledgebasetextlocator);
		WebElement knowledgebasetext = driver.findElement(By.xpath(knowledgebasetextlocator));
		String knowledge = knowledgebasetext.getText();
		return knowledge;

	}

	// Deploy assertion
	public String sharelinktext() {
		waitelement(sharelinklocator);
		WebElement Sharelink = driver.findElement(By.xpath(sharelinklocator));
		String Sharelinktext = Sharelink.getText();
		return Sharelinktext;

	}

	// Setting agentdetails
	public String agentdetailstext() {
		waitelement(agentdetailstextlocator);
		WebElement Sharelink = driver.findElement(By.xpath(agentdetailstextlocator));
		String Agentdetailstext = Sharelink.getText();
		return Agentdetailstext;

	}

	// Conversation screen
	public String conversationscreentext() {
		waitelement(conversationscreentextlocator);
		WebElement Conversationscreentext = driver.findElement(By.xpath(conversationscreentextlocator));
		String conversationscreentext = Conversationscreentext.getText();
		return conversationscreentext;

	}

//  Deploy Button Share Embed Integration 
	public void sharelink() {
		waitelement(sharelinklocator);
		WebElement Sharelink = driver.findElement(By.xpath(sharelinklocator));
		Sharelink.click();

	}

//  Share Link get URL or turn on toggle and get URL 
	public String Sharelinkgeturl() throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebElement Sharelinkurl = driver.findElement(By.xpath(sharelinkurllocator));
			if (Sharelinkurl.isDisplayed()) 
			{
//				String sharelinkurl = Sharelinkurl.getAttribute("value");
//				System.out.println(sharelinkurl);
			}  
			else 
			{
				Thread.sleep(1000);
				waitelement(enablelinklocator);
				WebElement Enablelink = driver.findElement(By.xpath(enablelinklocator));
				Enablelink.click();				
				Thread.sleep(1000);
			}
		} catch (NoSuchElementException e) {

		}
		waitelement(sharelinkurllocator);
		WebElement enabledSharelinkurl = driver.findElement(By.xpath(sharelinkurllocator));
		String sharelinkurl = enabledSharelinkurl.getAttribute("value" );
		System.out.println(sharelinkurl);
		return sharelinkurl;

	}
	
	public void sharelinksendmessage() 
	{
		waitelement(sharelinksendmessagelocator);
		WebElement Sharelinksendmessage = driver.findElement(By.xpath(sharelinksendmessagelocator));
		Sharelinksendmessage.sendKeys("hii");

		waitelement(sharelinksendlocator);
		WebElement Sharelinksend = driver.findElement(By.xpath(sharelinksendlocator));
		Sharelinksend.click();
	}
	
	public String messageresponse() throws InterruptedException 
	{

		waitelement(messageresponselocator);
		WebElement Messageresponse = driver.findElement(By.xpath(messageresponselocator));
		System.out.println(Messageresponse.getText());
		Thread.sleep(4000);
		return Messageresponse.getText();
	}
	public void embedonwebsite() {
		waitelement(embedonwebsitelocator);
		WebElement Embedonwebsite = driver.findElement(By.xpath(embedonwebsitelocator));
		Embedonwebsite.click();

	}

	public void integratewithplateform() {
		waitelement(integratewithplateformlocator);
		WebElement Integratewithplateform = driver.findElement(By.xpath(integratewithplateformlocator));
		Integratewithplateform.click();
	}

}