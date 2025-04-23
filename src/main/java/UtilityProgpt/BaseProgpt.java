package UtilityProgpt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseProgpt extends PropertyProgpt {
	
    public static Logger log = LogManager.getLogger(BaseProgpt.class);


	public static WebDriver driver;

	
	public static void launchbrowser(String browserName) throws IOException {
		readdata();
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		}
	}

	public static void webURL(String weburl) throws InterruptedException {
//	Log.startTestCase("launched browser " + weburl);
		driver.get(weburl);
		System.out.println("WEB url " + weburl);
	}

	public void quit()   
	{
		driver.quit();
	}

	public static void waitelement(String path) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

	}
	
	public static String screenShot( String filename) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_"  + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
		
	}
	
	public static void switchwindow( ) 
	{
		Set<String> Windowhandles = driver.getWindowHandles();
		Iterator<String> iterator = Windowhandles.iterator();
		String mainhandle = iterator.next();
		String Subhandle  = iterator.next();
		driver.switchTo().window(Subhandle);

	}
	
	
}