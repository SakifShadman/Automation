package com.datadriven.test;

import com.test.utility.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class ParaBankTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @DataProvider
    public Iterator<Object[]> getTestData() {
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
        return testData.iterator();
    }

    @Test(dataProvider = "getTestData")
    public void paraBankRegPageTest(String firstName, String lastName, String address, String city,
                                    String state, String zipCode, String phone, String ssn,
                                    String userName, String passWord) {

        driver.findElement(By.id("customer.firstName")).clear();
        driver.findElement(By.id("customer.firstName")).sendKeys(firstName);

        driver.findElement(By.id("customer.lastName")).clear();
        driver.findElement(By.id("customer.lastName")).sendKeys(lastName);

        driver.findElement(By.id("customer.address.street")).clear();
        driver.findElement(By.id("customer.address.street")).sendKeys(address);

        driver.findElement(By.id("customer.address.city")).clear();
        driver.findElement(By.id("customer.address.city")).sendKeys(city);

        driver.findElement(By.id("customer.address.state")).clear();
        driver.findElement(By.id("customer.address.state")).sendKeys(state);

        driver.findElement(By.id("customer.address.zipCode")).clear();
        driver.findElement(By.id("customer.address.zipCode")).sendKeys(zipCode);

        driver.findElement(By.id("customer.phoneNumber")).clear();
        driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);

        driver.findElement(By.id("customer.ssn")).clear();
        driver.findElement(By.id("customer.ssn")).sendKeys(ssn);

        driver.findElement(By.id("customer.username")).clear();
        driver.findElement(By.id("customer.username")).sendKeys(userName);

        driver.findElement(By.id("customer.password")).clear();
        driver.findElement(By.id("customer.password")).sendKeys(passWord);

        driver.findElement(By.id("repeatedPassword")).clear();
        driver.findElement(By.id("repeatedPassword")).sendKeys(passWord);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}