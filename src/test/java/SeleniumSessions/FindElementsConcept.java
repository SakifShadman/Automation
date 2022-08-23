package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsConcept {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.calculator.net/sitemap.html");

        //1. get the total count of links on the page
        //2. get the text of each link on the page

        //all the links are represented by <a> html tag:
        List <WebElement> linkList = driver.findElements(By.tagName("a"));

        //size of linkList:
        System.out.println(linkList.size());

        for (WebElement name : linkList) {
            System.out.println(name.getText());
        }

        /*for (int i=0; i<linkList.size(); i++) {
            String linkText = linkList.get(i).getText();
            System.out.println(linkText);
        }*/
    }
}