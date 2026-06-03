package com.qa.pages.mobile;

import com.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileHomePage extends BasePage {

    @FindBy(accessibility = "test-Cart")
    private WebElement cartButton;

    @FindBy(accessibility = "test-Item")
    private List<WebElement> productItems;

    @FindBy(accessibility = "test-Menu")
    private WebElement menuButton;

    @FindBy(accessibility = "test-LOGOUT")
    private WebElement logoutButton;

    public MobileHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get product item count")
    public int getProductCount() {
        return productItems.size();
    }

    @Step("Check if cart button is displayed")
    public boolean isCartDisplayed() {
        return isDisplayed(cartButton);
    }

    @Step("Logout from mobile app")
    public MobileLoginPage logout() {
        click(menuButton);
        click(logoutButton);
        return new MobileLoginPage(driver);
    }
}
