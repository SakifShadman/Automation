package com.datadriven.test;

import com.excel.utility.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizeTest {
    public static void main(String[] args) {

        //web-driver code:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        //Data Driven Approach (Parameterization) -- used to create data driven framework: driving the test data from excel files

        //get test date from excel:
        Xls_Reader reader = new Xls_Reader("src/test/java/com/testdata/ParaBankTestData.xlsx");
        int rowCount = reader.getRowCount("RegTestData");

        reader.addColumn("RegTestData", "Status");

        //parameterization:
        for (int rowNum=2; rowNum<=rowCount; rowNum++) {
            String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
            System.out.println(firstName);

            String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
            System.out.println(lastName);

            String address = reader.getCellData("RegTestData", "address", rowNum);
            System.out.println(address);

            String city = reader.getCellData("RegTestData", "city", rowNum);
            System.out.println(city);

            String state = reader.getCellData("RegTestData", "state", rowNum);
            System.out.println(state);

            String zipCode = reader.getCellData("RegTestData", "zipcode", rowNum);
            System.out.println(zipCode);

            String phone = reader.getCellData("RegTestData", "phone", rowNum);
            System.out.println(phone);

            String ssn = reader.getCellData("RegTestData", "ssn", rowNum);
            System.out.println(ssn);

            String userName = reader.getCellData("RegTestData", "username", rowNum);
            System.out.println(userName);

            String passWord = reader.getCellData("RegTestData", "password", rowNum);
            System.out.println(passWord);

            System.out.println("=========");

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

            reader.setCellData("RegTestData", "Status", rowNum, "Pass"); //write the data into a cell
        }
    }
}