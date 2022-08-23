package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindowPopUp {
    public static void main(String[] args) throws InterruptedException {

        //1. Alerts -- JavaScript Pop Up -- Alert API (accept, dismiss)
        //2. File upload pop up -- Browse Button (type = file, sendKeys(path))
        //3. Browse window pop up -- Advertisement pop up (windowHandler API - getWindowHandles())

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.cssSelector("#windowButton")).click();

        Thread.sleep(3000);

        Set<String> handler = driver.getWindowHandles();

        Iterator<String> it = handler.iterator();

        String parentWindowId = it.next();
        System.out.println("Parent window id: " + parentWindowId);

        String childWindowId = it.next();
        System.out.println("Child window id: " + childWindowId);

        driver.switchTo().window(childWindowId);

        Thread.sleep(3000);

        System.out.println("Child window pop up title: " + driver.getTitle());

        driver.close(); //close specified windows where is the controller
        //driver.quit(); //close all the windows

        driver.switchTo().window(parentWindowId);

        Thread.sleep(3000);

        System.out.println("Parent window pop up title: " + driver.getTitle());
    }
}