package com.datadriven.test;

import com.excel.utility.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DataDrivenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        Xls_Reader reader = new Xls_Reader("src/test/java/com/testdata/ParaBankTestData.xlsx");

        String firstName = reader.getCellData("RegTestData", "firstname", 2);
        System.out.println(firstName);

        String lastName = reader.getCellData("RegTestData", "lastname", 2);
        System.out.println(lastName);

        String address = reader.getCellData("RegTestData", "address", 2);
        System.out.println(address);

        String city = reader.getCellData("RegTestData", "city", 2);
        System.out.println(city);

        String state = reader.getCellData("RegTestData", "state", 2);
        System.out.println(state);

        String zipCode = reader.getCellData("RegTestData", "zipcode", 2);
        System.out.println(zipCode);

        String phone = reader.getCellData("RegTestData", "phone", 2);
        System.out.println(phone);

        String ssn = reader.getCellData("RegTestData", "ssn", 2);
        System.out.println(ssn);

        String userName = reader.getCellData("RegTestData", "username", 2);
        System.out.println(userName);

        String passWord = reader.getCellData("RegTestData", "password", 2);
        System.out.println(passWord);


        driver.findElement(By.id("customer.firstName")).sendKeys(firstName);
        driver.findElement(By.id("customer.lastName")).sendKeys(lastName);
        driver.findElement(By.id("customer.address.street")).sendKeys(address);
        driver.findElement(By.id("customer.address.city")).sendKeys(city);
        driver.findElement(By.id("customer.address.state")).sendKeys(state);
        driver.findElement(By.id("customer.address.zipCode")).sendKeys(zipCode);
        driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);
        driver.findElement(By.id("customer.ssn")).sendKeys(ssn);
        driver.findElement(By.id("customer.username")).sendKeys(userName);
        driver.findElement(By.id("customer.password")).sendKeys(passWord);
        driver.findElement(By.id("repeatedPassword")).sendKeys(passWord);
    }
}
