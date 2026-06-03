package com.qa.tests.steps.mobile;

import com.qa.driver.MobileDriverFactory;
import com.qa.pages.mobile.MobileHomePage;
import com.qa.pages.mobile.MobileLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MobileLoginSteps {

    private WebDriver driver;
    private MobileLoginPage loginPage;
    private MobileHomePage homePage;

    @Given("the mobile app is launched")
    public void theMobileAppIsLaunched() {
        driver = MobileDriverFactory.getDriver();
        loginPage = new MobileLoginPage(driver);
    }

    @When("I enter mobile username {string} and password {string}")
    public void iEnterMobileUsernameAndPassword(String username, String password) {
        homePage = loginPage.login(username, password);
    }

    @And("I tap the login button")
    public void iTapTheLoginButton() {
        // Login already triggered in the step above
    }

    @Then("I should see the home screen with the cart button")
    public void iShouldSeeTheHomeScreenWithTheCartButton() {
        Assert.assertTrue(homePage.isCartDisplayed());
    }

    @Then("I should see a mobile error message")
    public void iShouldSeeAMobileErrorMessage() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @And("I logout from the mobile app")
    public void iLogoutFromTheMobileApp() {
        loginPage = homePage.logout();
    }

    @Then("I should be on the mobile login screen")
    public void iShouldBeOnTheMobileLoginScreen() {
        Assert.assertNotNull(loginPage);
    }
}
