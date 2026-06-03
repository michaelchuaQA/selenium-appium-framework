package com.qa.tests.steps.web;

import com.qa.driver.DriverFactory;
import com.qa.pages.web.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class InventorySteps {

    private InventoryPage inventoryPage;

    private InventoryPage getInventoryPage() {
        if (inventoryPage == null) {
            inventoryPage = new InventoryPage(DriverFactory.getDriver());
        }
        return inventoryPage;
    }

    @Then("I should see {int} products on the inventory page")
    public void iShouldSeeProductsOnTheInventoryPage(int expectedCount) {
        Assert.assertEquals(getInventoryPage().getItemCount(), expectedCount);
    }

    @When("I add the {string} to the cart")
    public void iAddTheToTheCart(String productName) {
        getInventoryPage().addProductToCart(productName);
    }

    @And("I remove the {string} from the cart")
    public void iRemoveTheFromTheCart(String productName) {
        getInventoryPage().removeProductFromCart(productName);
    }

    @Then("the cart badge should show {string}")
    public void theCartBadgeShouldShow(String expectedCount) {
        Assert.assertEquals(getInventoryPage().getCartBadgeCount(), expectedCount);
    }

    @Then("the cart badge should not be visible")
    public void theCartBadgeShouldNotBeVisible() {
        Assert.assertFalse(getInventoryPage().isCartBadgeVisible());
    }
}
