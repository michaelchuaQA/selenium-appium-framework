package com.qa.tests.steps.web;

import com.qa.config.ConfigReader;
import com.qa.driver.DriverFactory;
import com.qa.pages.web.InventoryPage;
import com.qa.pages.web.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("web.base.url"));
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        inventoryPage = loginPage.clickLogin();
    }

    @Then("I should be redirected to the inventory page")
    public void iShouldBeRedirectedToTheInventoryPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        Assert.assertEquals(inventoryPage.getPageTitle(), expectedTitle);
    }

    @Then("I should see an error message containing {string}")
    public void iShouldSeeAnErrorMessageContaining(String expectedMessage) {
        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedMessage));
    }
}
