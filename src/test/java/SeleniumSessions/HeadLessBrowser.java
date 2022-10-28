package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class HeadLessBrowser {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        //html unit driver is not available in Selenium
        //html unit driver -- to use this concept, we have to add it dependency in our pom.xml

        //advantages:
        //1. testing is happening behind the scene -- no browser is launched
        //2. very fast -- execution of test cases -- very fast -- performance of the script
        //3. not suitable for Action class -- user actions -- mouse movement, double click, drag and drop
        //4. Ghost Driver -- Headless Browser:
            //--HtmlUnitDriver -- Java
            //--PhantomJS -- JavaScript

        //By HtmlUnitDriver
        //WebDriver driver = new HtmlUnitDriver();

        //By ChromeDriver
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--headless");
//        WebDriver driver = new ChromeDriver(co);

        //By FirefoxDriver
//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions fo = new FirefoxOptions();
//        fo.addArguments("--headless");
//        WebDriver driver = new FirefoxDriver(fo);

        //incognito mode
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(co);


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        System.out.println("Before login, title is:== " + driver.getTitle());

        By username = By.name("username");
        By password = By.name("password");
        driver.findElement(username).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(RelativeLocator.with(By.tagName("button")).below(password)).click();

        System.out.println("After login, title is:== " + driver.getTitle());
    }
}