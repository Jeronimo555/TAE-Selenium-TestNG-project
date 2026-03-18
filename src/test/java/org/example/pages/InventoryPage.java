package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage{
    @FindBy(className = "btn_inventory")
    private List<WebElement> add_to_cart_buttons;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart_button;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //Add a random item to the cart
    public void addToCart(){
        Random random = new Random();
        int rand_index = random.nextInt(this.add_to_cart_buttons.size());
        add_to_cart_buttons.get(rand_index).click();
    }

    public void clickCartButton(){
        this.cart_button.click();
    }

}
