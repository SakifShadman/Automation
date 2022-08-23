package com.parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    WebDriver driver;

    @Test
    @Parameters({"url","emailId"})
    public void loginTest(String url, String emailId) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to(url);

        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys(emailId);
        driver.findElement(By.id("login-signin")).click();
    }
}
