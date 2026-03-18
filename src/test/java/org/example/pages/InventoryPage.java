package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage{
    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //Add a random item to the cart
    public void addToCart(){
        Random random = new Random();
        int rand_index = random.nextInt(this.addToCartButtons.size());
        addToCartButtons.get(rand_index).click();
    }

}
