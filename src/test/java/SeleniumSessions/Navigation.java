package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //get() vs navigate().to()
        //get() are used to launch the url
        //navigate().to() used to launch the external url

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        driver.get("https://www.amazon.com");
        //driver.navigate().to("https://www.amazon.com");
        System.out.println(driver.getTitle());

        //back and forward buttons simulation:
        driver.navigate().back();
        System.out.println(driver.getTitle());

        //Thread.sleep(3000);

        driver.navigate().forward();
        System.out.println(driver.getTitle());

        //Thread.sleep(3000);

        driver.navigate().back();
        System.out.println(driver.getTitle());

        driver.navigate().refresh();
        System.out.println(driver.getTitle());

        //Thread.sleep(3000);

        driver.quit();
    }
}