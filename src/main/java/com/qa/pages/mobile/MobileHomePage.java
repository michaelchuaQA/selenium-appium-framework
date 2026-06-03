package com.qa.pages.mobile;

import com.qa.base.BasePage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class MobileHomePage extends BasePage {

    @AndroidFindBy(accessibility = "test-Cart")
    private WebElement cartButton;

    @AndroidFindBy(accessibility = "test-Item")
    private List<WebElement> productItems;

    @AndroidFindBy(accessibility = "test-Menu")
    private WebElement menuButton;

    @AndroidFindBy(accessibility = "test-LOGOUT")
    private WebElement logoutButton;

    public MobileHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
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
