package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.Duration;

public class HtmlUnitDriverConcept {
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

        WebDriver driver = new HtmlUnitDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        System.out.println("Before login, title is:== " + driver.getTitle());

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(5000);

        System.out.println("After login, title is:== " + driver.getTitle());
    }
}