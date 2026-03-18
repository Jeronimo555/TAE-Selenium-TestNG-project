package org.example.tests;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;
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

        WebDriver driver = getDriver();

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        inventoryPage.addToCart();
        inventoryPage.clickCartButton();

        cartPage.checkout();
        checkoutInfoPage.fillInformation(first_name,last_name,postal_code);
        checkoutOverviewPage.clickFinish();

    }
}
