package com.qa.pages.mobile;

import com.qa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileLoginPage extends BasePage {

    @FindBy(accessibility = "test-Username")
    private WebElement usernameField;

    @FindBy(accessibility = "test-Password")
    private WebElement passwordField;

    @FindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    @FindBy(accessibility = "test-Error message")
    private WebElement errorMessage;

    public MobileLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Mobile login with username: {username}")
    public MobileHomePage login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
        return new MobileHomePage(driver);
    }

    @Step("Get mobile error message")
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Check if error message is displayed")
    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }
}
