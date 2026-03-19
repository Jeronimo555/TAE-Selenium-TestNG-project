package org.example.tests;

import lombok.Builder;
import lombok.Data;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Data
public abstract class BaseTest {
    private WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    //There is a data breach pop up that is messing up the flow of execution of Selenium.
    //Therefore, we have to disable it.
    public ChromeOptions disablePopups(){
        ChromeOptions options = new ChromeOptions();

        // Disable the password manager and credential service (This kills the data breach popup)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        return options;
    }

    public void login(){
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);
    }


    @BeforeMethod
    public void setup(){
        //Set up the Selenium WebDriver.
        ChromeOptions options = disablePopups();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);

        login();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            // Close all browser windows and safely end the session
            driver.quit();
        }
    }


}
