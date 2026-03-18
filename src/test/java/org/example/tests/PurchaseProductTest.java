package org.example.tests;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest{

    @BeforeMethod
    public void login(){
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);
    }

    @Test(testName = "Select a product and go through the entire purchase process.")
    public void purchaseProductTest(){
        String first_name = "Aidan";
        String last_name = "Griven";
        String postal_code = "133";

        WebDriver driver = getDriver();

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        inventoryPage.addToCart();
        inventoryPage.clickCartButton();

        cartPage.checkout();
        checkoutInfoPage.fillInformation(first_name,last_name,postal_code);
        checkoutOverviewPage.clickFinish();

        //We do this to separate the test logic from the page logic.
        String text = checkoutCompletePage.checkSuccessMessage();
        Assert.assertEquals(text,"Thank you for your order!","Checkout failed: Success message was not displayed.");
    }
}
