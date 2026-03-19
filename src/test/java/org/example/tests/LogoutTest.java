package org.example.tests;

import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test(testName = "Successfully log out of the application")
    public void logoutTest() {
        WebDriver driver = getDriver();

        InventoryPage inventoryPage = new InventoryPage(driver);
        LoginPage loginPage = new LoginPage(getDriver());

        inventoryPage.openMenuAndLogout(driver);


        boolean login_button = loginPage.checkIfLoginIsVisible();
        Assert.assertTrue(login_button, "Test Failed: The login button is not visible!");
    }

}
