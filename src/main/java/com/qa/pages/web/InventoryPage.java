package com.qa.pages.web;

import com.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get page title")
    public String getPageTitle() {
        return getText(pageTitle);
    }

    @Step("Get inventory item count")
    public int getItemCount() {
        return inventoryItems.size();
    }

    @Step("Add {productName} to cart")
    public void addProductToCart(String productName) {
        String dataTest = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        driver.findElement(By.cssSelector("[data-test='" + dataTest + "']")).click();
    }

    @Step("Remove {productName} from cart")
    public void removeProductFromCart(String productName) {
        String dataTest = "remove-" + productName.toLowerCase().replace(" ", "-");
        driver.findElement(By.cssSelector("[data-test='" + dataTest + "']")).click();
    }

    @Step("Get cart badge count")
    public String getCartBadgeCount() {
        return getText(cartBadge);
    }

    @Step("Check if cart badge is visible")
    public boolean isCartBadgeVisible() {
        try {
            return cartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
