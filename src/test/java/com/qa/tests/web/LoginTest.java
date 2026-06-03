package com.qa.tests.web;

import com.qa.pages.web.InventoryPage;
import com.qa.pages.web.LoginPage;
import com.qa.tests.base.WebBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends WebBaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify successful login with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify error message with locked out user")
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Sorry, this user has been locked out"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify error message with invalid credentials")
    public void testInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");

        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Username and password do not match"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when username is empty")
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "secret_sauce");

        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message when password is empty")
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "");

        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
    }
}
