package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://clevertap.com/ppc/live-product-demo/?utm_medium=ppc&utm_source=capterra&capterra=capterra");

        //handle drop box:
        Select select = new Select(driver.findElement(By.id("monthly_avg_users")));
        select.selectByVisibleText("Under 50k");
//        select.selectByIndex(2);
//        select.selectByValue("");
    }
}