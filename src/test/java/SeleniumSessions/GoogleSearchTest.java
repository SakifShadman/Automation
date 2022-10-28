package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GoogleSearchTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("java");

        List<WebElement> list =
                driver.findElements(By.xpath("//ul[@class='erkvQe']//li//div[@class='wM6W7d']"));

        System.out.println("total number of suggestions in search box:::===> " + list.size());

        for (WebElement element : list) {
            String name = element.getText();
            System.out.println(name);
            if (name.equals("javascript")) {
                element.click();
                break;
            }
        }
    }
}