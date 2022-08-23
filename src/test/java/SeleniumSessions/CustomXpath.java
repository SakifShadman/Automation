package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CustomXpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //launch chrome;
        driver.manage().window().maximize(); //maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.calculator.net/gas-mileage-calculator.html"); //enter url

        //absolute xpath: not recommended
        //html[1]/body[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[11]/a[1]
        //1. performance issue
        //2. not reliable
        //3. can be changed at any time in future

        //customize Xpath:
        driver.findElement(By.xpath("//input[@class='inlong']")).clear();
        driver.findElement(By.xpath("//input[@name='uspodreading']")).clear();
        driver.findElement(By.xpath("//input[contains(@class,'inlong')]")).sendKeys("1111");

        //dynamic id: input
        //id = test_123
        //By.id("test_123")

        //starts-with
        //id = test_456
        //id = test_789
        //id = test_test_7890_test

        //ends-with
        //id = 1234_test_t
        //id = 23456_test_t
        //id = 6789_test_t

        //driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
        //driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");
        //driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("Test");

        //for links: custom xpath:
        //all the links are represented by <a> html tag:
        driver.findElement(By.xpath("//a[contains(text(),'Financial')]")).click();
    }
}