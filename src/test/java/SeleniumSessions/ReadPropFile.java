package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();

        FileInputStream ip = new FileInputStream("C://Users//arnob//IdeaProjects//AutomationYoutube//src//test//java/SeleniumSessions//config.properties");

        prop.load(ip);

        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));

        String url = prop.getProperty("URL");
        System.out.println(url);

        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equals("FF")) {
            System.out.println("Launch FireFox");
        }
        else if (browserName.equals("IE")) {
            System.out.println("Launch InternetExplorer");
        }

        driver.get(url);

        driver.findElement(By.xpath(prop.getProperty("firstName_xpath"))).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.xpath(prop.getProperty("lastName_xpath"))).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
        driver.findElement(By.xpath(prop.getProperty("gender_xpath"))).click();
        driver.findElement(By.xpath(prop.getProperty("mobile_xpath"))).sendKeys(prop.getProperty("mobile"));
    }
}