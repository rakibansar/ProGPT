package PageObjectProgpt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilityProgpt.BaseProgpt;

public class ResourcesPage extends BaseProgpt{
	
// icon redirection to correct page 
	   private String blogsredirectionlocator = "//img[@alt='Blogs']" ;
	   private String supportredirectionlocator = "//img[@alt='Support']" ;
	   private String usermanualredirectionlocator = "//img[@alt='User Manual']" ;
	   private String tutorialsredirectionlocator = "//img[@alt='Tutorials']" ;
       private String trustsecurityredirectionlocator = "//img[@alt='Trust & Security']" ;
	   private String pricingplanredirectionlocator = "//img[@alt='Pricing Plan']" ;
	
//	FAQ loators
	   private String faqitemslocator = "//div[@class='MuiButtonBase-root MuiAccordionSummary-root css-ybf2xc']" ;
	   private String faqquestionslocator = "//div[@class='MuiBox-root css-178yklu']/div/div/div/p" ;
	   private String faqanswerslocator = "//div[@class='MuiBox-root css-178yklu']/div/div/div/div/div" ;

	   
	   
   public  WebElement blogsredirection ( ) 
   {
		waitelement(blogsredirectionlocator); 
		WebElement Blogsredirection = driver.findElement(By.xpath(blogsredirectionlocator));
		return Blogsredirection;
   }
   
   public  WebElement supportredirection ( ) 
   {
		waitelement(supportredirectionlocator); 
		WebElement Supportredirection = driver.findElement(By.xpath(supportredirectionlocator));
		return Supportredirection;
   }
   
   public  WebElement usermanualredirection ( ) 
   {
		waitelement(usermanualredirectionlocator); 
		WebElement Usermanualredirection = driver.findElement(By.xpath(usermanualredirectionlocator));
		return Usermanualredirection;
   }
   
   public  WebElement tutorialsredirection ( ) 
   {
		waitelement(tutorialsredirectionlocator); 
		WebElement Tutorialsredirection = driver.findElement(By.xpath(tutorialsredirectionlocator));
		return Tutorialsredirection;
   }
   
   public  WebElement trustsecurityredirection ( ) 
   {
		waitelement(trustsecurityredirectionlocator); 
		WebElement Trustsecurityredirection = driver.findElement(By.xpath(trustsecurityredirectionlocator));
		return Trustsecurityredirection;
   }
   
   public  WebElement pricingplanredirection ( ) 
   {
		waitelement(pricingplanredirectionlocator); 
		WebElement Pricingplanredirection = driver.findElement(By.xpath(pricingplanredirectionlocator));
		return Pricingplanredirection;
   }
   
   public  List<WebElement> faqItemscount ( ) 
   {
		waitelement(faqitemslocator); 
	   List<WebElement> faqItems = driver.findElements(By.xpath(faqitemslocator)); 
	   return faqItems;
   }
   
   public  void  questionexpandandcollapse ( ) throws InterruptedException 
   {
		waitelement(faqquestionslocator); 
   List<WebElement> questions = driver.findElements(By.xpath(faqquestionslocator));
   List<WebElement> answers = driver.findElements(By.xpath(faqanswerslocator)); 
   Assert.assertEquals(questions.size(), answers.size(), "Mismatch in number of questions and answers");

        for (int i = 0; i < questions.size(); i++)
        {
			WebElement question = questions.get(i);
			WebElement answer = answers.get(i);

			// Click to expand
			question.click();
			Thread.sleep(1000);
			Assert.assertTrue(answer.isDisplayed(),"❌ FAQ answer is not visible after expanding: " + question.getText());

			// Click to collapse
			question.click();
			Thread.sleep(1000);
			Assert.assertFalse(answer.isDisplayed(), "❌ FAQ answer is still visible after collapsing: " + question.getText());
         }
     }
   
  
}
