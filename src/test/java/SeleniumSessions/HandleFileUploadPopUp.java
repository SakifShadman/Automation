package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFileUploadPopUp {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/upload-download");

        //type="file" should be present for Browse/AttachFile/UploadFile buttons
        driver.findElement(By.cssSelector("#uploadFile")).sendKeys("C://Users//arnob//Pictures//Screenshot.png");
    }
}