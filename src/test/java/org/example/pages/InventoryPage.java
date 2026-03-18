package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage{
    @FindBy(className = "btn_inventory")
    private List<WebElement> add_to_cart_buttons;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart_button;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burger_menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout_link;


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //Add a random item to the cart
    public void addToCart(){
        Random random = new Random();
        int rand_index = random.nextInt(this.add_to_cart_buttons.size());
        add_to_cart_buttons.get(rand_index).click();
    }

    //This method is necessary becasue calling the addToCart
    //method multiple times can trigger the same item multiple times.
    public void addMultipleDifferentProducts(int amount) {
        for (int i = 0; i < amount; i++) {
            this.add_to_cart_buttons.get(i).click();
        }
    }

    public void clickCartButton(){
        this.cart_button.click();
    }

    public void openMenuAndLogout(WebDriver driver){
        this.burger_menu.click();

        // Create a wait (max 5 seconds) just for this specific animation
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(this.logout_link));

        this.logout_link.click();
    }
}
