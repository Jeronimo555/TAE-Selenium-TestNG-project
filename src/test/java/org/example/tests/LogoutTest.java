package org.example.tests;

import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @BeforeMethod
    public void login(){
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);
    }

    @Test(testName = "Successfully log out of the application")
    public void logoutTest() {
        // We use getDriver() assuming you are using that getter from your updated BaseTest
        WebDriver driver = getDriver();

        InventoryPage inventoryPage = new InventoryPage(driver);

        // 1. Perform the logout action
        inventoryPage.openMenuAndLogout(driver);

        // 2. The Assertion: Prove we are back on the login screen
        // SauceDemo's login URL is exactly "https://www.saucedemo.com/"
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/", "Test Failed: User was not redirected to the login page!");
    }

}
