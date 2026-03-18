package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage{
    @FindBy(id = "first-name")
    private WebElement first_name;

    @FindBy(id = "last-name")
    private WebElement last_name;

    @FindBy(id = "postal-code")
    private WebElement postal_code;

    @FindBy(id = "continue")
    private WebElement continue_button;


    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public void fillInformation(String first_name, String last_name, String postal_code){
        this.first_name.sendKeys(first_name);
        this.last_name.sendKeys(last_name);
        this.postal_code.sendKeys(postal_code);

        this.continue_button.click();
    }


}
