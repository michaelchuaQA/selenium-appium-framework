package com.qa.pages.web;

import com.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    private static final By CART_BADGE = By.className("shopping_cart_badge");

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
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(CART_BADGE));
        return badge.getText();
    }

    @Step("Check if cart badge is visible")
    public boolean isCartBadgeVisible() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        boolean visible = !driver.findElements(CART_BADGE).isEmpty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return visible;
    }
}
