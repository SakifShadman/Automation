package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTitleTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://www.google.com/");
    }

    @Test()
    public void googleTitleTest() {
        String title = driver.getTitle();
        System.out.println(title);

        Assert.assertEquals(title, "Google", "title is not matched");
    }

    @Test()
    public void googleLogoTest() {
        boolean b = driver.findElement(By.id("hplogo")).isDisplayed();

        Assert.assertTrue(b);
        //Assert.assertEquals(b, true);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
