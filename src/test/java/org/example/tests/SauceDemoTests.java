package org.example.tests;

import org.example.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

public class SauceDemoTests extends BaseTest{

    @BeforeMethod
    public void login(){
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);
     }


}
