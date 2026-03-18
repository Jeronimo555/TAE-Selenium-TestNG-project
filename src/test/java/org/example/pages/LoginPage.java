package org.example.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login_button;

    public LoginPage(WebDriver driver) {super(driver);}

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.login_button.click();
    }
}
