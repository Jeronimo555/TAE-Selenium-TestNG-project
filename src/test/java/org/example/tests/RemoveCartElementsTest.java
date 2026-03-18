package org.example.tests;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RemoveCartElementsTest extends BaseTest{

    @BeforeMethod
    public void login(){
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);
    }

    @Test(testName = "Add 3 elements to Cart and then remove them.")
    public void removeCartElementsTest(){
        WebDriver driver = getDriver();

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        //Add 3 random items to the cart.
        inventoryPage.addMultipleDifferentProducts(3);

        inventoryPage.clickCartButton();

        boolean is_empty = cartPage.removeElementsFromCart(3);

        Assert.assertTrue(is_empty, "Test Failed, the cart is not empty.");
    }
}
