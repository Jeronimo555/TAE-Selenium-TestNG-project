package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(id = "checkout")
    private WebElement checkout_button;

    @FindBy(className = "cart_button")
    private List<WebElement> remove_buttons;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkout(){
        this.checkout_button.click();
    }

    public boolean removeElementsFromCart(int amount){
        //We treat this as a LIFO list.
        for(int i = 0;i<amount;i++){
            this.remove_buttons.get(this.remove_buttons.size()-1).click();
        }

        return this.remove_buttons.isEmpty();
    }
}
