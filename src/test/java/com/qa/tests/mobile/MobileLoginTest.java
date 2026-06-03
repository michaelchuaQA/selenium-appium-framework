package com.qa.tests.mobile;

import com.qa.pages.mobile.MobileHomePage;
import com.qa.pages.mobile.MobileLoginPage;
import com.qa.tests.base.MobileBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileLoginTest extends MobileBaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify successful mobile login with valid credentials")
    public void testValidMobileLogin() {
        MobileLoginPage loginPage = new MobileLoginPage(driver);
        MobileHomePage homePage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(homePage.isCartDisplayed());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify error message with invalid mobile credentials")
    public void testInvalidMobileLogin() {
        MobileLoginPage loginPage = new MobileLoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can logout from mobile app")
    public void testMobileLogout() {
        MobileLoginPage loginPage = new MobileLoginPage(driver);
        MobileHomePage homePage = loginPage.login("standard_user", "secret_sauce");
        loginPage = homePage.logout();

        Assert.assertNotNull(loginPage);
    }
}
