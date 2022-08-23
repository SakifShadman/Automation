package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameHandling {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement iFrameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);

        WebElement element = driver.findElement(By.id("tinymce"));
        element.clear();
        element.sendKeys("This is a test");
    }
}
