package com.qa.tests.web;

import com.qa.pages.web.InventoryPage;
import com.qa.pages.web.LoginPage;
import com.qa.tests.base.WebBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends WebBaseTest {

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void loginFirst() {
        LoginPage loginPage = new LoginPage(driver);
        inventoryPage = loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify inventory page displays products after login")
    public void testProductsDisplayed() {
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
        Assert.assertEquals(inventoryPage.getItemCount(), 6);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify adding item to cart updates cart badge")
    public void testAddItemToCart() {
        inventoryPage.addBackpackToCart();

        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1");
    }
}
