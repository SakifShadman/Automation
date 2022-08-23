package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class CalenderSelectTest {
    static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        driver.findElement(By.id("dateOfBirthInput")).click();

        String date = "21-September-1996";
        String[] dateArray = date.split("-");
        String day = dateArray[0];
        String month = dateArray[1];
        String year = dateArray[2];

        Select select = new Select(explicitWait(driver, By.xpath("//select[@class='react-datepicker__month-select']"),30));
        select.selectByVisibleText(month);

        Select select1 = new Select(explicitWait(driver, By.xpath("//select[@class='react-datepicker__year-select']"), 30));
        select1.selectByVisibleText(year);

        /*
        //body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[5]
        //body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]
        //body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[4]
        //body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[4]
        /html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[2]
        */

        String beforeXpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[";
        String afterXpath = "]/div[";

        final int totalWeekDays = 7;
        String dayVal = null;
        boolean isPresent = false;

        for (int row=1; row<=5; row++) {
            for (int col=1; col<=totalWeekDays; col++) {

                try {
                    dayVal = driver.findElement(By.xpath(beforeXpath + row + afterXpath + col + "]")).getText();
                } catch (NoSuchElementException e) {
                    System.out.println("Please enter a correct date value");
                    isPresent = true;
                    break;
                }
                //System.out.println(dayVal);
                if (dayVal.equals(day)) {
                    //driver.findElement(By.xpath(beforeXpath + row + afterXpath + col + "]")).click();
                    explicitWait(driver, By.xpath(beforeXpath + row + afterXpath + col + "]"), 30).click();
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                break;
            }
        }
    }
    public static WebElement explicitWait(WebDriver driver, By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}