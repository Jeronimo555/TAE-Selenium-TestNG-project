package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{
    @FindBy(className = "complete-header")
    private WebElement success_header;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String checkSuccessMessage() {
        return this.success_header.getText();
    }

}
