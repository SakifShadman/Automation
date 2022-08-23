package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkTest {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://makemysushi.com/404");

        /*
        driver.navigate().to("https://opensource-demo.orangehrmlive.com");
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        */


        //1. get the list of all the links and image:
        List<WebElement> list = driver.findElements(By.tagName("a"));
        list.addAll(driver.findElements(By.tagName("img")));

        System.out.println("size of full links and images---> " + list.size());

        List<WebElement> activeLinks = new ArrayList<>();


        //2. iterate list: exclude all the links/images - does not have any href attribute
        for (WebElement element : list) {
            System.out.println(element.getAttribute("href"));
            if (element.getAttribute("href") != null && (!element.getAttribute("href").contains("javascript"))) {
                activeLinks.add(element);
            }
        }

        //get the size of active links list:
        System.out.println("size of active links and images---> " + activeLinks.size());


        //3. check the href url, with http-connection api:
        //200 -- Ok
        //400 -- bad request
        //404 -- not found
        //500 -- internal error
        for (WebElement element: activeLinks) {
            HttpURLConnection connection = (HttpURLConnection)new URL(element.getAttribute("href")).openConnection();

            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(element.getAttribute("href") + "---> " + response);
        }
    }
}