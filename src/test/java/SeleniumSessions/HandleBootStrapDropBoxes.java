package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandleBootStrapDropBoxes {
    WebDriver driver;

    @Test
    public void bootstrap() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://getbootstrap.com/docs/4.0/components/dropdowns/");

        driver.findElement(By.id("dropdownMenuButton")).click();

        List<WebElement> list =
                driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu') and (@aria-labelledby='dropdownMenuButton')]//a"));

        System.out.println(list.size());

        for (WebElement element : list) {
            System.out.println(element.getText());
            if (element.getText().equals("Action")) {
                element.click();
                break;
            }
        }
    }
}