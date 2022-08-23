package com.test;

import org.testng.annotations.*;

public class TestNgBasics {

    /*
    @BeforeSuite -- setup system property for chrome -- 1
    @BeforeTest -- launch Chrome browser -- 2
    @BeforeClass -- login to app -- 3

    @BeforeMethod -- enter URLc -- 4
    @Test -- Google logo test -- 5
    @AfterMethod -- logout from app -- 6

    @BeforeMethod -- enter URL
    @Test -- Google Title Test
    @AfterMethod -- logout from app

    @BeforeMethod -- enter URL
    @Test -- search test
    @AfterMethod -- logout from app

    @AfterClass -- Close Browser -- 7
    @AfterTest -- delete all cookies -- 8
    */

    //Pre-conditions annotations -- starting with @Before
    @BeforeSuite //1
    public void setUp() {
        System.out.println("@BeforeSuite -- setup system property for chrome");
    }

    @BeforeTest //2
    public void launchBrowser() {
        System.out.println("@BeforeTest -- launch Chrome browser");
    }

    @BeforeClass //3
    public void login() {
        System.out.println("@BeforeClass -- login to app");
    }

    /*
    @BeforeMethod
    @Test #1
    @AfterMethod

    @BeforeMethod
    @Test #2
    @AfterMethod

    @BeforeMethod
    @Test #3
    @AfterMethod
    */

    @BeforeMethod //4
    public void enterURL() {
        System.out.println("@BeforeMethod -- enter URL");
    }

    //test cases -- starting with @Test
    @Test //5
    public void googleTitleTest() {
        System.out.println("@Test -- Google Title Test");
    }

    @Test
    public void searchTest() {
        System.out.println("@Test -- search test");
    }

    @Test
    public void googleLogoTest() {
        System.out.println("@Test -- Google logo test");
    }

    //post conditions -- starting with @After
    @AfterMethod //6
    public void logOut() {
        System.out.println("@AfterMethod -- logout from app");
    }

    @AfterClass //7
    public void closeBrowser() {
        System.out.println("@AfterClass -- Close Browser");
    }

    @AfterTest //8
    public void deleteAllCookies() {
        System.out.println("@AfterTest -- delete all cookies");
    }
}