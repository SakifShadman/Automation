package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElementVisibilityTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://battlefy.com/account/signup");
        driver.findElement(By.xpath("//span[contains(text(), 'Email')]")).click();

        //1. isDisplayed() method: applicable for all the elements
        boolean b1 = driver.findElement(By.xpath("//a[contains(text(), 'Makes sense to me!')]")).isDisplayed();
        System.out.println(b1); //true


        //2. isEnabled() method:
        boolean b2 = driver.findElement(By.xpath("//a[contains(text(), 'Makes sense to me!')]")).isEnabled();
        System.out.println(b2); //false

        //select I Agree checkbox:
        driver.findElement(By.xpath("//input[@type='checkbox']")).click(); //--button is enabled now
        boolean b3 = driver.findElement(By.xpath("//a[contains(text(), 'Makes sense to me!')]")).isEnabled();
        System.out.println(b3); //true


        //3. isSelected method: only applicable for checkbox, dropdown, radiobutton
        boolean b4 = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        System.out.println(b4); //true

        //de-select I Agree checkbox:
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        boolean b5 = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        System.out.println(b5); //false
    }
}