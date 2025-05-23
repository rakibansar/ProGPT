package UtilityProgpt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
import org.openqa.selenium.chrome.ChromeOptions;
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

             ChromeOptions options = new ChromeOptions();
            // Optional: Run in headless mode
//            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu"); // (optional but useful)
            options.addArguments("--remote-allow-origins=*"); // if needed for CORS issues
            driver = new ChromeDriver(options);
            break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    public static void webURL(String weburl) throws InterruptedException {
        driver.get(weburl);
        System.out.println("WEB url " + weburl);
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void waitelement(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static String screenShot(String filename) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }

    public static void switchwindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String mainHandle = iterator.next();
        String subHandle = iterator.hasNext() ? iterator.next() : null;

        if (subHandle != null) {
            driver.switchTo().window(subHandle);
        }
    }
}
