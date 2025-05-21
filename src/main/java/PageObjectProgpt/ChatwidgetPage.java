package PageObjectProgpt;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UtilityProgpt.BaseProgpt;

public class ChatwidgetPage extends BaseProgpt{
	// Search Agent
				private String chatheadinglocator = "//span[@id=\"progpt_heading\"]";
				private String refreshiconlocator = "//*[@id=\"progpt_refresh-icon\"]";
				private String chatdropdowniconlocator = "//div[@id=\"progpt_cross-icon\"]";
				private String brandinglocator = "//span[contains(text(),'Powered by')]//following-sibling::span";

   // Message locator
				private String chatbotiframelocator = "//iframe[@id='progpt_iframe']";

				private String intialmessagelocator = "//h6[contains(text(),'Hey! How can I assist you today?')]";
				private String sendmessageboxlocator = "//textarea[@placeholder='Send a message']";
				private String sendmessageiconlocator = "//img[@alt='send']/parent::div";

				private String hiiresponselocator = "//p[contains(text(),' How can I assist you today?')]";
				private String randomtextresponselocator = "//p[contains(text(),'There is no information related to')]";

				
	public String chatheadingtextvisible() 
	{
		waitelement(chatheadinglocator);
		WebElement Dashboardchatbotheadingtext = driver.findElement(By.xpath(chatheadinglocator));
		String chatbotheadingtext = Dashboardchatbotheadingtext.getText();
		return chatbotheadingtext;
	}

	public void refreshiconclick() 
	{
		waitelement(refreshiconlocator);
		WebElement Refreshicon = driver.findElement(By.xpath(refreshiconlocator));
		Refreshicon.click();
	}

	public void chatdropdowniconclick() 
	{
		waitelement(chatdropdowniconlocator);
		WebElement Chatdropdowniconclick = driver.findElement(By.xpath(chatdropdowniconlocator));
		Chatdropdowniconclick.click();
	}

	public String brandingtext() 
	{
		waitelement(brandinglocator);
		WebElement Brandingtext = driver.findElement(By.xpath(brandinglocator));
		return Brandingtext.getText();
	}

//	Message response
	public String intialmessage() 
	{
		waitelement(intialmessagelocator);
		WebElement Intialmessage = driver.findElement(By.xpath(intialmessagelocator));
		return Intialmessage.getText();

	}

	public void Sendmessage(String text) throws InterruptedException 
	{
		waitelement(sendmessageboxlocator);
		WebElement Sendmessage = driver.findElement(By.xpath(sendmessageboxlocator));
		Sendmessage.sendKeys(text);
		Thread.sleep(2000);

	}

	public void sendmessageiconclick() 
	{
		waitelement(sendmessageiconlocator);
		WebElement Sendmessageiconclick = driver.findElement(By.xpath(sendmessageiconlocator));
		boolean isDisabled = Sendmessageiconclick.getAttribute("class").contains("disabled");
		if (isDisabled) {
			log.info("Send message icon is disabled, so it won't be clicked.");
		} else {
			Sendmessageiconclick.click();
		}
	}

	public String hiiresponse() 
	{
		waitelement(hiiresponselocator);
		WebElement Hiiresponse = driver.findElement(By.xpath(hiiresponselocator));
		String response = Hiiresponse.getText();
		return response;
	}
	
	public String randomtextresponse() 
	{
		waitelement(randomtextresponselocator);
		WebElement Randomtextresponse = driver.findElement(By.xpath(randomtextresponselocator));
		String response = Randomtextresponse.getText();
		return response;
	}
	
	
//	Switch Frame
	public void movetochatbotframe() 
	{
		  driver.switchTo().defaultContent();

			waitelement(chatbotiframelocator);
			driver.switchTo().frame(driver.findElement(By.xpath(chatbotiframelocator)));           
	}
	
	public void movetochatbotheaderframe() 
	{
		waitelement(chatbotiframelocator);
		driver.switchTo().frame(driver.findElement(By.xpath(chatbotiframelocator)));
	}
}


