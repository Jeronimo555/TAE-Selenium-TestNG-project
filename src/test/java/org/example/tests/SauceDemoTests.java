package org.example.tests;

import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTests extends BaseTest{

    @BeforeMethod
    public void login(){
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);
    }

    @Test
    public void purchaseProductTest(){
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        inventoryPage.addToCart();
        inventoryPage.clickCartButton();

    }
}
