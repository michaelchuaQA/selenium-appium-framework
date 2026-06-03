package com.qa.pages.web;

import com.qa.base.BasePage;
import io.qameta.allure.Step;
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

    @FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addBackpackToCart;

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

    @Step("Add backpack to cart")
    public void addBackpackToCart() {
        click(addBackpackToCart);
    }

    @Step("Get cart badge count")
    public String getCartBadgeCount() {
        return getText(cartBadge);
    }
}
