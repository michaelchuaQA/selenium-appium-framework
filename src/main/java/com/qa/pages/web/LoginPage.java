package com.qa.pages.web;

import com.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login with username: {username}")
    public InventoryPage login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
        return new InventoryPage(driver);
    }

    @Step("Get error message text")
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Check if error message is displayed")
    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }
}
