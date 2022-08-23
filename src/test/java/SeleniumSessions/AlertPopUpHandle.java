package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertPopUpHandle {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click(); //click on click me button

        Thread.sleep(5000); //it will wait 5 secs before click the ok on alert button

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        String text = alert.getText();

        //validation
        if (text.equals("You clicked a button")) {
            System.out.println("correct alert message");
        }
        else {
            System.out.println("in-correct alert message");
        }

        alert.accept(); //click on OK button
        //alert.dismiss(); //click on CANCEL button
    }
}