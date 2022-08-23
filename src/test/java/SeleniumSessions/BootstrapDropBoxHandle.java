package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BootstrapDropBoxHandle {
    WebDriver driver;

    @Test
    public void bootstrap() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

        List<WebElement> list =
                driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));

        System.out.println(list.size());

        //selecting all the checkboxes/options
        for (WebElement element : list) {
            System.out.println(element.getText());
            element.click();
        }

        /*
        //selecting Angular option
        for (WebElement element : list) {
            System.out.println(element.getText());
            if (element.getText().equals("Angular")) {
                element.click();
                break;
            }
        }
        */
    }
}