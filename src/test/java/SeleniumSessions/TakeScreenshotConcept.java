package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotConcept {
    public static void main(String[] args) throws IOException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com");

        String path = "src/test/java/SeleniumSessions/";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(path + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(screenshot, destFile);
    }
}