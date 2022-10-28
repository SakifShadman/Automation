package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {

        //Chrome browser:
        System.setProperty("webdriver.chrome.driver", "C:/Dev_tools/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver(); //launch chrome;

        driver.get("http://www.google.com"); //enter url

        String title = driver.getTitle(); //to get title
        System.out.println(title);

        //validation point:
        if (title.equals("Google")) {
            System.out.println("correct title");
        }
        else {
            System.out.println("in-correct title");
        }

        System.out.println(driver.getCurrentUrl()); //get current url
        //System.out.println(driver.getPageSource()); //get page source

        driver.quit(); //quit the browser
    }
}