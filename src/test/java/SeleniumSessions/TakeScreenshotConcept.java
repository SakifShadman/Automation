package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotConcept {
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com");

        //Take screenshot and store as a file format
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //now copy the screenshot to desired location using copyFile/method
        FileUtils.copyFile(src, new File("C:/Users/arnob/IdeaProjects/AutomationYoutube/src/test/java/SeleniumSessions/google.png"));
    }
}