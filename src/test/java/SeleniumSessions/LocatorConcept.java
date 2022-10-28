package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //launch chrome;

        driver.get("https://www.calculator.net/gas-mileage-calculator.html"); //enter url

        //1. xpath: -- (2nd priority)
        //absolute xpath should not be used -- //body[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[5]/td[1]/img[1]
        //only relative xpath should be used -- //input[@id='uscodreading']
        driver.findElement(By.xpath("//body[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[5]/td[1]/img[1]")).click();
        //driver.findElement(By.xpath("//input[@id='uscodreading']")).sendKeys("7500");
        //driver.findElement(By.xpath("//input[@id='uspodreading']")).sendKeys("7250");


        //2. id: -- (1st priority)
        //driver.findElement(By.id("uscodreading")).sendKeys("7500");
        //driver.findElement(By.id("uspodreading")).sendKeys("7250");


        //3. name: -- (3rd priority)
        driver.findElement(By.name("uscodreading")).sendKeys("7500");
        driver.findElement(By.name("uspodreading")).sendKeys("7250");


        //4. linkTest: -- (this is only for links but if it has id then use id)
        //driver.findElement(By.linkText("Financial")).click();


        //5. partialLinkText: not useful
        //driver.findElement(By.partialLinkText("fueleconomy.gov")).click();


        //6. CSSSelector: -- (2nd priority as like xpath)
        //if id is there --- #{idvalue}
        //if class is there --- .{classvalue}
        driver.findElement(By.cssSelector("#usgasputin")).sendKeys("14.75");


        //7. class name: not useful
        //driver.findElement(By.className("inlong")).sendKeys("5.005");

        //8. tag name:\
        driver.findElements(By.tagName("a"));
    }
}