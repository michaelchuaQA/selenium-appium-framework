package com.qa.tests.base;

import com.qa.config.ConfigReader;
import com.qa.driver.DriverFactory;
import com.qa.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class WebBaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.get(ConfigReader.get("web.base.url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureScreenshot(driver, result.getName());
        }
        DriverFactory.quitDriver();
    }
}
