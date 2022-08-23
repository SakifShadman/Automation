package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //get() vs navigate().to()
        //get() are used to launch the url
        //navigate().to() used to launch the external url

        driver.get("https://www.google.com");

        driver.navigate().to("https://www.amazon.com");

        //back and forward buttons simulation:
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().back();

        driver.navigate().refresh();
    }
}