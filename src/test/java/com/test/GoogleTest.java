package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTest {

    WebDriver driver;

    //1 //4 //7
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

    /*
     *************** Test cases will be executed as per alphabetic order not random order ***************
     */

    //2
    @Test(priority = 1, groups = "Title")
    public void googleTitleTest() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    //8
    @Test(priority = 3, groups = "logo")
    public void googleLogoTest() {
        boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
    }

    //5
    @Test(priority = 2, groups = "Link Test")
    public void gmailLinkTest() {
        boolean b = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isDisplayed();
    }

    @Test(priority = 4, groups = "Test")
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 5, groups = "Test")
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 6, groups = "Test")
    public void test3() {
        System.out.println("test3");
    }

    //3 //6 //9
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}