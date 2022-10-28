package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitConcept {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.facebook.com");

        //clickOn(driver, driver.findElement(By.xpath("//a[contains(text(),'Create a Page')]")), Duration.ofSeconds(20));

        explicitWait(driver, By.xpath("//a[contains(text(),'Create a Page')]"), 20);
    }

    /*public static void clickOn(WebDriver driver, WebElement locator, Duration timeout) {
        new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }*/

    public static void explicitWait(WebDriver driver, By locator, int duration) {
       new WebDriverWait(driver, Duration.ofSeconds(duration))
               .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}