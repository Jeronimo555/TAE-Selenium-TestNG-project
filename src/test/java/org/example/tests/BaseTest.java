package org.example.tests;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Data
public abstract class BaseTest {
    private WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setup(){
        //Set up the Selenium WebDriver.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            // Close all browser windows and safely end the session
            driver.quit();
        }
    }


}
