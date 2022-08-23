package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.calculator.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Loan Calculator")).click();
        driver.findElement(By.id("cloanamount")).clear();
        driver.findElement(By.id("cloanamount")).sendKeys("50000");
        driver.findElement(By.id("cloanterm")).clear();
        driver.findElement(By.id("cloanterm")).sendKeys("5");
        driver.findElement(By.id("cloantermmonth")).clear();
        driver.findElement(By.id("cloantermmonth")).sendKeys("8");
        driver.findElement(By.cssSelector("#cinterestrate")).clear();
        driver.findElement(By.cssSelector("#cinterestrate")).sendKeys("5");

        Select select = new Select(driver.findElement(By.id("ccompound")));
        select.selectByVisibleText("Annually (APY)");

        Select select1 = new Select(driver.findElement(By.id("cpayback")));
        select1.selectByVisibleText("Every Year");

        driver.findElement(By.cssSelector("input[value='Calculate']")).click();
    }
}