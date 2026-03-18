package org.example.tests;

import org.example.pages.CartPage;
import org.example.pages.CheckoutInfoPage;
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
        String first_name = "Aidan";
        String last_name = "Griven";
        String postal_code = "133";


        InventoryPage inventoryPage = new InventoryPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(getDriver());

        inventoryPage.addToCart();
        inventoryPage.clickCartButton();

        cartPage.checkout();
        checkoutInfoPage.fillInformation(first_name,last_name,postal_code);

    }
}
