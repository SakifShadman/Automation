package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.spicejet.com/"); //enter url

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"))).build().perform();

        Thread.sleep(3000);

        driver.findElement(By.linkText("SpicePlus")).click();
    }
}